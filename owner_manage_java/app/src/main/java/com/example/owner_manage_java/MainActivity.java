package com.example.owner_manage_java;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendButton = findViewById(R.id.sendbutton);
        //画面遷移
        sendButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplication(),SubActivity.class);
                startActivity(intent);
            }
        });
        //画面遷移終了
        Spinner sp = findViewById(R.id.spinner);
        //csv読み込み
        CsvReader parser = new CsvReader();
        parser.reader(getApplicationContext());
        ListViewAdapter listViewAdapter = new ListViewAdapter(this,0,parser.objects);
        ListView listview = (ListView)findViewById(R.id._dynamic);
        listview.setAdapter(listViewAdapter);
        //csv読み込みリストへ反映終わり

        //スピナーの設定
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Spinner sp = (Spinner) parent;
                Toast.makeText(MainActivity.this,
                        String.format("選択項目：%s", sp.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
               String select =sp.getSelectedItem().toString();
                createSpinner(select);

            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });
}

    private void createSpinner(String select){
        Spinner sp2 = findViewById(R.id.spinner2);
        ArrayList<String> spnitem_content_place = new ArrayList<String>(Arrays.asList("401","402","403","404","405","406","407","408","409","410","411","412","413","414","415"));
        ArrayList<String> spnitem_content_admin = new ArrayList<String>(Arrays.asList("内田","宇都木","大島","川村","島川","須志田","宮田","山野辺"));
        switch(select){
            case "場所":
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.select_dialog_item,spnitem_content_place);
                sp2.setAdapter(adapter);
                break;
            case"管理者":
                ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this,android.R.layout.select_dialog_item,spnitem_content_admin);
                sp2.setAdapter(adapter2);
                break;
        }
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Spinner sp = (Spinner) parent;
                Toast.makeText(MainActivity.this,
                        String.format("選択項目：%s", sp.getSelectedItem()),
                        Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }
}
