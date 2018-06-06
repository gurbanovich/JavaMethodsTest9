package testC.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileWordFinder {

	public boolean printTextToFile(String str, File f) {
		boolean flag = false;
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)))) {
			pw.println(str);
			flag = true;
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
		return flag;
	}

	public ArrayList<String> readTextFromFile(File f) {
		ArrayList<String> lines = new ArrayList<String>();
		String s = null;
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			while ((s = br.readLine()) != null)
				lines.add(s);
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
		return lines;
	}

	public String findWord(ArrayList<String> str, String w) {
		String res = null;
		for (String s : str) {
			String[] words = s.split(" ");
			for (String word : words) {
				if (word.equals(w)) {
					res = word;
					break;
				}
			}
		}
		return res;
	}

}
