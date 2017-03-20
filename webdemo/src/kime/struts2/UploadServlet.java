package kime.struts2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.jni.File;

public class UploadServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
//			设置请求参数的编码
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
//			下面的代码开始使用Commons-UploadFile组件处理上传的文件数据
			FileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(factory);
//			分析请求，并得到上传文件的FileItem对象
			List<FileItem> items=upload.parseRequest(request);
//			从web.xml文件中的参数中得到上传文件所在服务器端的路径
			String uploadPath=this.getInitParameter("path");
			String fileName="";
			InputStream is=null;
			for(FileItem item :items){
//				处理普通的表单域，获取文件名
				if (item.isFormField()) {
					if (item.getFieldName().equals("filename")) {
						if (!item.getString().equals("")) {
							fileName=item.getString("UTF-8");
						}
					}
				}else if (item.getName()!=null&&item.getName().equals("")) {
//					从上传的客户端发送过来的上传文件路径中截取文件名
					fileName=item.getName().substring(item.getString().lastIndexOf("\\")+1);
					is=item.getInputStream();
					
				}
				
				
			}
			
			fileName=uploadPath+fileName;
//			如果服务器已存在和上传文件同名的文件，则输出提示信息。
			if (new java.io.File(fileName).exists()) {
				out.println("该文件名已存在，请为文件指定一个新的文件名");
			}else if (!fileName.equals("")) {
				FileOutputStream fos=new FileOutputStream(fileName);
				byte[] buffer=new byte[8192];
				int count=0;
				while((count=is.read(buffer))>0){
					fos.write(buffer,0,count);
										
				}
				fos.close();
				is.close();
				out.print("文件上传成功");
			}
			
			
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
