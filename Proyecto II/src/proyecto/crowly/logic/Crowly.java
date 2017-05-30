package proyecto.crowly.logic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

import proyecto.crowly.library.GraphyType;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Crowly {

	private JFrame frmCrowly;
	private Control ControlCrowly;

	public Crowly() 
	{
		initialize();
		ControlCrowly = new Control();
	}

	private void initialize()
	{
		frmCrowly = new JFrame();
		frmCrowly.setTitle("Crowly");
		frmCrowly.getContentPane().setBackground(new Color(0, 153, 255));
		frmCrowly.getContentPane().setForeground(Color.RED);
		frmCrowly.setBounds(100, 100, 498, 472);
		frmCrowly.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCrowly.getContentPane().setLayout(null);	
		JButton btnNewButton = new JButton("Bar");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				ControlCrowly.openBrowser(GraphyType.BAR);
			}
		});
		btnNewButton.setBounds(24, 328, 110, 33);
		frmCrowly.getContentPane().add(btnNewButton);
		
		JButton btnScartter = new JButton("Scartter");
		btnScartter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				ControlCrowly.openBrowser(GraphyType.SCARTTER);
			}
		});
		btnScartter.setBounds(343, 328, 110, 33);
		frmCrowly.getContentPane().add(btnScartter);
		
		JButton btnLine = new JButton("Line");
		btnLine.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				ControlCrowly.openBrowser(GraphyType.LINE);
			}
		});
		btnLine.setBounds(184, 328, 121, 33);
		frmCrowly.getContentPane().add(btnLine);
		
		JLabel lblCrowly = new JLabel("Crowly");
		lblCrowly.setBackground(new Color(255, 255, 255));
		lblCrowly.setForeground(new Color(255, 255, 255));
		lblCrowly.setFont(new Font("Kristen ITC", Font.BOLD, 43));
		lblCrowly.setBounds(151, 38, 194, 95);
		frmCrowly.getContentPane().add(lblCrowly);
		
		JButton btnNewButton_2 = new JButton("Process Video");
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				ControlCrowly.prosecute();
			}
		});
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(183, 184, 122, 25);
		frmCrowly.getContentPane().add(btnNewButton_2);
	}
}
