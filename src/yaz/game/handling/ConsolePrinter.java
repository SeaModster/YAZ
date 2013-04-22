package yaz.game.handling;

public class ConsolePrinter {
	
	public static void PrintConsole(int priority, String Message) {
		if(priority >= 0 && priority <= 3) {
			switch(priority) {
				case 0:
					System.out.println("[GAME-INFO]: "+Message);
					break;
				case 1:
					System.out.println("[GAME-DEBUG]: "+Message);
					break;
				case 2:
					System.out.println("[GAME-WARNING]: "+Message);
					break;
				case 3:
					System.out.println("[GAME-STRICT]: "+Message);	
					break;
			}
		} else {
			System.out.println("[GAME-STRICT] : System cannot identify priority: [" + priority + "]");
		}
	}

}
