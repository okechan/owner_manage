package com.example.owner_manage_java;

import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class CsvWriter {
    private static final String COMMA = ",";
    private static final String NEW_LINE="\r\n";
    public static void writer(String[][] itemlist){
        try{

            File file = new File(Environment.getExternalStorageDirectory().getPath()+"/test.csv");
            file.delete();
            file.createNewFile();
            FileWriter fw = new FileWriter(Environment.getExternalStorageDirectory().getPath()+"/test.csv",false);
            PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

            for(int i=0;i<itemlist.length;i++){
                for(int j=0;j<8;j++){
                    pw.print(itemlist[i][j]);
                    pw.print(COMMA);
                }
                pw.print(NEW_LINE);
            }
            pw.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
