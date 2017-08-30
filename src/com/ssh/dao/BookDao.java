package com.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;

import com.ssh.model.Book;

public class BookDao {
	SessionFactory sessionFactory;
	
	public void BookDao(){}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	//获取指定分类的所有的书本方法
	public List<Book> getNewBooks(int bookType){
		Session session=null;
		try{
			//获得session
			session=sessionFactory.openSession(); //得到session对象
			//HQL语句
			String queryString="from Book where flag=0 and typeId=? "; //Like '%" + bookType + "%'
			//得到Query对象
			Query query=session.createQuery(queryString);
			query.setParameter(0, bookType);
			//执行查询HQL语句
			List list=(List)query.list();
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	//NewBook页面的分页功能
		public List<Book> queryByPage(int pageNo,int pageSize,int bookType){//临时状态
			Session session=null;
			try{
				//获得session
				session=sessionFactory.openSession(); //得到session对象
				String queryString="from Book where flag=0 and typeId=?";
				Query query=session.createQuery(queryString);
				query.setParameter(0, bookType);
				
				//分页查询
				query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
				query.setMaxResults(pageSize); //这一页显示的记录个数
				List<Book> list=query.list(); //只返回5条数据
				return list;
			}catch(Exception ex){
				ex.printStackTrace();
				return null;
			}finally{
				//关闭session
				session.close();
			}
		}
		
		//ManageBook页面的分页功能
		public List<Book> manageByPage(int pageNo,int pageSize){//临时状态
			Session session=null;
			try{
				//获得session
				session=sessionFactory.openSession(); //得到session对象
				String queryString="from Book Where flag=0";
				Query query=session.createQuery(queryString);
				
				//分页查询
				query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
				query.setMaxResults(pageSize); //这一页显示的记录个数
				List<Book> list=query.list(); //只返回5条数据
				return list;
			}catch(Exception ex){
				ex.printStackTrace();
				return null;
			}finally{
				//关闭session
				session.close();
			}
		}
		
		//获取随机的书本方法
		public List<Book> randomBook(int sum){
			//临时状态
			System.out.println("这里是randomBook开头");
			Session session=null;
			try{
				//获得session
				session=sessionFactory.openSession(); //得到session对象
				//SQL语句
				String queryString="Select * from Books Where flag=0 Order By NewID()"; //Like '%" + bookType + "%'
				//得到Query对象
				SQLQuery sqlquery = session.createSQLQuery(queryString).addEntity(Book.class);
				sqlquery.setMaxResults(sum); //这一页显示的记录个数
				List<Book> list = (List<Book>)sqlquery.list(); //只返回3条数据
				System.out.println("这里是randomBook结尾");
				return list;
			}catch(Exception ex){
				System.out.println("这里是错误!");
				ex.printStackTrace();
				return null;
			}finally{
				//关闭session
				session.close();
			}
		}
		
		//获取全部书本的方法
		public List<Book> getAllBook(){
			//临时状态
			System.out.println("这里是getAllBook开头");
			Session session=null;
			try{
				//获得session
				session=sessionFactory.openSession(); //得到session对象
				String queryString="from Book Where flag=0";
				Query query=session.createQuery(queryString);
				System.out.println("这里是getAllBook结尾");
				//执行查询HQL语句
				List list=(List)query.list();
				return list;
			}catch(Exception ex){
				System.out.println("这里是getAllBook错误!");
				ex.printStackTrace();
				return null;
			}finally{
				//关闭session
				session.close();
			}
		}
			
		//通过Id获取全部书本的方法
		public Book queryBookById(int bookId){//临时状态
			System.out.println("这里是queryBookById开头");
			Session session=null;
			try{
				//获得session
				session=sessionFactory.openSession(); //得到session对象
				String queryString="from Book where flag=0 and id=?";
				Query query=session.createQuery(queryString);
				query.setParameter(0, bookId);
				//执行查询HQL语句
				List<Book> list= (List<Book>)query.list();
				System.out.println("这里是queryBookById结尾");
				return list.get(0);
			}catch(Exception ex){
				System.out.println("这里是queryBookById错误!");
				ex.printStackTrace();
				return null;
			}finally{
				//关闭session
				session.close();
			}
		}
		
	//通过bookId删除书本
	public boolean deleteBookById(int id){//临时状态
		System.out.println("这里是deleteBookById开头");
		Session session=null;
		boolean flag=true;
		try{
			//获得session
			session=sessionFactory.openSession(); //得到session对象
			Book book=(Book)session.load(Book.class,id);
			book.setFlag(1);
			Transaction trans=session.beginTransaction();
			session.update(book);
			trans.commit();
		}catch(Exception ex){
			System.out.println("这里是deleteBookById错误!");
			ex.printStackTrace();
			flag=false;
		}finally{
			//关闭session
			session.close();
		}
		return flag;
	}

	//新添图书的方法
		public boolean AddNewBook(Book book){
			//临时状态
			System.out.println("这里是ReviseBook开头");
			Session session=null;
			try{
				//获得session
				session=sessionFactory.openSession(); //得到session对象
				//SQL语句
				Transaction trans=session.beginTransaction();
				session.save(book);
				trans.commit();
				System.out.println("这里是ReviseBook结尾");
				return true;
			}catch(Exception ex){
				System.out.println("这里ReviseBook是错误!");
				ex.printStackTrace();
				return false;
			}finally{
				//关闭session
				session.close();
			}
		}
		
		//修改图书的方法
		public boolean ReviseBook(Book book){
			//临时状态
			System.out.println("这里是ReviseBook开头");
			Session session=null;
			try{
				//获得session
				session=sessionFactory.openSession(); //得到session对象
				//SQL语句
				Transaction trans=session.beginTransaction();
				session.update(book);
				trans.commit();
				System.out.println("这里是ReviseBook结尾");
				return true;
			}catch(Exception ex){
				System.out.println("这里ReviseBook是错误!");
				ex.printStackTrace();
				return false;
			}finally{
				//关闭session
				session.close();
			}
		}
		
		/*
		 * 通过图书编号获取目标图书实体
		 */
		public Book getBookByBookId(int bookId){
			Session session=null;
			try{
				//获得session
				session=sessionFactory.openSession(); //得到session对象
				String queryString="from Book where flag=0 and id=?";
				Query query=session.createQuery(queryString);
				query.setParameter(0, bookId);
				return (Book)query.list().get(0);
			}catch(Exception ex){
				ex.printStackTrace();
				return null;
			}finally{
				//关闭session
				session.close();
			}
		}
		
		//获取搜索的书籍
		public List<Book> SerachBook(String bookName){
			//临时状态
			System.out.println("SerachBook开头。");
			Session session=null;
			try{
				//获得session
				session=sessionFactory.openSession(); //得到session对象
				String queryString="from Book Where flag=0 and name Like ?";//模糊查询
				Query query=session.createQuery(queryString);
				query.setParameter(0, "%"+bookName+"%");//传值给name
				System.out.println("SerachBook结尾");
				//执行查询HQL语句
				List list=(List)query.list();
				return list;
			}catch(Exception ex){
				System.out.println("SerachBook报错!");
				ex.printStackTrace();
				return null;
			}finally{
				//关闭session
				session.close();
			}	
		}
		
		//ManageBook页面的分页功能
		public List<Book> manageBookByPage(int pageNo,int pageSize,String bookName){
			//临时状态
			Session session=null;
			try{
				//获得session
				session=sessionFactory.openSession(); //得到session对象
				String queryString="from Book Where flag=0 and name Like ?";//模糊查询
				Query query=session.createQuery(queryString);
				query.setParameter(0, "%"+bookName+"%");//传值给name
				
				//分页查询
				query.setFirstResult((pageNo-1)*pageSize); //设置这一页显示的第一条记录的索引
				query.setMaxResults(pageSize); //这一页显示的记录个数
				List<Book> list=query.list(); //只返回5条数据
				return list;
			}catch(Exception ex){
				ex.printStackTrace();
				return null;
			}finally{
				//关闭session
				session.close();
			}
		}
		
		//获取新产品书籍
		public List<Book> getNewProduct(){
			//临时状态
			Session session=null;
			try{
				//获得session
				session=sessionFactory.openSession(); //得到session对象
				String queryString="from Book Where flag=0 Order by id Desc";//倒序排列
				Query query=session.createQuery(queryString);
				
				query.setMaxResults(10); //这一页显示的记录个数
				List<Book> list=query.list(); //只返回510条数据
				return list;
			}catch(Exception ex){
				ex.printStackTrace();
				return null;
			}finally{
				//关闭session
				session.close();
			}
		}
		
		//获取最便宜的书籍
		public List<Book> cheapBook(){
			//临时状态
			Session session=null;
			try{
				//获得session
				session=sessionFactory.openSession(); //得到session对象
				String queryString="from Book Where flag=0 Order by price Asc";//倒序排列
				Query query=session.createQuery(queryString);
				
				query.setMaxResults(10); //这一页显示的记录个数
				List<Book> list=query.list(); //只返回510条数据
				return list;
			}catch(Exception ex){
				ex.printStackTrace();
				return null;
			}finally{
				//关闭session
				session.close();
			}
			
		}
		
		//判断ISBN是否存在
		public boolean checkISBNExist(String isbn){
			//临时状态
			Session session=null;
			try{
				//获得session
				session=sessionFactory.openSession(); //得到session对象
				String queryString="from Book Where flag=0 and isbn=?";//倒序排列
				Query query=session.createQuery(queryString);
				
				query.setParameter(0, isbn);
				List<Book> list=query.list(); //只返回510条数据
				if(list.size()<1)
					return false;
				else
					return true;
			}catch(Exception ex){
				ex.printStackTrace();
				return true;
			}finally{
				//关闭session
				session.close();
			}
			
		}

		//通过图书编号获取目标图书实体
		public Book getBookByBookIdWCH(int bookId){
			Session session=null;
			try{
				//获得session
				session=sessionFactory.openSession(); //得到session对象
				String queryString="from Book where id=? and flag = 0";
				Query query=session.createQuery(queryString);
				query.setParameter(0, bookId);
				List list = query.list();
				if(list == null || list.size() == 0){
					System.out.println("书不存在或已被删除");//
					return null;
				}
				return (Book)list.get(0);
			}catch(Exception ex){
				ex.printStackTrace();
				return null;
			}finally{
				//关闭session
				session.close();
			}
		}
}
