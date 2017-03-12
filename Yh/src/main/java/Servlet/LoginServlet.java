package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("uname");
		String password = req.getParameter("upwd");

		System.out.println("�û�����" + userName);
		System.out.println("���룺" + password);
		
		Connection conn = null;
		PreparedStatement pre = null;
		String sql = "select * from user u where u.uname=? and u.upwd=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/o", "root", "root");

			pre = conn.prepareStatement(sql);
			pre.setString(1, userName);
			pre.setString(2, password);
			
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				req.getRequestDispatcher("index.jsp").forward(req, resp);

			}
			pre.close();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
