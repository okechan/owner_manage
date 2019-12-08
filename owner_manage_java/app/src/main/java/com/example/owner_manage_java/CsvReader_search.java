package com.example.owner_manage_java;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Environment;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader_search {
    List<ListData> objects = new ArrayList<ListData>();
    public static ArrayList<ArrayList<String>> arraylist_search = new ArrayList<>();
    public void reader(Context context,String sp1 ,Object sp2) {
        try {
            // CSVファイルの読み込み
            arraylist_search.clear();
            File file = new File(Environment.getExternalStorageDirectory().getPath()+"/test.csv");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                ArrayList<String> array = new ArrayList<>();
                //カンマ区切りで１つづつ配列に入れる
                ListData data = new ListData();
                String[] RowData = line.split(",");
                if(sp1.equals("管理者")) {
                    if (sp2 == "宇都木" && RowData[2].equals("宇都木")) {
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
                        arraylist_search.add(array);
                        objects.add(data);
                    } else if (sp2 == "島川" && RowData[2].equals("島川")) {
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
                        arraylist_search.add(array);
                        objects.add(data);
                    } else if (sp2 == "宮田" && RowData[2].equals("宮田")) {
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
                        arraylist_search.add(array);
                        objects.add(data);
                    } else if (sp2 == "山野辺" && RowData[2].equals("山野辺")) {
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
                        arraylist_search.add(array);
                        objects.add(data);
                    } else if (sp2 == "佐藤" && RowData[2].equals("佐藤")) {
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
                        arraylist_search.add(array);
                        objects.add(data);
                    } else if (sp2 == "大島" && RowData[2].equals("大島")) {
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
                        arraylist_search.add(array);
                        objects.add(data);
                    } else if (sp2 == "川村" && RowData[2].equals("川村")) {
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
                        arraylist_search.add(array);
                        objects.add(data);
                    } else if (sp2 == "須志田" && RowData[2].equals("須志田")) {
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
                        arraylist_search.add(array);
                        objects.add(data);
                    } else if (sp2 == "内田" && RowData[2].equals("内田")) {
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
                        arraylist_search.add(array);
                        objects.add(data);
                    }
                }else if(sp1.equals("場所")){
                    if (sp2 == "宇都木研" && RowData[3].equals("宇都木研")) {
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
                        arraylist_search.add(array);
                        objects.add(data);
                    } else if (sp2 == "島川研" && RowData[3].equals("島川研")) {
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
                        arraylist_search.add(array);
                        objects.add(data);
                    } else if (sp2 == "宮田研" && RowData[3].equals("宮田研")) {
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
                        arraylist_search.add(array);
                        objects.add(data);
                    } else if (sp2 == "山野辺研" && RowData[3].equals("山野辺研")) {
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
                        arraylist_search.add(array);
                        objects.add(data);
                    } else if (sp2 == "佐藤研" && RowData[3].equals("佐藤研")) {
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
                        arraylist_search.add(array);
                        objects.add(data);
                    } else if (sp2 == "大島研" && RowData[3].equals("大島研")) {
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
                        arraylist_search.add(array);
                        objects.add(data);
                    } else if (sp2 == "川村研" && RowData[3].equals("川村研")) {
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
                        arraylist_search.add(array);
                        objects.add(data);
                    } else if (sp2 == "須志田研" && RowData[3].equals("須志田研")) {
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
                        arraylist_search.add(array);
                        objects.add(data);
                    } else if (sp2 == "内田研" && RowData[3].equals("内田研")) {
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
                        arraylist_search.add(array);
                        objects.add(data);
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
