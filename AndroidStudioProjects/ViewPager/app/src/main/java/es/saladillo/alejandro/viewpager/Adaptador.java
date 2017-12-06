package es.saladillo.alejandro.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Alejandro on 27/01/2017.
 */

public class Adaptador extends FragmentPagerAdapter {

    private ArrayList<Fragment> mFragmentos = new ArrayList<>();

    public Adaptador(FragmentManager fm) {
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
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Página" + (position + 1);
    }
}
