package com.calculator.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.calculator.dao.interf.IOrderManagementDao;
import com.calculator.pojo.ItemInfo;

public class OrderManagementService {

	@Autowired
	IOrderManagementDao dao;

	final static Logger logger = Logger.getLogger(OrderManagementService.class);
	
	public String deleteItem(int itemId, Model model) {
		logger.info("executing OrderManagementService :: deleteItem!!");
		int result = dao.deleteItem(itemId);

		if (result == 1) {
			logger.debug("Deleted Succssful!!" + itemId);
			String message = itemId + " deleted successfully!!";
			model.addAttribute("msg", message);// adding msg to model. will show this message in menu.jsp page.
		} else {
			logger.debug("Failed to delete!!" + itemId);
			String message = itemId + " failed to delete!!";
			model.addAttribute("msg", message);
		}

		// fetching updated menu data to show in view page
		List<ItemInfo> menuData = dao.fetchMenu();
		model.addAttribute("menuData", menuData);// menuData name should match with forEach loop in menu.jsp
		logger.info("exit OrderManagementService :: deleteItem!!");
		return "menu";
	}
	
	public String updateItem(ItemInfo item, Model model) {
		logger.info("executing OrderManagementService :: updateItem");
		
		dao.updateItem(item);
		
		String message = item.getItem() + " updated successfully!!";
		model.addAttribute("msg", message);
		logger.debug(message);
//		fetching updated menu data to show in view page

		List<ItemInfo> fetchMenu = dao.fetchMenu();
		model.addAttribute("menuData", fetchMenu);

		logger.info("exit OrderManagementService :: updateItem");
		return "menu";
	}
	
	public String editView(int itId, Model model) {
		logger.info("executing OrdermangementService :: editView");
		ItemInfo item = dao.getItemInfoByItemId(itId);

		// set itemInfo to model, to display in editView
		model.addAttribute("itInfo", item);
		if (item.getTypeOfItem().equals("Veg")) {
			model.addAttribute("veg", "checked");
		} else {
			model.addAttribute("nonVeg", "checked");
		}
		logger.info("exit OrdermangementService :: editView");
		return "editView";
	}
}
