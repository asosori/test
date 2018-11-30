package com.internousdev.ecsite.action;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ItemListAction extends ActionSupport implements SessionAware {

	public Map<String,Object>session;
	private ItemListDAO itemlistDAO=new ItemListDAO();
	private ArrayList<ItemInfoDTO> itemList=new ArrayList<ItemInfoDTO>();
	private String message;
	public String deleteFlg;

	public String execute()throws SQLException{
		if(!session.containsKey("id")){
			return ERROR;
		}

		if(deleteFlg==null){
			String item_name=session.get("id").toString();
			String user_master_id=session.get("item_name").toString();

			itemList=itemListDAO.getItemInfo(item_name,user_master_id);
		}
		else if(deleteFlg.equals("1")){
			delete();
		}
		String result=SUCCESS;
		return result;
	}

	public void delete()throws SQLException{

		String item_name=session.get("id").toString();
		String user_master_id=session.get("item_name").toString();

		int res = itemListDAO.itemListDelete(item_name, user_master_id);

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

    public ArrayList<ItemInfoDTO>getItemList(){
    	return this.itemList;
    }

    public String getMessage(){
    	return this.message;
    }

    public void setMessage(String message){
    	this.message=message;
    }
}
