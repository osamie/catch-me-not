/*
package Model;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class StartGame extends JFrame implements ActionListener {
	//JFrame startpg;
	Container p;
	JButton startButton;
	FramesManager Fm;
	public StartGame(FramesManager f)
	{
		super("CLICKY PAC");
		Fm = f;
		//startpg = new JFrame("CLICKY PAC");
		
		p = this.getContentPane();
		this.setSize(800,650);
		
		ImageIcon startpicx = new ImageIcon(getClass().getResource("/images/startpage.jpg"));
		startButton = new JButton("Start",startpicx);
		startButton.setSize(this.getSize());
		startButton.addActionListener(this);
		this.add(startButton);
		//(startpicx);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setVisible(true);
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if (obj instanceof JButton)
		{
			
			Fm.startgame(this);
			
			//GraphicalGame g = new GraphicalGame();
		}
		else 
		{
			Fm.startgame(this);
		}
		// TODO Auto-generated method stub
		
	}
	
	

}
*/