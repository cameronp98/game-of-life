import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;


public class Game extends BasicGame {

	private static double spawnRate;
	
	private static int gameWidth;
	private static int gameHeight;
	
	private Cell[][] thisMat;
	private Cell[][] nextMat;
	
	private int generation = 0;

	public Game(int width, int height, double spawnRate) {
		super("Conway's 'Game of Life'");

		this.gameWidth = width;
		this.gameHeight = height;
		
		thisMat = new Cell[width][height];
		nextMat = new Cell[width][height];
		
		this.spawnRate = spawnRate;
	}

	public void init(GameContainer gc) throws SlickException {
		boolean alive;
		int differentCells = 0;
		for (int i = 0; i < gameWidth; i++) {
			for (int j = 0; j < gameHeight; j++) {
				alive = false;
				if (Math.random() < spawnRate)
					alive = true;
				nextMat[i][j] = new Cell(i, j, alive);
			}
		}
		
		thisMat = nextMat.clone();
	}

	public void update(GameContainer gc, int delta) throws SlickException {
		generation++;
		
		int i, j, neighbours;
		for (i = 0; i < gameWidth; i++) {
			for (j = 0; j < gameHeight; j++) {
				neighbours = countNeighbours(i, j);
				nextMat[i][j].update(gc, delta, neighbours);
			}
		}
		
		thisMat = nextMat.clone();
	}
	
	public void render(GameContainer gc, Graphics g) throws SlickException {
		for (int i = 0; i < gameWidth; i++) {
			for (int j = 0; j < gameHeight; j++) {
				thisMat[i][j].render(gc, g);
			}
		}
		
		g.setColor(Color.red);
		g.drawString(gc.getFPS() + "/" + generation, 10, 10);
	}
	
	private int countNeighbours(int i, int j) {
		int ci, cj, neighbours = 0;
		
		for (ci = -1; ci < 2; ci++) {
			for (cj = -1; cj < 2; cj++) {
				if (cj == 0 && ci == 0)
					continue;
				if (i+ci >=0 && i+ci < gameWidth && j+cj >= 0 && j+cj < gameHeight && thisMat[i+ci][j+cj].isAlive())
					neighbours++;
			}
		}
		
		return neighbours;
	}

	public static void main(String[] args) {
		
	}
	
}
