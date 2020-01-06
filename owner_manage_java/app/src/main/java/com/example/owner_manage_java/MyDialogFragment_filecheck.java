package com.example.owner_manage_java;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;

public class MyDialogFragment_filecheck extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        return builder.setTitle("警告").setMessage("CSVファイルが見つかりません。\n内部ストレージ直下に「data1.csv」というファイルがあるか確認してください").create();
    }
}
