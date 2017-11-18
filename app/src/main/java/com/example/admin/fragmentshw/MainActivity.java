package com.example.admin.fragmentshw;


import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.admin.fragmentshw.fragments.CelebNamesFragment;
import com.example.admin.fragmentshw.fragments.CelebrityInfoFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CelebNamesFragment.OnFragmentInteractionListener{
    public static final String CELEBRITY_INFO_FRAG_TAG = "CelebrityInfoFragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listView);
        final ArrayList<String> celebList = new ArrayList<>();
        celebList.add("Kobe Bryant");
        celebList.add("Manu Ginobli");
        celebList.add("Greg Poppovich");
        celebList.add("Kawaii Leanord");
        celebList.add("Tim Duncan");
        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, celebList);
        listView.setAdapter(listAdapter);
        AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Log.d("MainActivity", "onItemClick for list of celebrity names: position is  " + position + " and id is " + id);
                String celebName = celebList.get(position);
                addCelebrityInfoFrag(celebName);

               // String category = categoryList.get(position);
                //ArrayList<Animal> animalList = new ArrayList<>();
                //animalList = myDB.getAnimalsFromCategoriesAsList(category);
                //goToAnimalsActivity(v, animalList);
            }
        };
        listView.setOnItemClickListener(mMessageClickedHandler);



    }
    private void addCelebrityInfoFrag(String name)
    {
        CelebrityInfoFragment blueFragment =
                CelebrityInfoFragment.newInstance(name, "");
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.animator.enter_from_left, R.animator.exit_to_right);
        ft.replace(R.id.celebrityInfo, blueFragment, CELEBRITY_INFO_FRAG_TAG)
            .addToBackStack(CELEBRITY_INFO_FRAG_TAG)
            .commit();
        /*
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.celebrityInfo, blueFragment, CELEBRITY_INFO_FRAG_TAG)
                .addToBackStack(CELEBRITY_INFO_FRAG_TAG)
                .commit(); */
    }
    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
