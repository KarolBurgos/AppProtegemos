package com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed;


import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.co.com.revistaprotegemos.appprotegemos.Banner.CustomAdapter;
import com.example.co.com.revistaprotegemos.appprotegemos.IniciarSesion;
import com.example.co.com.revistaprotegemos.appprotegemos.PrincipalFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.R;
import com.example.co.com.revistaprotegemos.appprotegemos.Suscribete.SuscribeteActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.ViewPagerAdapter;
import com.example.co.com.revistaprotegemos.appprotegemos.WebViewAbrirPaginasUrl;
import com.example.co.com.revistaprotegemos.appprotegemos.settings.NuestraEmpresaActivity;
import com.example.co.com.revistaprotegemos.appprotegemos.validacionnohayinternet.ValidacionNoHayInternet;
import com.example.co.com.revistaprotegemos.appprotegemos.settings.SuscritosFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.api2.DatosApii;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.DataAdapterr;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.JSONResponsee;
import com.example.co.com.revistaprotegemos.appprotegemos.webserviceiniciopautas.models2.Pautas;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.api2.DatosApiii;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models.DataaAdapter;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models.JSOONResponse;
import com.example.co.com.revistaprotegemos.appprotegemos.webservicejornadas.models.Jornadas;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import pl.droidsonroids.gif.GifImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment {

    //Banner protegemos
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private  int dotscount;
    //B

    private ImageView[] dots;
    private RecyclerView recyclerView;
    private RecyclerView recyclerView2;
    private ArrayList<Pautas> data;
    private ArrayList<Jornadas> data2;
    private DataAdapterr adapter;
    private DataaAdapter adapter2;
    private ImageView imagen1,img2;
    private TextView t1,t2;
    private FragmentActivity myContext;
    private Button bsuscr,btn;
    private AdapterViewFlipper IVF;
    private String url;
    private TextView quienes_somos,visite,encontrara,jornada;
    private TextView tg1,nuestrosplanes,susc,somo,estaslisto,pautas;
    private Typeface Nuestrosplanes,Aurella;
    private ImageButton facebook,twitter;
    SwipeRefreshLayout swipeRefreshLayout;
    TextView textView;
    int number=0;
    public InicioFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context activity) {
        myContext=(FragmentActivity) activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        //Banner protegemos
/*        viewPager=(ViewPager)view.findViewById(R.id.viewPager);
        sliderDotspanel =(LinearLayout)view.findViewById(R.id.SliderDots);
        ViewPagerAdapter viewPagerAdapter =new ViewPagerAdapter(getContext());
        viewPager.setAdapter(viewPagerAdapter);

        dotscount =viewPagerAdapter.getCount();
        dots =new ImageView[dotscount];
        for (int i=0;i<dotscount; i++)
        {
            dots[i]=new ImageView(getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.nonactive_dot));
            LinearLayout.LayoutParams params =new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8,0,8,0);
            sliderDotspanel.addView(dots[i],params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i=0;i<dotscount;i++)
                {
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.nonactive_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer=new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),2000,4000);*/

        //Fin Banner protegemos


        facebook=(ImageButton)view.findViewById(R.id.facebook);
        twitter=(ImageButton)view.findViewById(R.id.twitter);
        swipeRefreshLayout=(SwipeRefreshLayout)view.findViewById(R.id.Swipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                NetworkInfo activeNetwork = ((ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
                if (activeNetwork != null && activeNetwork.isConnectedOrConnecting()) {

                    // Load Webview
                    Fragment fragment = null;
                    Class fragmentClass= PrincipalFragment.class;
                    try{
                        fragment = (Fragment) fragmentClass.newInstance();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    FragmentManager fragmentManager=myContext.getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.flContentt, fragment).commit();

                } else {

                    // Show No internet
                    Intent intent = new Intent(getActivity().getApplication(), ValidacionNoHayInternet.class);
                    startActivity(intent);

                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                },4000);
            }
        });

            recyclerView = (RecyclerView) view.findViewById(R.id.recyclerVieww);
            recyclerView.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
            recyclerView.setLayoutManager(layoutManager);
            loadJSONn();

            recyclerView2 = (RecyclerView) view.findViewById(R.id.recyclerVieew);
            recyclerView2.setHasFixedSize(true);
            /*GridLayoutManager gridLayoutManager2 = new GridLayoutManager(getActivity().getApplicationContext(), 2);
            recyclerView2.setLayoutManager(gridLayoutManager2);*/
            RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getActivity().getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
            recyclerView2.setLayoutManager(layoutManager2);
            loadJSON();


   /*          Bitmap obtener_imagen = get_imagen("http://www.revistaprotegemos.com.co/imagenesaplicativo/premia.png");
             //uImageView.setImageBitmap(obtener_imagen);
            Drawable d = new BitmapDrawable(getResources(), obtener_imagen);
            int drawableId = Integer.parseInt(d.toString());*/




            int images[] = {R.drawable.premia, R.drawable.drogueria, R.drawable.ips};
            String names[] = {"imagen1", "imagen2", "imagen3"};

        bsuscr=(Button)view.findViewById(R.id.btonsuscribirme);


        //Bannerconmovimiento
/*        IVF = (AdapterViewFlipper) view.findViewById(R.id.IVF);
        CustomAdapter custom = new CustomAdapter(myContext.getApplicationContext(), names, images);
        IVF.setAdapter(custom);
        IVF.setFlipInterval(5000);*/
        //IVF.setAutoStart(true);

        return view;
    }
    public void inter() {

    }
    private Bitmap get_imagen(String url) {
        Bitmap bm = null;
        try {
            URL _url = new URL(url);
            URLConnection con = _url.openConnection();
            con.connect();
            InputStream is = con.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (IOException e) {

        }
        return bm;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        bsuscr.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent=new Intent (getContext(),SuscribeteActivity.class);
                startActivity(intent);


            }
        });
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getContext(), WebViewAbrirPaginasUrl.class);
                myIntent.putExtra("direccion", "www.facebook.com/Grupo-Editorial-Protegemos-1810118702587250/?view_public_for=1810118702587250");
                startActivity(myIntent);
            }
        });
        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(getContext(), WebViewAbrirPaginasUrl.class);
                myIntent.putExtra("direccion", "twitter.com/citas_grupo");
                startActivity(myIntent);
            }
        });
    }

    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://181.62.161.60")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DatosApii request = retrofit.create(DatosApii.class);
        Call<JSONResponsee> call = request.getJSON();
        call.enqueue(new Callback<JSONResponsee>() {
            @Override
            public void onResponse(Call<JSONResponsee> call, Response<JSONResponsee> response) {

                JSONResponsee jsonResponse = response.body();
                data = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapter = new DataAdapterr(data,getContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<JSONResponsee> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }

    private void loadJSONn(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://181.62.161.60")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        DatosApiii request = retrofit.create(DatosApiii.class);
        Call<JSOONResponse> call = request.getJSON();
        call.enqueue(new Callback<JSOONResponse>() {
            @Override
            public void onResponse(Call<JSOONResponse> call, Response<JSOONResponse> response) {

                JSOONResponse jsonResponse = response.body();
                data2 = new ArrayList<>(Arrays.asList(jsonResponse.getAndroid()));
                adapter2 = new DataaAdapter(data2,getContext());
                recyclerView2.setAdapter(adapter2);
            }

            @Override
            public void onFailure(Call<JSOONResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }

    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

           /* getContext().this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    } else if(viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    } else {
                        viewPager.setCurrentItem(0);
                    }

                }
            });*/

        }
    }

}
