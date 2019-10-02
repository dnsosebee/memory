// CardLayout.java -- class for hold a List of Cards that can be used to play memory

import java.util.ArrayList;
import java.util.List;

import Constants.MemoryConstants;

public class CardLayout {
	private List<Card> layout;
	
	// indices of the card/cards that are currently flipped up.
	private int activeCard1 = -1;
	private int activeCard2 = -1;

	// number of cards in the layout
	private int cardCount;

	public CardLayout() {
		layout = new ArrayList<Card>();
		cardCount = 0;
	}

	// Returns true if there are more pairs to be found in the CardLayout
	public boolean gameContinues() {
		return cardCount > 0;
	}

	// Returns true if the index chosen is a valid and available card.
	// Flips that card up and sets it as an active card.
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

	// Returns true if the active cards are a valid pair
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

	// Flips down the active cards (because they were not a valid pair)
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

	// Removes the active cards (because they were a valid pair)
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

	// Resets the stored indices activeCard1 and activeCard2
	private void deactivateCards() {
		activeCard1 = -1;
		activeCard2 = -1;
	}

	// creates a random List of Cards, indexed 0 to NUMBER_OF_CARDS
	public CardLayout fillRandomly() {
		for (int i = cardCount; i < MemoryConstants.NUMBER_OF_CARDS; ++i) {
			placeRandom(i);
		}
		return this;
	}

	// Inserts a card randomly into the List of cards
	private void placeRandom(int cardNumber) {
		Card card = new Card(cardNumber);
		int index = (int) ((cardCount + 1) * Math.random());
		placeCard(index, card);
	}

	// Inserts a card into a specific index of the layout
	private void placeCard(int index, Card card) {
		if (cardCount == MemoryConstants.NUMBER_OF_CARDS) {
			throw new RuntimeException("Layout is already full, can't add another card.");
		}
		layout.add(index, card);
		cardCount++;
	}

	// Returns a string representing the full layout
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

	// Returns a string representing a particular card in the layout
	private String cardIdentifier(Card card, int layoutIndex) {
		if (card == null) {
			return justifiedCard("");
		} else if (card.faceUp) {
			return card.toString();
		} else {
			String identifyingNumber = ((Integer) (layoutIndex + 1)).toString();
			return justifiedCard(identifyingNumber);
		}
	}

	// Returns a string representing the identifier of the card at index identifyingNumber - 1
	// which is full width justified.
	private String justifiedCard(String identifyingNumber) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(" [");
		// Fill the space preceding the text with empty characters
		for (int i = identifyingNumber.length(); i < MemoryConstants.CARD_BODY_LENGTH; ++i) {
			stringBuilder.append(' ');
		}
		stringBuilder.append(identifyingNumber);
		stringBuilder.append(']');
		return stringBuilder.toString();
	}
}
