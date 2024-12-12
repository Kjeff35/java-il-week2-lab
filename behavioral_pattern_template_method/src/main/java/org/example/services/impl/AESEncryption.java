package org.example.services.impl;

import org.example.services.DataEncryptionTemplate;

public class AESEncryption extends DataEncryptionTemplate {
    protected void encryptData() {
        System.out.println("Encrypting data using AES Algorithm");
    }

    protected void decryptData() {
        System.out.println("Decrypting data using AES Algorithm");
    }
}
