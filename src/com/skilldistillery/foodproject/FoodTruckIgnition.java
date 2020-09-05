package com.skilldistillery.foodproject;

import java.util.Scanner;

public class FoodTruckIgnition {

	public static void main(String[] args) {

		FoodTruckIgnition ft1 = new FoodTruckIgnition();
		ft1.go();

	}

	public void go() {

		int truckMax = 5;
		// Make Array with default Food Trucks;
		FoodTruck[] foodTruckArray = new FoodTruck[truckMax];
		foodTruckArray = makeArray(truckMax);
		// Fill data of the default Food Trucks
		foodTruckArray = makeFoodTrucks(foodTruckArray, truckMax);

		// 	Test code to make sure the array has been filled according to instructions.
				System.out.println(foodTruckArray[0].toString());
				System.out.println(foodTruckArray[1].toString());
				System.out.println(foodTruckArray[2].toString());
				System.out.println(foodTruckArray[3].toString());
				System.out.println(foodTruckArray[4].toString());
	}

	
	public FoodTruck[] makeArray(int truckMax) {
		FoodTruck[] returnArray = new FoodTruck[truckMax];
		for (int i = 0; i < truckMax; i++) {
			FoodTruck emptyTruck = new FoodTruck();
			returnArray[i] = emptyTruck;
		}
		return returnArray;
	}

	
	public FoodTruck[] makeFoodTrucks(FoodTruck[] tempArray, int truckMax) {

		Scanner input = new Scanner(System.in);

		FoodTruck[] returnArray = tempArray;

		System.out.println("Please enter food truck info:");

		for (int i = 0; i < truckMax; i++) {

			System.out.print("Truck No. " + (i + 1) + " Name (or type 'quit' if finished): ");
			tempArray[i].setTruckName(input.nextLine());
			if (tempArray[i].getTruckName().equals("quit")) {
				break;
			}
			System.out.print("Truck No. " + (i + 1) + " Food Type(s): ");
			tempArray[i].setFoodType(input.nextLine());
			System.out.print("Truck No. " + (i + 1) + " Rating: ");
			tempArray[i].setTruckRating(input.nextInt());
			input.nextLine();
		}

		input.close();
		return returnArray;
	
	}
	
	
}

