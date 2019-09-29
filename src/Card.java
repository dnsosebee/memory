import Constants.MemoryConstants;

public class Card {

	public boolean faceUp;
	
	private int number;
	
	public Card(int cardNumber) {
		number = cardNumber;
		faceUp = false;
	}
	
	public int getNumber() {
		return number;
	}
	
	private String displayString() {
		return MemoryConstants.CARD_TYPE_STRINGS[number / MemoryConstants.NUMBER_OF_SUITS];
	}
	
	private String suitString() {
		return MemoryConstants.SUIT_STRINGS[number % MemoryConstants.NUMBER_OF_SUITS];
	}
	
	public String toString() {
		if ((number % MemoryConstants.NUMBER_OF_SUITS) / 2 ==0) {
			return " ("+ displayString() + suitString() + ")";
		} else {
			return " {"+ displayString() + suitString() + "}";
		}
	}

	// Parameters: other -- Card which is a potential match to this card
	// Returns true if the two card numbers are contiguous, with the even number lower
	public boolean isPairOf(Card other) {
		if ((number & 1) == 0) {
			return (other.getNumber() - 1 == number);
		} else {
			return (other.getNumber() + 1 == number);
		}
	}
}
