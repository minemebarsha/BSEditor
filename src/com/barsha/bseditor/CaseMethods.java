package com.barsha.bseditor;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaseMethods {

	public static Scanner scanner = new Scanner(System.in);
	public static ArrayList<File> arrayList = new ArrayList<File>();

	public static void createNewFile(String path) {

		while (true) {

			System.out.println("enter file name");
			String file_name = scanner.next();
			File file = new File(path + file_name);
			
			Pattern pattern = Pattern.compile("\\.([^.]*)$");
			Matcher matcher = pattern.matcher(file_name);

			if (file_name.contains(" ")) {
				System.out.println("space isn't allowed");
			} else if (file.exists()) {
				System.out.println("file name already exist");
			} 
				else if(!matcher.find()){
				System.out.println("please give the extension");
			}
			else {
				Functions.writeFile(file);
				break;
			}

		}

	}

	public static void openFile(String path) {

		if (Functions.fileList(path)) {

			File file = new File(path);
			File[] files = file.listFiles();

			for (File file2 : files) {
				arrayList.add(file2);
			}

			System.out.println("enter file no.");
			int index = scanner.nextInt();
			File file_name = new File(arrayList.get(index - 1).toString());
			Functions.readFile(file_name);

		} else {

			System.out.println("there is no file" + "\n"
					+ "can't you follow menu :-| :-|");

		}

	}

	public static void copyFile(String path) {

		if (Functions.fileList(path)) {

			File file = new File(path);
			File[] files = file.listFiles();

			for (File file2 : files) {
				arrayList.add(file2);
			}

			while (true) {
				System.out.println("enter source file's no.");
				int index = scanner.nextInt();
				File file_name = new File(arrayList.get(index - 1).toString());

				if (file_name.exists()) {

					System.out.println("enter destination file's no.");
					int index1 = scanner.nextInt();
					File file_name1 = new File(arrayList.get(index1 - 1)
							.toString());

					Functions.copyText(file_name, file_name1);
					break;

				} else {

					System.out.println("this file doesn't exist");

				}
			}

		} else {

			System.out.println("there is no file" + "\n"
					+ "can't you follow menu :-| :-|");
		}

	}

	public static void editFile(String path) {

		if (Functions.fileList(path)) {

			File file = new File(path);
			File[] files = file.listFiles();

			for (File file2 : files) {
				arrayList.add(file2);
			}

			System.out.println("enter file no.");
			int index = scanner.nextInt();
			File file_name = new File(arrayList.get(index - 1).toString());

			System.out.println("contents of " + "file no. " + index + ":");
			Functions.readFile(file_name);
			Functions.writeFile(file_name);
			System.out.println("file is successfully edited");

		} else {

			System.out.println("there is no file" + "\n"
					+ "can't you follow menu :-| :-|");
		}

	}

	public static void renameFile(String path) {

		if (Functions.fileList(path)) {

			File file = new File(path);
			File[] files = file.listFiles();

			for (File file2 : files) {
				arrayList.add(file2);
			}

			System.out.println("enter file no. you want to rename");
			int index = scanner.nextInt();
			File file_name = new File(arrayList.get(index - 1).toString());

			while (true) {

				System.out.println("enter file's new name");
				String file_name1 = scanner.next();

				if (!new File(file_name1).exists()) {
					file_name.renameTo(new File(path + file_name1));
					System.out.println("file is renamed");
					break;
				}

				System.out.println("file name already exist");
			}

		} else {

			System.out.println("there is no file" + "\n"
					+ "can't you follow menu :-| :-|");
		}

	}

	public static void deleteFile(String path) {

		if (Functions.fileList(path)) {

			File file = new File(path);
			File[] files = file.listFiles();

			for (File file2 : files) {
				arrayList.add(file2);
			}

			System.out.println("enter file no.");
			int index1 = scanner.nextInt();
			File file_name = new File(arrayList.get(index1 - 1).toString());

			file_name.delete();
			System.out.println("file is deleted");
			System.out.println("why did you delete the file :@ :@ :@ :@");

		} else {

			System.out.println("there is no file" + "\n"
					+ "can't you follow menu :-| :-|");

		}

	}

}
