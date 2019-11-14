package com.example.owner_manage_java;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CsvReader_editsearch {
    List<ListData> objects = new ArrayList<ListData>();
    public void reader(Context context,String edit) {
        AssetManager assetManager = context.getResources().getAssets();
        try {
            // CSVファイルの読み込み
            InputStream inputStream = assetManager.open("data.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferReader = new BufferedReader(inputStreamReader);
            String line;

            while ((line = bufferReader.readLine()) != null) {
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
                    data.setmonth(RowData[6]);
                    data.setday(RowData[7]);
                    objects.add(data);
                }
            }
            bufferReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
