package com.cg.iter.ctrl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerServlet() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controller doPost called!!");
		String action=request.getParameter("action");
		String id=(request.getParameter("id"));
		String availSeats=(request.getParameter("availSeats"));
		if(action!=null) {
			RequestDispatcher rd=null;
			if(action.equals("ShowHomePage")) {
				rd=request.getRequestDispatcher("/index.html");
				rd.forward(request, response);
			}
			if(action.equals("getAllDetails")) {
				rd=request.getRequestDispatcher("GetAllDetails");
				rd.forward(request, response);
			}
			if(action.equals("UpdatePage")) {
				rd=request.getRequestDispatcher("UpdateServlet?id="+id+"&availSeats="+availSeats);
				rd.forward(request, response);
			}
		}
	}
}
