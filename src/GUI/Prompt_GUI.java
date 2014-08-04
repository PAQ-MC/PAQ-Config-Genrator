package GUI;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Prompt_GUI /*implements ActionListener*/{
	
	JFrame frame = new JFrame("Updater");
	JPanel CP = new JPanel();
	JLabel bl = new JLabel(""), l1 = new JLabel("Name"), l2 = new JLabel("Link"), l3 = new JLabel("ID: "), l4 = new JLabel("Client Only:"),l5 = new JLabel("File Size: ");
	JTextField btb1 = new JTextField(),btb2 = new JTextField(),tb1 = new JTextField(), tb2 = new JTextField(),tb3 = new JTextField();
	JButton b1 = new JButton("Update");
	
	
	public Prompt_GUI(){
	
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CP.setLayout(new GridLayout (0,2,10,5));
		
		CP.add(l1);	CP.add(tb1); 
		
		CP.add(l2); CP.add(btb2);
		
		CP.add(l3); CP.add(tb2);
		
		CP.add(l4); CP.add(btb1);
		
		CP.add(l5); CP.add(tb3);
		
		frame.setContentPane(CP);
		frame.pack();
		frame.setVisible(true);
		}
		public static void main(String[]args){
			JFrame.setDefaultLookAndFeelDecorated(true);
			Prompt_GUI x = new Prompt_GUI();
	}
}