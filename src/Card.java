
public class Card {
	
	private int number;
	
	public Card(int cardNumber) {
		number = cardNumber;
	}
	
	public int getNumber() {
		return number;
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
