import java.util.ArrayList;
import java.util.List;

import Constants.MemoryConstants;

public class CardLayout {
	List<Card> layout;
	int cardCount;
	public CardLayout() {
		layout = new ArrayList<Card>();
		cardCount = 0;
	}

	public void placeRandom(int cardNumber) {
		Card card = new Card(cardNumber);
		int index = (int) ((cardCount+ 1) * Math.random());
		placeCard(index, card);
	}

	private void placeCard(int index, Card card) {
		if (cardCount == MemoryConstants.NUMBER_OF_CARDS) {
			throw new RuntimeException("Layout is already full, can't add another card.");
		}
		layout.add(index, card);
		cardCount++;
	}
}
