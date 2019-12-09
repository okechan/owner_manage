package com.example.owner_manage_java;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.owner_manage_java.CsvReader.arraylist_all;

public class SubActivity_check extends AppCompatActivity{
    Bundle args1 = new Bundle();
    Bundle args2 = new Bundle();
    final MyDialogFragment_check dialogFragment = new MyDialogFragment_check();

    public String[] tempolary_item = new String[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_check);
        final ListView lv = (ListView) findViewById(R.id.check_view);
        Button returnButton = findViewById(R.id.return_button);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SubActivity_check.this,
                        String.format("ファイルが出力されました"),
                        Toast.LENGTH_LONG).show();
                finish();
            }
        });
        final CsvReader parser = new CsvReader();
        parser.reader(getApplicationContext());
        final ListViewAdapter_check listViewAdapter_all = new ListViewAdapter_check(this, 0, parser.objects);
        lv.setAdapter(listViewAdapter_all);
        //csv読み込みリストへ反映終わり
        
        findViewById(R.id.Searchviewbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final CsvReader_editsearch editsearch = new CsvReader_editsearch();
                ListViewAdapter_check listViewAdapter_edit = new ListViewAdapter_check(getApplicationContext(), 0, editsearch.objects);
                listViewAdapter_all.clear();
                listViewAdapter_edit.clear();
                EditText edit1 = findViewById(R.id.editText2);
                String edit = edit1.getText().toString();
                if(edit.isEmpty()){
                    parser.reader(getApplicationContext());
                    lv.setAdapter(listViewAdapter_all);
                }else {
                    editsearch.reader(getApplicationContext(), edit);
                    lv.setAdapter(listViewAdapter_edit);
                }
                InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> av, View view, int position, long id) {
                listViewAdapter_all.clear();
                parser.reader(getApplicationContext());
                int place = (int) listViewAdapter_all.getItemId(position);
                for (int i = 0; i < 8; i++) tempolary_item[i] = arraylist_all.get(place).get(i);
                args1.putStringArray("temporary", tempolary_item);
                args2.putInt("place", place);
                dialogFragment.setArguments(args1);
                dialogFragment.show(getSupportFragmentManager(), "dialog_basic");
            }
        });
    }
    public static String gettime(){
        final DateFormat df = new SimpleDateFormat("yyyy/mm");
        final Date date = new Date(System.currentTimeMillis());
        return df.format(date);
    }
}
