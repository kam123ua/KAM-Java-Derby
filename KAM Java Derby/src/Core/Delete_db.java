package Core;

import java.io.File;
import java.io.FileNotFoundException;

public class Delete_db {
	public static void delete_basa(File file) {
		
	    if(!file.exists())
	      return;
	    if(file.isDirectory()){
	      for(File f : file.listFiles()){
	    	  delete_basa(f);
	      }
	    	  
	      file.delete();
	    }
	    else {
	      file.delete();
	    }
	}
	
	public static void delete(String nameFile) throws FileNotFoundException {
	    Metod.exists(nameFile);
	    new File(nameFile).delete();
	}
	
	public static void Funk() {
		try {
			String[] items=Core.Metod.Read("del.txt").trim().split("\n");
			delete_basa(new File("database\\"+items[0]));
			delete("del.txt");
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

