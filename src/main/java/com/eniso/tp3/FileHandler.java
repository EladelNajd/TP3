/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.eniso.tp3;
import java.util.ArrayList;
import java.io.File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author LENOVO
 */
public class FileHandler {
    private String filePath;
    private int sizeInKb;
    private int numberOfLines;
    private ArrayList<String> fileContent;

    public FileHandler(String filePath) {
        this.filePath = filePath;
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("File path: " + filePath); // Print out the file path
            this.sizeInKb = (int) file.length() / 1024;
            try {
                this.numberOfLines = countLines(filePath);
                System.out.println("Number of lines in the file: " + numberOfLines);
                this.fileContent = readFileContent(filePath);
                if (fileContent == null) {
                    System.err.println("Error: Unable to read file content.");
                } else {
                    System.out.println("FileHandler initialized successfully.");
                }
            } catch (IOException e) {
                System.err.println("Error reading the file: " + e.getMessage());
            }
        } else {
            System.err.println("Error: The specified file path does not exist.");
        }
    
    


    }
     public static ArrayList<String> readFileContent(String filePath) throws IOException {
        ArrayList<String> content = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.add(line);
            }
        }
        return content;}
    
     
        public static int countLines(String filePath) throws IOException {
       
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int lines = 0;
         
            while (reader.readLine() != null) {
                lines++;
            }
            return lines;
        }
    }
        public ArrayList<String> findLinesWithPattern(String pattern) {
        ArrayList<String> matchingLines = new ArrayList<>();
        for (String line : fileContent) {
            if (line.contains(pattern)) {
                matchingLines.add(line);
            }
        }
        return matchingLines;
    }
        public boolean compareStrings1(String str1, String str2) {
        return str1.equals(str2);}
         public boolean compareStrings3(String str1, String str2) {
        return str1.equalsIgnoreCase(str2);
    }
         public boolean compareStrings2(String str1, String str2) {
        return str1 == str2;
    }
         public String reverseString(int lineIndex) {
        if (lineIndex >= 0 && lineIndex < fileContent.size()) {
            String originalLine = fileContent.get(lineIndex);
           
            StringBuilder reversedLine = new StringBuilder(originalLine).reverse();
            return reversedLine.toString();
        } else {
            return "Invalid line index. Please provide a valid index.";
        }
    }
         public String removeDuplicates(int lineIndex) {
    if (lineIndex >= 0 && lineIndex < fileContent.size()) {
        String originalLine = fileContent.get(lineIndex);
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < originalLine.length(); i++) {
            char currentChar = originalLine.charAt(i);
   
            if (result.indexOf(String.valueOf(currentChar)) == -1) {
                result.append(currentChar);
            }
        }

        return result.toString();
    } else {
        return "Invalid line index. Please provide a valid index.";
    }
}
         
        
}
     