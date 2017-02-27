package Model;
// import images.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;

import javax.swing.JOptionPane;

/**
 * Write a description of class GraphicalGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GraphicalGame extends Game implements ActionListener,MouseListener
{
    // instance variables - replace the example below with your own
	int width = 800;
	int height = 600;
	public JFrame pacframe;
	public JFrame endFrame;
	JFrame winFrame;
	Container eframe;
	Container wframe;
	PacButton buttons[][];
	//ImageIcon pacmanPicx = new ImageIcon("c:/pacc/pacmanPicx.png");
	//ImageIcon pacmanPicx = new ImageIcon("/images/pacmanPicx.png");
	ImageIcon background = new ImageIcon(getClass().getResource("/images/bckground.png"));
	ImageIcon pacFood = new ImageIcon(getClass().getResource("/images/pacFood1.png"));

	ImageIcon pacmanPicx = new ImageIcon(getClass().getResource("/images/pacmanpicx12.jpg"));
	ImageIcon wall = new ImageIcon(getClass().getResource("/images/wall1.png"));
	ImageIcon ghost1 = new ImageIcon(getClass().getResource("/images/Brian_Griffin.jpg"));
	//ImageIcon ghost2 = new ImageIcon(getClass().getResource("/images/Brian_Griffin.jpg"));
	ImageIcon endPicx = new ImageIcon(getClass().getResource("/images/Stewie-You-Suck.jpg"));
	ImageIcon winPicx = new ImageIcon(getClass().getResource("/images/FireworksAnimated.gif"));
	ImageIcon startPg = new ImageIcon(getClass().getResource("/images/startPage.jpg"));



	JLabel loselabel;
	JLabel winlabel;

	//(new ImageIcon("c:/pacc/theEnd_pacfuneral.jpg"));
	//theEnd.add(endPicx);

	//ImageIcon pacFood = new ImageIcon("c:/pacc/pacFood1.png");
	//JLabel l = new JLabel(pacmanPicx);


	//ImageIcon background = new ImageIcon(canvas);
	JFrame startFrame;


    /**
     * Constructor for objects of class GraphicalGame
     */
    public GraphicalGame()
    {


    	 endFrame = new JFrame("Game Over");

    	 winFrame = new JFrame("GameOver");

    	 startFrame = new JFrame("Clicky Pac");
    	 startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    	 //Container c = startFrame.getContentPane();
    	 JLabel label = new JLabel(startPg);

    	 label.addMouseListener(this);
    	 startFrame.add(label);
    	 startFrame.setSize(width, height);
    	 //startFrame.setVisible(true);

    	 pacframe = new JFrame("Catch Me Not");
         pacframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         pacframe.setSize(width,height);

         pacframe.setLayout(new GridLayout(Maze.SIZE,Maze.SIZE));


    	/*
         for(;;)
         {
        	 repaint();
         }
         */



    	 startFrame.addMouseListener(this);




         startGame();



    }


    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y
     */
    public void repaint()
    {
        int x = pac.getX();
        int y = pac.getY();

        if(!maze.hasLost() && !maze.hasWon())
        {
        	for (int j=0; j<Maze.SIZE; j++) {
        		for (int i= 0; i <Maze.SIZE; i++) {
        			if (maze.hasWallAt(i,j)) buttons[i][j].setIcon(wall);
        			else if (maze.hasGhostAt(i, j))buttons[i][j].setIcon(ghost1);
                //else if ( (i==x) && (j==y) )buttons[i][j].setText("P");
        			else if ( (i==x) && (j==y) )buttons[i][j].setIcon(pacmanPicx);
        			else if (maze.hasDotAt(i,j))buttons[i][j].setIcon(pacFood); //setText(".");
        				else
        				{
        					buttons[i][j].setIcon(background);
        					//buttons[i][j].setBackground(Color.BLACK);

                     	 //buttons[i][j].remove(pacmanPicx);
        				}
                //repaint();


        		}

        	}
        }

        else if (maze.hasLost())
        {
        	//pacframe.setEnabled(false);
        	//pacframe = endFrame;
        	//pacframe.dispose();
        	pacframe.dispose();
        	loselabel = new JLabel(endPicx);
        	eframe = endFrame.getContentPane();
       	 	eframe.setBackground(Color.black);
       	 	eframe.add(loselabel);



       	 	endFrame.setBackground(Color.black);
        	endFrame.setSize(800,600);
        	endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	endFrame.setVisible(true);

        }

        else if (maze.hasWon())
        {
        	pacframe.dispose();

        	/*
        	JButton j2 = new JButton("Play Eight Queens", Queen);
    		j2.addActionListener(this);
    		j2.setVerticalTextPosition(SwingConstants.BOTTOM);
    		j2.setHorizontalTextPosition(SwingConstants.CENTER);
    		//wframe.add(j2);
    		j2.setLocation(,0)
    		j2.setRolloverEnabled(false);
    		j2.setVisible(true);
    		*/





        	winlabel = new JLabel("YOU WIN",JLabel.TOP);
        	winlabel.setIcon(winPicx);


        	winlabel.setFont(new Font("Times New Roman", Font.BOLD,48));

        	winlabel.setHorizontalTextPosition(SwingConstants.CENTER);
        	winlabel.setVerticalTextPosition(SwingConstants.TOP);

        	winlabel.setBackground(Color.black);
        	wframe = winFrame.getContentPane();
        	wframe.setBackground(Color.black);
        	wframe.add(winlabel);

        	winFrame.setSize(width,height);
        	winFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	winFrame.setVisible(true);

        }




    }

    //mouse listener method
    public void actionPerformed(ActionEvent ev)
    {


        Object obj = ev.getSource();
        if(obj instanceof PacButton)
        {

            PacButton selected = (PacButton)obj;
            Point p1 = selected.getCoord();
            double x = pac.getX();
            double y = pac.getY();
            double i = p1.getX();
            double j = p1.getY();

            if (i == x+1 && j==y){pac.moveRight();}
            else if (i == x-1 && j==y){pac.moveLeft();}
            else if (i == x && j==y-1){pac.moveUp();}
            else if (i == x && j==y+1){pac.moveDown();}

            else{JOptionPane.showMessageDialog(null,"You cannot move there!!!");}


            for (Ghost gho : maze.getGhosts())
            {
                gho.move();
            }
            if (maze.hasWon()) {

            	repaint();

            }
            if (maze.hasLost())
            {

                repaint();
            }


        }
    }


    public void startGame()
    {
    	 //startFrame.setVisible(false);
    	 //startFrame.dispose();

 //    	 java.applet.AudioClip clip;
	// 	clip = java.applet.Applet.newAudioClip(getClass().getResource("/audio/fbk.mp3"));
	// 	clip.play();
	// 	clip.loop();
	// 	System.out.println(clip.toString());


       //startGame()
         pacframe.setVisible(true);

    	 buttons = new PacButton[Maze.SIZE][Maze.SIZE];
         for (int i= 0; i<Maze.SIZE; i++) {
           for (int j= 0; j < Maze.SIZE; j++) {
           	buttons[i][j] = new PacButton(i,j);
           	buttons[i][j].setBackground(Color.BLACK);
           	pacframe.getContentPane().add(buttons[i][j]);
           	buttons[i][j].addActionListener(this);


           }

         }



        for(;;)
        {
        	repaint();
        }
    }


	@Override
	public void mouseClicked(MouseEvent arg0) {
		startGame();
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args)
	{

		GraphicalGame g = new GraphicalGame();

	}
}
