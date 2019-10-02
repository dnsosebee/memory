// Player.java -- Class for representing a player in a game of memory

public class Player {
	private int pairsCollected;
	private int failedAttempts;

	public Player() {
		pairsCollected = 0;
		failedAttempts = 0;
	}
	
	// A successfully matched pair will increase the players pairsCollected by 1
	public void succeeded() {
		pairsCollected++;
	}
	
	// An pair that is not a successful match increases the player's failedAttempts by 1
	public void failed() {
		failedAttempts++;
	}
	
	public int pairsCollected() {
		return pairsCollected;
	}
	
	public int failedAttempts() {
		return failedAttempts;
	}
	
	// Override of toString method, allows for printing of player information.
	public String toString(int number) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("\n     Player ");
		stringBuilder.append(number + 1);
		stringBuilder.append(" has ");
		stringBuilder.append(pairsCollected);
		stringBuilder.append(" pairs collected, and ");
		stringBuilder.append(failedAttempts);
		stringBuilder.append(" incorrect guesses.");
		return stringBuilder.toString();
	}
}
