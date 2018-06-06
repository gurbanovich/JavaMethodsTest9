package testA.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StringModefier {
	/**
	 * The task: The following tasks require you to enter a sequence of lines from a text
	 * stream and perform the specified actions. Two options can be considered:
	 * • each line consists of one word; 
	 * • each line consists of several words.
	 * The names of the input and output files, as well as the absolute path to
	 * them, can be be entered as command line parameters or stored in a file.
	 * 
	 * 1. In each line, find and delete the specified substring.
	 * 
	 * 4. Find and output words of text for which the last letter of one word
	 * coincides with the first letter of the next word.
	 */

	private ArrayList<String> lines;

	public StringModefier(FileReader fr) {
		this.lines = new ArrayList<String>();
		try (BufferedReader in = new BufferedReader(fr)) {
			String s = new String();
			while ((s = in.readLine()) != null)
				this.lines.add(s);
		} catch (IOException e) {
			System.err.println("I /O Exception!");
		}
	}

	public ArrayList<String> getLines() {
		return lines;
	}

	public void deleteSubstring(String sub) {
		String str = null;
		for (int i = 0; i < getLines().size(); i++) {
			str = getLines().get(i).replace(sub, "");
			getLines().set(i, str);
		}
	}

	public void findEqualFirstAndLastLetter() {
		StringBuffer sb = new StringBuffer();
		for (String s : getLines()) {
			sb.append(s);
			sb.append(System.lineSeparator());
		}
		String[] words = sb.toString().replace("  ", " ").split(" ");
		for (int i = 1; i < words.length - 1; i++) {
			if (i - 1 >= 0) {
				if (words[i - 1].charAt(words[i - 1].length() - 1) == words[i].charAt(0)) {
					System.out.println(words[i - 1] + " " + words[i]);
				}
			}
		}
	}

	public void showText() {
		for (String s : getLines())
			System.out.println(s);
		;
	}

}
