package com.isel.adeetc.leic.si.serie1.ex7.model;

public class UnsupportedAlgorithmException extends RuntimeException {
	private static final long serialVersionUID = -3744548326322250940L;
	private static final String template = "The algorithm: %s, is not supported!";
	
	public UnsupportedAlgorithmException(String algorithm){
		super(String.format(template, algorithm));
	}

}
