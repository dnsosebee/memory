import Constants.Errors;
import Constants.MemoryConstants;

public class Main {
	public static void main(String[] args) {
		if (args.length != 2) {
			errorMessage(Errors.wrongNumArgs);
			return;
		}
		int numberOfCardTypes = 0;

		try {
			numberOfCardTypes = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			errorMessage(Errors.wrongArgument);
			return;
		}
		if (numberOfCardTypes < 1 || numberOfCardTypes > 13) {
			errorMessage(Errors.wrongArgument);
			return;
		}
		MemoryConstants.NUMBER_OF_CARD_TYPES = numberOfCardTypes;
		MemoryConstants.NUMBER_OF_CARDS = numberOfCardTypes * MemoryConstants.NUMBER_OF_SUITS;

		if (args.length != 2) {
			errorMessage(Errors.wrongNumArgs);
			return;
		}
		MemoryController controller;
		switch (args[0]) {
		case "solo":
			controller = new SoloMemoryController();
			break;
		case "competitive":
			controller = new CompetitiveMemoryController();
			break;
		default:
			errorMessage(Errors.wrongArgument);
			return;
		}
		controller.run();
		controller.endGameMessage();
	}

	private static void errorMessage(Errors error) {
		String usage = "\nPlease use either \"solo\" or \"competitive\" as your first argument,"
				+ "and a number between 1 and 13 as your second argument.\n" + "Ex: ./Memory.run solo 13";
		String message;
		switch (error) {
		case wrongNumArgs:
			message = "There was an incorrect number of arguments. ";
			break;
		case wrongArgument:
			message = "An argument entered was invalid. ";
			break;
		default:
			message = "Unknown Error. ";
			break;
		}
		System.out.println(message + usage);
	}
}
