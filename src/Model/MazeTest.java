package Model;



/**
 * The test class MazeTest.
 *
 * @author  babak
 */
public class MazeTest //extends junit.framework.TestCase
{
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
/**    protected void setUp(){}

	public void testMoves()
	{
		Maze maze1 = new Maze();
		Pacman pacman1 = new Pacman(maze1);
		
		//testing initial position of Pacman
		assertEquals(0, pacman1.getX());
		assertEquals(0, pacman1.getY());
		
		//moving down: should work
		pacman1.moveDown();
		assertEquals(0, pacman1.getX());
		assertEquals(1, pacman1.getY());
		
		//moving left now should not work: bumping into a wall
		pacman1.moveLeft();
		assertEquals(0, pacman1.getX());
		assertEquals(1, pacman1.getY());
		
		//moving right should not work either: going off-limits
		pacman1.moveRight();
		assertEquals(0, pacman1.getX());
		assertEquals(1, pacman1.getY());
		
		//creating a ghost and testing initial position
		Ghost ghost1 = new Ghost(0, 0, maze1);
		assertEquals(0, ghost1.getX());
		assertEquals(0, ghost1.getY());
		
		//game is not over yet
		assertEquals(false, maze1.hasWon());
		assertEquals(false, maze1.hasLost());
		
		//now moving the ghost: it should catch Pacman immediately,
		//thus ending the game by a loss
		ghost1.move();
		assertEquals(false, maze1.hasWon());
		assertEquals(true, maze1.hasLost());
	}
**/
}

