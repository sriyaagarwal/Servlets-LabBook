package com.cg.iter.bean;

public class Training {
	private int trainigID;
	private String trainingname;
	private int availSeats;
	
	public int getTrainigID() {
		return trainigID;
	}
	public void setTrainigID(int trainigID) {
		this.trainigID = trainigID;
	}
	public String getTrainingname() {
		return trainingname;
	}
	public void setTrainingname(String trainingname) {
		this.trainingname = trainingname;
	}
	public int getAvailSeats() {
		return availSeats;
	}
	public void setAvailSeats(int availSeats) {
		this.availSeats = availSeats;
	}
	public Training(int trainigID, String trainingname, int availSeats) {
		super();
		this.trainigID = trainigID;
		this.trainingname = trainingname;
		this.availSeats = availSeats;
	}
	
	public Training() {}
}
