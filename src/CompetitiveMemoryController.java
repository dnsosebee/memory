import java.util.ArrayList;
import java.util.List;

import Constants.MemoryConstants;

public class CompetitiveMemoryController extends MemoryController {

	public CompetitiveMemoryController() {
		cardLayout = new CardLayout().fillRandomly();
		players = new ArrayList<Player>();
		for (int i = 0; i < MemoryConstants.PLAYERS_IN_COMPETITIVE_GAME; ++i) {
			players.add(new Player());
		}
	}

	@Override
	public void endGameMessage() {
		StringBuilder message = new StringBuilder();
		int max = -1;
		List<Integer> winners = new ArrayList<Integer>();
		int pairsForCurrent;
		for (int i = 0; i < players.size(); ++i) {
			pairsForCurrent = players.get(i).pairsCollected();
			if (pairsForCurrent > max) {
				max = pairsForCurrent;
				winners = new ArrayList<Integer>();
				winners.add(i);
			} else if (pairsForCurrent == max) {
				winners.add(i);
			}
		}
		if (winners.size() > 1) {
			message.append("It's a tie between player ");
			message.append(winners.get(0) + 1);
			for (int i = 1; i < winners.size(); ++i) {
				message.append(" and player ");
				message.append(winners.get(i) + 1);
			}
		} else {
			message.append("Good job player ");
			message.append(winners.get(0) + 1);
		}
		message.append(", who won with ");
		message.append(max);
		message.append(" points! Thanks for playing!");
		super.print(message.toString());
	}
}
