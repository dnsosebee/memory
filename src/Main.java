import Constants.Errors;

public class Main {
	
	// We expect 
	public static void main(String[] args) {
		if (args.length != 1) {
			errorMessage(Errors.wrongNumArgs);
			return;
		}
		switch (args[0]) {
		case "solo":
			break;
		case "competitive":
			break;
		default:
			errorMessage(Errors.wrongArgument);
			return;
		}
		MemoryController controller;
	}
	
	private static void errorMessage(Errors error) {
		String usage = "Please use either \"solo\" or \"competitive\" as your single argument. "
				+ "Ex: "; //TODO
		String message;
		switch (error) {
		case wrongNumArgs:
			message = "There was an incorrect number of arguments. ";
			break;
		case wrongArgument:
			message = "The argument entered was invalid. ";
			break;
		default:
			message = "Unknown Error. ";
			break;
		}
		System.out.println(message + usage);
	}
}
