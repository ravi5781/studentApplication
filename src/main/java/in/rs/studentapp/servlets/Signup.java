package in.rs.studentapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import in.rs.studentapp.dao.StudentImp;
import in.rs.studentapp.dto.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/signup")
public class Signup extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student s=new Student();
		StudentImp sdao=new StudentImp();
		PrintWriter out=resp.getWriter();
		
		s.setName(req.getParameter("name"));
		s.setPhone(Long.parseLong(req.getParameter("phone")));
		
		s.setMail(req.getParameter("mail"));
		s.setBranch(req.getParameter("branch"));
		s.setLoc(req.getParameter("loc"));
		
		if(req.getParameter("password").equals(req.getParameter("confirm"))) {
			s.setPassword(req.getParameter("password"));
			boolean res=sdao.insertStudent(s);
			if(res) {
				out.println("<h1>Data added successfully</h1>");
			}
			else {
				out.println("<h1>Failed to add the data</h1>");
			}
		}
		else {
			out.println("<h1>Password mismatch</h1>");
		}
		
	}
	
}
