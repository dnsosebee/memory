
public abstract class MemoryController {
	
	protected CardLayout cardLayout;
	
	public abstract void run();
	
	protected void print(String message) {
		System.out.println(message);
	}
}
