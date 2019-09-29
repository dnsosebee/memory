import java.util.List;
import java.util.Scanner;

public abstract class MemoryController {

	protected List<Player> players;

	protected CardLayout cardLayout;

	private int turn = 0;

	private Scanner scanner = new Scanner(System.in);

	public abstract void endGameMessage();

	public void run() {
		while (cardLayout.gameContinues()) {
			simulateTurn();
		}
		scanner.close();
	}

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

	private void chooseCard() {
		int chosenNumber;
		boolean invalidInput = true;

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Player ");
		stringBuilder.append(turn + 1);
		stringBuilder.append(", please enter the number corresponding to an available card.");

		while (invalidInput) {
			print(stringBuilder.toString());
			chosenNumber = scanner.nextInt();
			scanner.nextLine();
			if (cardLayout.choose(chosenNumber - 1)) {
				break;
			}
		}
	}

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
