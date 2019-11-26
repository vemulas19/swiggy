package com.calculator.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.calculator.dao.interf.IOrderManagementDao;
import com.calculator.pojo.ItemInfo;

public class OrderManagementHibernateDaoImpl implements IOrderManagementDao {//Assume this is Dog

	final static Logger logger = Logger.getLogger(OrderManagementHibernateDaoImpl.class);
	
	public int deleteItem(int itemId) {
		logger.info("executing OrderManagementDaoImpl :: deleteIOrderManagementService.javatem");
		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = configure.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tc = session.beginTransaction();

		Query query = session.createQuery("delete ItemInfo where itemId = :id");
		query.setParameter("id", itemId);
		int result = query.executeUpdate();
		tc.commit();
		logger.debug("delete item done!!" + itemId);
		session.close();
		logger.info("exit OrderManagementDaoImpl :: deleteItem");
		return result;
	}
	
	public List<ItemInfo> fetchMenu() {
		logger.info("executing OrderManagementDaoImpl :: fetchMenu");
		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = configure.buildSessionFactory();
		Session session = sf.openSession();
		
		Query fetchMenuQuery = session.createQuery("from ItemInfo");
		List<ItemInfo> menuData = fetchMenuQuery.list();
		session.close();
		logger.info("exit OrderManagementDaoImpl :: fetchMenu");
		return menuData;
	}
	
	public void updateItem(ItemInfo item) {
		logger.info("executing OrderManagementDaoImpl :: updateItem");
		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = configure.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		session.update(item);
		tx.commit();
		logger.debug("update done for : " + item.getItem());
		logger.info("exit OrderManagementDaoImpl :: updateItem");
		session.close();
	}
	
	public ItemInfo getItemInfoByItemId(int itemId) {
		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = configure.buildSessionFactory();
		Session session = sf.openSession();

		// fetch item information from database based on itemId
		Query fetchMenuQuery = session.createQuery("from ItemInfo where itemId = :id");
		fetchMenuQuery.setParameter("id", itemId);
		ItemInfo item = (ItemInfo) fetchMenuQuery.list().get(0);
		logger.info("exit OrderManagementDaoImpl :: getItemInfoByItemId");
		return item;
	}
}
