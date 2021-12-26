import javax.swing.*;
import java.io.File;
import java.util.Scanner;

/****************************************************/
/* Adapted from CS 01B - Intermediate Software Design in Java
/* By Soumil Gupta
/****************************************************/

public class DirectoryCounter {
  public static long num_dir = 0;				// the number of sub-directories
	public static long num_file= 0; 			// the number of files

	public static void run() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a directory (Either 'dir1' or 'dir2'): ");
		String string = scanner.next();

		java.io.File inputDir = new File(string);
		num_file = getFilecount(inputDir);
		num_dir = getDirectorycount(inputDir);

		System.out.println(num_dir + " directories");
		System.out.println(num_file + " files");
	}
	public static long getFilecount(File dir){
		int filecount=0;
		try {
			if (dir.isDirectory()) {
				File[] files = dir.listFiles();
				for (int i = 0; i < files.length; i++) {
					if (files[i].isFile()) {
						filecount++;
					} else {
						filecount += getFilecount(files[i]);
					}
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("File not found " + dir );
			e.printStackTrace();
		}
		return filecount;
	}

	public static long getDirectorycount(File dir){
		int subdircount=0;
		if (dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					subdircount++;
          subdircount += getDirectorycount(files[i]);
				}
			}
		}
		return subdircount;
	}
}