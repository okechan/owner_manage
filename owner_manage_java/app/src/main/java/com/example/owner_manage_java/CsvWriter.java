package com.example.owner_manage_java;

import android.os.Environment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CsvWriter {
    private static final String COMMA = ",";
    private static final String NEW_LINE = "\r\n";

    public static void writer(ArrayList<ArrayList<String>> itemise) {
        try {
            File file = new File(Environment.getExternalStorageDirectory().getPath() + "/data1.csv");
            file.delete();
            file.createNewFile();
            FileWriter fw = new FileWriter(Environment.getExternalStorageDirectory().getPath() + "/data1.csv", false);
            PrintWriter pw = new PrintWriter(new BufferedWriter(fw));

            loop:
            for (int i = 0; i < itemise.size(); i++) {
                for (int j = 0; j < 6; j++) {
                    if (itemise.get(i).get(j).equals("NULL")) {
                        break loop;
                    }
                    pw.print(itemise.get(i).get(j));
                    pw.print(COMMA);
                }
                pw.print(NEW_LINE);
            }
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void part_write(String[] itemlist, ArrayList<ArrayList<String>> itemise) {
        for (int i = 0; i < itemise.size(); i++) {
            for (int j = 0; j < 6; j++) {
                if (itemise.get(i).get(0).equals(itemlist[0]) && itemise.get(i).get(1).equals(itemlist[1]) && itemise.get(i).get(2).equals(itemlist[2]) &&
                        itemise.get(i).get(3).equals(itemlist[3]) && itemise.get(i).get(4).equals(itemlist[4])) {
                    itemise.get(i).add(5,itemlist[5]);
                }
            }
        }
        writer(itemise);
    }
}
