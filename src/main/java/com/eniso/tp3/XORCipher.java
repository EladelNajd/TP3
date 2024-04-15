/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eniso.tp3;

/**
 *
 * @author LENOVO
 */
public class XORCipher {
    private String key;
    
    public XORCipher(String key) {
        this.key = key; 
    }
    
    public String encrypt(String plaintext) {
        StringBuilder encryptedText = new StringBuilder();
        
       
        while (key.length() < plaintext.length()) {
            key += key;
        }
        
        for (int i = 0; i < plaintext.length(); i++) {
         
            char encryptedChar = (char)(plaintext.charAt(i) ^ key.charAt(i));
            encryptedText.append(encryptedChar);
        }
        
        return encryptedText.toString();
    }
    
    public String decrypt(String ciphertext) {
        StringBuilder decryptedText = new StringBuilder();
        
        
        while (key.length() < ciphertext.length()) {
            key += key;
        }
        
        for (int i = 0; i < ciphertext.length(); i++) {
          
            char decryptedChar = (char)(ciphertext.charAt(i) ^ key.charAt(i));
            decryptedText.append(decryptedChar);
        }
        
        return decryptedText.toString();
    }
    
    public static void main(String[] args) {
        XORCipher cipher = new XORCipher("yourkey");
        String plaintext = "plaintext";
        String encryptedText = cipher.encrypt(plaintext);
        String decryptedText = cipher.decrypt(encryptedText);
        
        System.out.println("Plaintext: " + plaintext);
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}


