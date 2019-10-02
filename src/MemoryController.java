// MemoryController.java -- Base class for orchestrating gameplay for memory

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public abstract class MemoryController {

	protected List<Player> players;

	protected CardLayout cardLayout;

	// Corresponds to the index of the List<Player> 'players' for the current player
	private int turn = 0;

	private Scanner scanner = new Scanner(System.in);

	// Prints the message that displays once the game is finished
	public abstract void endGameMessage();

	// Runs a single game of memory
	public void run() {
		while (cardLayout.gameContinues()) {
			simulateTurn();
		}
		scanner.close();
	}

	// Goes through a single turn, letting the player choose two cards, and checking if they're a pair
	private void simulateTurn() {
		chooseCard();
		chooseCard();
		if (cardLayout.CheckActiveCards()) {
			players.get(turn).succeeded();
			print("That's a pair!. Press enter to try again.");
			scanner.nextLine();
			cardLayout.removeActiveCards();
		} else {
			players.get(turn).failed();
			turn = (turn + 1) % players.size();
			print("Not a pair, press enter to continue to next player's turn.");
			scanner.nextLine();
			cardLayout.flipDownActiveCards();
		}
	}

	// Prompt user to choose a card to 'turn over', and will re-prompt until a valid input is received.
	private void chooseCard() {
		// Default value of 0 for chosenNumber is invalid on purpose.
		// This means an InputMismatchException will result in invalidInput remaining true.
		int chosenNumber = 0;
		boolean invalidInput = true;

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Player ");
		stringBuilder.append(turn + 1);
		stringBuilder.append(", please enter the number corresponding to an available card.");

		while (invalidInput) {
			print(stringBuilder.toString());
			try {
				chosenNumber = scanner.nextInt();
			} catch (InputMismatchException e) {
				;
			}
			scanner.nextLine();
			if (cardLayout.choose(chosenNumber - 1)) {
				break;
			}
		}
	}

	// Prints the board for memory, along with whatever message is passed in as a parameter.
	protected void print(String message) {
		StringBuilder view = new StringBuilder("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		view.append(" MEMORY!\n\n");
		view.append(cardLayout.toString());
		for (int i = 0; i < players.size(); ++i) {
			view.append(players.get(i).toString(i));
		}
		view.append("\n\n\n" + message);
		System.out.println(view.toString());
	}
}
