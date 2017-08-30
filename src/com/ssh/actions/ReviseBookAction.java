package com.ssh.actions;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.dao.BookDao;
import com.ssh.model.Book;

public class ReviseBookAction extends ActionSupport{
	//定义私有属性
	private File upload;
	private String uploadFileName; //文件名
	private String uploadContentType; //文件类型
	
	Book book;
	BookDao bd;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public BookDao getBd() {
		return bd;
	}
	public void setBd(BookDao bd) {
		this.bd = bd;
	}
	
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	//复制文件
	public void uploadFile(File target, File source){
		try{
			//创建输入流对象
			FileInputStream fis=new FileInputStream(source);
			DataInputStream dis=new DataInputStream(fis);
			
			//创建输出流对象
			FileOutputStream fos=new FileOutputStream(target);
			DataOutputStream dos=new DataOutputStream(fos);
			int temp;
			
			while((temp=dis.read())!=-1){
				dos.write(temp);
			}
			//关闭
			dis.close();
			fis.close();
			dos.close();
			fos.close();
		}catch(FileNotFoundException ex){
			System.out.println("文件找不到");
			ex.printStackTrace();
		}catch(IOException ex){
			System.out.println("文件读写异常");
			ex.printStackTrace();
		}
	}

	public void validate(){
		System.out.println("这是ReviseBookAction的validate");
		if(book.getName().equals("")){
			System.out.println("----------------");
			this.addFieldError("errorName", "*不可以为空！");
		}
		if(book.getAuthor().equals("")){
			System.out.println("----------------");
			this.addFieldError("errorAuthor", "*不可以为空！");
		}
		if(book.getPrice()<=0){
			System.out.println("----------------");
			this.addFieldError("errorPrice", "*必须为正数！");
		}
		if(book.getPublisher().equals("")){
			System.out.println("----------------");
			this.addFieldError("errorPublisher", "*不可以为空！");
		}
		if(book.getIsbn().equals("")){
			System.out.println("----------------");
			this.addFieldError("errorISBN", "*不可以为空！");
		}
	}
	
	public static String getRandomString(int length){
	     String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	     Random random=new Random();
	     StringBuffer sb=new StringBuffer();
	     for(int i=0;i<length;i++){
	       int number=random.nextInt(62);
	       sb.append(str.charAt(number));
	     }
	     return sb.toString();
	}
	
	public String execute() throws Exception{
		//获取所有用户的信息
		System.out.println("这是ReviseBookAction的excute");
		System.out.println("图书bookId:"+book.getId());
		System.out.println("图书bookType:"+book.getTypeId());
		System.out.println("图书bookPageCount:"+book.getPageCount());
		System.out.println("图书bookWordCount:"+book.getWordCount());
		System.out.println("图书bookImage:"+book.getImage());

		System.out.println("File:"+upload);
		System.out.println("文件名:"+uploadFileName);
		System.out.println("文件类型:"+uploadContentType);
		
		if(upload!=null){
			uploadFileName = getRandomString(10)+".jpg";
			
			book.setImage(uploadFileName);
			
			//获取文件上传路径,括号里的upload是指文件夹upload不是上面的文件upload
			String filePath=ServletActionContext.getServletContext().getRealPath("img/books")
	        +"\\"+this.uploadFileName;
			
			System.out.println("文件位置；"+filePath);
			
			File target=new File(filePath);
			//调用uploadFile方法进行文件复制
			uploadFile(target,upload);
		}
		if(book.getIntroduction()==null||book.getIntroduction().equals(""))
			book.setIntroduction("无");
		
		bd.ReviseBook(book);
		
		return LOGIN;
	}
}
