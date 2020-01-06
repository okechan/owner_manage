package com.example.owner_manage_java;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.owner_manage_java.CsvReader.arraylist_all;
import static com.example.owner_manage_java.CsvReader_editsearch.arraylist_edit;
import static com.example.owner_manage_java.CsvReader_search.arraylist_search;

public class SubActivity_view extends AppCompatActivity {
    Bundle args = new Bundle();
    final MyDialogFragment_view dialogFragment = new MyDialogFragment_view();
    ArrayList<String> spnitem_content_place = new ArrayList<String>(Readchanger.read_place());
    ArrayList<String> spnitem_content_admin = new ArrayList<String>(Readchanger.read_admin());
    ArrayList<String> spnitem_content_all = new ArrayList<String>(Arrays.asList("ALL"));
    final CsvReader allsearch = new CsvReader();
    final CsvReader_editsearch editsearch = new CsvReader_editsearch();
    final CsvReader_search search = new CsvReader_search();

    public static String select = new String();
    public static Object select2 = new Object();
    public String[] tempolary_item = new String[6];
    public static String edit;
    public int place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_view);
        Spinner sp1 = findViewById(R.id.spinner);
        Button returnButton = findViewById(R.id.return_button);
        final ListViewAdapter_check listViewAdapter_edit = new ListViewAdapter_check(getApplicationContext(), 0, editsearch.objects);
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
        final EditText edit1 = findViewById(R.id.editText);
        //スピナーの設定
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                Spinner sp1 = (Spinner) parent;
                edit1.setText("");
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
                listViewAdapter_all.clear();
                listViewAdapter_edit.clear();
                edit = edit1.getText().toString();
                if (edit.isEmpty()) {
                    allsearch.reader(getApplicationContext());
                    listview.setAdapter(listViewAdapter_all);
                } else {
                    editsearch.reader(getApplicationContext(), edit);
                    listview.setAdapter(listViewAdapter_edit);
                }
                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            final ListViewAdapter listViewAdapter_search = new ListViewAdapter(getApplicationContext(), 0, search.objects);
            final ListViewAdapter listViewAdapter_all = new ListViewAdapter(getApplicationContext(), 0, allsearch.objects);

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edit = edit1.getText().toString();
                listViewAdapter_edit.clear();
                listViewAdapter_search.clear();
                listViewAdapter_all.clear();
                if (edit.equals("")) {
                    if (select.equals("場所") || select.equals("管理者")) {
                        search.reader(getApplicationContext(), select, select2);
                        for (int i = 0; i < 6; i++)
                            tempolary_item[i] = arraylist_search.get((int) listViewAdapter_search.getItemId(position)).get(i);
                        listview.setAdapter(listViewAdapter_search);
                    } else if (select.equals("ALL")) {
                        allsearch.reader(getApplicationContext());
                        for (int i = 0; i < 6; i++)
                            tempolary_item[i] = arraylist_all.get((int) listViewAdapter_all.getItemId(position)).get(i);
                        listview.setAdapter(listViewAdapter_all);
                    }
                } else {
                    editsearch.reader(getApplicationContext(), edit);
                    place = (int) listViewAdapter_edit.getItemId(position);
                    for (int i = 0; i < 6; i++)
                        tempolary_item[i] = arraylist_edit.get(place).get(i);
                    listview.setAdapter(listViewAdapter_edit);
                }
                args.putStringArray("temporary", tempolary_item);
                dialogFragment.setArguments(args);
                dialogFragment.show(getSupportFragmentManager(), "dialog_basic");
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
                    System.out.println(select2);
                    search.reader(getApplicationContext(), select,select2);
                    listview.setAdapter(listViewAdapter_search);
                }
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
