// SoloMemoryController.java -- Controller sub-type for single-player gameplay.

import java.util.ArrayList;

public class SoloMemoryController extends MemoryController {

	// Initializes the controller with a single player and a randomized CardLayout
	public SoloMemoryController() {
		cardLayout = new CardLayout().fillRandomly();
		players = new ArrayList<Player>();
		players.add(new Player());
	}

	// Prints the single-player end game message, which includes the number of incorrect choices
	@Override
	public void endGameMessage() {
		super.print(
				"Good job! you only took " + (players.get(0).failedAttempts() + 1) + " attempts to win! Thanks for playing!");
	}
}
