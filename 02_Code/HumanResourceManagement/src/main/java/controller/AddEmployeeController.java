package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import model.EmployeeDetail;
import model.Profile;

@WebServlet (urlPatterns = {"/addemployee"})
public class AddEmployeeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("Views/Admin/addemployee.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String employeeid = req.getParameter("employeeid");
		String employeename = req.getParameter("employeename");
		String employeebirths = req.getParameter("employeebirth");
		String employeeaddress = req.getParameter("employeeaddress");
		String employeehometown = req.getParameter("employeehometown");
		String enoloyeephone = req.getParameter("enoloyeephone");
		String employeeworkdays = req.getParameter("employeeworkday");
		String employeeexp = req.getParameter("employeeexp");
		String positionid = req.getParameter("positionid");
		String departmentid = req.getParameter("departmentid");
		String image = req.getParameter("image");
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date employeebirth = dateFormat.parse(employeebirths);
			Date employeeworkday = dateFormat.parse(employeeworkdays);
			EmployeeDetail emDetail = new EmployeeDetail(employeeid, image, employeename, employeebirth, employeeaddress, employeehometown, enoloyeephone, employeeworkday, employeeexp, positionid, departmentid);
			EmployeeDAO employeeDAO = new EmployeeDAO();
			EmployeeDetail exits = employeeDAO.getByID(employeeid);
			if(exits == null) {
				employeeDAO.insert(emDetail);
				resp.sendRedirect("listemployee");
			}
			else {
				req.setAttribute("error", "Mã "+employeeid+" đã tồn tại!");
				req.getRequestDispatcher("/Views/Admin/addemployee.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
