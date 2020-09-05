package com.skilldistillery.foodproject;

public class FoodTruck {

	private static int ID_COUNTER = 100;
	private String truckName;
	private String foodType;
	private int truckRating;
	private int truckId;

	FoodTruck() {
		this.truckId = ID_COUNTER;
		ID_COUNTER++;
	}

	FoodTruck(String truckName, String foodType, int truckRating) {

		this.truckName = truckName;
		this.foodType = foodType;
		this.truckRating = truckRating;
		this.truckId = ID_COUNTER;
		ID_COUNTER++;

	}

	@Override
	public String toString() {
		StringBuilder truckinfo = new StringBuilder();
		truckinfo.append("Truck ID: ")
		.append(this.truckId)
		.append(", Truck Name: ")
		.append(this.truckName)
		.append(", Food Type: ")
		.append(this.foodType)
		.append(", Truck Rating: ")
		.append(this.truckRating);
		return truckinfo.toString();
	}
	
	public String getTruckName() {
		return this.truckName;
	}
	
	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}
	
	public String getFoodType() {
		return this.foodType;
	}
	
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	
	public int getTruckRating() {
		return this.truckRating;
	}
	
	public void setTruckRating(int truckRating) {
		this.truckRating = truckRating;
	}
	
	public int getTruckId() {
		return this.truckId;
	}
	
}

