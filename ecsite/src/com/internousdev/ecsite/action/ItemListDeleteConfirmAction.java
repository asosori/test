package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteConfirmAction extends ActionSupport implements SessionAware{
public Map<String,Object> session;
private ItemListDeleteCompleteDAO itemListDeleteCompleteDAO = new ItemListDeleteCompleteDAO();

public String execute() throws SQLException {

ItemListDeleteCompleteDAO.ItemeInfo(

session.get("id").toString(),
session.get("item_name").toString(),
session.get("item_price").toString(),
session.get("item_stock").toString());
String result = SUCCESS;
return result;

}

@Override
public void setSession(Map<String, Object> session) {

this.session = session;

}

}