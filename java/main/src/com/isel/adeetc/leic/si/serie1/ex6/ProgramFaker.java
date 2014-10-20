package com.isel.adeetc.leic.si.serie1.ex6;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ProgramFaker {
	private byte[] targetHash;
	private byte[] startingMessage;
	
	public ProgramFaker(byte[] hash,byte[] message){
		this.targetHash = hash;
		this.startingMessage = message;
	}
	
	public static void main(String[] args) throws Exception{
		int operationLen = Integer.parseInt(args[0]);
		File f1 = new File(args[1]);
		File f2 = new File(args[2]);
		
		byte[] f2message = ProgramFaker.getAsString(f2);
		byte[] hash = ProgramFaker.HashCode(f2message,operationLen);

		byte[] message = ProgramFaker.getAsString(f1);
		
		byte[] fakeMessage = new ProgramFaker(hash,message).fakeIt(operationLen);
		System.out.println("Found faker! Asserting...");
		
		byte[] fakeHash = ProgramFaker.HashCode(fakeMessage,operationLen);
		if(Equals(fakeHash,hash,operationLen)){
			System.out.print("Success! The following message is the fake:\n«");
			System.out.println(fakeMessage);System.out.println("»");
		}else
			System.out.println("Assert failed. Try again");
		
	}

	private static boolean Equals(byte[] fakeHash, byte[] hash,int len) {
		if(fakeHash.length< len || hash.length <len)
			return false;
		for(int i=0;i<len;i++)
		{
			if(fakeHash[i]!=hash[i])
				return false;
		}
		return true;
	}

	private static byte[] getAsString(File f) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(f));
		StringBuilder sb = new StringBuilder();
		String buffer;
		do{
			buffer = reader.readLine();
			sb.append(buffer);
		}while(buffer!=null);
		reader.close();
		return sb.toString().getBytes();
	}

	private static byte[] HashCode(byte[] message,int len) throws NoSuchAlgorithmException, DigestException {
		byte[] response = new byte[len];
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		md.update(message);
		byte[] buffer = md.digest();
		for(int i=0;i<len;i++)
			response[i] = buffer[i];
		return response;
		
	}
	
	private byte[] fakeIt(int len) throws NoSuchAlgorithmException, DigestException, IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream(startingMessage.length);
		stream.write(startingMessage);
		do{
			byte currentByte = Byte.MIN_VALUE;
			stream.write(currentByte);
			byte[] currentMessage = stream.toByteArray();
			do{
				byte[] hash = HashCode(currentMessage,len);
				currentByte +=1;
				currentMessage[currentMessage.length-1]=currentByte;
				if(Equals(hash, targetHash, len))
					return currentMessage;
			}while(currentByte!=Byte.MAX_VALUE);
		}while(true);
	}
}