import Constants.MemoryConstants;

public abstract class MemoryController {
	
	public abstract void setup();
	
	public abstract void run();
	
	private CardLayout newShuffledDeck() {
		CardLayout cardLayout = new CardLayout();
		for (int i = 0; i < MemoryConstants.NUMBER_OF_CARDS; ++i) {
			cardLayout.placeRandom(i);
		}
		return cardLayout;
	}
}
