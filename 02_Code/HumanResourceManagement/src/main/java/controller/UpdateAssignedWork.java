package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AssignedWorkDAO;
import model.AssignedWork;

@WebServlet (urlPatterns = {"/updateassignedwork"})
public class UpdateAssignedWork extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String jobid = req.getParameter("jobid");
		try {
			AssignedWorkDAO assignedWorkDAO = new AssignedWorkDAO();
			AssignedWork assignedWork = assignedWorkDAO.getByID(jobid);
			req.setAttribute("assignedWork", assignedWork);
			req.getRequestDispatcher("/Views/Admin/updatework.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String jobid = req.getParameter("jobid");
		String deliverydates = req.getParameter("deliverydate");
		String descriptions = req.getParameter("descriptions");
		String deadlines = req.getParameter("deadline");
		String workrogress = req.getParameter("workrogress");
		String employeeid = req.getParameter("employeeid");
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date deliverydate = dateFormat.parse(deliverydates);
			Date deadline = dateFormat.parse(deadlines);
			AssignedWork assignedWork = new AssignedWork(jobid, deliverydate, descriptions, deadline, workrogress, employeeid);
			AssignedWorkDAO assignedWorkDAO = new AssignedWorkDAO();
			assignedWorkDAO.update(assignedWork);
			resp.sendRedirect("listassignedwork");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
