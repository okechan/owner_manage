package com.example.owner_manage_java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.Arrays;

import static com.example.owner_manage_java.CsvReader.arraylist_all;
import static com.example.owner_manage_java.CsvReader_search.arraylist_search;

public class SubActivity_view extends AppCompatActivity {
    Bundle args = new Bundle();
    final MyDialogFragment_view dialogFragment = new MyDialogFragment_view();

    ArrayList<String> spnitem_content_place = new ArrayList<String>(Arrays.asList("島川研", "山野辺研", "宇都木研", "須志田研", "内田研", "大島研", "宮田研", "川村研", "409", "410", "411", "412", "413", "414", "415"));
    ArrayList<String> spnitem_content_admin = new ArrayList<String>(Arrays.asList("内田", "宇都木", "大島", "川村", "島川", "須志田", "宮田", "山野辺"));
    ArrayList<String> spnitem_content_all = new ArrayList<String>(Arrays.asList("ALL"));

    final CsvReader allsearch = new CsvReader();
    final CsvReader_editsearch editsearch = new CsvReader_editsearch();
    final CsvReader_search search = new CsvReader_search();

    public static String select = new String();
    public static Object select2 = new Object();
    public String[] tempolary_item = new String[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_view);
        Spinner sp1 = findViewById(R.id.spinner);
        Button returnButton = findViewById(R.id.return_button);
        final ListView listview = (ListView) findViewById(R.id.view_view);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //csv読み込み
        final ListViewAdapter listViewAdapter_all = new ListViewAdapter(getApplicationContext(), 0, allsearch.objects);
        allsearch.reader(getApplicationContext());
        listview.setAdapter(listViewAdapter_all);
        //csv読み込みリストへ反映終わり

        //スピナーの設定
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Spinner sp1 = (Spinner) parent;
                select = sp1.getSelectedItem().toString();
                createSpinner(select);
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        findViewById(R.id.Search_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListViewAdapter listViewAdapter_edit = new ListViewAdapter(getApplicationContext(), 0, editsearch.objects);
                listViewAdapter_edit.clear();
                EditText edit1 = (EditText) findViewById(R.id.editText);
                String edit = edit1.getText().toString();
                editsearch.reader(getApplicationContext(), edit);
                listview.setAdapter(listViewAdapter_edit);
            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            final ListViewAdapter listViewAdapter_search = new ListViewAdapter(getApplicationContext(),0,search.objects);
            final ListViewAdapter listViewAdapter_all = new ListViewAdapter(getApplicationContext(), 0, allsearch.objects);

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
                if(select.equals("場所")||select.equals("管理者")) {
                    listViewAdapter_search.clear();
                    search.reader(getApplicationContext(), select, select2);
                    for (int i = 0; i < 8; i++) tempolary_item[i] = arraylist_search.get((int) listViewAdapter_search.getItemId(position)).get(i);
                }else if(select.equals("ALL")){
                    listViewAdapter_all.clear();
                    allsearch.reader(getApplicationContext());
                    for (int i=0;i<8;i++) tempolary_item[i] = arraylist_all.get((int)listViewAdapter_all.getItemId(position)).get(i);
                }
                args.putStringArray("temporary",tempolary_item);
                dialogFragment.setArguments(args);
                dialogFragment.show(getSupportFragmentManager(),"dialog_basic");
            }
        });
    }
        private void createSpinner(final String select) {
            Spinner sp2 = findViewById(R.id.spinner2);
            ArrayAdapter<String> adapter0 = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, spnitem_content_all);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, spnitem_content_place);
            ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, spnitem_content_admin);
            switch (select) {
            case "ALL":
                sp2.setAdapter(adapter0);
                break;
            case "場所":
                sp2.setAdapter(adapter);
                break;
            case "管理者":
                sp2.setAdapter(adapter2);
                break;
        }
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            final ListView listview = (ListView) findViewById(R.id.view_view);
            ListViewAdapter listViewAdapter_all = new ListViewAdapter(getApplicationContext(), 0, allsearch.objects);
            ListViewAdapter listViewAdapter_search = new ListViewAdapter(getApplicationContext(),0,search.objects);
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (select.equals("ALL")) {
                    listViewAdapter_all.clear();
                    allsearch.reader(getApplicationContext());
                    listview.setAdapter(listViewAdapter_all);
                } else if (select.equals("場所") || select.equals("管理者")) {

                    listViewAdapter_search.clear();
                    Spinner sp2 = (Spinner) parent;
                    select2 = sp2.getSelectedItem();
                    search.reader(getApplicationContext(), select, select2);
                    listview.setAdapter(listViewAdapter_search);
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
