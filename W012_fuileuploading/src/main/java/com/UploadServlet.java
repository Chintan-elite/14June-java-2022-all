package com;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = "D:\\Classwork\\14June_java\\W012_fuileuploading\\src\\main\\webapp\\img";
		
		String name = request.getParameter("name");
		Part file = request.getPart("file");
		
		String filename = Paths.get(file.getSubmittedFileName()).getFileName().toString();
		
		
		file.write(path+File.separator+filename);
		
		
		
	}

}
