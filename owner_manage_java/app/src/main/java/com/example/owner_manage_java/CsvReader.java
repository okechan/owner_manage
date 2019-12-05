package com.example.owner_manage_java;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class CsvReader {
    List<ListData> objects = new ArrayList<ListData>();
    public static String[][] csvReader_list = new String[100][8];
    int i=0;
    public void reader(Context context) {
        AssetManager assetManager = context.getResources().getAssets();
        //List<String[]> list_List= Arrays.asList(list);
        try {
            /* CSVファイルの読み込み */
            InputStream inputStream = assetManager.open("data.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferReader.readLine()) != null) {

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
                csvReader_list[i]=RowData;
                objects.add(data);
                i++;
            }
            bufferReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
