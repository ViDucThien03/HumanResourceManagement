package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import model.EmployeeSummary;

@WebServlet(urlPatterns = {"/listemployee"})
public class ListEmployeeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String departmentid = req.getParameter("departmentid");
        try {
            EmployeeDAO employeeDAO = new EmployeeDAO();
            List<EmployeeSummary> employee = employeeDAO.getEmployee(departmentid); // Đổi tên biến
            req.setAttribute("employee", employee); // Đổi tên biến
            req.getRequestDispatcher("/Views/Admin/employee.jsp").forward(req, resp);
        } catch (Exception e) {
            // Xử lý ngoại lệ
        }
    }
}
