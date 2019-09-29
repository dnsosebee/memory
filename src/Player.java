
public class Player {
	private int pairsCollected;
	private int failedAttempts;

	public Player() {
		pairsCollected = 0;
		failedAttempts = 0;
	}
	
	public void succeeded() {
		pairsCollected++;
	}
	
	public void failed() {
		failedAttempts++;
	}
	
	public int pairsCollected() {
		return pairsCollected;
	}
	
	public int failedAttempts() {
		return failedAttempts;
	}
	
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
