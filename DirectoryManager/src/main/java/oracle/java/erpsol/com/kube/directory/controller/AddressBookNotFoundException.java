package oracle.java.erpsol.com.kube.directory.controller;

@SuppressWarnings("serial")
public class AddressBookNotFoundException extends RuntimeException {

	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;

	public AddressBookNotFoundException(String exception) {
		super(exception);
	}
}
