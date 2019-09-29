<<<<<<< HEAD
import java.util.ArrayList;
=======

>>>>>>> 11fbcd819abe565e482952353f69664837c646ab

public class SoloMemoryController extends MemoryController {

	public SoloMemoryController() {
		cardLayout = new CardLayout().fillRandomly();
<<<<<<< HEAD
		players = new ArrayList<Player>();
		players.add(new Player());
	}

	@Override
	public void endGameMessage() {
		super.print("Good job! you only took " +
				players.get(0).failedAttempts() +
				" attempts to win! Thanks for playing!"
		);
=======
	}

	@Override
	public void run() {
		System.out.println(cardLayout.toString());
>>>>>>> 11fbcd819abe565e482952353f69664837c646ab
	}
}
