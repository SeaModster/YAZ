package yaz.game.handling;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

import yaz.game.main.yaz;

public class SaveGameFactory {
	
	/*
	 * Save File Handlers Begin
	 * 
	 */
	File LastCreatedSaveFile;
	
	public void SaveLastCreatedSaveFile() throws InvalidFileFormatException, IOException {
		if(LastCreatedSaveFile != null){
			getYAZconfg().put("HANDLES", "LastEditedSaveFile", LastCreatedSaveFile.getName());
			getYAZconfg().store();
		}else{
			ConsolePrinter.PrintConsole(3, "Cannot save last saved file.");
		}
	}

	public void LoadLastCreatedSaveFile() throws InvalidFileFormatException, IOException {
		String LoadedString = getYAZconfg().get("HANDLES", "LastEditedSaveFile", String.class);
		if(LoadedString != null){
			File f = new File(".\\yaz\\datastorage\\saves\\" + LoadedString + ".ini");
			LastCreatedSaveFile = f;
		}else{
			ConsolePrinter.PrintConsole(3, "Cannot load last saved file.");
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
			LastCreatedSaveFile = f;
        	ConsolePrinter.PrintConsole(0, ini.getFile().getName() + " created.");
		}else{
			ConsolePrinter.PrintConsole(3, "Error in file creation!");
		}
	}
	
	public void CreateSaveFile(String FileName) throws IOException {
		File f = new File(".\\yaz\\datastorage\\saves\\" + FileName.toLowerCase() + ".ini");
		BufferedWriter out = new BufferedWriter(new FileWriter(f));
		for (int i = 0; i < 1; i++) {
			out.write("{FILE-GENERATOR-MARKER}");
        }
        out.close();
        Wini ini = new Wini(f);
		if(!ini.isEmpty() && ini != null) {
			LastCreatedSaveFile = f;
        	ConsolePrinter.PrintConsole(0, ini.getFile().getName() + " created.");
		}else{
			ConsolePrinter.PrintConsole(3, "Error in file creation!");
		}
	}
	
	public void RenameSaveFile(String OldFileName, String NewFileName) throws InvalidFileFormatException, IOException {
		File f = new File(".\\yaz\\datastorage\\saves\\" + OldFileName.toLowerCase() + ".ini");
		File nf = new File(".\\yaz\\datastorage\\saves\\" + NewFileName.toLowerCase() + ".ini");
		f.renameTo(nf);
		LastCreatedSaveFile = nf;
	}
	
	public Wini GetSaveFile(String FileName) throws InvalidFileFormatException, IOException {
		File f = new File(".\\yaz\\datastorage\\saves\\" + FileName.toLowerCase() + ".ini");
		Wini ini = new Wini(f);
		return ini;
	}
	
	public Wini GetLastCreatedINI() throws InvalidFileFormatException, IOException {
		Wini ini = new Wini(LastCreatedSaveFile);
		return ini;
	}
	
	public File GetLastCreatedFile() throws InvalidFileFormatException, IOException {
		return LastCreatedSaveFile;
	}
	
	public boolean CheckSaveFileExistance(String Filename) {
		File f = new File(".\\yaz\\datastorage\\saves\\" + Filename.toLowerCase() + ".ini");
		if(f.exists())
			return true;
		else
			return false;
	}
	
	// And to think I was going to use a recursive loop... so stupid of me.
	private int GetNextSaveFile() {
		File SavesFolder = new File(".\\yaz\\datastorage\\saves\\");
		File[] ArrayOfSavedFiles = SavesFolder.listFiles();
		if(ArrayOfSavedFiles.length == 0) {
			return 1;
		} else {
			return ArrayOfSavedFiles.length + 1;
		}
	}
	
	/*
	 * Save File Handlers End
	 * 
	 */
	
	public static int buildnumber;
	
	public void CreateINI(String filename) throws IOException {
		File f = new File(".\\yaz\\datastorage\\" + filename + ".ini");
        Wini ini = new Wini(f);
        if(f.exists() && ini.isEmpty()){
        	// Core Processes
        	ini.put("CORE", "build", 1);
	        ini.put("CORE", "yazzer_coins", 0);
	        ini.put("CORE", "Sound", false);
	        // For Options
	        ini.put("OPTIONS", "DebugMode", yaz.DebugMode);
	        ini.put("OPTIONS", "DisplayChangelog", yaz.DisplayChangelog);
	        ini.store();
        }else{
        	ConsolePrinter.PrintConsole(0, "Can't create " + ini.getFile().getName() + "; file already exists.");
        }
	}
	
	public Wini getYAZconfg() throws InvalidFileFormatException, IOException {
		File f = new File(".\\yaz\\datastorage\\YAZ.ini");
        Wini ini = new Wini(f);
        return ini;
	}
	
	public void IncrementBuildNumber() throws InvalidFileFormatException, IOException {
		File f = new File(".\\yaz\\datastorage\\YAZ.ini");
        Wini ini = new Wini(f);
        int b = ini.get("CORE", "build", int.class);
        ini.put("CORE", "build", b + 1);
        ini.store();
	}
	
	public static int GetBuildNumber() throws InvalidFileFormatException, IOException {
		File f = new File(".\\yaz\\datastorage\\YAZ.ini");
        Wini ini = new Wini(f);
        buildnumber = ini.get("CORE", "build", int.class);
        return buildnumber;
	}	
}