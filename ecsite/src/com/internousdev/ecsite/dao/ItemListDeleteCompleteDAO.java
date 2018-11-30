package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.util.DBConnector;

public class ItemListDeleteCompleteDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();

	public ArrayList<ItemListDeleteCompleteDTO>getItemInfo(String item_name,String user_master_id)throws SQLException{
	   ArrayList<ItemListDeleteCompleteDTO>itemListDeleteCompleteDTO=new ArrayList<ItemListDeleteCompleteDTO>();
	   String sql=
			   "SELECT ubit.id,iit.item_name,ubit.item_price,ubit.item_stock,ubit.insert_date FROM item_info_transaction ubit LEFT JOIN item_info_transaction iit ON ubit.item_name=iit.id WHERE ubit.item_name =? AND ubit.user_master_id =? ORDER BY insert_date DESC";


	try {

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, item_name);
		preparedStatement.setString(2, user_master_id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			ItemListDeleteCompleteDTO dto=new ItemListDeleteCompleteDTO();
        dto.setId(resultSet.getString("id"));
		dto.setItemName(resultSet.getString("item_name"));
		dto.setItemPrice(resultSet.getString("item_price"));
		dto.setItemStock(resultSet.getString("item_stock"));
		dto.setInsert_date(resultSet.getString("insert_date"));
		itemListDeleteCompleteDTO.add(dto);
		}


	} catch(Exception e) {

	e.printStackTrace();

	}
	finally{
		connection.close();
	}
	return itemListDeleteCompleteDTO;

	}

	public int itemHistoryDelete(String item_name,String user_master_id)throws SQLException{

		String sql = "DELETE FROM item_info_transaction WHERE item_name=? AND user_master_id=?";
		PreparedStatement preparedStatement;
		int result = 0;


		try {

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, item_name);
			preparedStatement.setString(2, user_master_id);

			result=preparedStatement.executeUpdate();
		}

		catch(SQLException e){
			e.printStackTrace();
		}

		finally{
			connection.close();
		}
		return result;

	}
}
