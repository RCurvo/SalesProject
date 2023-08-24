package br.com.rcurvo.exceptions;

public class KeyTypeNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public KeyTypeNotFoundException(String msg) {
        this(msg, null);
    }

    public KeyTypeNotFoundException(String msg, Throwable e) {
        super(msg, e);
    }
}
