import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;


public class Main {
	
	private static final int width = 32;
	private static final int height = 32;
	
	private static final int screenWidth = width * Cell.width;
	private static final int screenHeight = height * Cell.height;
	
	private static final int targetFPS = 30;
	
	private static final double spawnRate = 0.06;
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Game(width, height, spawnRate));
		app.setDisplayMode(screenWidth, screenHeight, false);
		app.setTargetFrameRate(targetFPS);
		app.setAlwaysRender(true);
		app.setShowFPS(false);
		app.start();
	}
	
}
