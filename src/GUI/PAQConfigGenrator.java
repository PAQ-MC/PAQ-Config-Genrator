package GUI;

import java.util.*;
import java.awt.*;

import javax.swing.*;

import Json.GetInstallInfo;
import Json.InstallInfo;
import Worker.FileGrab;

import java.awt.event.*;
import java.io.*;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

public class PAQConfigGenrator {

	public static InstallInfo obj;

	static JFrame frame = new JFrame("Forge Configuration");
	JPanel CP = new JPanel();
	JLabel bl = new JLabel(""), l1 = new JLabel("Configuration"),
			l2 = new JLabel("Forge"), l3 = new JLabel("Version: "),
			l4 = new JLabel("Mods: ");
	public static JTextField tbForge = new JTextField(),
			tbConfig = new JTextField(), tbVersion = new JTextField();
	JButton b1 = new JButton("Update"), b2 = new JButton("Write");
	public static JComboBox cbMods = new JComboBox();

	public PAQConfigGenrator() {

		try {
			obj = GetInstallInfo.JsonInfo();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/* This is the start of the display */
		CP.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("124px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("281px:grow"),},
			new RowSpec[] {
				RowSpec.decode("23px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),}));

		CP.add(l1, "1, 1, fill, fill");

		CP.add(tbConfig, "3, 1, fill, fill");

		CP.add(l2, "1, 3, fill, fill");
		tbForge.setEditable(false);
		CP.add(tbForge, "3, 3, fill, fill");

		CP.add(l3, "1, 5, fill, fill");
		CP.add(tbVersion, "3, 5, fill, fill");

		CP.add(l4, "1, 7, fill, fill");
		cbMods.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int SelectedIndex = cbMods.getSelectedIndex();
				Prompt_Mod_Updater x = new Prompt_Mod_Updater(obj, SelectedIndex);
				x.frame.setVisible(true);
			}
		});

		CP.add(cbMods, "3, 7, fill, fill");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					FileGrab.setup(obj);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		CP.add(b1, "1, 9, fill, fill");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		CP.add(b2, "3, 9, fill, fill");

		/* This is the end of the display */

		frame.setContentPane(CP);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		PAQConfigGenrator x = new PAQConfigGenrator();
	}

	public static JFrame getFrame() {
		return frame;
	}
}
