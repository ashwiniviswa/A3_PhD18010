package com.mobilecomp.viswa.a3_phd18010;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity implements DetailFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.detail_fragLayout);
        if (frag == null){
            frag = new DetailFragment();
        }
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.detail_fragLayout,frag);
        ft.commit();
        setContentView(R.layout.activity_detail);

    }

    @Override
    public void onFragmentInteraction(Uri uri){
        //you can leave it empty
    }


}
