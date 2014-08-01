package Json;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

public class WriteInstallInfo {
	public static void Wirte(InstallInfo obj) throws IOException{
		String version;
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		String json = gson.toJson(obj);
		 
		try {
			//write converted json data to a file named "file.json"
			FileWriter writer = new FileWriter("file.json");
			writer.write(json);
			writer.close();
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
