package yaz.game.handling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

public class SaveGameFactory {
	
	public void CreateINI(String filename) throws IOException {
        Wini ini = new Wini(new File(filename));
        if(ini.isEmpty()){
	        ini.put("CORE", "Unlocked_Characters", 1);
	        ini.put("CORE", "yazzer_coins", 0);
	        ini.put("CORE", "Debug_Mode", false);
	        ini.put("CORE", "Sound", false);
	        ini.store();
        }else{
        	ConsolePrinter.PrintConsole(0, "Can't create " + ini.getFile().getName() + "; file already exists.");
        }
	}
	
	public void CreateSaveFile() throws IOException {
		File f = new File(".\\yaz\\datastorage\\saves\\save_" + GetNextSaveFile() + ".ini");
		BufferedWriter out = new BufferedWriter(new FileWriter(f));
		for (int i = 0; i < 1; i++) {
			out.write("{FILE-GENERATOR-MARKER}");
        }
        out.close();
        Wini ini = new Wini(f);
		if(!ini.isEmpty() && ini != null) {
        	ConsolePrinter.PrintConsole(0, ini.getFile().getName() + " created.");
		}else{
			ConsolePrinter.PrintConsole(3, "Error in file creation!");
		}
	}
	
	// And to think I was going to use a loop... so stupid of me.
	private int GetNextSaveFile() {
		File SavesFolder = new File(".\\yaz\\datastorage\\saves\\");
		File[] ArrayOfSavedFiles = SavesFolder.listFiles();
		if(ArrayOfSavedFiles.length == 0) {
			return 1;
		} else {
			return ArrayOfSavedFiles.length + 1;
		}
	}
	

	public void SetValue(String key, String value, Object obj) throws InvalidFileFormatException, IOException {
		if(key != null && value != null) {
			Wini ini = new Wini(new File(".\\yaz\\datastorage\\saves\\save_" + GetNextSaveFile() + ".ini"));
			if(ini != null) {
				if(obj.equals(boolean.class)) {
					boolean bol = (boolean) obj;
					ini.put(key, value, bol);
					ini.store();
				}
				if(obj.equals(String.class)) {
					String str = (String) obj;
					ini.put(key, value, str);
					ini.store();
				}
				if(obj.equals(int.class)) {
					int integer = (int) obj;
					ini.put(key, value, integer);
					ini.store();
				}
				if(obj.equals(double.class)) {
					double dec = (double) obj;
					ini.put(key, value, dec);
					ini.store();
				}
	        }
		}
	}

	public void SetValue(String key, String value, Object obj, String FileName) throws InvalidFileFormatException, IOException {
		String str2 = ".\\yaz\\datastorage\\saves\\" + FileName.toLowerCase() + ".ini";
		if(key != null && value != null) {
	        Wini ini = new Wini(new File(str2));
	        if(ini != null) {
	        	if(obj.equals(boolean.class)) {
					boolean bol = (boolean) obj;
					ini.put(key, value, bol);
					ini.store();
				}
				if(obj.equals(String.class)) {
					String str = (String) obj;
					ini.put(key, value, str);
					ini.store();
				}
				if(obj.equals(int.class)) {
					int integer = (int) obj;
					ini.put(key, value, integer);
					ini.store();
				}
				if(obj.equals(double.class)) {
					double dec = (double) obj;
					ini.put(key, value, dec);
					ini.store();
				}
	        }
		}
	}
	
	public void SetValue(String key, String value, Object obj, Wini ini_File) throws InvalidFileFormatException, IOException {
		String str2 = ini_File.getFile().getName().toLowerCase();
		if(key != null && value != null) {
	        Wini ini = new Wini(new File(str2));
	        if(ini != null) {
	        	if(obj.equals(boolean.class)) {
					boolean bol = (boolean) obj;
					ini.put(key, value, bol);
					ini.store();
				}
				if(obj.equals(String.class)) {
					String str = (String) obj;
					ini.put(key, value, str);
					ini.store();
				}
				if(obj.equals(int.class)) {
					int integer = (int) obj;
					ini.put(key, value, integer);
					ini.store();
				}
				if(obj.equals(double.class)) {
					double dec = (double) obj;
					ini.put(key, value, dec);
					ini.store();
				}
	        }
		}
	}
	
}
