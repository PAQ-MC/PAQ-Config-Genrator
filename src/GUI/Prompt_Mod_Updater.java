package GUI;

import java.util.*;
import java.util.List;
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import Json.InstallInfo;
import Json.mods;

import com.google.gson.Gson;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

public class Prompt_Mod_Updater /* implements ActionListener */{

	JFrame frame = new JFrame("Mod Updater");
	JPanel CP = new JPanel();
	JLabel bl = new JLabel(""), l1 = new JLabel("Name"),
			l2 = new JLabel("Link"), l3 = new JLabel("ID: "), l4 = new JLabel(
					"Client Only:"), l5 = new JLabel("File Size: ");
	JTextField tbLink = new JTextField(), tbName = new JTextField(),
			tbID = new JTextField(), tbFileSize = new JTextField();
	JButton b1 = new JButton("Update");
	private final JButton btnSave = new JButton("Save");
	private final JButton btnCancel = new JButton("Cancel");
	private final JToggleButton tglbtnClinetOnly = new JToggleButton(
			"True/False");

	public Prompt_Mod_Updater(final InstallInfo obj, final int SelectedIndex) {
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		CP.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("116px"), FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("220px:grow"), }, new RowSpec[] {
				RowSpec.decode("23px"), FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"), FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"), FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"), FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"), FormFactory.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"), }));

		CP.add(l1, "1, 1, fill, fill");
		tbName.setText(obj.mods().get(SelectedIndex).name());
		CP.add(tbName, "3, 1, fill, fill");

		CP.add(l2, "1, 3, fill, fill");
		tbLink.setText(obj.mods().get(SelectedIndex).link());
		CP.add(tbLink, "3, 3, fill, fill");

		CP.add(l3, "1, 5, fill, fill");
		tbID.setText(obj.mods().get(SelectedIndex).id() + "");
		CP.add(tbID, "3, 5, fill, fill");

		CP.add(l4, "1, 7, fill, fill");
		tglbtnClinetOnly
				.setSelected(obj.mods().get(SelectedIndex).ClientOnly());

		CP.add(tglbtnClinetOnly, "3, 7");

		CP.add(l5, "1, 9, fill, fill");
		tbFileSize.setText(obj.mods().get(SelectedIndex).FileSize() + "");
		CP.add(tbFileSize, "3, 9, fill, fill");

		frame.setContentPane(CP);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = tbName.getText();
				String link = tbLink.getText();
				String id = tbID.getText();
				String ClientOnly = tglbtnClinetOnly.isSelected() + "";
				String FileSize = tbFileSize.getText();

				String Mods = "{\"name\":\""+ name 
						+"\",\"link\":\""+ link 
						+ "\",\"id\":" + id 
						+",\"ClientOnly\":"+ ClientOnly 
						+ ",\"FileSize\":\"" + FileSize 
						+ "\"}";
						
				Gson gson = new Gson();
					
				mods obj2 = gson.fromJson(Mods, mods.class);
			
				obj.mods().set(SelectedIndex, obj2);
				
				System.out.println(obj.toString());
				
				frame.dispose();

			}
		});
		CP.add(btnSave, "1, 11, fill, fill");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});

		CP.add(btnCancel, "3, 11, fill, fill");
		frame.pack();
	}
}