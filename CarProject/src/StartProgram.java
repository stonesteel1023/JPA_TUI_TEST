import java.util.List;
import java.util.Scanner;

import car.Controller.CarHelper;
import car.Model.CarEntity;



public class StartProgram {

	Scanner in = new Scanner(System.in);
	CarHelper ch = new CarHelper();
	
	public static void main(String[] args) {
		StartProgram st = new StartProgram();
		st.runMenu();
	}

	private void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Our Garage! ---");
		while (goAgain) {
			System.out.println("*  Select:");
			System.out.println("*  1 -- Add a car");
			System.out.println("*  2 -- Edit a car");
			System.out.println("*  3 -- Delete a car");
			System.out.println("*  4 -- View the Garage");
			System.out.println("*  5 -- Exit");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addACar();
			} else if (selection == 2) {
				editACar();
			} else if (selection == 3) {
				deleteACar();
			} else if (selection == 4) {
				viewTheGarage();
			} else {
				ch.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}
	}
	private void deleteACar() {
		System.out.print("Enter the Make of car to delete: ");
		String make = in.nextLine();
		System.out.print("Enter the Model of car to delete: ");
		String model = in.nextLine();
		System.out.print("Enter the Year of car to delete: ");
		int year = in.nextInt();
		CarEntity toDelete = new CarEntity(make,model,year);
		ch.deleteCarEntity(toDelete);		
	}

	private void editACar() {

		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Make");
		System.out.println("2 : Search by Model");
		System.out.println("3 : Search by Year");

		int searchBy = in.nextInt();
		in.nextLine();
		List<CarEntity> foundCars;
		if (searchBy == 1) {
			System.out.print("Enter the Make: ");
			String make = in.nextLine();
			foundCars = ch.searchForCarEntityByMake(make);

			
		} else if(searchBy == 2) {
			System.out.print("Enter the Model: ");
			String model = in.nextLine();
			foundCars = ch.searchForCarEntityByModel(model);

		}else {
			System.out.print("Enter the Year: ");
			String year = in.nextLine();
			foundCars = ch.searchForCarEntityByYear(year);
			}
		

		if (!foundCars.isEmpty()) {
			System.out.println("Found Results.");
			for (CarEntity c : foundCars) {
				System.out.println(c.getId() + " : " + c.returnCarDetails());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			CarEntity toEdit = ch.searchForCarEntityById(idToEdit);
			System.out.println("Retrieved " + toEdit.getMake() + " " + toEdit.getModel() + " " + toEdit.getYear());
			System.out.println("1 : Update Make");
			System.out.println("2 : Update Model");
			System.out.println("3 : Update Year");
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
				int newYear = in.nextInt();
				toEdit.setYear(newYear);
			}

			ch.updateCarEntity(toEdit);

		} else {
			System.out.println("---- No results found");
		}
	}

	private void viewTheGarage() {
		List<CarEntity> allItems = ch.showAllCarEntitys();
		for(CarEntity singleItem : allItems) {
			System.out.println(singleItem.returnCarDetails());
		}
	}

	private void addACar() {
		System.out.print("Enter car make: ");
		String make = in.nextLine();
		System.out.print("Enter car model: ");
		String model = in.nextLine();
		System.out.print("Enter car year: ");
		int year = in.nextInt();
		CarEntity toAdd = new CarEntity(make,model,year);
		ch.insertCarEntity(toAdd);

	}

}