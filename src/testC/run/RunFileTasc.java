package testC.run;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import testC.logic.FileNumberStream;
import testC.logic.FileWordChanger;
import testC.logic.FileWordFinder;

public class RunFileTasc {
	/**
	 * The task: When you run the following tasks to output the results, create
	 * a new directory and file using the File class.
	 * 
	 * 1. Create and fill the file with random integers. Sort by the contents of
	 * the file in ascending order. (Realized in class in the FileNumberStream)
	 * 
	 * 2. Read the text of the Java program and replace all public words in the
	 * attribute declaration and class methods with private. (Realized in class
	 * the FileWordChanger)
	 * 
	 * 12. Enter a sequence of lines from the text file. Select individual words
	 * separated by spaces. Write a method for finding words by pattern. Output
	 * the found word to another file.
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		File f1 = new File("examplesVarC\\integer.txt");
		File f2 = new File("src\\testB\\aircraft\\Aircraft.java");
		File f3 = new File("examplesVarC\\Aircraft.java");
		File f4 = new File("examplesVarC\\Example.txt");
		File f5 = new File("examplesVarC\\Finder woed.txt");

		FileNumberStream fn = new FileNumberStream();
		FileWordChanger fwc = new FileWordChanger();
		FileWordFinder fwf = new FileWordFinder();

		boolean b = false;
		String word1 = "public", word2 = "private";

		// Showing task 1
		System.out.println("Creating file with random number and sorting it: ");
		Random r = new Random();
		ArrayList<Integer> num = new ArrayList<Integer>();

		System.out.println("Getting numbers: ");
		for (int i = 0; i < 10; i++) {
			num.add(r.nextInt(100));
			System.out.println(num.get(i));
		}

		b = fn.printNumbersToFile(num, f1);
		System.out.println("Creating file finishing = " + b);
		num = fn.readNumbersFromFile(f1);
		Collections.sort(num);
		System.out.println("Sorting numbers: ");
		for (int i : num)
			System.out.println(i);
		b = fn.printNumbersToFile(num, f1);
		System.out.println("Sorting numbers rewrite to file file finishing = " + b);

		// Showing task 2
		System.out.println();
		System.out.println("Reading java-file and changing access of fields and methods: ");
		System.out.println("Getting code is finished!");

		ArrayList<String> code = fwc.readTextFromFile(f2);

		ArrayList<String> code2 = fwc.changeWord(code, word1, word2);
		b = fwc.printTextToFile(code2, f3);
		System.out.println("Creating file finishing and changing code is wrtten = " + b);

		// Showing task 3
		System.out.println();
		System.out.println("Reading file and finding word by pattern: ");
		System.out.println("Getting code is finished!");
		ArrayList<String> text = fwf.readTextFromFile(f4);
		String findWord = fwf.findWord(text, "Java");
		System.out.println("Findin word is: " + findWord);
		b = fwf.printTextToFile(findWord, f5);
		System.out.println("Finding word is written = " + b);
	}

}
