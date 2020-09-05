package com.skilldistillery.foodproject;

public class FoodTruckIgnition {

	public static void main(String[] args) {
		
		FoodTruckIgnition truckTest = new FoodTruckIgnition();
		truckTest.start();
		
	}

	public void start() {
		
		FoodTruck truck1 = new FoodTruck("DogHaus", "Hot Dogs", 1);
		FoodTruck truck2 = new FoodTruck("Pizza Man", "Pizza", 2);
		FoodTruck truck3 = new FoodTruck();
		
		System.out.println(truck1.truckName + " - ID NUM: " + truck1.truckId);
		System.out.println(truck2.truckName + " - ID NUM: " + truck2.truckId);
		System.out.println(truck3.truckName + " - ID NUM: " + truck3.truckId);
	}

}
