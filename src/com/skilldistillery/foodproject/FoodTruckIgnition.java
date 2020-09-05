package com.skilldistillery.foodproject;

import java.util.Scanner;

public class FoodTruckIgnition {

	Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		FoodTruckIgnition ft1 = new FoodTruckIgnition();
		ft1.go();

	}

	public void go() {

		int truckMax = 5;
		// Declare and instantiate an Array of default Food Trucks;
		FoodTruck[] foodTruckArray = new FoodTruck[truckMax];
		foodTruckArray = makeTruckArray(truckMax);
		// Fill data of the default Food Trucks
		foodTruckArray = makeFoodTrucks(foodTruckArray, truckMax);

		menu();
		input.close();
	}

	public FoodTruck[] makeTruckArray(int truckMax) {
		FoodTruck[] returnArray = new FoodTruck[truckMax];
		for (int i = 0; i < truckMax; i++) {
			FoodTruck emptyTruck = new FoodTruck();
			returnArray[i] = emptyTruck;
		}
		return returnArray;
	}

	public FoodTruck[] makeFoodTrucks(FoodTruck[] tempArray, int truckMax) {

		FoodTruck[] returnArray = tempArray;

		System.out.println("Welcome to Quick Byte!  Please enter Food Truck info:\n");

		for (int i = 0; i < truckMax; i++) {

			System.out.print("Truck No. " + (i + 1) + " Name (or type 'quit' if finished): ");
			tempArray[i].setTruckName(input.nextLine());
			if (tempArray[i].getTruckName().equals("quit")) {
				break;
			}
			System.out.print("Truck No. " + (i + 1) + " Food Type(s): ");
			tempArray[i].setFoodType(input.nextLine());
			System.out.print("Truck No. " + (i + 1) + " Rating (1 - 10): ");
			tempArray[i].setTruckRating(input.nextInt());
			input.nextLine();
		}

		return returnArray;

	}

	public void menu() {

		boolean keepGoing = true;
		do {
			printmenu();
			System.out.print("\nPlease enter a selection: ");
			String userChoice = input.nextLine();

			switch (userChoice) {

			case "1":
			case "one":
				System.out.println("\nPlacemarker for 1");
				break;

			case "2":
			case "two":
				System.out.println("\nPlacemarker for 2");
				break;
			case "3":
			case "three":
				System.out.println("\nPlacemarker for 3");
				break;
			case "4":
			case "four":
			case "quit":
			case "exit":
				System.out.println("\nGoodbye! Happy Eating!");
				keepGoing = false;
				break;
			default:
				System.out.println("\nPlease choose 1 - 4");

			}

		} while (keepGoing);
	}

	public void printmenu() {

		System.out.println("");
		System.out.println("*************|QUICK    |*************");
		System.out.println("*************|     BYTE|*************");
		System.out.println("**                                 **");
		System.out.println("**  1. List all Trucks             **");
		System.out.println("**  2. See Average Ratings         **");
		System.out.println("**  3. Display Highest-Rated Truck **");
		System.out.println("**  4. Quit                        **");
		System.out.println("**                                 **");
		System.out.println("*************************************");
		System.out.println("*************************************");
	}

}