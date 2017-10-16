package com.example.tavernelli.daniele.libreriadidanieletavernelli.Classes.DialogClasses;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tavernelli.daniele.libreriadidanieletavernelli.R;

import java.util.ArrayList;





public class WithListViewDialog extends Dialog {

    private Context context;
    private ArrayList<String> items;
    private ListView listView;
    private AdapterView.OnItemClickListener onItemClickListener;

    public WithListViewDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_with_list_view);
        listView=(ListView) findViewById(R.id.dialog_with_list_view_list_viw);
        listView.setAdapter(new ArrayAdapter<>(context,R.layout.simple_string_item,items));
        listView.setOnItemClickListener(onItemClickListener);

    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
        ((ArrayAdapter)listView.getAdapter()).notifyDataSetChanged();
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
