package view;

import java.util.Scanner;

import model.HashTable;

public class Program {
	private boolean isRunning = true;
	private Scanner sc = new Scanner(System.in);
	private HashTable table = new HashTable();

	public Program() {}
	
	private int validInput() {
		boolean isValid = true;	
		String value = "";
		int x = -1;
		
		do {
			System.out.println("Input an Integer number x where x >= 0:");		
			value = sc.nextLine();
			
			if (!value.matches("[0-9]+")) {
				System.out.println("Invalid number");
				isValid = false;
			} else {
				x = Integer.parseInt(value);	
				isValid = true;
			}
		} while (!isValid);
		return x;
	}
	
	private void showChoices() {
		System.out.println("Choice an option:");
		System.out.println("1 - Insert value");
		System.out.println("2 - Remove value");
		System.out.println("3 - Show table");
		System.out.println("4 - Quit");
		
		switch (sc.nextLine()) {
		case "1":
			System.out.println("INSERT");
			int valueToAdd = validInput();			
			if (valueToAdd >= 0) System.out.println(table.insert(valueToAdd));
			break;
		case "2":
			System.out.println("REMOVE");
			int valueToRem = validInput();			
			if (valueToRem >= 0) System.out.println(table.remove(valueToRem));
			break;
		case "3":
			System.out.println("SHOW TABLE");
			System.out.println(table.show());
			break;
		case "4":
			System.out.println("QUIT");
			isRunning = false;
			break;

		default:
			System.out.println("Invalid option\n");
			break;
		}
	}

	public void execute() {
		System.out.println("H A S H   T A B L E   P R O G R A M");		
		while(isRunning) { showChoices(); }		
		System.out.println("F I N A L I Z I N G");		
	}	
}
