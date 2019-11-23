package com.calculator.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.calculator.dao.interf.IOrderManagementDao;
import com.calculator.pojo.ItemInfo;

public class OrderManagementJdbcDaoImpl implements IOrderManagementDao {//Assume this is Cat

	final static Logger logger = Logger.getLogger(OrderManagementJdbcDaoImpl.class);
	
	public int deleteItem(int itemId) {
		logger.info("executing OrderManagementJdbcDaoImpl :: deleteItem");
		int count = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SYSTEM", "system");
			PreparedStatement ps = con.prepareStatement("delete from menu where itemid = ?");
			ps.setInt(1, itemId);
			count = ps.executeUpdate();
		} catch (Exception e) {
			logger.error("Exception occured while deleting item : "+itemId , e);
		}
		logger.info("exit OrderManagementJdbcDaoImpl :: deleteItem");
		return count;
	}

	public List<ItemInfo> fetchMenu() {
		logger.info("executing OrderManagementJdbcDaoImpl :: fetchMenu");
		List<ItemInfo> itemInfoList = new ArrayList<ItemInfo>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "SYSTEM", "system");
			PreparedStatement ps = con.prepareStatement("select *from menu");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int itemId = rs.getInt("itemId");
				String item = rs.getString("item");
				String qty = rs.getString("qty");
				int price = rs.getInt("price");
				String typeOfItem = rs.getString("typeOfItem");
				
				ItemInfo itemInfo = new ItemInfo();
				itemInfo.setItemId(itemId);
				itemInfo.setItem(item);
				itemInfo.setQty(qty);
				itemInfo.setPrice(price);
				itemInfo.setTypeOfItem(typeOfItem);
				itemInfoList.add(itemInfo);
			}
			
		} catch (Exception e) {
			logger.error("Exception occured while fetching menu information : ", e);
		}
		logger.info("exit OrderManagementJdbcDaoImpl :: fetchMenu");
		return itemInfoList;
	}

	public void updateItem(ItemInfo item) {
		logger.info("Jdbc flow");
		// TODO Auto-generated method stub
		
	}

	public ItemInfo getItemInfoByItemId(int itemId) {
		logger.info("Jdbc flow");
		// TODO Auto-generated method stub
		return null;
	}

}
