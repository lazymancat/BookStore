package com.ssh.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ssh.model.ConsignmentAddress;
import com.ssh.model.Customer;

public class ConsignmentAddressDao {
	SessionFactory sessionFactory;
	
	public ConsignmentAddressDao(){}
	
	/**
	 * 根据传入的收货地址编号查找对应的收货地址 
	 * @param id
	 * @return
	 */
	public ConsignmentAddress getConsignmentAddressById(int id){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			String queryString = "from ConsignmentAddress where flag=0 and id = ?";  //数据库预编译查询语句
			Query query = session.createQuery(queryString);
			query.setParameter(0, id);  //设置参数
			
			List<ConsignmentAddress> list = (List<ConsignmentAddress>)query.list();
			
			if(list.isEmpty()){
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
	 * 根据传入的用户编号查询属于该用户的所有有效的收货地址列表
	 * @param cusId
	 * @return
	 */
	public List<ConsignmentAddress> getAllConsignmentAddressByCusId(int cusId){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			String queryString = "from ConsignmentAddress where flag=0 and cusId = ?";  //数据库预编译查询语句
			Query query = session.createQuery(queryString);
			query.setParameter(0, cusId);  //设置参数
			
			List<ConsignmentAddress> list = (List<ConsignmentAddress>)query.list();
			
			if(list.size() == 0){
				return null;
			}else{
				return list;
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
	 * 将传入的修改后的收货地址信息更新至数据库
	 * @param consignmentAddress
	 * @return
	 */
	public boolean reviseConsignmentAddress(ConsignmentAddress consignmentAddress){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			session.update(consignmentAddress);
			trans.commit();
			
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	/**
	 * 删除传入的收货地址
	 * @param consignmentAddress
	 * @return
	 */
	public boolean deleteConsignmentAddress(ConsignmentAddress consignmentAddress){
		Session session = null;
		try{
			consignmentAddress.setFlag(1);  //将收货地址的删除标记设置为已删除
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			session.update(consignmentAddress);
			trans.commit();
			
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	/**
	 * 将传入的收货地址添加至数据库
	 * @param consignmentAddress
	 * @return
	 */
	public boolean addConsignmentAddress(ConsignmentAddress consignmentAddress){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Transaction trans = session.beginTransaction();
			session.save(consignmentAddress);
			trans.commit();
			
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	/**
	 * 检查属于传入的用户编号所代表的用户的收货地址数量是否已经达到上限
	 * @param cusId
	 * @param quantityLimit
	 * @return
	 */
	public boolean checkAboveTheLimit(int cusId, int quantityLimit){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			String queryString = "from ConsignmentAddress where flag=0 and cusId = ?";  //数据库预编译查询语句
			Query query = session.createQuery(queryString);
			query.setParameter(0, cusId); //设置参数
			
			List<ConsignmentAddress> list = (List<ConsignmentAddress>)query.list();
			
			if(list.size() >= quantityLimit){
				return true;
			}else{
				return false;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return true;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	
	
	
	
	
	//输入：用户id 输出：成功-该用户的常用地址list 失败-null
	public List<ConsignmentAddress> getConsignmentAddressbyCusId(int cusId){
		Session session=null;
		try{
			//获得session
			session=sessionFactory.openSession(); //得到session对象
			String queryString="from ConsignmentAddress where cusId = ? and  flag = 0";
			Query query=session.createQuery(queryString);
			query.setParameter(0, cusId);
			return query.list();
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			//关闭session
			session.close();
		}
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
