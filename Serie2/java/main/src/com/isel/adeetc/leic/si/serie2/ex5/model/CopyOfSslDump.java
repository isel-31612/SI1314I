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

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;

public class CopyOfSslDump {

	private static final String X509_CERTIFICATE_TYPE = "X.509";
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss z");

	private static final String host = "www.mbnet.pt";
	private static final int port = 443;
	public static void main(String[] args) throws Exception {

		X509Certificate[] certs = CopyOfSslDump.getCertificates1(host, port);

		if (certs == null) {
			return;
		}

		// send to browser

		List<CertificateInfoBean> certificateInfoBeans = new ArrayList<CertificateInfoBean>();

		try {

			int i = 0;
			for(X509Certificate cert : certs) {
				CertificateInfoBean certInfoBean = new CertificateInfoBean();
				
				Date currentDate = new Date();

				Date startDate = cert.getNotBefore();
				Date endDate = cert.getNotAfter();

				boolean notYetValid = currentDate.before(startDate);
				boolean noLongerValid = currentDate.after(endDate);

				certInfoBean.version = Integer.toString(cert.getVersion());

				certInfoBean.subject = cert.getSubjectX500Principal().getName();
				
//				jdnSubject.setDistinguishedName(X500NameUtils.x500PrincipalToX500Name(cert
//						.getSubjectX500Principal()));

				certInfoBean.issuer = cert.getIssuerDN().getName();
//				jdnIssuer
//				.setDistinguishedName(X500NameUtils.x500PrincipalToX500Name(cert.getIssuerX500Principal()));

				certInfoBean.serialNumber = "0x" + new BigInteger(1, cert.getSerialNumber().toByteArray()).toString(16).toUpperCase(); 
//				jtfSerialNumber.setText("0x"
//						+ new BigInteger(1, cert.getSerialNumber().toByteArray()).toString(16).toUpperCase());

				certInfoBean.validFrom = DATE_FORMAT.format(startDate);

				if (notYetValid) {
					certInfoBean.validFrom = ("DViewCertificate.jtfValidFrom.notyetvalid.text") + certInfoBean.validFrom;
					// another color... red		
							
				} else {
//					jtfValidFrom.setForeground(jtfVersion.getForeground());
				}

				certInfoBean.validUntil = DATE_FORMAT.format(endDate); 

				if (noLongerValid) {
					certInfoBean.validUntil = ("DViewCertificate.jtfValidUntil.expired.text") + certInfoBean.validUntil;
					// another color... red		
				} else {
					//jtfValidUntil.setForeground(jtfVersion.getForeground());
				}

				PublicKey pubKey = cert.getPublicKey();
				
				//pubKey.getEncoded()
				
				certInfoBean.publicKey = pubKey.getAlgorithm();
				
				certInfoBean.signatureAlgorithm = cert.getSigAlgName();
				

				byte[] encodedCertificate;
				encodedCertificate = cert.getEncoded();

				certInfoBean.encoded = "0x" + new BigInteger(1, encodedCertificate).toString(16).toUpperCase();
				//certInfoBean.fingerPrintSHA_1 = 
				
				certificateInfoBeans.add(certInfoBean);

			}
		} catch (Exception ex) {
		}
		
		
		for(CertificateInfoBean cert : certificateInfoBeans) {
			System.out.println(cert);
		}
	}

	//	private String sslHost;
	//	private int sslPort;
	//	private X509Certificate[] certificates;

	private CopyOfSslDump() {

	}

	//	public SslDump(String sslHost, int sslPort) {
	//		this.sslHost = sslHost;
	//		this.sslPort = sslPort;
	//	}

	public static X509Certificate[] getCertificates1(String sslHost, int sslPort) 
			throws Exception{

		URL url = new URL(MessageFormat.format("https://{0}:{1}/", sslHost, "" + sslPort));
		HttpsURLConnection connection = null;

		System.setProperty("javax.net.debug", "ssl");

		try {
			connection = (HttpsURLConnection) url.openConnection();



			// We are only interested in getting the SSL certificates even if they are invalid
			// either in and of themselves or for the host name they are associated with

			// 1) Set connection's SSL Socket factory to have a very trusting trust manager
//			SSLContext context = SSLContext.getInstance("TLS");
//			context.init(new KeyManager[] { null }, new TrustManager[] { null }, null);
//			SSLSocketFactory factory = context.getSocketFactory();
//			connection.setSSLSocketFactory(factory);
//
//			// 2) Set a host name verifier that always verifies the host name
//			connection.setHostnameVerifier(new HostnameVerifier() {
//				public boolean verify(String hostname, SSLSession sslSession) {
//					return true;
//				}
//			});

			connection.connect();

			// this is necessary in order to cause a handshake exception when the client cert is not accepted
			connection.getResponseMessage();

			connection.getCipherSuite();
			System.out.println(connection.toString());

			return convertCertificates(connection.getServerCertificates());

		} catch (GeneralSecurityException ex) {
			//throw new CryptoException(res.("NoLoadCertificate.exception.message"), ex);
			throw new Exception(("NoLoadCertificate.exception.message"), ex);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}

	}

	public static X509Certificate[] convertCertificates(Certificate[] certsIn) throws Exception {

		if (certsIn == null) {
			return new X509Certificate[0];
		}

		X509Certificate[] certsOut = new X509Certificate[certsIn.length];

		for (int i = 0; i < certsIn.length; i++) {
			certsOut[i] = convertCertificate(certsIn[i]);
		}

		return certsOut;
	}

	public static X509Certificate convertCertificate(Certificate certIn) throws Exception {
		try {
			CertificateFactory cf = CertificateFactory.getInstance(X509_CERTIFICATE_TYPE);
			ByteArrayInputStream bais = new ByteArrayInputStream(certIn.getEncoded());
			return (X509Certificate) cf.generateCertificate(bais);
		} catch (CertificateException e) {
			//throw new CryptoException(res.getString("NoConvertCertificate.exception.message"), e);
			throw new Exception("NoConvertCertificate.exception.message", e);
		}
	}

}
