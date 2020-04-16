package com.cg.iter.dao;

public interface QueryMapper {
	public static final String FETCH_ALL_TRAINING_DETAILS="select * from Training";
	public static final String FETCH_DETAILS_BASED_ON_ID="select * from training where trainingid=?";
	public static final String UPDATE_AVAILABLESEATS="update training set AVAILABLESEATS=? where trainingid=?";
}
