package Model;

import java.awt.Point;


/**
 * This class launches the game by creating the maze
 * and the various monsters, prompting the user to play,
 * displaying the current state of the maze, 
 * and ending it.
 * 
 *
 */
public class Game {
    protected Maze maze;
    protected Pacman pac;

    /**
     * Creates the maze, Pacman, some ghosts
     */
    public Game() 
    {
    	
        maze = new Maze();
        //building the maze
        
        //row 0
        maze.addWall(new Point(0,1));
        maze.addWall(new Point(0,2));
        //maze.addWall(new Point(0,4));
        //maze.addWall(new Point(0,5));
        maze.addWall(new Point(0,8));
        maze.addWall(new Point(0,9));
        
        maze.addWall(new Point(1,1));
        maze.addWall(new Point(1,2));
        maze.addWall(new Point(1,4));
        maze.addWall(new Point(1,5));
        
        
        maze.addWall(new Point(2,7));
        maze.addWall(new Point(2,8));
        
        maze.addWall(new Point(3,1));
        maze.addWall(new Point(3,2));
        maze.addWall(new Point(3,4));
        maze.addWall(new Point(3,7));
        
        maze.addWall(new Point(4,2));
        maze.addWall(new Point(4,4));
        maze.addWall(new Point(4,5));
        maze.addWall(new Point(4,7));
        maze.addWall(new Point(4,9));
        
        
        maze.addWall(new Point(5,0));
        maze.addWall(new Point(5,4));
        
        maze.addWall(new Point(6,0));
        maze.addWall(new Point(6,6));
        maze.addWall(new Point(6,9));
        
        maze.addWall(new Point(7,0));
        maze.addWall(new Point(7,1));
        maze.addWall(new Point(7,2));
        maze.addWall(new Point(7,4));
        maze.addWall(new Point(7,6));
        maze.addWall(new Point(7,7));
        //maze.addWall(new Point(7,8));
        maze.addWall(new Point(7,9));
        
        maze.addWall(new Point(8,4));
        //maze.addWall(new Point(8,8));
        
        
        
        maze.addWall(new Point(9,3));
        maze.addWall(new Point(9,4));
        maze.addWall(new Point(9,8));
        
        pac = new Pacman(maze);
        
        //no need to keep a ref to the ghost(s)
        new Ghost(Maze.SIZE - 1, Maze.SIZE - 1, maze);
        new Ghost(Maze.SIZE - 2, Maze.SIZE - 8, maze);
    }
    
    /**
     * - Outputs the current state of the maze
     * - Gets console input from the user to determine Pacman's next move
     * (<a, s, w, z> keys to move, "q" to quit)
     * - until game is won or lost or the user quit.
     */
    /*
    public void play() 
    {
        Scanner sc = new Scanner(System.in);
        String command;
        maze.print();
        System.out.println("Enter your move <a,s,w,z> or q to quit");       
        while (sc.hasNext()) {
            command = sc.next();
            if (command.equals("q")) return;
            if (command.equals("w")) pac.moveUp();
            if (command.equals("z")) pac.moveDown();
            if (command.equals("a")) pac.moveLeft();
            if (command.equals("s")) pac.moveRight();
            for (Ghost g : maze.getGhosts()) {
                g.move();
            }
            maze.print();
            if (maze.hasWon()) {
                System.out.println("Congratulations! You solved the puzzle!");
                return;
            }
            if (maze.hasLost()) {
                System.out.println("Oh no! You were captured by a ghost! Game over.");
                return;
            }
            System.out.println("Enter your move <a,s,w,z> or q to quit");
        }
    }

    
    /**
     * Launches the game by instantiating a new game and calling play() on it.
     */
    /*
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
    */

}





