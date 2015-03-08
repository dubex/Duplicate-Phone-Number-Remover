package com.netcracker.assignment;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Prakash Kumar Dubey This class perform various operation on
 *         {@link MobileNumber}
 * 
 *
 */
public class MobileNumberOperation {
	HashSet<MobileNumber> hs;
	FileReader fr;
	BufferedReader br;
	FileWriter fw;
	BufferedWriter bw;
	ArrayList<File> files;

	// File outputFile;

	public MobileNumberOperation() {
		super();
		this.hs = new HashSet<MobileNumber>();
		this.files = new ArrayList<File>();
	}

	/**
	 * Method insert 2 files (mobile1.txt and mobile2.txt) and display.txt into
	 * ArrayList.
	 */
	public void getFiles() {
		files.add(new File(
				"D:\\workspaces\\workspace_Learning\\JavaTrainingAssignment\\mobile1.txt"));
		files.add(new File(
				"D:\\workspaces\\workspace_Learning\\JavaTrainingAssignment\\mobile2.txt"));
		files.add(new File(
				"D:\\workspaces\\workspace_Learning\\JavaTrainingAssignment\\display.txt"));
	}

	/**
	 * @throws IOException
	 *             It will copy all the phone number from text files
	 *             (mobile1.txt and mobile2.txt) and put in the {@link HashSet}.
	 *             So it automatically removes duplicate number regardless of
	 *             number starting with "+91" or "0". It will consider same
	 *             number in the both case
	 */
	public void giveFileContentInHashSet() throws IOException {
		for (File file : files) {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String number = br.readLine();

			while (number != null) {
				try {
					validatePhoneNumber(number);
					hs.add(new MobileNumber(number));
				} catch (InAppropriateNumberException e) {
					System.out.println(e);
				}
				number = br.readLine();
			}
		}
		br.close();
		fr.close();
	}

	/**
	 * @throws IOException
	 *             It will copy all the Phone Numbers to the display.txt file
	 */
	public void printContentOfHashSetInFile() throws IOException {
		fw = new FileWriter(files.get(2));
		bw = new BufferedWriter(fw);
		for (MobileNumber mobNum : hs) {
			bw.write(mobNum.getMobileNumber());
			bw.newLine();
		}
		bw.close();
		fw.close();
	}

	public void printContentOfHashSet() {
		System.out.println(hs);
	}

	/**
	 * It validate the Phone is correct or not.
	 * 
	 * @param mobileNumber
	 * @throws InAppropriateNumberException
	 */
	public void validatePhoneNumber(String mobileNumber)
			throws InAppropriateNumberException {
		if (mobileNumber.length() > 13 || mobileNumber.length() < 9)
			throw new InAppropriateNumberException(
					"Then Phone Number is not valid. Ihe Phone number length is: "
							+ mobileNumber.length());

	}

}
