package kime.test1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowImage extends HttpServlet {

	/**
	 * 在页面输出一个图片
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/JPEG");
		OutputStream os= resp.getOutputStream();
		byte[] buffer=new byte[8192];
		String image=req.getParameter("name");
		//String image="E:\\图片\\1.jpg";
		FileInputStream fS=new FileInputStream(image);
		int count=0;
		while(true){
			count=fS.read(buffer);
			if (count<=0) {
				break;
			}
			os.write(buffer);			
		}
		fS.close();
	}

}
