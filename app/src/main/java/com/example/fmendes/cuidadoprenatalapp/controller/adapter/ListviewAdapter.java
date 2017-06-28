package com.example.fmendes.cuidadoprenatalapp.controller.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fmendes.cuidadoprenatalapp.R;
import com.example.fmendes.cuidadoprenatalapp.controller.core.Noticia;

import java.util.ArrayList;

/**
 * Created by Fmendes on 31/05/2017.
 */

public class ListviewAdapter extends BaseAdapter {

    private ArrayList<Noticia> mData = new ArrayList<Noticia>();
    private LayoutInflater mInflater;

    public ListviewAdapter(Context context){

        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addItem(Noticia noticia){
        mData.add(noticia);
        notifyDataSetChanged();
    }

    public int getCount(){
        return mData.size();
    }

    public Noticia getItem(int position){
        return mData.get(position);
    }

    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertview, ViewGroup parent){

        ViewHolder holder = new ViewHolder();

        if(convertview == null){

            convertview = mInflater.inflate(R.layout.item__listview_main, null);

       //     holder.noticiaImageView = (ImageView) convertview.findViewById(R.id.noticia_imageview);
           // holder.autorImageview = (ImageView) convertview.findViewById(R.id.autor_imageview);
            holder.tituloNoticiaTextView = (TextView) convertview.findViewById(R.id.titulo_noticia_texview);
          //  holder.autorTextView = (TextView)convertview.findViewById(R.id.autor_textview);


            convertview.setTag(holder);
        }else {

            holder = (ViewHolder) convertview.getTag();


        }

       // holder.noticiaImageView.setImageResource(mData.get(position).getImg());
      //  holder.autorImageview.setImageResource(mData.get(position).getImagemAutor());
        holder.tituloNoticiaTextView.setText(mData.get(position).getTitulo());
       // holder.autorTextView.setText(mData.get(position).getAutor());


        return convertview;


    }

    public static class ViewHolder{

      //  public ImageView noticiaImageView;
    //    public ImageView autorImageview;
        public TextView tituloNoticiaTextView;
    //    public TextView autorTextView;

    }
}
