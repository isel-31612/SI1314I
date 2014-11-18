package com.isel.adeetc.leic.si.serie2.ex5.model;

import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class SslDump {

	private static final String X509_CERTIFICATE_TYPE = "X.509";
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss z");

	private static final String host = "www.mbnet.pt";
	private static final int port = 443;
	
	private SslDump() {

	}
	
	public static List<CertificateInfoBean> getCertificatesFromServer(String host, int port) throws Exception {

		if (host == null)
			host = SslDump.host;
		
		if (port == 0)
			port = SslDump.port;
		
		X509Certificate[] certs = connectToHost(host, port);

		List<CertificateInfoBean> certificateInfoBeans = new ArrayList<CertificateInfoBean>();

		if (certs == null) {
			return null;
		}


		try {

			for(X509Certificate cert : certs) {
				CertificateInfoBean certInfoBean = new CertificateInfoBean();
				
				Date currentDate = new Date();

				Date startDate = cert.getNotBefore();
				Date endDate = cert.getNotAfter();

				boolean notYetValid = currentDate.before(startDate);
				boolean noLongerValid = currentDate.after(endDate);

				certInfoBean.version = Integer.toString(cert.getVersion());

				certInfoBean.subject = cert.getSubjectX500Principal().getName();
				
				certInfoBean.issuer = cert.getIssuerDN().getName();

				certInfoBean.serialNumber = "0x" + new BigInteger(1, cert.getSerialNumber().toByteArray()).toString(16).toUpperCase(); 

				certInfoBean.validFrom = DATE_FORMAT.format(startDate);

				if (notYetValid) {
					certInfoBean.validFrom = "Not yet valid : " + certInfoBean.validFrom;
				}
				certInfoBean.validUntil = DATE_FORMAT.format(endDate); 

				if (noLongerValid) {
					certInfoBean.validUntil = "No longer valid : " + certInfoBean.validUntil;
				}

				PublicKey pubKey = cert.getPublicKey();
				
				certInfoBean.publicKey = pubKey.getAlgorithm();
				certInfoBean.signatureAlgorithm = cert.getSigAlgName();

				certificateInfoBeans.add(certInfoBean);

			}
		} catch (Exception ex) {
		}
		
		return certificateInfoBeans;
	}

	public static void dumpCertificatesFromServer(String host, int sslPort) throws Exception {
		List<CertificateInfoBean> certificateInfoBeans = getCertificatesFromServer(host, sslPort);
		
		for(CertificateInfoBean cert : certificateInfoBeans) {
			System.out.println(cert);
		}
		
	}
	
	private static X509Certificate[] connectToHost(String sslHost, int sslPort) 
			throws Exception{

		URL url = new URL(MessageFormat.format("https://{0}:{1}/", sslHost, "" + sslPort));
		HttpsURLConnection connection = null;


		try {
			connection = (HttpsURLConnection) url.openConnection();

			connection.connect();

			connection.getResponseMessage();
			connection.getCipherSuite();

			return convertCertificates(connection.getServerCertificates());

		} catch (GeneralSecurityException ex) {
			throw new Exception(ex);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}

	}

	private static X509Certificate[] convertCertificates(Certificate[] certsIn) throws Exception {

		if (certsIn == null) {
			return new X509Certificate[0];
		}

		X509Certificate[] certsOut = new X509Certificate[certsIn.length];

		for (int i = 0; i < certsIn.length; i++) {
			certsOut[i] = convertCertificate(certsIn[i]);
		}

		return certsOut;
	}

	private static X509Certificate convertCertificate(Certificate certIn) throws Exception {
		try {
			CertificateFactory cf = CertificateFactory.getInstance(X509_CERTIFICATE_TYPE);
			ByteArrayInputStream bais = new ByteArrayInputStream(certIn.getEncoded());
			return (X509Certificate) cf.generateCertificate(bais);
		} catch (CertificateException e) {
			throw new Exception(e);
		}
	}

}
