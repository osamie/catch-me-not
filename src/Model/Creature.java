package Model;


/**
 * Creature represents anything that moves in the maze.
 *
 * @author 
 */
public class Creature {
    // x is column, y is row
    protected int x, y;
    protected Maze maze;

    /**
     * Assign the maze, and give an initial position (for example 0, 0)
     */
    public Creature(Maze m) {
        this(0, 0, m);
    }

    /**
     * Assign the maze
     * and set the coordinates to the ones supplied by the parameters
     */
    public Creature(int x, int y, Maze m) {
        if (m == null) throw new IllegalArgumentException();
        if ((x < 0) || (y < 0) || (x >= Maze.SIZE) || (y >= Maze.SIZE))
            throw new IllegalArgumentException();
        maze = m;
        this.x = x; this.y = y;
    }

    /**
     * @return the x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    protected boolean canGoTo(int i, int j) {
        boolean b = ((i >= 0) && (j >= 0) && (i < Maze.SIZE) && (j < Maze.SIZE) &&
                (!maze.hasWallAt(i,j)) &&
                ((Math.abs(x-i) + Math.abs(y-j)) == 1) );
        return b;
    }
}
