package testA.run;

import java.io.FileNotFoundException;
import java.io.FileReader;

import testA.logic.StringModefier;

public class RunStringModefier {
	/**
	 * Demo class StringModefier
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		try {
			StringModefier sm = new StringModefier(new FileReader(args[0]));

			// Showing all text from file
			sm.showText();
			System.out.println();

			// Showing text after finding and deleting the specified substring in each
			// line
			System.out.println("Showing after text finding and deleting the specified substring in each line");
			sm.deleteSubstring(args[1]);
			sm.showText();
			System.out.println();

			// Showing finding and outputting words of text for which the last
			// letter of one word
			// coincides with the first letter of the next word.
			System.out.println("Words with the same last and first letter from text");
			sm.findEqualFirstAndLastLetter();

		} catch (FileNotFoundException e) {
			System.err.println("File not found, enter another path!");
		}

	}

}
