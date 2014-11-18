package com.isel.adeetc.leic.si.serie2.ex5;

import com.isel.adeetc.leic.si.serie2.ex5.model.SslDump;

public class Ex5 {

	private static int sslPort;

	public static void main(String[] args) throws Exception {
		
		if (args.length < 1) {
			System.out.println("Invalid arguments\n Program usage : Ex5 hostname [ssl port]");
			System.exit(-1);
		}
		try {
			Integer.valueOf(args[1]);
		} catch(Exception e) {
			sslPort = 0;
		}
		
		SslDump.dumpCertificatesFromServer(args[0], sslPort);
	}
	
}
