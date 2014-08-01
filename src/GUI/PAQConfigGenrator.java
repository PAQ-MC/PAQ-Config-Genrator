package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Json.InstallInfo;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class PAQConfigGenrator {

	private JFrame frame;

	/**
	 * Launch the application.
	 * @throws Exception 
	 */
	
	private static InstallInfo obj;
	private JLabel lblNewLabel_1;
	private JTextField txtConfig;
	private JLabel lblMajor;
	private JLabel lblBuild;
	private JSpinner spBuild;
	
	public static void main(String[] args) throws Exception {
		
		obj = Json.GetInstallInfo.JsonInfo();
		Json.WriteInstallInfo.Write(obj);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PAQConfigGenrator window = new PAQConfigGenrator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PAQConfigGenrator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Version:");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Config: ");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		txtConfig = new JTextField();
		txtConfig.setText(obj.Config());
		txtConfig.setBounds(61, 36, 363, 20);
		frame.getContentPane().add(txtConfig);
		txtConfig.setColumns(10);
		
		lblMajor = new JLabel("Major:");
		lblMajor.setBounds(76, 11, 36, 14);
		frame.getContentPane().add(lblMajor);
		
		JSpinner spMajor = new JSpinner();
		spMajor.setModel(new SpinnerNumberModel(new Integer(obj.version().get(0).major()), null, null, new Integer(1)));
		spMajor.setBounds(115, 8, 36, 20);
		frame.getContentPane().add(spMajor);
		
		JLabel lblNewLabel_2 = new JLabel("Minor:");
		lblNewLabel_2.setBounds(157, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JSpinner spMinor = new JSpinner();
		spMinor.setModel(new SpinnerNumberModel(new Integer(obj.version().get(0).minor()), null, null, new Integer(1)));
		spMinor.setBounds(197, 8, 36, 20);
		frame.getContentPane().add(spMinor);
		
		lblBuild = new JLabel("Build:");
		lblBuild.setBounds(243, 11, 46, 14);
		frame.getContentPane().add(lblBuild);
		
		spBuild = new JSpinner();
		spBuild.setModel(new SpinnerNumberModel(new Integer(obj.version().get(0).build()), null, null, new Integer(1)));
		spBuild.setBounds(284, 8, 36, 20);
		frame.getContentPane().add(spBuild);
	}
}
