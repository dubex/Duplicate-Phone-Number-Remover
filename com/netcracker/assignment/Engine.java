package com.netcracker.assignment;

import java.io.IOException;

/**
 * @author Prakash Kumar Dubey The class Engine will instantiate and invoke
 *         methods of {@link MobileNumberOperation}. It is starting point of
 *         program. This Program consider {+919415289192, 09415289192, 9415289192} as a same Phone number.
 */
public class Engine {

	public static void main(String[] args) {
		MobileNumberOperation mno = new MobileNumberOperation();
		mno.getFiles();
		try {
			mno.giveFileContentInHashSet();
			mno.printContentOfHashSetInFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		mno.printContentOfHashSet();
	}

}
