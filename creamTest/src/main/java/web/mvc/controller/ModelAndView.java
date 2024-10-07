package web.mvc.controller;

public class ModelAndView {
	private String viewName; 
	private boolean redirect;
	
	public ModelAndView() {}
	public ModelAndView(String viewName) {
		this.viewName = viewName;
	}
	public ModelAndView(String viewName, boolean redirect) {
		this(viewName);
		this.redirect = redirect;
	}

	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
}
