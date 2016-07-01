
public class Main {
	public static void main(String[] args) {
		int event = 0;
	
		Manager manager = new Manager();
		Company rival = new Company();
		
		while (!manager.gameOver()) {
			System.out.println();
			System.out.println(manager.day);
			System.out.println("$" + manager.cash);
			
			event = (int)Math.random() * 10 + 1;
			
			switch (event) {	
				case 1: 	manager.rivalChoice(rival);
				
				default: 	System.out.println("Unproductive Day");
							System.out.println("Net Loss of $50");
							manager.cash -= 50;
							break;
			}
			
			manager.day++;
		}
	}
}
