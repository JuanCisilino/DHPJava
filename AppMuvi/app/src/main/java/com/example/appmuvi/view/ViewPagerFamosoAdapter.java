package com.example.appmuvi.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.appmuvi.model.Famoso;
import com.example.appmuvi.model.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerFamosoAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> fragmentList;

    public ViewPagerFamosoAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

  /*  public ViewPagerFamosoAdapter(FragmentManager fm, List<Famoso> famosoAMostrar) {
        super(fm);
        fragmentList = new ArrayList<>();
        for (Famoso famoso: famosoAMostrar) {
            FragmentListaFamosos fragment = FragmentListaFamosos.dameUnFragment(famoso);
            fragmentList.add(fragment);
            
        }
    }*/

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
