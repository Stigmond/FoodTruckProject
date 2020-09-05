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
		// Pass foodTruck Array to menu to be further passed to other methods.
		menu(foodTruckArray);

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
			System.out.print("Truck No. " + (i + 1) + " Rating [1 (worst) - 5 (best)]: ");
			// TODO SET PARAMETERS SO NUMBER MUST BE 1-5
			tempArray[i].setTruckRating(input.nextInt());
			input.nextLine();
		}

		return returnArray;

	}

	public void menu(FoodTruck[] truckArray) {

		boolean keepGoing = true;
		do {
			printmenu();
			System.out.print("\nPlease enter a selection: ");
			String userChoice = input.nextLine();

			switch (userChoice) {

			case "1": case "one": case "list":
				listTrucks(truckArray);
				break;

			case "2": case "two": case "average":
				truckAverage(truckArray);
				break;

			case "3": case "three": case "best":
				highestTruck(truckArray);
				break;

			case "4": case "four": case "quit":	case "exit":
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

	public void listTrucks(FoodTruck[] truckArray) {
		System.out.println("");

		int numberOfTrucks = 0;

		for (FoodTruck foodTruck : truckArray) {
			if ((foodTruck.getTruckName() == null) || ((foodTruck.getTruckName().equals("quit")))) {
				continue;
			} else {
				numberOfTrucks++;
			}
		}

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

	public void truckAverage(FoodTruck[] truckArray) {

		int ratingTotal = 0;
		int numberOfTrucks = 0;
		double truckAverage = 0;

		for (FoodTruck foodTruck : truckArray) {
			if ((foodTruck.getTruckName() == null) || ((foodTruck.getTruckName().equals("quit")))) {
				continue;
			} else {
				numberOfTrucks++;
			}
		}

		for (int i = 0; i < truckArray.length; i++) {
			if ((truckArray[i].getTruckName() == null) || ((truckArray[i].getTruckName().equals("quit")))) {
				continue;
			} else {
				ratingTotal += truckArray[i].getTruckRating();
			}
		}

		if (numberOfTrucks == 0) {
			System.out.println("\nNo Trucks in Database!");
		} else {
			truckAverage = ((double)ratingTotal / numberOfTrucks);
			System.out.println("\nThe average rating of the food trucks is: " + truckAverage);
		}

	}

	public void highestTruck(FoodTruck[] truckArray) {

		int highestNumber = 0;
		String highestRated = null;
		for (FoodTruck foodTruck : truckArray) {
			if (foodTruck.getTruckRating() > highestNumber) {
				highestNumber = foodTruck.getTruckRating();
				highestRated = foodTruck.toString();
			}
		}

		if (highestNumber == 0) {
			System.out.println("\nNo Trucks in Database!");
		} else {
			System.out.println("\nHighest rated -- " + highestRated);
		}
	}

}