

public class SoloMemoryController extends MemoryController {

	public SoloMemoryController() {
		cardLayout = new CardLayout().fillRandomly();
	}

	@Override
	public void run() {
		System.out.println(cardLayout.toString());
	}
}
