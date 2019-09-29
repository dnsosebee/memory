package Constants;

public class MemoryConstants {
	
<<<<<<< HEAD
	public final static int PLAYERS_IN_COMPETITIVE_GAME = 2;
	
=======
>>>>>>> 11fbcd819abe565e482952353f69664837c646ab
	public final static String[] CARD_TYPE_STRINGS = {
			" A"," 2"," 3"," 4"," 5"," 6"," 7"," 8"," 9","10"," J"," Q"," K"
	};
	
	public final static String[] SUIT_STRINGS = {
			"D","H","S","C"
	};
	
<<<<<<< HEAD
	public final static int NUMBER_OF_SUITS = SUIT_STRINGS.length;
	
	public final static int CARD_BODY_LENGTH = 3;
	
	public static int NUMBER_OF_CARD_TYPES;

	public static int NUMBER_OF_CARDS;
=======
	public final static int NUMBER_OF_CARD_TYPES = CARD_TYPE_STRINGS.length;
	
	public final static int NUMBER_OF_SUITS = SUIT_STRINGS.length;

	public final static int NUMBER_OF_CARDS = NUMBER_OF_CARD_TYPES * NUMBER_OF_SUITS;
	
	public final static int CARD_IDENTIFIERS_LENGTH = ((Integer)NUMBER_OF_CARDS).toString().length();
>>>>>>> 11fbcd819abe565e482952353f69664837c646ab
}
