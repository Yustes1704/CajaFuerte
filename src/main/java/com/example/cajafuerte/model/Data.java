package com.example.cajafuerte.model;

import java.io.*;

public class Data {
    //Atributes
    private Password pass;
    private Content content;

    private static Data instance;

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    public Password getPass() {
        return pass;
    }

    public void setPass(Password pass) {
        this.pass = pass;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    private Data() {
        StringBuilder temp = new StringBuilder();
        try {
            File file = new File("Content.txt");
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

            String line;
            while ((line = reader.readLine()) != null) {
                temp.append(line);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        content = new Content(temp.toString());

        StringBuilder json = null;
        try {
            File file = new File("Pass.txt");
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert json != null;
        String[] num = json.toString().split("|");
        int num1 = Integer.parseInt(num[0]);
        int num2 = Integer.parseInt(num[1]);
        int num3 = Integer.parseInt(num[2]);
        int num4 = Integer.parseInt(num[3]);
        int num5 = Integer.parseInt(num[4]);
        int num6 = Integer.parseInt(num[5]);
        pass = new Password(num1, num2, num3, num4, num5, num6);
    }
}
