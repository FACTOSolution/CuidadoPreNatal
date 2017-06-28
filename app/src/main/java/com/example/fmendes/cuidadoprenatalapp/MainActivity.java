package com.example.fmendes.cuidadoprenatalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    public final static String POSITION_CATEGORY = "com.example.fmendes.cuidadoprenatal.POSITION_CATEGORY";

    public ImageView image1;
    public ImageView image2;
    public ImageView image3;
    public ImageView image4;
    public ImageView image5;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.categoria_listview);


        toolbar = (Toolbar) findViewById(R.id.toolbar_category);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.navigation_view);
        setUpToolbat();


       setUpNavDrawer();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(MenuItem menuItem){

                menuItem.setChecked(true);

                switch (menuItem.getItemId()){

                    case R.id.sobre:
                        Intent sobre = new Intent(getApplicationContext(), Sobre.class);
                        startActivity(sobre);
                        break;
                    case R.id.calculo:
                        Intent calculoGestacao = new Intent(getApplicationContext(), CalculoGestacao.class);
                        startActivity(calculoGestacao);
                        break;
                }

                return true;
            }

        });





        image1 = (ImageView) findViewById(R.id.categoria_1);
        image2 = (ImageView) findViewById(R.id.categoria_2);
        image3 = (ImageView) findViewById(R.id.categoria_3);
        image4 = (ImageView) findViewById(R.id.categoria_4);





    }

    public void onClick (View v){

           Intent listnoticia = new Intent(getApplicationContext(), ListNoticias.class);
        listnoticia.putExtra(POSITION_CATEGORY, v.getId());
        startActivity(listnoticia);
    }

    private void setUpToolbat(){

       // toolbar = (Toolbar) findViewById(R.id.toolbar_category);
        toolbar.setTitle(getResources().getString(R.string.app_name));

        setSupportActionBar(toolbar);
        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().show();

    }

    private void setUpNavDrawer(){

       // if(toolbar != null){


            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationIcon(R.drawable.ic_drawer);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    drawerLayout.openDrawer(GravityCompat.START);
                }
            });

       // }

    }



}
