package com.example.co.com.revistaprotegemos.appprotegemos;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed.InicioFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed.PlanesFragment;
import com.example.co.com.revistaprotegemos.appprotegemos.fragmenttabbed.RevistaProtegemos;


/**
 * A simple {@link Fragment} subclass.
 */
public class PrincipalFragment extends Fragment {

    private AppBarLayout appBar;
    FragmentManager fragMan;
    private TabLayout tabs;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private ImageView logo;
    private Toolbar toolbar;
    private FragmentTabHost tabHost;
    private Button mib;
    public PrincipalFragment() {
        // Required empty public constructor
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_principal, container, false);
        View contenedor = (View) container.getParent();
        appBar = (AppBarLayout) contenedor.findViewById(R.id.appbar);
        toolbar = (Toolbar) contenedor.findViewById(R.id.toolbar);
        appBar.setBackgroundColor(Color.parseColor("#FFF9FBFB"));
        tabs = new TabLayout(getActivity());
        //tabs.setTabTextColors(Color.parseColor("#FF00BAD1"), Color.parseColor("#FF00BAD1"));
        appBar.addView(tabs);
        viewPager = (ViewPager) view.findViewById(R.id.pager);
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getFragmentManager());

        viewPager.setAdapter(pagerAdapter);
        tabs.setupWithViewPager(viewPager);
        //64

        //int icons[] = {R.drawable.ic_icons8_cas, R.drawable.ic_icons8_acuerdo_50, R.drawable.ic_icons8_agregar_regla_50};
        int icons[] = {R.drawable.ic_home_icon_silhouette, R.drawable.ic_signing_the_contract, R.drawable.ic_press_delivery_service};
        //int icons[] = {R.drawable.ic_home_icon_silhouette, R.drawable.ic_website, R.drawable.ic_folded_newspaper};
        //int icons[] = {R.drawable.ic_house, R.drawable.ic_website, R.drawable.ic_folded_newspaper};
        tabs.getTabAt(0).setIcon(icons[0]);
        tabs.getTabAt(1).setIcon(icons[1]);
        tabs.getTabAt(2).setIcon(icons[2]);

        iconcolor(tabs.getTabAt(tabs.getSelectedTabPosition()),"#3b5998");
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                iconcolor(tab,"#3b5998");

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

                iconcolor(tab,"#E0E0E0");
        }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //    ImageView logo= (ImageView)view.findViewById(R.id,i);
        //  logo.setImageResource(R.drawable.inicio);
        return view;
    }
private void iconcolor(TabLayout.Tab tab, String color)
{

    tab.getIcon().setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_IN);
}

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        appBar.removeView(tabs);
    }

    public static class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }


        //String tabtext=getResources().getStringArray(R.array.tabs);
        String[] tirulotabs = {"Inicio", "Inf", "NUestra"};

//String.valueOf(getResources().getDrawable(R.drawable.inicio))

        /**
         * Return the Fragment associated with a specified position.
         *
         * @param position
         */
        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new InicioFragment();
                case 1:
                    return new PlanesFragment();
                case 2:
                    return new RevistaProtegemos();

            }
            return null;
        }

        /**
         * Return the number of views available.
         */
        @Override
        public int getCount() {
            return 3;
        }

        /**
         * This method may be called by the ViewPager to obtain a title string
         * to describe the specified page. This method may return null
         * indicating no title for this page. The default implementation returns
         * null.
         *
         * @param position The position of the title requested
         * @return A title for the requested page
         */
        @Override
        public CharSequence getPageTitle(int position) {

   return null;

        }
        // return tirulotabs[position];

    }


    }




