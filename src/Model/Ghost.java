package Model;


/**
 * This class represents the Ghosts in the Pacman game
 *
 * @author
 */
public class Ghost extends Creature {

    /**
     * Initialize the ghost's state, and add self to the grid.
     * initial coordinates of the ghost provided by the parameters
     */
    public Ghost(int x, int y, Maze m) {
        super(x, y, m);
        maze.addGhost(this);
    }

    /**
     * Move one step in the general direction of Pacman
     * unless blocked by an obstacle.
     */
    public void move() {
        int px = maze.getPacman().getX();
        int py = maze.getPacman().getY();
        int dx = x - px;
        int dy = y - py;
        int tempx = x;
        int tempy = y;
        if (Math.abs(dx) > Math.abs(dy)) {
            if (dx > 0) tempx--; else tempx++;
        }
        else {
            if (dy > 0) tempy--;
            if (dy < 0) tempy++;
            //if dy == 0 don't move!
        }
        //TODO: test if new position feasible
        if (!(maze.hasWallAt(tempx, tempy))) {x = tempx; y = tempy;}
    }
}
