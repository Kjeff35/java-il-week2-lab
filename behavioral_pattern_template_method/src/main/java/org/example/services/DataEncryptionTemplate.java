package org.example.services;

public abstract class DataEncryptionTemplate {
    // template method
    public final void processData() {
        generateKey();
        encryptData();
        decryptData();
    }

    private void generateKey() {
        System.out.println("Generating encryption key...");
    }

    protected abstract void encryptData();
    protected abstract void decryptData();

}
