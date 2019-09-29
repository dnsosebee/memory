import java.util.ArrayList;

public class SoloMemoryController extends MemoryController {

	public SoloMemoryController() {
		cardLayout = new CardLayout().fillRandomly();
		players = new ArrayList<Player>();
		players.add(new Player());
	}

	@Override
	public void endGameMessage() {
		super.print(
				"Good job! you only took " + players.get(0).failedAttempts() + " attempts to win! Thanks for playing!");
	}
}
