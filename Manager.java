import java.util.Scanner;
import java.util.Random;

public class Manager {
	long day = 1;
	double cash = 0;
	boolean lawyeredUp = false;
	
	public Manager () {
		cash = -1000;
	}
	
	public void rivalChoice (Company rival) {
		Random ran = new Random();
		int mainChoice = ran.nextInt(10);
		int secChoice = ran.nextInt(3);
		boolean answered = false;
		switch (mainChoice) {
			case 1:	System.out.println("Your rival is suing you on unreasonable claims!");
					if (lawyeredUp) {
						System.out.println("But you have better lawyers and countersue!");
						System.out.println("Net gain of $250");
						cash += 250;
					}
					else if (secChoice == 2) {
						System.out.println("Their lawyers are better than yours!");
						Scanner input = new Scanner(System.in);
						System.out.println("Afford better lawyers for $500?");
						System.out.println("Yes or no?");
						String answer = input.nextLine();
						while (!answered) {
							if (answer.equalsIgnoreCase("yes")) {
								System.out.println("Your new lawyers successfully countersue!");
								System.out.println("Net loss of $250");
								cash -= 250;
								lawyeredUp = true;
								answered = true;
							}
							else if (answer.equalsIgnoreCase("no")) {
								System.out.println("Your lawyers lose the case.");
								System.out.println("Net loss of $500");
								cash -= 500;
								answered = true;
							}
							else {
								System.out.println("Please enter a valid response: Yes or no?");
								answer = input.nextLine();
							}
						}
					}
					else {
						System.out.println("The judge realized their unreasonableness and threw out "
								+ "the case. Settlement awarded for $100.");
						System.out.println("Net gain of $100");
						cash += 100;
					}
			
			default:
					break;
		}
	}
	
	public boolean gameOver () {
		if (cash >= 10000) {
			return true;
		}
		else if (cash < -15000) {
			return true;
		}
		else if (day > 100) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int event = 0;
	
		Manager manager = new Manager();
		Company rival = new Company();
		
		while (!manager.gameOver()) {
			System.out.println();
			System.out.println(manager.day);
			System.out.println("$" + manager.cash);
			
			Random random = new Random();
			event = random.nextInt(2);
				
			switch (event) {
			case 1: manager.rivalChoice(rival);
					break;
			default: 
					System.out.println("Unproductive Day");
					System.out.println("Net Loss of $50");
					manager.cash -= 50;
					break;
			}
			
			manager.day++;
		}
	}
}

