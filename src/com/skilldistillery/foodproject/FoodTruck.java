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
	
}
