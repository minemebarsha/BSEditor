package com.barsha.bseditor;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("**all files will save in default location");
		System.out.println("**if you want to change your location,");
		System.out.println("  please enter the real path of location");
		System.out.println("\t"+"-> for example,D:" + "\\" + "imp" + "\\"+"files"+"\\");
		
		String path = "data" + File.separator ;
		File path_file = new File("data");

		if (!path_file.isDirectory()) {
			path_file.mkdir();
		}

		Scanner scanner = new Scanner(System.in);

		while (true) {

			if (!Functions.isAnyFileExist(path)) {
				Functions.printCommand(0);
			} else {
				Functions.printCommand(1);
			}

			try {

				System.out.println("enter choice");
				int i = scanner.nextInt();

				switch (i) {

				case 0:

					System.out.println("have a good day....by by");
					return;

				case 1:

					System.out
							.println("you must give the real path of location");
					path = scanner.next();

					break;

				case 2:

					if (Functions.fileList(path)) {
						break;
					}

					System.out.println("there is no file");
					break;

				case 3:

					CaseMethods.createNewFile(path);
					break;

				case 4:

					CaseMethods.openFile(path);
					break;

				case 5:

					CaseMethods.copyFile(path);
					break;

				case 6:

					CaseMethods.editFile(path);
					break;

				case 7:

					CaseMethods.renameFile(path);
					break;

				case 8:

					CaseMethods.deleteFile(path);
					break;

				default:
					System.out.println("can't you follow menu :-| :-|");
					break;

				}

			} catch (Exception e) {

				System.out
						.println("only number is allowed/may some error has occured");
				break;

			}

		}
	}
}
