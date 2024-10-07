package web.mvc.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * 	모든 요청을 중앙집중적으로 관리해줄 진입점 Controller이다 =FrontController이다
 * */
@WebServlet(urlPatterns = "/front", loadOnStartup = 1)
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 50
)
public class DispatcherServlet extends HttpServlet {
    private Map<String, Controller> map;
    private Map<String, Class<?>> classMap;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext application = config.getServletContext();
        map = (Map<String, Controller>) application.getAttribute("map");
        classMap = (Map<String, Class<?>>) application.getAttribute("classMap");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        String methodName = request.getParameter("methodName");

        try {
            // 전달받은 key에 해당하는 Controller를 Map에서 찾아서 호출
            Controller con = map.get(key);
            Class<?> className = classMap.get(key);
            Method method = className.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            // 파일 처리 (if 필요시 multipart 요청인지 확인)
            if (request.getContentType() != null && request.getContentType().startsWith("multipart/form-data")) {
                Part part = request.getPart("file");
                String fileName = getFilename(part);
                long fileSize = part.getSize();
                String saveDir = request.getServletContext().getRealPath("/save");

                if (fileName != null && !fileName.isEmpty()) {
                    part.write(saveDir + "/" + fileName);
                }

                // 파일 정보를 request에 추가
                request.setAttribute("fileName", fileName);
                request.setAttribute("fileSize", fileSize);
            }

            // Controller로 요청 처리
            ModelAndView mv = (ModelAndView) method.invoke(con, request, response);
            if (mv.isRedirect()) {
                response.sendRedirect(mv.getViewName());
            } else {
                request.getRequestDispatcher(mv.getViewName()).forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getFilename(Part part) {
        String headerContent = part.getHeader("content-disposition");
        String[] split = headerContent.split(";");
        for (String temp : split) {
            if (temp.trim().startsWith("filename")) {
                return temp.substring(temp.indexOf("=") + 2, temp.length() - 1); // ""때문에 indexOf() +2
            }
        }
        return null;
    }
}
