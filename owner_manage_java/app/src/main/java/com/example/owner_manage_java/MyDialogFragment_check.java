package com.example.owner_manage_java;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

import static com.example.owner_manage_java.CsvReader.arraylist_all;
import static com.example.owner_manage_java.SubActivity_check.gettime;

public class MyDialogFragment_check extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String[] itemlist = getArguments().getStringArray("temporary");
        final int place = getArguments().getInt("place");
        return builder.setTitle("詳細情報")
                .setMessage("資産コード:" + itemlist[0] + "\n" + "資産名:" + itemlist[1] + "\n" + "管理者:" + itemlist[2] + "\n" + "管理場所:" + itemlist[3] + "\n" + "個数:" + itemlist[4] + "\n" + "最終確認日:" + itemlist[5] + "\n")
                .setPositiveButton("確認", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "チェックされました", Toast.LENGTH_SHORT).show();
                        arraylist_all.get(place).set(5, gettime());
                        CsvWriter.writer(arraylist_all);
                        arraylist_all.clear();
                    }
                }).setNegativeButton("中断", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "中断しました", Toast.LENGTH_SHORT).show();
                    }
                }).create();
    }
}
