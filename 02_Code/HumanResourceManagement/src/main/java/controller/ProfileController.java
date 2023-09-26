package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import model.Profile;

@WebServlet (urlPatterns = {"/profile"})
public class ProfileController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String employeeid = req.getParameter("employeeid");
		try {
			EmployeeDAO employeeDAO = new EmployeeDAO();
			Profile profile = employeeDAO.profiledisplay(employeeid);
			req.setAttribute("profile", profile);
			req.getRequestDispatcher("/Views/Admin/profile.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
