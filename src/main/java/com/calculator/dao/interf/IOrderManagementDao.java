package com.calculator.dao.interf;

import java.util.List;

import com.calculator.pojo.ItemInfo;

public interface IOrderManagementDao {

	public int deleteItem(int itemId);
	public List<ItemInfo> fetchMenu();
	public void updateItem(ItemInfo item);
	public ItemInfo getItemInfoByItemId(int itemId);
	
}
