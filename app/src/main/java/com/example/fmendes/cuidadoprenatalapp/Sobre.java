package com.example.fmendes.cuidadoprenatalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fmendes.cuidadoprenatalapp.controller.core.Noticia;

public class Sobre extends AppCompatActivity {

    private TextView tituloNoticia;
    private TextView descricaoNoticia;


    public Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sobre);


        tituloNoticia = (TextView) findViewById(R.id.Cuidado_Pre_Natal);
        descricaoNoticia = (TextView) findViewById(R.id.descricao_sobre);



        tituloNoticia.setText("Cuidado Pré-Natal");
        descricaoNoticia.setText("Cuidado Pré-natal é um aplicativo com orientações destinadas as gestantes de baixo risco atendidas na atenção primária à saúde. O conteúdo disponibilizado resultou de pesquisas cientificas e manuais do Ministério da Saúde. É produto de uma dissertação de mestrado do Programa de Pós-graduação em Saúde da Mulher (PPGSM) da Universidade Federal do Piauí (UFPI) e foi desenvolvido em parceria com a FACTOS (Factory of Computational Solutions).");

        setUpToolbat();
    }

    public void setUpToolbat(){

        toolbar = (Toolbar) findViewById(R.id.toolbar_sobre);
        toolbar.setTitle("Sobre");

        setSupportActionBar(toolbar);
        // getSupportActionBar().setHomeButtonEnabled(true);
        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().show();




    }
}
