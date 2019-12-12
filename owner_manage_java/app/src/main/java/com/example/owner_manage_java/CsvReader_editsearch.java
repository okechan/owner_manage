package com.example.owner_manage_java;

import android.content.Context;
import android.os.Environment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader_editsearch {
    List<ListData> objects = new ArrayList<ListData>();
    public static ArrayList<ArrayList<String>> arraylist_edit = new ArrayList<>();

    public void reader(Context context,String edit) {
        try {
            arraylist_edit.clear();
            // CSVファイルの読み込み
            File file = new File(Environment.getExternalStorageDirectory().getPath()+"/data1.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                ArrayList<String> array = new ArrayList<>();
                //カンマ区切りで１つづつ配列に入れる
                ListData data = new ListData();
                String[] RowData = line.split(",");
                if(edit.equals(RowData[0])){
                    data.setId(RowData[0]);
                    data.setName(RowData[1]);
                    data.setAdmin(RowData[2]);
                    data.setplace(RowData[3]);
                    data.setnumber(RowData[4]);
                    data.setyear(RowData[5]);
                    //data.setmonth(RowData[6]);
                    //data.setday(RowData[7]);
                    for (int i=0;i<6;i++) {
                        array.add(RowData[i]);
                    }
                    arraylist_edit.add(array);
                    objects.add(data);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
