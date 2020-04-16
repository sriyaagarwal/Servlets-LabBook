package com.cg.iter.service;

import java.sql.SQLException;
import java.util.List;

import com.cg.bean.Training;

public interface TrainingService {
	public List<Training> getAllTrainingDetails() throws SQLException;
	public String UpdateAvailableseats(int id) throws SQLException;
}
