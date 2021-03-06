package com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed;


import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.api.DatosApi;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.JSONResponse;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.Planes;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceplanes.models.PlanesAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlanesFragment extends Fragment {

    private Retrofit retrofit;
    //private DataAdapter planes;
   // private RecyclerView recyclerView;
    private int ofset;
    private boolean cargar;
    private RecyclerView recyclerView;
    private ArrayList<Planes> data;
    private ArrayList<Planes> data2;
    private PlanesAdapter adapter;
    private PlanesAdapter adapter2;
    private FragmentActivity myContext;
    private TextView t1;
    TextView ti;
    SwipeRefreshLayout swipeRefreshLayout;

    public PlanesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_planes, container, false);
        swipeRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.Swipeplanes);

        Explode explode =new Explode();
        getActivity().getWindow().setExitTransition(explode);
        getActivity().getWindow().setAllowEnterTransitionOverlap(false);


        recyclerView = (RecyclerView)view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();


        return view;

    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://181.62.161.60")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DatosApi request = retrofit.create(DatosApi.class);
        Call<JSONResponse> call = request.getJSON();
        call.enqueue(new Callback<JSONResponse>() {
            @Override
            public void onResponse(Call<JSONResponse> call, Response<JSONResponse> response) {

                JSONResponse jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapter = new PlanesAdapter(data, getContext(),myContext,swipeRefreshLayout);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }

    public int numero(View view)
    {

        adapter2 = new PlanesAdapter(data2, getContext(), myContext, swipeRefreshLayout);
        return adapter2.nuevo(view,myContext,getContext());
    }

}
