
/**
 * @author joshtegeler - jmtegeler
 * CIS175 - Spring 2024
 * Jan 30, 2024
 */


import java.util.List;
import java.util.Scanner;

import controller.CarHelper;
import model.Car;

public class Main {

		static Scanner in = new Scanner(System.in);
		static CarHelper c = new CarHelper();

		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a make: ");
			String make = in.nextLine();
			System.out.print("Enter a model: ");
			String model = in.nextLine();
			System.out.print("Enter a year: ");
			String year = in.nextLine();
			System.out.print("Enter the horsepower: ");
			String horsepower = in.nextLine();
			Car toAdd = new Car(make, model, year, horsepower);
			c.insertCar(toAdd);

		}

		private static void deleteAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter the make to delete: ");
			String make = in.nextLine();
			System.out.print("Enter the model to delete: ");
			String model = in.nextLine();
			System.out.print("Enter the year to delete: ");
			String year = in.nextLine();
			System.out.print("Enter the horsepower to delete: ");
			String horsepower = in.nextLine();
			Car toDelete = new Car(make, model, year, horsepower);
			c.deleteCar(toDelete);

		}

		private static void editAnItem() {
			// TODO Auto-generated method stub
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Make");
			System.out.println("2 : Search by Model");
			int searchBy = in.nextInt();
			in.nextLine();
			List<Car> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the car make: ");
				String carMake = in.nextLine();
				foundItems = c.searchForModelByMake(carMake);
			} else {
				System.out.print("Enter the model: ");
				String modelName = in.nextLine();
				foundItems = c.searchForModelByModel(modelName);


			}

			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (Car l : foundItems) {
					System.out.println(l.getId() + " : " + l.toString());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();

				Car toEdit = c.searchForCarById(idToEdit);
				System.out.println("Retrieved " + toEdit.getModel() + " from " + toEdit.getMake());
				System.out.println("1 : Update Make");
				System.out.println("2 : Update Model");
				System.out.println("3 : Update Year");
				System.out.println("4 : Update Horsepower");
				int update = in.nextInt();
				in.nextLine();

				if (update == 1) {
					System.out.print("New Make: ");
					String newMake = in.nextLine();
					toEdit.setMake(newMake);
				} else if (update == 2) {
					System.out.print("New Model: ");
					String newModel = in.nextLine();
					toEdit.setModel(newModel);
				} else if (update == 3) {
					System.out.print("New Year: ");
					String newYear = in.nextLine();
					toEdit.setYear(newYear);
				} else if (update == 4) {
					System.out.print("New Horsepower: ");
					String newHorsepower = in.nextLine();
					toEdit.setHorsepower(newHorsepower);
				}

				c.updateCar(toEdit);

			} else {
				System.out.println("---- No results found");
			}

		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();

		}

		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to the Car Inventory System ---");
			while (goAgain) {
				System.out.println("*  Select a Number:");
				System.out.println("*  1 -- Add a Car");
				System.out.println("*  2 -- Edit a Car");
				System.out.println("*  3 -- Delete a Car");
				System.out.println("*  4 -- View all cars");
				System.out.println("*  5 -- Exit the app");
				System.out.print("*  Choose: ");	
				int selection = in.nextInt();
				in.nextLine();

				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					c.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}

			}

		}

		private static void viewTheList() {
			// TODO Auto-generated method stub
			List<Car> allItems = c.showAllCars();
			for(Car singleItem: allItems) {
				System.out.println(singleItem.returnCarDetails());
			}

		}

	}
