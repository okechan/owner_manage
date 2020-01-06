package com.example.owner_manage_java;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Readchanger {
    public static ArrayList<String> arraylist_admin = new ArrayList<>();
    public static ArrayList<String> arraylist_place = new ArrayList<>();

    public static ArrayList<String> read_admin(){
        FileInputStream fi = null;
        InputStreamReader is = null;
        BufferedReader br = null;
        try{
            arraylist_admin.clear();
            /* CSVファイルの読み込み */
            fi = new FileInputStream(Environment.getExternalStorageDirectory().getPath()+"/teacher.txt");
            is = new InputStreamReader(fi,"UTF-8");
            br = new BufferedReader(is);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                arraylist_admin.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return arraylist_admin;
    }

    public static ArrayList<String> read_place(){
        FileInputStream fi = null;
        InputStreamReader is = null;
        BufferedReader br = null;
        try{
            arraylist_place.clear();
            /* CSVファイルの読み込み */
            fi = new FileInputStream(Environment.getExternalStorageDirectory().getPath()+"/place.txt");
            is = new InputStreamReader(fi,"UTF-8");
            br = new BufferedReader(is);
            String line;
            while ((line = br.readLine()) != null) {
                arraylist_place.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return arraylist_place;
    }
}
