package Model;

import java.util.*;
import java.awt.Point;
/**
 * The Maze is a SIZExSIZE grid (a 2-d array of booleans)
 * An uneaten dot is represented by true, an empty cell is represented by false.
 * The Maze also maintains a reference to Pacman (this will be needed
 * by the ghosts, and for display purposes) and to the ghosts.
 *
 * @author
 */
public class Maze
{
    public static int SIZE = 10;
    private boolean[][] grid;
    private int dotsLeft;
    private Pacman pac;
    private ArrayList<Ghost> ghosts;
    private ArrayList<Point> walls;

    /**
     * Set all the cells in the maze to True (no dots have been eaten yet)
     * Create Pacman and keep a reference to it.
     * List of ghosts is empty initially.
     * List of walls is to be created and populated here.
     */
    public Maze() {
        dotsLeft = 0;
        grid = new boolean[SIZE][SIZE];
        for (int i= 0; i<SIZE; i++) {
            for (int j= 0; j <  SIZE; j++) {
                grid[i][j] = true;
                dotsLeft++;
            }
        }
        ghosts = new ArrayList<Ghost>();
        walls = new ArrayList<Point>();
        /*
        walls.add(new Point(1,2)); dotsLeft--;
        walls.add(new Point(1,3)); dotsLeft--;
        walls.add(new Point(1,4)); dotsLeft--;
        walls.add(new Point(2,4)); dotsLeft--;
        walls.add(new Point(2,5)); dotsLeft--;
        walls.add(new Point(2,6)); dotsLeft--;
        walls.add(new Point(2,7)); dotsLeft--;
        walls.add(new Point(2,2)); dotsLeft--;
        walls.add(new Point(3,2)); dotsLeft--;
        walls.add(new Point(4,2)); dotsLeft--;
        walls.add(new Point(5,2)); dotsLeft--;
        walls.add(new Point(5,3)); dotsLeft--;
        walls.add(new Point(5,4)); dotsLeft--;
        walls.add(new Point(5,5)); dotsLeft--;
        walls.add(new Point(6,5)); dotsLeft--;
        */
        //can I initialize pacman yet? chicken and egg problem.
        //Pacman pac = new Pacman(this);

    }


    /**
     * @return a reference to Pacman
     */
    public Pacman getPacman() {
        return pac;
    }

    public void addWall(Point p)
    {
    	this.walls.add(p);
    	this.dotsLeft--;
    }

    /**
     * @return the list of ghosts
     */
    public ArrayList<Ghost> getGhosts() {
        return ghosts;
    }

    /**
     * Set Pacman
     */
    public void setPacman(Pacman p) {
        if (p!= null) {
            pac = p;
            //next line is to make sure Pacman doesn't leave a dot behind!
            this.eat(pac.getX(), pac.getY());
        }
    }

    /**
     * Add a ghost to the list of ghosts
     */
    public void addGhost(Ghost g)
    {
        if (g!= null) ghosts.add(g);
    }


    /**
     * Removes a 'dot' indicated by the supplied coordinates from the Grid
     */
    public void eat(int i, int j) {
        if ((i < SIZE) && (i>=0) && (j < SIZE) && (j >= 0)) {
            if (grid[i][j]) dotsLeft--;
            grid[i][j] = false; //doesn't matter if 'dot' is present or not
        }
    }

    /**
     * @return true if there is a ghost at the supplied coordinates
     */
    public boolean hasGhostAt(int i, int j) {
        for (Ghost g : ghosts) {
            if ((g.getX() == i) && (g.getY() == j)) return true;
        }
        return false;
    }

    /**
     * @return true if there is a wall at the supplied coordinates
     */
    public boolean hasWallAt(int i, int j) {
        Point p = new Point(i,j);
        return walls.contains(p);
    }

    public boolean hasDotAt(int i, int j)
    {
        return grid[i][j];
    }

    /**
     * @return true if there are no more dots left. Puzzle completed!
     */
    public boolean hasWon() {
        return (dotsLeft <= 0);
    }

    /**
     * @return true if there is a ghost at the same coordinate as Pacman.
     */

    public boolean hasLost() {
        int px = pac.getX();
        int py = pac.getY();
        for (Ghost g : ghosts) {
            if ((g.getX() == px) && (g.getY() == py)) return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "";
        int x = pac.getX();
        int y = pac.getY();
        for (int j=0; j<SIZE; j++) {
            for (int i= 0; i <  SIZE; i++) {
                if (hasWallAt(i,j)) s+= "W";
                else if (hasGhostAt(i, j)) s+= "G";
                else if ( (i==x) && (j==y) ) s+= "P";
                else if (grid[i][j]) s+= ".";
                     else s+= " ";
            }
            s += "\n";
        }
        return s;
    }

    /**
     * Ouput a string representation of the maze to the console
     */
    public void print() {
        System.out.println(this);
    }
}
