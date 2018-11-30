package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.ItemListDeleteCompleteDAO;
import com.internousdev.ecsite.dto.ItemListDeleteCompleteDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ItemListDeleteCompleteAction extends ActionSupport implements SessionAware {

	public Map<String,Object>session;
	private ItemListDeleteCompleteDAO itemListDeleteCompleteDAO=new ItemListDeleteCompleteDAO();
	private ArrayList<ItemListDeleteCompleteDTO> itemList=new ArrayList<ItemListDeleteCompleteDTO>();
	private String message;
	public String deleteFlg;

	public String execute()throws SQLException{
		if(!session.containsKey("id")){
			return ERROR;
		}

		if(deleteFlg==null){
			String item_name=session.get("id").toString();
			String user_master_id=session.get("login_user_id").toString();

			itemList=itemListDeleteCompleteDAO.getItemInfo(item_name,user_master_id);
		}
		else if(deleteFlg.equals("1")){
			delete();
		}
		String result=SUCCESS;
		return result;
	}

	public void delete()throws SQLException{

		String item_name=session.get("id").toString();
		String user_master_id=session.get("login_user_id").toString();

		int res = itemListDeleteCompleteDAO.itemHistoryDelete(item_name, user_master_id);

		if(res>0){
			itemList=null;
			setMessage("商品情報を正しく削除しました");
		}else if(res==0){
			setMessage("商品情報の削除に失敗しました");
		}
	}


public String getDeleteFlg() {

	return deleteFlg;
}

    public void setDeleteFlg(String deleteFlg){
	  this.deleteFlg = deleteFlg;
    }

    @Override
    public void setSession(Map<String,Object>session){
    	this.session=session;
    }

    public ArrayList<ItemListDeleteCompleteDTO>getItemList(){
    	return this.itemList;
    }

    public String getMessage(){
    	return this.message;
    }

    public void setMessage(String message){
    	this.message=message;
    }
}
