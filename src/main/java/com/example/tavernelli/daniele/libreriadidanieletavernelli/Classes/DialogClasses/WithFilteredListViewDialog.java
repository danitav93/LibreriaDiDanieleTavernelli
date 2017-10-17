package com.example.tavernelli.daniele.libreriadidanieletavernelli.Classes.DialogClasses;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.tavernelli.daniele.libreriadidanieletavernelli.R;

import java.util.ArrayList;



public class WithFilteredListViewDialog extends Dialog {

    private Context context;
    private ArrayList<String> items;
    private ListView listView;
    private OnQueryTextSubmitListener onQueryTextSubmitListener;
    private boolean byList=false;
    private SearchView searchView;


    public WithFilteredListViewDialog(@NonNull Context context) {
        super(context);
        this.context=context;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_with_filtered_list_view);
        listView=(ListView) findViewById(R.id.dialog_with_filtered_list_viw_list_viw);
        listView.setAdapter(new ArrayAdapter<>(context,R.layout.simple_string_item,items));

        searchView = (SearchView) findViewById(R.id.dialog_with_filtered_list_viw_search_view);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (byList) {
                    onQueryTextSubmitListener.onSubmit();
                }
                byList=false;
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ((ArrayAdapter)listView.getAdapter()).getFilter().filter(newText);
                return false;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                byList=true;
                searchView.setQuery(items.get(position),true);

            }
        });


    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
        ((ArrayAdapter)listView.getAdapter()).notifyDataSetChanged();
    }

    public void setOnQueryTextSubmitListener(OnQueryTextSubmitListener onQueryTextSubmitListener) {
        this.onQueryTextSubmitListener = onQueryTextSubmitListener;
    }

    public interface OnQueryTextSubmitListener {
        public void onSubmit();
    }

    public SearchView getSearchView() {
        return searchView;
    }
}
