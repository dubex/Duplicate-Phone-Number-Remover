package com.netcracker.assignment;

/**
 * @author Prakash Kumar Dubey 
 * This class represent Phone Number
 *
 */
public class MobileNumber {
	String mobileNumber;

	public MobileNumber(String mobileNumber)
			throws InAppropriateNumberException {
		super();
		this.mobileNumber = mobileNumber;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "Mobile Number{" + mobileNumber + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof MobileNumber))
			return false;

		MobileNumber mobNum = (MobileNumber) o;
		if (this.getMobileNumWithoutCountryCode() == mobNum
				.getMobileNumWithoutCountryCode())
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		return getMobileNumWithoutCountryCode().hashCode();
	}

	/**
	 * It removes the suffix "0" or "+91" from mobile number and return original
	 * content
	 * 
	 * @return String
	 */
	public String getMobileNumWithoutCountryCode() {
		return this.mobileNumber.startsWith("+") ? this.mobileNumber
				.substring(3)
				: (this.mobileNumber.startsWith("0") ? this.mobileNumber
						: this.mobileNumber.substring(1));
	}

}
