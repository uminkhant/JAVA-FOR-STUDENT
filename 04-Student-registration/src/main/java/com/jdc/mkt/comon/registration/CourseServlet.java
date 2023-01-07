package com.jdc.mkt.comon.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static com.jdc.mkt.utils.ConnectionManager.getConnector;

@WebServlet(value = { "/save-course","/list-courses","/add-course"})
public class CourseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("commons/header.jsp").include(req, resp);
		req.getRequestDispatcher(req.getServletPath().concat(".jsp")).include(req, resp);
		req.getRequestDispatcher("commons/footer.jsp").include(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String sql = "select * from user_tbl";
		String sql="insert into stu_tbl values(?,?)";
		try (Connection con = getConnector(); PreparedStatement stmt = con.prepareStatement(sql)) {
			
			stmt.setInt(1, 2);
			stmt.setString(2, "hi");
			stmt.executeUpdate();
			
//			var rs=stmt.executeQuery();
//			
//			while(rs.next()) {
//				System.out.println(rs.getInt(1));
//			}
			
			System.out.println("successfully save mkt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
