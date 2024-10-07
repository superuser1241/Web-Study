package web.mvc.controller;

import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import web.mvc.dto.Electronics;
import web.mvc.service.ElectronicsServiceImpl;


public class ElectronicsController implements Controller {
	ElectronicsServiceImpl service = new ElectronicsServiceImpl();
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String methodName = request.getParameter("methodName");
		ModelAndView mv = null;
		
		try {
			switch (methodName) {
				case "select":
					mv = select(request, response);
					break;
				case "insert":
					mv = insert(request, response);
					break;
				case "update":
					mv = update(request, response);
					break;
				case "delete":
					mv = delete(request, response);
					break;
				case "selectByModelNum":
					mv = selectByModelNum(request, response);
					break;
				}
		} catch (Exception e) {
			e.printStackTrace();
			mv = new ModelAndView("error/error.jsp");
		}
		return mv;
    }
	
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		List<Electronics> list=service.selectAll();
		request.setAttribute("list", list);
		
		System.out.println(list);
		
		return new ModelAndView("elec/list.jsp");
	}
	
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		String modelNum = request.getParameter("model_num");
		String modelName = request.getParameter("model_name");
		String priceStr = request.getParameter("price");
		String description = request.getParameter("description");
		String password = request.getParameter("password");
		
		String fileName = (String) request.getAttribute("fileName");
		int fileSize = (int)(long) request.getAttribute("fileSize");
        //Caused by: java.lang.ClassCastException: class java.lang.Long cannot be cast to class java.lang.Integer 
        //(java.lang.Long and java.lang.Integer are in module java.base of loader 'bootstrap')
    	//at web.mvc.controller.ElectronicsController.insert(ElectronicsController.java:65)
        //Long타입으로 변환 안하면 fileSize 크기가 안맞음;
		
		if (priceStr.isEmpty()) {
			request.setAttribute("errorMsg", "가격을 입력해 주세요.");
			return new ModelAndView("error/error.jsp");
        }
		
		int price;
		try {
			price = Integer.parseInt(priceStr);
		} catch (Exception e) {
			request.setAttribute("errorMsg", "가격은 숫자여야 합니다.");
			return new ModelAndView("error/error.jsp");
        }
		
		Electronics electronics = new Electronics(modelNum, modelName, price, description, password, null, 0, fileName, fileSize);
		int result = service.insert(electronics);
		
		request.setAttribute("insertResult", result);

		return new ModelAndView("/front?key=elec&methodName=select"); //이부분 다시보기;;
    }
	
	public ModelAndView selectByModelNum(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		String modelNum = request.getParameter("modelNum");
		Electronics ele = service.selectByModelNum(modelNum);
		
		if (ele == null) {
			request.setAttribute("error", "해당 모델 번호의 전자 제품이 존재하지 않습니다.");
			return new ModelAndView("error/error.jsp");
		}
		
		request.setAttribute("elec", ele); 
		return new ModelAndView("elec/read.jsp");
	}
	
	public ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		String modelNum = request.getParameter("modelNum");
		Electronics electronics = service.selectByModelNum(modelNum);
		
		if (electronics == null) {
			request.setAttribute("error", "해당 모델 번호의 전자 제품이 존재하지 않습니다.");
			return new ModelAndView("error/error.jsp");
		}
		
		request.setAttribute("elec", electronics);
		return new ModelAndView("elec/update.jsp");
	}
	
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		String modelNum = request.getParameter("modelNum");
		String modelName = request.getParameter("modelName");
		String priceStr = request.getParameter("price");
		String description = request.getParameter("description");
		String password = request.getParameter("password");
		
		
//	    System.out.println("ModelNum: " + modelNum);//모델넘버가 안넘어옴;
//	    System.out.println("ModelName: " + modelName);
//	    System.out.println("Price: " + priceStr);
//	    System.out.println("Description: " + description);
//	    System.out.println("Password: " + password);
		
		int price;
		try {
			price = Integer.parseInt(priceStr);
		} catch (NumberFormatException e) {
			request.setAttribute("error", "가격은 숫자여야 합니다.");
			return new ModelAndView("error/error.jsp");
		}
		
		Electronics electronics = new Electronics(modelNum, modelName, price, description, password);
		int result = service.update(electronics);

		if (result == 0) {
			request.setAttribute("error", "비밀번호가 맞지 않습니다.");
			return new ModelAndView("error/error.jsp");
		}
		
		request.setAttribute("updateResult", result);
		
		return new ModelAndView("/front?key=elec&methodName=select");
		
	}
	
	public ModelAndView delete(HttpServletRequest request, HttpServletResponse response) throws SQLException{
		String modelNum = request.getParameter("modelNum");
		String password = request.getParameter("password");
		int result = service.delete(modelNum, password);
		
		if (result == 0) {
			request.setAttribute("error", "비밀번호가 맞지 않거나 해당 제품이 존재하지 않습니다.");
			return new ModelAndView("error/error.jsp");
		}
		
		request.setAttribute("deleteResult", result);
		
		return new ModelAndView("/front?key=elec&methodName=select");
	}
	
}
