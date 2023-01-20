package fileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JOptionPane;

public class fileDemo {

	public static void main(String[] args) {
		String filename = JOptionPane.showInputDialog("Enter filename: ");
		filename = "/home/a3_devesh/"+filename;
		File f = new File(filename);
		try {
			f.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println("file exist: "+f.exists());
		System.out.println("file is readable: "+f.canRead());
		System.out.println("file is writable: "+f.canWrite());
		System.out.println("Is a directory: "+f.isDirectory());
		System.out.println("Length of file: "+f.length()+"bytes");
		try
		{
			char ch;
			StringBuffer buff = new StringBuffer("");
			FileInputStream fis = new FileInputStream(filename);
			while(fis.available()!=0)
			{
				ch = (char) fis.read();
				buff.append(ch);
			}
			System.out.println("\nContents of file are: ");
			System.out.println(buff);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Cannot find specified file...");
		}
		catch(IOException i)
		{
			System.out.println("Cannot read file....");
		}

	}

}
