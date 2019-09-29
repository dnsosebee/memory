import java.util.ArrayList;
import java.util.List;

import Constants.MemoryConstants;

public class CardLayout {
<<<<<<< HEAD
	private List<Card> layout;
	private int activeCard1 = -1;
	private int activeCard2 = -1;

	private int cardCount;
=======
	List<Card> layout;
	int cardCount;
>>>>>>> 11fbcd819abe565e482952353f69664837c646ab

	public CardLayout() {
		layout = new ArrayList<Card>();
		cardCount = 0;
	}

<<<<<<< HEAD
	public boolean gameContinues() {
		return cardCount > 0;
	}

	public boolean choose(int index) {
		if (index >= layout.size() || index < 0 || index == activeCard1) {
			return false;
		}
		Card card = layout.get(index);
		if (card != null) {
			if (activeCard1 == -1) {
				activeCard1 = index;
			} else if (activeCard2 == -1) {
				activeCard2 = index;
			} else {
				throw new RuntimeException("Too many cards were chosen at one time.");
			}
			card.faceUp = true;
			return true;
		}
		return false;
	}

	public boolean CheckActiveCards() {
		if (activeCard1 == -1 || activeCard2 == -1) {
			throw new RuntimeException("Can't process any less than two active cards.");
		}
		if (layout.get(activeCard1).isPairOf(layout.get(activeCard2))) {
			return true;
		} else {
			return false;
		}
	}

	public void flipDownActiveCards() {
		Card c;
		if (activeCard1 > -1) {
			c = layout.get(activeCard1);
			c.faceUp = false;
		}
		if (activeCard2 > -1) {
			c = layout.get(activeCard2);
			c.faceUp = false;
		}
		deactivateCards();
	}

	public void removeActiveCards() {
		if (activeCard1 > -1) {
			layout.set(activeCard1, null);
		}
		if (activeCard2 > -1) {
			layout.set(activeCard2, null);
		}
		deactivateCards();
		cardCount -= 2;
	}

	private void deactivateCards() {
		activeCard1 = -1;
		activeCard2 = -1;
	}

=======
>>>>>>> 11fbcd819abe565e482952353f69664837c646ab
	public CardLayout fillRandomly() {
		for (int i = cardCount; i < MemoryConstants.NUMBER_OF_CARDS; ++i) {
			placeRandom(i);
		}
		return this;
	}

	private void placeRandom(int cardNumber) {
		Card card = new Card(cardNumber);
		int index = (int) ((cardCount + 1) * Math.random());
		placeCard(index, card);
	}

	private void placeCard(int index, Card card) {
		if (cardCount == MemoryConstants.NUMBER_OF_CARDS) {
			throw new RuntimeException("Layout is already full, can't add another card.");
		}
		layout.add(index, card);
		cardCount++;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		int layoutIndex = 0;
		for (int y = 0; y < MemoryConstants.NUMBER_OF_SUITS; ++y) {
			for (int x = 0; x < MemoryConstants.NUMBER_OF_CARD_TYPES; ++x) {
				if (layoutIndex == layout.size()) {
					break;
				}
				stringBuilder.append(cardIdentifier(layout.get(layoutIndex), layoutIndex));
				layoutIndex++;
			}
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

	private String cardIdentifier(Card card, int layoutIndex) {
<<<<<<< HEAD
		if (card == null) {
			return justifiedCard("");
		} else if (card.faceUp) {
			return card.toString();
		} else {
			String identifyingNumber = ((Integer) (layoutIndex + 1)).toString();
			return justifiedCard(identifyingNumber);
		}
	}

	private String justifiedCard(String identifyingNumber) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" [");
		// Fill the space preceding the text with empty characters
		for (int i = identifyingNumber.length(); i < MemoryConstants.CARD_BODY_LENGTH; ++i) {
			stringBuilder.append(' ');
		}
		stringBuilder.append(identifyingNumber);
		stringBuilder.append(']');
=======
		StringBuilder stringBuilder = new StringBuilder();
		String identifyingNumber;
		stringBuilder.append(" (");
		if (card == null) {

			// Fill the space with blank characters
			for (int i = 0; i < MemoryConstants.CARD_IDENTIFIERS_LENGTH; ++i) {
				stringBuilder.append(' ');
			}
		} else {
			identifyingNumber = ((Integer) (layoutIndex + 1)).toString();

			// Fill the space preceding the identifying number with empty characters
			for (int i = identifyingNumber.length(); i < MemoryConstants.CARD_IDENTIFIERS_LENGTH; ++i) {
				stringBuilder.append(' ');
			}
			stringBuilder.append(identifyingNumber);
		}
		stringBuilder.append(')');
>>>>>>> 11fbcd819abe565e482952353f69664837c646ab
		return stringBuilder.toString();
	}
}
