package com.cg.iter.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.service.TrainingService;
import com.cg.service.TrainingServiceImpl;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TrainingService trService=null;

    public UpdateServlet() {
    	trService=new TrainingServiceImpl();
        System.out.println("GetAllDetails Servlet");    }

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		RequestDispatcher rd=null;
		int id=Integer.parseInt(request.getParameter("id"));
		int availSeats=Integer.parseInt(request.getParameter("availSeats"));
		if(availSeats<=0) {
			out.println("Oops!!You Cannot Enroll");
			rd=request.getRequestDispatcher("GetAllDetails");
			rd.include(request, response);
		}
		else {
			try {
				String trainingName = trService.UpdateAvailableseats(id);
				out.println("Hi you have successfully enrolled for "+trainingName+" Training.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
