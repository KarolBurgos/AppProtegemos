package com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.ServiciosActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.WebViewAbrirPaginasUrl;
import com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed.ServiciosVentajasFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASPIRE VX15 on 2/05/2018.
 */

public class PlanesAdapter  extends RecyclerView.Adapter<PlanesAdapter.ViewHolderN > {
    private ViewGroup linearLayoutDetails;
    private ImageView imageViewExpand;
    private static final int DURATION = 250;

    SwipeRefreshLayout swipeRefreshLayout;
    private ArrayList<Planes> android;
    private Context context;
    private List<String> countries;
    private FragmentActivity myContext;

    private View view;
    private ArrayList<Planes> android2;
    private Context context2;
    private FragmentActivity myContext2;
    private AdapterView.OnItemClickListener escucha;
    private ServiciosVentajasFragment sv;

    public PlanesAdapter(ArrayList<Planes> android, Context context,FragmentActivity f,SwipeRefreshLayout swipeRefreshLayout) {
        this.android = android;
        this.context = context;
        this.escucha = escucha;
        this.myContext=f;
        this.swipeRefreshLayout=swipeRefreshLayout;
        //this.sv = pSv;
    }



    @Override
    public ViewHolderN onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);

        return new PlanesAdapter.ViewHolderN(view);
    }

    @Override
    public void onBindViewHolder(PlanesAdapter.ViewHolderN viewHolder, int i) {
        viewHolder.tit.setText(android.get(i).getTitulo());
        viewHolder.descr.setText(android.get(i).getDescripcion());
        viewHolder.id.setText(android.get(i).getidString());
        Glide.with(context)
                .load(android.get(i).getImg())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.img);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });

    }


    public class ViewHolderN extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tit, descr, id, leer;
        public ImageView img;
        RequestQueue rq;
        JsonRequest jrq;
        Button b1;
        private Typeface Ofaly,Color;
        TextView titu;
        private Context context1;
        private FragmentActivity myContext1;
        public ViewHolderN(View view) {
            super(view);

            img = (ImageView) view.findViewById(R.id.fotico);
            tit = (TextView) view.findViewById(R.id.txt2);
            descr = (TextView) view.findViewById(R.id.tv_version);
            id = (TextView) view.findViewById(R.id.idpla);
            b1=(Button)view.findViewById(R.id.button2);
            rq = Volley.newRequestQueue(context);

            b1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {


                    final String edi1 = id.getText().toString();
                    int ed=Integer.parseInt(edi1);

                    Intent myIntent = new Intent(context, ServiciosActivity.class);
                    myIntent.putExtra("param", edi1);
                    context.startActivity(myIntent);


                }
            });


        }

        @Override
        public void onClick(View view) {
        }
        public int obtenId()
        {
/*            String id_P=id.getText().toString();
            return id_P;*/

            return 3;
        }
    }

    public int  nuevo(View view,FragmentActivity f,Context context) {
        /*        viewHolder.tit.setText(android.get(i).getTitulo());
        viewHolder.descr.setText(android.get(i).getDescripcion());*/
       /*     ViewHolderN viewHolderN =new ViewHolderN(view,f,context);
           return  viewHolderN.obtenId();*/
        return  1;


    }
    public void cambiarId(int valor)
    {

    }

    public  int obtId()
    {

        int t = 2;

        return t;
    }
    @Override
    public int getItemCount() {
        return android.size();
    }




    public void setcountries(List<String> countries)
    {
        this.countries=countries;
        notifyDataSetChanged();
    }

    private void refresh()
    {
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
/*                android.add(0,android.get(new Random().nextInt(android.size())));*/
                PlanesAdapter.this.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        },1000);
    }


}




