package com.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.type.StandardBasicTypes;

import com.ssh.model.Customer;

public class CustomerDao {
	SessionFactory sessionFactory;
	
	public CustomerDao(){}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * 检查传入的用户名与密码在数据库中是否存在
	 * @param regName
	 * @param password
	 * @return
	 */
	public Customer checkCustomerExist(String regName, String password){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			String queryString = "from Customer where flag=0 and regName = ? and password = ?";  //数据库预编译查询语句
			Query query=session.createQuery(queryString);
			query.setParameter(0, regName);  //设置参数
			query.setParameter(1, password);
			List<Customer> list = (List<Customer>)query.list();
			
			if(list.size() == 0){
				return null;	
			}else{
				return list.get(0);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}	
	
	/**
	 * 检查传入的用户名是否已被使用
	 * @param regName
	 * @return
	 */
	public boolean checkRegNameUnused(String regName){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			String queryString = "from Customer where regName = ?";  //数据库预编译查询语句
			Query query=session.createQuery(queryString);
			query.setParameter(0, regName);  //设置参数
			List<Customer> list = (List<Customer>)query.list();
			
			if(list.size() == 0){
				return true;
			}else{
				return false;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	public boolean checkRegNameUnused_revise(int id, String regName){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			String queryString = "from Customer where id != ? and regName = ?";  //数据库预编译查询语句
			Query query=session.createQuery(queryString);
			query.setParameter(0, id);
			query.setParameter(1, regName);  //设置参数
			List<Customer> list = (List<Customer>)query.list();
			
			if(list.size() == 0){
				return true;
			}else{
				return false;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	/**
	 * 将用户注册的账号添加至数据库
	 * @param customer
	 * @return
	 */
	public boolean registerCustomer(Customer customer){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			
			Transaction trans = session.beginTransaction();
			int num=Integer.parseInt(session.save(customer).toString()); //存到缓冲区里,并未真正写入数据库
			trans.commit();
			
			if(num == 0){
				return false;
			}else{
				return true;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			//关闭session
			session.close();
		}
	}	
	
	/**
	 * 将传入的修改后的用户资料更新至数据库
	 * @param customer
	 * @return
	 */
	public boolean reviseCustomerData(Customer customer){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			session.update(customer);
			trans.commit();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 将传入的修改后的用户密码更新至数据库
	 * @param customer
	 * @return
	 */
	public boolean reviseCustomerPassword(Customer customer){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			session.update(customer);
			trans.commit();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 根据传入的用户名关键字在数据库中模糊查询可能的用户
	 * @param nameKeyWord
	 * @return
	 */
	public List<Customer> getCustomerListByNameKeyWord(String nameKeyWord){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			String hql=" from Customer where flag=0 and regName like ?";  //数据库预编译查询语句
			Query query = session.createQuery(hql);
			
			if(nameKeyWord != null){
				query.setParameter(0, "%" + nameKeyWord +"%");  //设置参数
			}else{
				query.setParameter(0, "%");
			}
			
			List<Customer> cusList = (List<Customer>)query.list();
			
			return cusList;
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 根据传入的用户编号查询对应的用户
	 * @param id
	 * @return
	 */
	public Customer getCustomerById(int id){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			String hql=" from Customer where flag=0 and id=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, id);
			
			List<Customer> list = query.list();
			
			if(list.size() == 0){
				return null;
			}else{
				return list.get(0);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	/**
	 * 删除传入的用户
	 * @param cus
	 * @return
	 */
	public boolean deleteCustomer(Customer cus){
		Session session = null;
		try{
			cus.setFlag(1);  //将该用户的删除标记设置为已删除
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			session.update(cus);
			trans.commit();
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
}
