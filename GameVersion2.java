import java.util.Scanner;
import java.util.concurrent.TimeUnit;
public class GameVersion2{
	
	public void display_Intro(){
		System.out.println("-----------WELCOME TO THE 22-Stick Game-------------");
		System.out.println("_______________coded by Abu Samuel________________");
		System.out.println("_inspired by my friends M. Guzuba and S. Ngcizela_");
		System.out.println("__during an afternoon of de-stressing over beers__");
		System.out.println("___________________at the Barn____________________\n");
		try{
			Thread.sleep(1500);
		}
		catch(InterruptedException ex){
			Thread.currentThread().interrupt();
		}
	}

	public void display_Rules(){
		System.out.println("_______________HOW TO PLAY_______________");
		System.out.println("--The game is simple and easy to understand :)\n");
		try{
			Thread.sleep(1500);
		}
		catch(InterruptedException ex){
			Thread.currentThread().interrupt();
		}
		System.out.println("--There are 22 Sticks available to be picked.");
		System.out.println("--But the sticks are picked in turns. ");
		System.out.println("--The player can choose to take first turn");
		System.out.println("--or the player can choose to allow the game pick first\n");
		try{
			Thread.sleep(1500);
		}
		catch(InterruptedException ex){
			Thread.currentThread().interrupt();
		}
		System.out.println("--The player can only pick 1 or 2 or 3 sticks in a turn");
		System.out.println("--The game can also only pick 1 or 2 or 3 sticks in a turn\n");
		System.out.println("--whoever picks the last 1 or 2 or 3 sticks wins!\n");
		try{
			Thread.sleep(1500);
		}
		catch(InterruptedException ex){
			Thread.currentThread().interrupt();
		}
		System.out.println("--That's all folks! Now go out there an enjoy the game!\n");
		Scanner entry = new Scanner(System.in);
		System.out.print("        Enter x to exit game rules: ");
		
		int i = 0;
		while(i != 1){
			String input = entry.next();
			if(input.equalsIgnoreCase("x")){
				System.out.println("\n_________exiting game rules and returning to menu\n");
				i = 1;
				try{
					Thread.sleep(1500);
				}
				catch(InterruptedException ex){
					Thread.currentThread().interrupt();
				}
				menu();		
			}
			else{
				System.out.println("        Wrong entry.");
				System.out.print("        Enter x to exit game rules: ");	
			}
		}
		System.out.println();
	}

	public int wisdom(int number){
		int intelligence = number % 4;
		if(intelligence == 0){
			intelligence = intelligence + 1;
		}
		return intelligence;
	}

	public String play(int stick_total){
		Scanner entry = new Scanner(System.in);
		int input = 0;
		String winner = "";
		while((winner.equalsIgnoreCase("p") != true) || (winner.equalsIgnoreCase("c") !=true)){
			System.out.println("------PLAYER TURN");
			try{
				Thread.sleep(500);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			System.out.print("      Pick 1 or 2 or 3 stick(s): ");
			try{
				input = entry.nextInt();
			}
			catch(Exception e){
				System.out.println("      Wrong entry. Enter a digit.");
				play(stick_total);
				break;
			}

			if(input > 3 || input < 1){
				System.out.println("      Wrong entry. Try again.");
				continue;
			}
			stick_total = stick_total - input;
			try{
				Thread.sleep(500);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			System.out.println();
			System.out.println("------Sticks available: " + stick_total + "\n");
			try{
				Thread.sleep(2000);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			if(stick_total == 0){
				System.out.println("------PLAYER WINS!!!------");
				winner = "p";
				break;
			}
			System.out.println("------COMPUTER TURN");
			int wiz = wisdom(stick_total);
			try{
				Thread.sleep(1500);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			System.out.print("      Computer picks: " + wiz + "\n");
			stick_total = stick_total - wiz;
			try{
				Thread.sleep(500);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			System.out.println("\n------Sticks available: " + stick_total + "\n");
			try{
				Thread.sleep(500);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			if(stick_total == 0){
				System.out.println("------COMPUTER WINS!!!------");
				winner = "c";
				break;
			}
		}
		return winner;
	}

	public String cplay(int stick_total){
		String winner = "";
		Scanner entry = new Scanner(System.in);
		int input = 0;
		while((winner.equalsIgnoreCase("p") != true) || (winner.equalsIgnoreCase("c") !=true)){
			System.out.println("------COMPUTER TURN");
			int wiz = wisdom(stick_total);
			try{
				Thread.sleep(1500);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			System.out.print("      Computer picks: " + wiz + "\n");
			stick_total = stick_total - wiz;	
			try{
				Thread.sleep(500);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}

			System.out.println("\n------Sticks available: " + stick_total + "\n");
			if(stick_total == 0){
				System.out.println("------COMPUTER WINS!!!------");
				winner = "c";
				break;
			}
			try{
				Thread.sleep(500);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			System.out.println("------PLAYER TURN");
			try{
				Thread.sleep(500);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			System.out.print("      Pick 1 or 2 or 3 stick(s): ");
//-----------------------------------------Exception handling-----------------------------------------			
			try{                          
				input = entry.nextInt();
			}
			catch(Exception e){
				System.out.println("      Wrong entry. Enter a digit.");
				play(stick_total);
				break;
			}                            
//----------------------------------------------------------------------------------------------------
			if(input > 3 || input < 1){
				System.out.println("      Wrong entry. Try again.");
				play(stick_total);
				break;
			}
			stick_total = stick_total - input;
			System.out.println("\n------Sticks available: " + stick_total + "\n");
			if(stick_total == 0){
				System.out.println("------PLAYER WINS!!!------");
				winner = "p";
				break;
			}
			try{
				Thread.sleep(2000);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
		}
		return winner;
	}

	public void start(){
		int sticks = 22;
		Scanner entry = new Scanner(System.in);
		String winner = "";
		while(sticks > 0){
			System.out.println("____________________PICK TURN______________________\n");
			System.out.println("------Sticks available: " + sticks + "\n");
			System.out.println("      Enter v to take 1st turn or Enter c to let game take 1st turn");
			System.out.print("      Enter: ");
			String input = entry.next();
			System.out.println();
			try{
				Thread.sleep(500);
			}
			catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			if(input.equalsIgnoreCase("v")){
				winner = play(sticks);
				sticks = 0;
			}
			else if(input.equalsIgnoreCase("c")){
				winner = cplay(sticks);
				sticks = 0;
			}	
			else{
				System.out.println("      Wrong entry.");
				try{
					Thread.sleep(500);
				}
				catch(InterruptedException ex){
					Thread.currentThread().interrupt();
				}
				System.out.println("      Read options properly.");
			}	
		}

		System.out.println();
		menu();
	}

	public void scan_Entry(String input){
		if(input.equalsIgnoreCase("r")){
			display_Rules();
		}
		else if(input.equalsIgnoreCase("s")){
			start();
		}
		else if(input.equalsIgnoreCase("q")){
			System.out.println("        Game exits...thank you for playing :)");
			System.exit(0);
		}
		else{
			System.out.println("        Wrong entry.\n");
			menu();
		}
	}

	public void menu(){
		Scanner input = new Scanner(System.in);
		try{
			Thread.sleep(1500);
		}
		catch(InterruptedException ex){
			Thread.currentThread().interrupt();
		}
		System.out.print("____________________GAME MENU____________________\n");
		System.out.print("        To read how to play press r\n");
		System.out.print("	To start game press s\n");
		System.out.print("        To quit game press q\n");
		System.out.print("        Enter: ");
		String entry = input.next();
		System.out.println();

//---------------------------------Time Delay Code for interactive purposes---------------------------------------
		try{
			Thread.sleep(1500);
		}
		catch(InterruptedException ex){
			Thread.currentThread().interrupt();
		}
//-----------------------------------------Time Delay Code above--------------------------------------------------
		
		scan_Entry(entry);
	}

	public static void main(String [] args){
		GameVersion2 run = new GameVersion2();
		run.display_Intro();
		run.menu();
	}
}