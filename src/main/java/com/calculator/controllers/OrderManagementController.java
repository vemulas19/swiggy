package com.calculator.controllers;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.calculator.pojo.ItemInfo;
import com.calculator.service.OrderManagementService;

@Controller
public class OrderManagementController {

	@Autowired
	OrderManagementService service;
	
	final static Logger log = Logger.getLogger(OrderManagementController.class);
	
	@RequestMapping(value = "/addItemPage")
	public String showAddItemPage(Model model) {
		/*
		 * String userName = (String) httpSession.getAttribute("userName");
		 * System.out.println("Show menu for :  " + userName); if(userName==null ||
		 * userName.isEmpty()) { model.addAttribute("message",
		 * "Please login first to access menu page!!"); return "login"; }
		 */
		
		log.info("executing OrderManagementController :: showAddItemPage method");
		log.info("exit OrderManagementController :: showAddItemPage method");
		return "addItemToMenu";
	}

	@RequestMapping(value = "/addItemToMenu", method = RequestMethod.POST)
	public String addItemToMenu(ItemInfo item, Model model) {
		// Save Item details to database
		
		/*
		 * String userName = (String) httpSession.getAttribute("userName");
		 * System.out.println("Show menu for :  " + userName); if(userName==null ||
		 * userName.isEmpty()) { model.addAttribute("message",
		 * "Please login first to access menu page!!"); return "login"; }
		 */
		
		log.info("executing OrderManagementController :: addItemToMenu");
		log.debug(item.getItem() + "--" + item.getPrice() + "--" + item.getTypeOfItem());

		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = configure.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tc = session.beginTransaction();
		session.save(item);
		tc.commit();
		session.close();
		String msg = item.getItem() + " added to menu succssfully!!";
		model.addAttribute("message", msg);
		log.info("exit OrderManagementController :: addItemToMenu");
		return "addItemToMenu";
	}

	@RequestMapping(value = "/showMenu")
	public String showMenu(Model model/* , HttpSession httpSession */) {
		
		/*
		 * String userName = (String) httpSession.getAttribute("userName");
		 * System.out.println("Show menu for :  " + userName); if(userName==null ||
		 * userName.isEmpty()) { model.addAttribute("message",
		 * "Please login first to access menu page!!"); return "login"; }
		 */
		
		
		Configuration configure = new Configuration().configure("hibernate.cfg.xml");
		SessionFactory sf = configure.buildSessionFactory();
		Session session = sf.openSession();

		Query query = session.createQuery("from ItemInfo");
		List<ItemInfo> menuData = query.list();

		for (ItemInfo itemInfo : menuData) {
			log.debug(itemInfo.getItemId() + itemInfo.getItem() + itemInfo.getPrice());
		}
		// setting menuData into model. will use this in menu jsp. menuData contains all
		// item details/menu details
		model.addAttribute("menuData", menuData);
		return "menu";
	}

	@RequestMapping(value = "/deleteItem", method = RequestMethod.POST)
	public String deleteItem(@RequestParam("itId") int itemId, Model model) {
		log.info("Delete request came for : " + itemId);
		String res = service.deleteItem(itemId, model);
		log.info("exit from OrderManagementController :: deleteItem!!");
		return res;
	}

	@RequestMapping(value = "/editItemView", method = RequestMethod.POST)
	public String editView(@RequestParam("itemId") int itId, Model model) {
		log.info("executing OrdermangementController :: editView");
		String resultPage = service.editView(itId, model);
		log.info("exit OrdermangementController :: editView");
		return resultPage;
	}

	@RequestMapping(value = "/updateItem", method = RequestMethod.POST)
	public String updateItem(ItemInfo item, Model model) {
		log.info("executing OrderManagementController :: updateItem");
		String result = service.updateItem(item, model);
		log.info("exit OrderManagementController :: updateItem");
		return result;
	}
	
	@RequestMapping(value="/deleteMultiple")
	public String deleteMultiple(@RequestParam("itemCheckBox") String items) {
		log.info("Selected items : " + items);
		//split items by comma separated string
		//delete one by one item
		//fetch updated menu
		//set it to model and forward to menu.jsp
		return "menu";
	}
}
