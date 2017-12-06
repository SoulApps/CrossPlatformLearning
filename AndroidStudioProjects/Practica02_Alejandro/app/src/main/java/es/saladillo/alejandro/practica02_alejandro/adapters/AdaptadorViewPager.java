package es.saladillo.alejandro.practica02_alejandro.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Alejandro on 27/01/2017.
 */

public class AdaptadorViewPager extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragmentos = new ArrayList<>();

    public AdaptadorViewPager(FragmentManager fm) {
        super(fm);
    }

    public void add(Fragment f) {
        mFragmentos.add(f);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentos.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0)
            return "Alumno";
        else
            return "Tutorías";
    }
}
