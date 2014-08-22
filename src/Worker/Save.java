package Worker;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Json.InstallInfo;

public class Save {

	public static void SaveData(InstallInfo obj, String Config, String Version) throws FileNotFoundException{
		
		obj.Config = Config;
		String[] v = new String[3];
		int i = 0;
		for (String retval: Version.split("-", 3)){
	         v[i] = retval;
	         i ++;
	      }
	      
		
		
		int Major = Integer.parseInt(v[0]);
		int Minor = Integer.parseInt(v[1]);
		int Build = Integer.parseInt(v[2]);
		
		obj.version().get(0).major = Major;
		obj.version().get(0).minor = Minor;
		obj.version().get(0).build = Build;
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		 
		String json = gson.toJson(obj);
		
		PrintWriter out = new PrintWriter(obj.version().get(0).major() + "." + obj.version().get(0).minor() + "." + obj.version().get(0).build() + ".json");
		
		out.print(json);
		out.close();
		
	}
	
}
