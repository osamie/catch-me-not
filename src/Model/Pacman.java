package Model;


/**
 * This class represents Pacman
 * @author
 */
public class Pacman extends Creature {


    /**
     * Constructor for objects of class Pacman
     * Sets the initial coordinates at (0,0), and add self to the grid
     * @param a reference to the maze
     */
    public Pacman(Maze m) {
        super(m);
        maze.setPacman(this);
    }


    /**
     * Move Down unless there is an obstacle,
     * eat dots if applicable
     */
    public void moveDown() {
        if (canGoTo(x,y+1)){
            y++;
            maze.eat(x,y);
        }
    }

    /**
     * Move up unless there is an obstacle,
     * eat dots if applicable
     */
    public void moveUp() {
        if (canGoTo(x, y-1)){
            y--;
            maze.eat(x,y);
        }
    }

    /**
     * Move left unless there is an obstacle,
     * eat dots if applicable
     */
    public void moveLeft() {
        if (canGoTo(x-1, y)){
            x--;
            maze.eat(x,y);
        }
    }

    /**
     * Move right unless there is an obstacle,
     * eat dots if applicable
     */
    public void moveRight() {
        if (canGoTo(x+1, y)){
            x++;
            maze.eat(x,y);
        }
    }
}
