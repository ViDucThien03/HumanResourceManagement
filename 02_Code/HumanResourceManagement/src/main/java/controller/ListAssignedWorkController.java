package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AssignedWorkDAO;
import model.AssignedWork;
import model.Top5Employee;

@WebServlet (urlPatterns = {"/listassignedwork"})
public class ListAssignedWorkController extends HttpServlet{
	private AssignedWorkDAO assignedWorkDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		assignedWorkDAO = new AssignedWorkDAO();
		List<AssignedWork> assignedWorks = new ArrayList<AssignedWork>();
		assignedWorks = assignedWorkDAO.getAll();
		req.setAttribute("assignedWorks", assignedWorks);
		int count = assignedWorkDAO.countTodayAssignedWorks();
        req.setAttribute("count", count);
        int countjd = assignedWorkDAO.countJobDone();
        req.setAttribute("countjd", countjd);
        double percent = assignedWorkDAO.percentDone();
        req.setAttribute("percent", percent);
        List<Top5Employee> list = new ArrayList<Top5Employee>();
        list = assignedWorkDAO.getTop5Employee();
        req.setAttribute("list", list);
		req.getRequestDispatcher("/Views/Admin/list_AssignedWork.jsp").forward(req, resp);
	}
}
