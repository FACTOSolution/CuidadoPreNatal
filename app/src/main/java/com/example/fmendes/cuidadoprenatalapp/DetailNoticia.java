package com.example.fmendes.cuidadoprenatalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fmendes.cuidadoprenatalapp.controller.core.Noticia;

public class DetailNoticia extends AppCompatActivity {

    private TextView tituloNoticia;
    private TextView descricaoNoticia;
    private ImageView imgNoticia;

    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_noticia);


        tituloNoticia = (TextView) findViewById(R.id.itulo_detail_noticia_textview);
        descricaoNoticia = (TextView) findViewById(R.id.descricao_noticia_textview);
        imgNoticia = (ImageView) findViewById(R.id.noticia_detail_imageview);


        Intent intent = getIntent();
        int position = intent.getIntExtra(ListNoticias.POSITION_NOTICIA, 0);

        Noticia noticia = ListNoticias.arrayNoticia.get(position);

        tituloNoticia.setText(noticia.getTitulo());
        descricaoNoticia.setText(noticia.getDescricao());
        imgNoticia.setImageResource(noticia.getImg());

        setUpToolbat();
    }

    public void setUpToolbat(){

        toolbar = (Toolbar) findViewById(R.id.toolbar_detail);
        toolbar.setTitle(getResources().getString(R.string.title_activity_detail_noticia));

        setSupportActionBar(toolbar);
       // getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().show();




    }
}
