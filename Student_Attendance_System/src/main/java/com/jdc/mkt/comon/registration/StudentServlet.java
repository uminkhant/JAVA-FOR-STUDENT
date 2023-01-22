package com.jdc.mkt.comon.registration;

import java.io.IOException;

import com.jdc.mkt.ds.Address;
import com.jdc.mkt.ds.ClassRoom;
import com.jdc.mkt.ds.Student;
import com.jdc.mkt.service.ClassRoomService;
import com.jdc.mkt.service.StudentService;
import com.jdc.mkt.service.impl.ClassRoomServiceImpl;
import com.jdc.mkt.service.impl.StudentServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/members/list-students", "/save-student", "/admin/add-student" })
public class StudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private StudentService studentSevice;
	private ClassRoomService classRoomService;

	@Override
	public void init() throws ServletException {
		studentSevice = new StudentServiceImpl();
		classRoomService = new ClassRoomServiceImpl();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setAttribute("students", studentSevice.getStudents(0, null, null));
		
		req.getRequestDispatcher("/header").include(req, resp);
		req.getRequestDispatcher(req.getServletPath().concat(".jsp")).include(req, resp);
		req.getRequestDispatcher("/footer").include(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String city = req.getParameter("city");
		String township = req.getParameter("township");
		String street = req.getParameter("street");
		String room = req.getParameter("room");

		Address ad = new Address();
		ad.setCity(city);
		ad.setTownship(township);
		ad.setStreet(street);

		ClassRoom cl = classRoomService.getClassRooms(0, room).stream().findFirst().orElse(null);

		Student st = new Student(name, phone, email, cl, ad);
		studentSevice.saveStudent(st);
		resp.sendRedirect(req.getContextPath().concat("/admin/add-student"));
	}

}
