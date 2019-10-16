package com.example.nuevomercadoabierto.view;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.example.nuevomercadoabierto.model.Articulo;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;

    public ViewPagerAdapter(FragmentManager fm, List<Articulo> articulosAMostrar) {
        super(fm);
        fragmentList = new ArrayList<>();
        for (Articulo articulo : articulosAMostrar) {
            FragmentDetalleArticuloOferta fragment = FragmentDetalleArticuloOferta.dameUnFragment(articulo);
            fragmentList.add(fragment);
        }
    }

    public ViewPagerAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }


}
