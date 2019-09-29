package Constants;

public class MemoryConstants {
	
	public final static String[] CARD_TYPE_STRINGS = {
			" A"," 2"," 3"," 4"," 5"," 6"," 7"," 8"," 9","10"," J"," Q"," K"
	};
	
	public final static String[] SUIT_STRINGS = {
			"D","H","S","C"
	};
	
	public final static int NUMBER_OF_CARD_TYPES = CARD_TYPE_STRINGS.length;
	
	public final static int NUMBER_OF_SUITS = SUIT_STRINGS.length;

	public final static int NUMBER_OF_CARDS = NUMBER_OF_CARD_TYPES * NUMBER_OF_SUITS;
	
	public final static int CARD_IDENTIFIERS_LENGTH = ((Integer)NUMBER_OF_CARDS).toString().length();
}
