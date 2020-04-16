package com.cg.iter.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.cg.bean.Training;
import com.cg.util.DBUtil;

public class TrainingDAOImpl implements TrainingDAO{
	static Connection con=null;
	Statement st=null;
	ResultSet rs=null;
	PreparedStatement pst=null,pst1=null;
	
	@Override
	public List<Training> getAllTrainingDetails() throws SQLException {
		con=DBUtil.getCon();
		List<Training> list=new ArrayList<>();
		st=con.createStatement();
		rs=st.executeQuery(QueryMapper.FETCH_ALL_TRAINING_DETAILS);
		while(rs.next()) {
			Training tr=new Training(rs.getInt("trainingid"),rs.getString("trainingname"),rs.getInt("availableseats"));
			list.add(tr);
		}
		return list;
	}

	@Override
	public String UpdateAvailableseats(int id) throws SQLException {
		String strTrainingName="";
		int availseats = 0;
		con=DBUtil.getCon();
		pst=con.prepareStatement(QueryMapper.FETCH_DETAILS_BASED_ON_ID,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		pst.setInt(1,id);
		rs=pst.executeQuery();
		if(rs.next()) {
			strTrainingName+=rs.getString("TRAININGNAME");
			availseats=rs.getInt("AVAILABLESEATS");
		}
		
		rs.first();
		int updatedAvailableSeats=availseats-1;
		
		pst1=con.prepareStatement(QueryMapper.UPDATE_AVAILABLESEATS);
		pst1.setInt(1,updatedAvailableSeats);
		pst1.setInt(2,id);
		int count=pst1.executeUpdate();

		return strTrainingName;
	}
}
