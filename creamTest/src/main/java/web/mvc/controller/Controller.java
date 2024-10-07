package web.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
	ModelAndView handleRequest(HttpServletRequest requset, HttpServletResponse response);
}
