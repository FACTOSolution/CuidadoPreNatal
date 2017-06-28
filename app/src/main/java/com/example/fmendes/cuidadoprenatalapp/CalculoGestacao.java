package com.example.fmendes.cuidadoprenatalapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;




/**
 * Created by Fmendes on 13/06/2017.
 */

public class CalculoGestacao extends AppCompatActivity{


    private Toolbar toolbar;

    private TextView descricao_calculo;
    private TextView titulo_calculo_gestacao;
    private TextView resultado_idade_gestacao;
    private TextView resultado_data_parto;
    private Button calcula_button;

    private EditText edit_text_Mens;
    private EditText edit_Text_Cons;

    private int mYear, mMonth, mDay, sYear, sMonth, sDay;
    private int cmYear, cmMonth, cmDay, csYear, csMonth, csDay;

    static final int DATE_ID = 0;
    static final int DATE_ID_2 = 1;

    java.util.Calendar C = java.util.Calendar.getInstance();
    java.util.Calendar C2 = java.util.Calendar.getInstance();

    public String data_escolhida_Mens;
    public String data_escolhida_Cons;

    public String data_parto;
    public String idade_gestacao;

    public Date data_atual;

    public long menstruacao, consulta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculo_gestacao);


        //Inicializando as datas de Menstruação
        sMonth = C.get(java.util.Calendar.MONTH);
        sYear = C.get(java.util.Calendar.YEAR);
        sDay = C.get(java.util.Calendar.DAY_OF_MONTH);

        //Inicializando as datas da Ultima Consulta
        csMonth = C2.get(java.util.Calendar.MONTH);
        csYear = C2.get(java.util.Calendar.YEAR);
        csDay = C2.get(java.util.Calendar.DAY_OF_MONTH);


        edit_text_Mens = (EditText) findViewById(R.id.edit_text_calendar_DUM);
        edit_Text_Cons = (EditText) findViewById(R.id.edit_text_calendar_DUC);



        edit_text_Mens.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                showDialog(DATE_ID);
            }
        });

        edit_Text_Cons.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                showDialog(DATE_ID_2);
            }
        });




        resultado_idade_gestacao = (TextView) findViewById(R.id.resultado_idade_gestacao);
        resultado_data_parto = (TextView) findViewById(R.id.resultado_data_parto);
        descricao_calculo = (TextView) findViewById(R.id.descricao_calculo);
        titulo_calculo_gestacao = (TextView) findViewById(R.id.titulo_calculo_gestacao);
        calcula_button = (Button) findViewById(R.id.calcula_button);


        calcula_button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                resultado_idade_gestacao.setText(idade_gestacao);
                resultado_data_parto.setText(data_parto);

            }

        });


        descricao_calculo.setText("A data da última menstruação corresponde ao primeiro dia de sangramento do último ciclo menstrual da mulher e serve de base para o cálculo da idade gestacional e data provável do parto.A idade gestacional é o tempo transcorrido da gravidez até a data atual.A data provável do parto é uma estimativa feita sobre o dia do parto.");
        titulo_calculo_gestacao.setText("Cálculo da Idade Gestacional e Data Provável do Parto.");

        setUpToolbat();

    }


    private DatePickerDialog.OnDateSetListener mDateSetListener =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    mYear = year;
                    mMonth = monthOfYear;
                    mDay = dayOfMonth;
                    colocar_fecha();

                }

            };

    private DatePickerDialog.OnDateSetListener mDateSetListener_2 =
            new DatePickerDialog.OnDateSetListener() {
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                    cmYear = year;
                    cmMonth = monthOfYear;
                     cmDay = dayOfMonth;
                    colocar_fecha_2();

                }

            };



    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_ID:
                return new DatePickerDialog(this, mDateSetListener, sYear, sMonth, sDay);

            case DATE_ID_2:
                return new DatePickerDialog(this,mDateSetListener_2, csYear, csMonth, csDay);


        }


        return null;
    }

    private void colocar_fecha() {

        data_escolhida_Mens = (mDay + "/" + (mMonth + 1) + "/" + mYear);
        edit_text_Mens.setText(data_escolhida_Mens);

        System.out.println("Primeira data Mens: " + data_escolhida_Mens);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date convertedDate_Mens = new Date();
        try {
            convertedDate_Mens = dateFormat.parse(data_escolhida_Mens);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Data Menstruação convertida:" + convertedDate_Mens);

        menstruacao = convertedDate_Mens.getTime();

        System.out.println("Long Menstruação convertida:" + menstruacao);

        calcula_Data_Parto();
    }

    private void colocar_fecha_2() {

        data_escolhida_Cons = (cmDay + "/" + (cmMonth + 1) + "/" + cmYear);
        edit_Text_Cons.setText(data_escolhida_Cons);

        System.out.println("Primeira data Cons: " + data_escolhida_Cons);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date convertedDate_Cons = new Date();
        try {
            convertedDate_Cons = dateFormat.parse(data_escolhida_Cons);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Data Consulta convertida:" + convertedDate_Cons);

        consulta = convertedDate_Cons.getTime();

        System.out.println("Long Consult convertida:" + consulta);



            long dias = (consulta - menstruacao) / (1000 * 60 * 60 * 24);
            int semanas = (int) dias / 7;
            int semanas_resto = (int) dias % 7;

            if((semanas >= 0) && (semanas_resto >= 0)) {

                idade_gestacao = ("Idade Gestação: " + semanas + " semanas" + " e " + semanas_resto + " dias");
            }else{
                idade_gestacao=("A data da última menstruação deve ser antes da consulta");
            }

            System.out.println("Data de Gestação: " + semanas + " semanas" + " e " + semanas_resto + " dias");

    }

    private void calcula_Data_Parto(){

        int day,month, year;
        int dia, mes, ano;

        //Se o mes for entre Janeiro e Março

        System.out.println("Mes escolhido: " + mMonth);

        if(mMonth >=0 && mMonth <= 2){

            System.out.println("Entrou no if:");

            day = mDay +7;

            month = mMonth;

            if(day > 31){
                day = day - 31;
                month = mMonth + 1;
            }
            month = month + 9;

            System.out.println("Mes é:" + month);

            year = 0;


            if(month > 11){

                System.out.println("CONDICAO DO MES SER MAIOR Q 12:");

                month = month - 12;
                year = 1;
            }
            year = year + mYear;

            data_parto = ("Previsão para Parto: " + day + "/" + (month + 1) + "/" + year);


        }else{

            day = mDay + 7;
            if(day > 31){
                day = day - 31;
                month = mMonth +1;
            }
            month = mMonth - 3;
            year = mYear+1;

            data_parto = ("Previsão para Parto: " + day + "/" + (month + 1) + "/" + year);
        }

        System.out.println("Data de Previsão do Parto:" + data_parto);


    }

    public void setUpToolbat(){

        toolbar = (Toolbar) findViewById(R.id.toolbar_calculo);
        toolbar.setTitle("Idade Gestacional e Data do Parto");

        setSupportActionBar(toolbar);
       // getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().show();




    }




}
