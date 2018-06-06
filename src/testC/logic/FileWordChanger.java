package testC.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileWordChanger {

	public boolean printTextToFile(List<String> str, File f) {
		boolean flag = false;
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)))) {
			for (String s : str) {
				pw.println(s);
				flag = true;
			}
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

	public ArrayList<String> changeWord(ArrayList<String> str, String w1, String w2) {
		for (int i = 0; i < str.size(); i++)
			str.set(i, str.get(i).replaceAll(w1, w2));
		return str;
	}

}
