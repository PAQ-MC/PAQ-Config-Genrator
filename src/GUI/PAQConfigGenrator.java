package GUI;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class PAQConfigGenrator implements ActionListener{
	
	JFrame frame = new JFrame("Forge Configuration");
	JPanel CP = new JPanel();
	JLabel bl = new JLabel(""), l1 = new JLabel("Configuration"), l2 = new JLabel("Forge"), l3 = new JLabel("Version: "), l4 = new JLabel("Mods: ");
	JTextField btb1 = new JTextField(),btb2 = new JTextField(),tb1 = new JTextField(), tb2 = new JTextField();
	JButton b1 = new JButton("Update"), b2 = new JButton("Write");
	
	
	public PAQConfigGenrator(){
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CP.setLayout(new GridLayout (0,2,10,5));
		
		b1.setActionCommand("Update");
		b1.addActionListener(this);	
		
		b2.setActionCommand("Write");
		b2.addActionListener(this);	
		
		/* This is the start of the display*/
	
		CP.add(l1);	CP.add(tb1); 
		
		CP.add(l2); CP.add(btb2);
		
		CP.add(l3); CP.add(tb2);
		
		CP.add(l4); CP.add(btb1);
		
		CP.add(b1);	CP.add(b2);
		
		/* This is the end of the display*/
				
		frame.setContentPane(CP);
		frame.pack();
		frame.setVisible(true);
		}
		public void actionPerformed(ActionEvent event){
			String eventX = event.getActionCommand();
			String content = tb1.getText();
			if(eventX == "Update"){
				Prompt_GUI x = new Prompt_GUI();
				}
				
			if(eventX =="Write"){
			//Issac Make this shit write to a file. I tried and fucked up.
			}
		}
		
		public static void main(String[]args){
			JFrame.setDefaultLookAndFeelDecorated(true);
			PAQConfigGenrator x = new PAQConfigGenrator();
	}
}

