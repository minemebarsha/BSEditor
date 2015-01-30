package com.barsha.bseditor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Functions {

	public static void writeFile(File file) {

		Scanner scanner = new Scanner(System.in);

		try(			FileWriter writer = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);) {

			StringBuffer stringBuffer = new StringBuffer();
			String texts = null;

			System.out.println("write texts(to exit 'BS Editor' enter 'exit')");

			while (true) {

				texts = scanner.nextLine();
				if (texts.equals("exit")) {
					break;
				}
				stringBuffer.append(texts + "\n");
			}

			System.out.println("file is saved :) :)");
			bufferedWriter.write(stringBuffer.toString());

		} catch (IOException e) {
			System.out.println("error....try again...");
		}
	}

	public static void readFile(File file) {

		try(FileReader reader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(reader);) {
			
			String string = null;

			while ((string = bufferedReader.readLine()) != null) {

				System.out.println(string);

			}

		} catch (FileNotFoundException e) {
			System.out.println("error....try again...");
		} catch (IOException e) {
			System.out.println("error....try again...");
		}

	}

	public static void copyText(File src, File dst) {

		try (FileInputStream in = new FileInputStream(src);
			FileOutputStream out = new FileOutputStream(dst);){			

			int c;
			
			while ((c = in.read()) != -1) {
				out.write(c);
			}
			System.out.println("texts are copied");

		} catch (FileNotFoundException e) {
			System.out.println("error....try again..");

		} catch (IOException e) {
			System.out.println("error....try again...");
		}

	}

	public static boolean isAnyFileExist(String path) {

		File file = new File(path);

		String[] files = file.list();
		boolean b=false;
		int counter = 0;

		for (String string : files) {

			File file2 = new File(path+string);
			if (file2.isFile()) {
				counter=1;
				return true;
				
			}

		}
		return b;

	}
	
	public static boolean isFileExist(String path,String file_name) {

		File file = new File(path);

		String[] files = file.list();
		boolean b=false;
		int counter = 0;

		for (String string : files) {

			File file2 = new File(path+string);
			if (file2.isFile()&&string.equals(file_name)) {
				counter=1;
				return true;
				
			}

		}
		return b;

	}

	public static boolean fileList(String path) {

		File file = new File(path);
		boolean b = false;
		int i = 1;

		String[] files = file.list();

		for (String string : files) {

			File file2 = new File(path+string);
			if (file2.isFile()) {
				if (i == 1) {
					System.out.println("list of files:");
				}
				System.out.println(i + ") " + string);
				b = true;
				i++;
			}

		}
		return b;

	}
	

	public static void printCommand(int i) {
		if (i == 0) {
			System.out.println("menu:");
			System.out.println("enter 1 to select location");
			System.out.println("enter 2 to see the list of file");
			System.out.println("enter 3 to create a file");
			System.out.println("enter 0 for exit"+"\n");
		} else {
			i = 1;
			System.out.println("menu:");
			System.out.println("enter 1 to select location");
			System.out.println("enter 2 to see the list of file");
			System.out.println("enter 3 to create a file");
			System.out.println("enter 4 to open a file");
			System.out.println("enter 5 to copy a file");
			System.out.println("enter 6 to edit a file");
			System.out.println("enter 7 to rename a file");
			System.out.println("enter 8 to delete a file");
			System.out.println("enter 0 for exit"+"\n");
		}
	}

}
