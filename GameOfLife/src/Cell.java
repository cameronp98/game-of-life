import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Cell {

	public static final int width = 24;
	public static final int height = 24;
	
	private float x, y;

	private boolean alive;
	
	private Image cell;
	
	public Cell(int x, int y, boolean alive) throws SlickException {
		this.x = x;
		this.y = y;
		
		this.alive = alive;
		
		cell = new Image("res/cell.jpg");
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void update(GameContainer gc, int delta, int neighbours) {
		if (neighbours < 2 || neighbours > 3)
			alive = false;
		else if(neighbours == 3)
			alive = true;
			
	}
	
	public void render(GameContainer gc, Graphics g) {
		if (alive)
			cell.draw(this.x * width, this.y * height, width, height);
	}
	
}
