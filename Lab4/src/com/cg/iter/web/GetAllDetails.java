package com.cg.iter.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.bean.Training;
import com.cg.service.TrainingService;
import com.cg.service.TrainingServiceImpl;

@WebServlet("/GetAllDetails")
public class GetAllDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TrainingService trService=null;
   
    public GetAllDetails() {
            trService=new TrainingServiceImpl();
            System.out.println("GetAllDetails Servlet");
        }    

	public void init(ServletConfig config) throws ServletException {
	}

	public void destroy() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
			List<Training> list=trService.getAllTrainingDetails();
			PrintWriter out=response.getWriter();
			out.println("<form action='' method='get'>");
			out.println("<table><tr><th>TrainingId</th>");
			out.println("<th>TrainingName</th>");
			out.println("<th>AvailableSeats</th></tr>");
			for(Training tr:list) {
			out.println("<tr>"+"<td>"+tr.getTrainigID()+"</td>");
			out.println("<td>"+tr.getTrainingname()+"</td>");
			out.println("<td>"+tr.getAvailSeats()+"</td>");
			out.println("<th><a href='ControllerServlet?action=UpdatePage&id="+tr.getTrainigID()+"&availSeats="+tr.getAvailSeats()+"'>Enroll</a></th></tr>");
			}
			out.println("</table>");
			out.println("</form>");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
