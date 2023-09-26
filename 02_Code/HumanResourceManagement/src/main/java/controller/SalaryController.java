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
import model.Salary;

@WebServlet (urlPatterns = {"/salary"})
public class SalaryController extends HttpServlet{
	private SalaryDAO salaryDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		salaryDAO = new SalaryDAO();
		List<Salary> salaries = new ArrayList<Salary>();
		salaries = salaryDAO.getTotalSalary();
		req.setAttribute("salaries", salaries);
		req.getRequestDispatcher("/Views/Admin/listsalary.jsp").forward(req, resp);
	}
}
