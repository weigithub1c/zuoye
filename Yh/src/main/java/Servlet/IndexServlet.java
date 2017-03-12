package Servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			FileInputStream fis = new FileInputStream("D:/hand培训/培训视频/安装软件/eclipse/ppppp/WebContent/g.jpg");
			BufferedInputStream bis = new BufferedInputStream(fis);
			FileOutputStream fos = new FileOutputStream("D:/hand培训/培训视频/安装软件/eclipse/ppppp/WebContent/down1.jpg");
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			byte[] b = new byte[1];
			int line = 0;
			while ((line = bis.read(b)) != -1) {
				bos.write(b, 0, line);
			}
			bos.flush();
			bos.close();
			fos.close();
			bis.close();
			fis.close();
				
			req.getRequestDispatcher("success.jsp").forward(req, resp);
		}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}



}
