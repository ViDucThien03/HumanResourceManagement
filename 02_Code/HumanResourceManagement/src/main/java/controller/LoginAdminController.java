package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import model.Account;
@WebServlet(urlPatterns = {"/loginAdmin"})
public class LoginAdminController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("Views/Admin/login_admin.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		AccountDAO accountDAO = new AccountDAO();
		Account account = accountDAO.checkLogin(username, password);
		if(account != null) {
			HttpSession session = req.getSession();
			session.setAttribute("username", account.getUserName());
			resp.sendRedirect("listassignedwork");
		}else {
			req.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
			req.getRequestDispatcher("/Views/Admin/login_admin.jsp").forward(req, resp);
		}
	}
}
