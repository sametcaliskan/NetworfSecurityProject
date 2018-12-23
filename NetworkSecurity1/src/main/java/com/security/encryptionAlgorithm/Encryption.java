package com.security.encryptionAlgorithm;

import java.nio.charset.StandardCharsets;

import com.google.common.hash.Hashing;

public class Encryption {

	
	public static String sha256Encrypt(final String originalString) {
		
		String sha256hex = Hashing.sha256()
				  .hashString(originalString, StandardCharsets.UTF_8)
				  .toString();
		return sha256hex;
	}
}
