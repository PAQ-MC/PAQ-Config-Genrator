package Worker;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;

import GUI.PAQConfigGenrator;
import Json.GetInstallInfo;
import Json.InstallInfo;
import Json.mods;

public class FileGrab {

	public static InstallInfo obj;
	
	public static void setup(InstallInfo obj_) throws Exception {
		JFrame frame = PAQConfigGenrator.getFrame();
		
		obj = obj_;
		
		PAQConfigGenrator.tbConfig.setText(obj.Config());
		PAQConfigGenrator.tbForge.setText(obj.forge().get(0).id()); //TODO work out better way of showing / eding this
		PAQConfigGenrator.tbVersion.setText(obj.version().toString());
		
		PAQConfigGenrator.cbMods.setModel(new DefaultComboBoxModel(mods()));
		
	}
	
	public static String[] mods(){
		String[] mods = new String[obj.mods().size()];
		
		for(int i = 0; i <= obj.mods().size() - 1; i++){
			mods[i] = obj.mods().get(i).name();
		}
		return mods;
	}
}
