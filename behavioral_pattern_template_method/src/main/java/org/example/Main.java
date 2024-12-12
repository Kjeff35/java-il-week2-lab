package org.example;

import org.example.services.DataEncryptionTemplate;
import org.example.services.impl.AESEncryption;
import org.example.services.impl.RSAEncryption;

public class Main {
    public static void main(String[] args) {
        DataEncryptionTemplate aesEncryption = new AESEncryption();
        System.out.println("Starting AES Encryption Process:");
        aesEncryption.processData();

        DataEncryptionTemplate rsaEncryption = new RSAEncryption();
        System.out.println("\nStarting RSA Encryption Process:");
        rsaEncryption.processData();
    }
}