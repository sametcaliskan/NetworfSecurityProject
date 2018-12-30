package com.security.encryptionAlgorithm;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

public class Encryption {
	static int ek=0;
	
	public static String sha256Encrypt(final String originalString) {
		
		String sha256hex = Hashing.sha256()
				  .hashString(originalString, StandardCharsets.UTF_8)
				  .toString();
		return sha256hex;
	}

	public static String createUsername(String username) {
		ek+=1;
		return username+ek;
	}

	public static String createPassword() {
		
		return null;
	}
}
