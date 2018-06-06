package testB.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import testB.aircraft.Aircraft;

public class SerializatorAircraft {
	/**
	 * The task: complete the tasks from option B of Task. 4, saving application
	 * objects in one or more files using the serialization mechanism. Objects
	 * can contain fields marked as static, as well as transient. For change
	 * information and extraction of information in the file, create a special
	 * class-connector with the methods necessary to perform these tasks.
	 * 
	 * @param a
	 * @param filename
	 * @return
	 */

	public boolean serialization(Aircraft a, String filename) {
		boolean flag = false;
		File f = new File(filename);
		ObjectOutputStream os = null;
		try {
			FileOutputStream fos = new FileOutputStream(f);
			if (fos != null) {
				os = new ObjectOutputStream(fos);
				os.writeObject(a);
				flag = true;
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		} catch (NotSerializableException se) {
			System.err.println("Class not serializable");
		} catch (IOException ioe) {
			System.err.println(ioe);
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (IOException e) {
				System.err.println(e);
			}
		}
		return flag;
	}

	public Aircraft deserializable(String filename) throws InvalidObjectException {
		File f = new File(filename);
		ObjectInputStream is = null;
		try {
			FileInputStream fis = new FileInputStream(f);
			is = new ObjectInputStream(fis);
			Aircraft a = (Aircraft) is.readObject();
			return a;
		} catch (ClassNotFoundException ce) {
			System.err.println("Class not found");
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
		} catch (InvalidClassException ie) {
			System.err.println("Class not match");
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				System.err.println(e);
			}
		}
		throw new InvalidObjectException("Object not matcn");
	}

}
