package com.example.owner_manage_java;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class CsvReader {
    List<ListData> objects = new ArrayList<ListData>();
    public static ArrayList<ArrayList<String>> arraylist_all = new ArrayList<>();
    private Context context;
    public void reader(Context context) {
        this.context = context;
        try {
            arraylist_all.clear();
            /* CSVファイルの読み込み */
            File file = new File(Environment.getExternalStorageDirectory().getPath()+"/test.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                ArrayList<String> array = new ArrayList<>();
                //カンマ区切りで１つづつ配列に入れる
                ListData data = new ListData();
                String[] RowData = line.split(",");
                //CSVの左([0]番目)から順番にセット
                data.setId(RowData[0]);
                data.setName(RowData[1]);
                data.setAdmin(RowData[2]);
                data.setplace(RowData[3]);
                data.setnumber(RowData[4]);
                data.setyear(RowData[5]);
                data.setmonth(RowData[6]);
                data.setday(RowData[7]);
                for (int i=0;i<8;i++) {
                    array.add(RowData[i]);
                }
                objects.add(data);
                arraylist_all.add(array);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
