package com.cg.iter.service;

import java.sql.SQLException;
import java.util.List;

import com.cg.bean.Training;
import com.cg.dao.TrainingDAOImpl;

public class TrainingServiceImpl implements TrainingService{
	TrainingDAOImpl dao=null;
	public TrainingServiceImpl() {
		dao=new TrainingDAOImpl();
	}
	@Override
	public List<Training> getAllTrainingDetails() throws SQLException {
		return dao.getAllTrainingDetails();
	}
	
	@Override
	public String UpdateAvailableseats(int id) throws SQLException{
		return dao.UpdateAvailableseats(id);
	}
}
