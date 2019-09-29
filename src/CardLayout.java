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
		return stringBuilder.toString();
	}
}
