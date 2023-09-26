package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AssignedWorkDAO;

@WebServlet (urlPatterns = {"/deletework"})
public class DeleteWorkController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String jobid = req.getParameter("jobid");
		try {
			AssignedWorkDAO assignedWorkDAO  = new AssignedWorkDAO();
			assignedWorkDAO.delete(jobid);
			resp.sendRedirect("listassignedwork");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
