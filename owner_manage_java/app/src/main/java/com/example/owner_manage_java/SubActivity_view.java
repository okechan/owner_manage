package com.example.owner_manage_java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class SubActivity_view extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_view);

        Button returnButton = findViewById(R.id.return_button);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Spinner sp1 = findViewById(R.id.spinner);

        //csv読み込み
        CsvReader parser = new CsvReader();
        parser.reader(getApplicationContext());
        ListViewAdapter listViewAdapter = new ListViewAdapter(this,0,parser.objects);
        ListView listview = (ListView)findViewById(R.id.view_view);
        listview.setAdapter(listViewAdapter);
    //csv読み込みリストへ反映終わり

    //スピナーの設定
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
        public void onItemSelected(AdapterView<?> parent, View view,
        int position, long id) {
            Spinner sp1 = (Spinner) parent;
            createSpinner(sp1.getSelectedItem().toString());
        }
        public void onNothingSelected(AdapterView<?> parent) {}
    });
        findViewById(R.id.Search_button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final CsvReader_editsearch editsearch = new CsvReader_editsearch();
                ListViewAdapter listViewAdapter = new ListViewAdapter(getApplicationContext(), 0, editsearch.objects);
                ListView listview = (ListView) findViewById(R.id.view_view);
                listViewAdapter.clear();
                EditText edit1 = (EditText) findViewById(R.id.editText);
                String edit = edit1.getText().toString();
                editsearch.reader(getApplicationContext(), edit);
                listview.setAdapter(listViewAdapter);
            }
        });

}

    private void createSpinner(final String select) {
        Spinner sp2 = findViewById(R.id.spinner2);
        final CsvReader_search csvsearch = new CsvReader_search();
        final CsvReader allsearch = new CsvReader();
        ArrayList<String> spnitem_content_place = new ArrayList<String>(Arrays.asList("島川研", "山野辺研", "宇都木研", "須志田研", "内田研", "大島研", "宮田研", "川村研", "409", "410", "411", "412", "413", "414", "415"));
        ArrayList<String> spnitem_content_admin = new ArrayList<String>(Arrays.asList("内田", "宇都木", "大島", "川村", "島川", "須志田", "宮田", "山野辺"));
        ArrayList<String> spnitem_content_all = new ArrayList<String>(Arrays.asList("ALL"));
        switch (select) {
            case "ALL":
                ArrayAdapter<String> adapter0 = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, spnitem_content_all);
                sp2.setAdapter(adapter0);
                break;
            case "場所":
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, spnitem_content_place);
                sp2.setAdapter(adapter);
                break;
            case "管理者":
                ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, spnitem_content_admin);
                sp2.setAdapter(adapter2);
                break;
        }

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(select.equals("ALL")) {
                    ListViewAdapter listViewAdapter = new ListViewAdapter(getApplicationContext(), 0, allsearch.objects);
                    ListView listview = (ListView) findViewById(R.id.view_view);
                    listViewAdapter.clear();
                    Spinner sp2 = (Spinner) parent;
                    allsearch.reader(getApplicationContext());
                    listview.setAdapter(listViewAdapter);

                }else if(select.equals("場所")||select.equals("管理者")){
                    ListViewAdapter listViewAdapter = new ListViewAdapter(getApplicationContext(), 0, csvsearch.objects);
                    ListView listview = (ListView) findViewById(R.id.view_view);
                    listViewAdapter.clear();
                    Spinner sp2 = (Spinner) parent;
                    csvsearch.reader(getApplicationContext(), select, sp2.getSelectedItem());
                    listview.setAdapter(listViewAdapter);
                }

            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
