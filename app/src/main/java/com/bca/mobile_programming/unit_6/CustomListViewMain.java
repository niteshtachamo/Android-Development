package com.bca.mobile_programming.unit_6;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bca.mobile_programming.R;
import com.bca.mobile_programming.unit_1.GenerelUtil;

public class CustomListViewMain extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();

        ActionBar bar =getSupportActionBar();
        if (bar !=null) bar.hide();
    }

    @Override
    public void onCreate(@Nullable Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.unit_6_list_view_main);

        Resources res =getResources();

        ListView listView =findViewById(R.id.listViewMainList);
        ViewGroup rootLayout =findViewById(R.id.listViewMainRoot);

        String[]  pokemonList =res.getStringArray(R.array.pokemon_list);
        String[]   descriptionList =res.getStringArray(R.array.pokemon_descriptions);
        int[] imageList = {
                R.drawable.pikachu,
                R.drawable.gengar,
                R.drawable.raichu,
                R.drawable.bulbasaur,
                R.drawable.charizard,
                R.drawable.greninja,
                R.drawable.squirtle,
                R.drawable.lucario,
                R.drawable.snorlax,
                R.drawable.eevee
        };


        CustomListItem customAdapter = new CustomListItem(this, pokemonList, descriptionList, imageList);

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener((list, v, position, id) -> {
            String close = "Okay";
            Adapter listAdapter = list.getAdapter();
            String value = listAdapter.getItem(position).toString();
            String message = value + " at position " + (position + 1) + " with id " + id;
            GenerelUtil.showMySnack(rootLayout, message, close);
        });
    }
}
