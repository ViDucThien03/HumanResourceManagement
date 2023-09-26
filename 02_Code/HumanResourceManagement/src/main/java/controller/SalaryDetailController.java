package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SalaryDAO;
import model.SalaryDetail;

@WebServlet (urlPatterns = {"/salarydetails"})
public class SalaryDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String employeeid = req.getParameter("employeeid");
		try {
			SalaryDAO salaryDAO = new SalaryDAO();
			SalaryDetail salary = salaryDAO.payrolldisplay(employeeid);
			req.setAttribute("salary", salary);
			req.getRequestDispatcher("/Views/Admin/salarydetail.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
}
