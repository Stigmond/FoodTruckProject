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
		foodTruckArray = makeTruckArray(foodTruckArray, truckMax);
		
		// Fill data of the default Food Trucks
		foodTruckArray = makeFoodTrucks(foodTruckArray, truckMax);
		
		// Determine number of valid food trucks in array so a null array won't be displayed.
		int numberOfTrucks = countTrucks(foodTruckArray);
		
		// Pass foodTruck Array to menu to be further passed to other methods.
		menu(foodTruckArray, numberOfTrucks);

		input.close();
	}

	public FoodTruck[] makeTruckArray(FoodTruck[] foodTruckArray, int truckMax) {

		for (int i = 0; i < truckMax; i++) {
			foodTruckArray[i] = new FoodTruck();
		}
		return foodTruckArray;
	}

	public FoodTruck[] makeFoodTrucks(FoodTruck[] foodTruckArray, int truckMax) {

		System.out.println("Welcome to Quick Byte! \n\nPlease enter Food Truck info:\n");

		for (int i = 0; i < truckMax; i++) {

			System.out.print("Truck No. " + (i + 1) + " Name (or type 'quit' if finished): ");
			foodTruckArray[i].setTruckName(input.nextLine());
			if (foodTruckArray[i].getTruckName().equals("quit")) {
				break;
			}
			System.out.print("Truck No. " + (i + 1) + " Food Type(s): ");
			foodTruckArray[i].setFoodType(input.nextLine());
			do {
				System.out.print("Truck No. " + (i + 1) + " Rating [1 (lowest) - 5 (highest): ");
				foodTruckArray[i].setTruckRating(input.nextDouble());
				input.nextLine();
			} while (foodTruckArray[i].getTruckRating() < 1 || foodTruckArray[i].getTruckRating() > 5);
			
		}

		return foodTruckArray;

	}

	public int countTrucks(FoodTruck[] foodTruckArray) {

		int numberOfTrucks = 0;

		for (FoodTruck foodTruck : foodTruckArray) {
			if ((foodTruck.getTruckName() == null) || ((foodTruck.getTruckName().equals("quit")))) {
				continue;
			} else {
				numberOfTrucks++;
			}
		}
		return numberOfTrucks;
	}

	public void menu(FoodTruck[] truckArray, int numberOfTrucks) {

		boolean keepGoing = true;
		do {
			printmenu();
			System.out.print("\nPlease enter a selection: ");
			String userChoice = input.nextLine();

			switch (userChoice) {

			case "1": case "one": case "list":
				listTrucks(truckArray, numberOfTrucks);
				break;

			case "2": case "two": case "average":
				truckAverage(truckArray, numberOfTrucks);
				break;

			case "3": case "three": case "best":
				highestTruck(truckArray, numberOfTrucks);
				break;

			case "4": case "four": case "quit": case "exit":
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

	public void listTrucks(FoodTruck[] truckArray, int numberOfTrucks) {
		System.out.println("");

		if (numberOfTrucks == 0) {
			System.out.println("No Trucks in Database!");
		} else {
			for (FoodTruck foodTruck : truckArray) {
				if ((foodTruck.getTruckName() == null) || ((foodTruck.getTruckName().equals("quit")))) {
					continue;
				} else {
					System.out.println(foodTruck.toString());
				}
			}
		}
	}

	public void truckAverage(FoodTruck[] truckArray, int numberOfTrucks) {

		if (numberOfTrucks == 0) {
			System.out.println("\nNo Trucks in Database!");
		} else {

			double ratingTotal = 0;
			double truckAverage = 0;

			for (int i = 0; i < truckArray.length; i++) {
				if ((truckArray[i].getTruckName() == null) || ((truckArray[i].getTruckName().equals("quit")))) {
					continue;
				} else {
					ratingTotal += truckArray[i].getTruckRating();
				}
			}
			truckAverage = ratingTotal / numberOfTrucks;
			System.out.println("\nThe average rating of the food trucks is: " + truckAverage);
		}

	}

	public void highestTruck(FoodTruck[] truckArray, int numberOfTrucks) {

		double highestNumber = -10000000;
		String highestRated = null;
		if (numberOfTrucks == 0) {
			System.out.println("\nNo Trucks in Database!");
		} else {

			for (FoodTruck foodTruck : truckArray) {
				if (foodTruck.getTruckRating() > highestNumber) {
					highestNumber = foodTruck.getTruckRating();
					highestRated = foodTruck.toString();
				}
			}
			System.out.println("\nHighest rated -- " + highestRated);
		}

		
	}

}