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

public class FileNumberStream {

	public boolean printNumbersToFile(List<Integer> nums, File f) {
		boolean flag = false;
		try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)))) {
			for (int i : nums) {
				pw.println(i);
				flag = true;
			}
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
		return flag;
	}

	public ArrayList<Integer> readNumbersFromFile(File f) {
		StringBuffer sb = new StringBuffer();
		String s = null;
		try (BufferedReader br = new BufferedReader(new FileReader(f))) {
			while ((s = br.readLine()) != null) {
				sb.append(s);
				sb.append(" ");
			}
		} catch (IOException ioe) {
			System.err.println(ioe);
		}
		return getIntegerList(sb);
	}
	
	private ArrayList<Integer> getIntegerList(StringBuffer sb) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		String[] numsStr = sb.toString().split(" ");
		for (String s1 : numsStr)
			nums.add(Integer.parseInt(s1));
		return nums;
	}

}
