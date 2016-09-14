package com.springer.challenge.commands;

public class InvalidParameter extends Exception {
	private static final long serialVersionUID = -8072425258607441266L;

	public InvalidParameter(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InvalidParameter(String arg0) {
		super(arg0);
	}

}
