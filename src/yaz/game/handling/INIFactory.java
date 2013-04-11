package yaz.game.handling;

import java.io.File;
import java.io.IOException;

import org.ini4j.Wini;

public class INIFactory {
	
	public void CreateINI(String filename) throws IOException {
        Wini ini = new Wini(new File(filename));
        if(ini.isEmpty()){
	        ini.put("CORE", "Unlocked_Characters", 1);
	        ini.put("CORE", "yazzer_coins", 0);
	        ini.put("CORE", "Debug_Mode", false);
	        ini.put("CORE", "Sound", false);
	        ini.store();
        }else{
        	System.out.println("File: 'yaz/res/datastorage/YAZ.ini' already exists.");
        }
	}
	
}
