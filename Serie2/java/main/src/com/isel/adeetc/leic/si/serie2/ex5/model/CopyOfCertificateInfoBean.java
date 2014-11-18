package com.isel.adeetc.leic.si.serie2.ex5.model;

import java.io.Serializable;

public class CopyOfCertificateInfoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String commonNames; // CN
	public String organizationUnit; // OU
	public String organizationName; // O
	public String localityName; // L
	public String stateName; // ST
	public String country; // C
	public String email; // E
	
	// All above in the format CN=www.mbnet.pt,OU=Certificado para Servidor WEB,O=SIBS FORWARD PAYMENT SOLUTIONS\, S.A.,L=Lisboa,C=PT
	public String subject;

	
//	public String commonNames; // CN
//	public String organizationUnit; // OU
//	public String organizationName; // O
//	public String localityName; // L
//	public String stateName; // ST
//	public String country; // C
//	public String email; // E
	
	// All above int the format CN=MULTICERT - Entidade de Certificação 001,OU=Entidade de Certificação Credenciada,O=MULTICERT - Serviços de Certificação Electrónica S.A.,C=PT
	public String issuer;
	
	
	public String serialNumber;
	public String validFrom;
	public String validUntil;
	
	
	public String algorithm;
	public String keySize;
	public String format;
	public String encoded;
	
	// All above in the format ex: RSA 2048 bits
	public String publicKey; 
	
	public String signatureAlgorithm;
	public String fingerPrintSHA_1;
	public String version;

	
//	public String alternativeNames;
//	public String prefix; //??
//	public String extendedValidation; //?
//	public String revocationInformation;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb
			.append("Version:\t").append(version).append("\n")
			.append("Subject:\t").append(subject).append("\n")
			.append("Issuer:\t").append(issuer).append("\n")
			.append("Serial number:\t").append(serialNumber).append("\n")
			.append("Valid From:\t").append(validFrom).append("\n")
			.append("Valid Until:\t").append(validUntil).append("\n")
			.append("Public Key:\t").append(publicKey).append("\n")
			.append("Signature Algorithm:\t").append(signatureAlgorithm).append("\n")
			.append("FingerPrint:\t").append(encoded).append("\n");
		
		return sb.toString();
	}
}
