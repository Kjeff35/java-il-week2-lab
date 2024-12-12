package org.example.services.impl;

import org.example.services.DataEncryptionTemplate;

public class RSAEncryption extends DataEncryptionTemplate {

    @Override
    protected void encryptData() {
        System.out.println("Encrypting data using RSA Algorithm");
    }

    @Override
    protected void decryptData() {
        System.out.println("Decrypting data using RSA Algorithm");
    }
}
