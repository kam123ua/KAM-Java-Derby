package Core;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

public class Metod {
	
	public static void Wait(){
		File file=new File("wait.jar");
		try {
		Desktop.getDesktop().open(file);
		} catch (IOException e1) {
		e1.printStackTrace();
		}
		try {
			   Thread.sleep(2000);
			} catch (InterruptedException e) {
			   e.printStackTrace();
			}
	}
	
	public static void ConnectToWeb(String str){
		try {
			Desktop.getDesktop().browse(new URI(str));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public static void Tabb(){
		Write("table.tab", " ");
		if(Member.kof!="0"){
			if ((new File("database\\"+Member.name+"\\tables.tab")).exists()) {
				try {
					Member.mas=Metod.Read("database\\"+Member.name+"\\tables.tab");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			} 
			else {
				Member.kof="0";
			}
		}
		new File("table.tab").delete();
	}
	
		
	public static void ToFile(){
		if(Member.kof=="0"){
			Metod.Write("database\\"+Member.name+"\\tables.tab", Member.str);
			Member.kof="1";
			Metod.Write("database\\"+Member.name+"\\kof.inf","1");
		}
		else if(Member.kof=="1"||Member.kof=="2"){
			try {
				Metod.Update("database\\"+Member.name+"\\tables.tab", Member.str);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void exists(String fileName) throws FileNotFoundException {
	    File file = new File(fileName);
	    if (!file.exists()){
	        throw new FileNotFoundException(file.getName());
	    }
	}
	
	public static void Write(String fileName, String text) {
	    File file = new File(fileName);
	 
	    try {
	        if(!file.exists()){
	            file.createNewFile();
	        }
	 
	        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
	 
	        try {
	            out.print(text);
	        } finally {
	            out.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	}
	
	public static String Read(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
	    StringBuilder sb = new StringBuilder();
	 
	    exists(fileName);
	 
	    try {
	        BufferedReader in = new BufferedReader(new FileReader( file.getAbsoluteFile()));
	        try {
	            String s;
	            while ((s = in.readLine()) != null) {
	                sb.append(s);
	                sb.append("\n");
	            }
	        } finally {
	            in.close();
	        }
	    } catch(IOException e) {
	        throw new RuntimeException(e);
	    }
	 
	    return sb.toString();
	}
	
	public static void Update(String nameFile, String newText) throws FileNotFoundException {
	    exists(nameFile);
	    StringBuilder sb = new StringBuilder();
	    String oldFile = Read(nameFile);
	    sb.append(oldFile);
	    sb.append(newText);
	    Write(nameFile, sb.toString());
	}
	
	public static void delete_basa(){
		Write("del.txt",Core.Member.name);
		File file=new File("restart.jar");
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		System.exit(0);
	}

	public static void delete_basa_Funk(){
		String fileName ="del.txt";
		if ((new File(fileName)).exists()) {
			JOptionPane.showMessageDialog(null, "OK");
		    Delete_db.Funk();
		}
		else{
		}
	}
	
	public static void del_tabl(String str){
		String res=Core.Member.mas.trim().replaceAll(str, "");
		
		new File("database\\"+Member.name+"\\"+str).delete();
		
		if(res==""){
			try {
				Delete_db.delete("database\\"+Member.name+"\\tables.tab");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		else{
			Metod.Write("database\\"+Member.name+"\\tables.tab", res);
		}
		
	}
	
}
