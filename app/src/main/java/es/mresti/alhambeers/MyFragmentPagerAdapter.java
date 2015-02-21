package es.mresti.alhambeers;

/**
 * Created by Jose on 21/02/2015.
 */
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    // List of fragments which are going to set in the view pager widget
    List<Fragment> fragments;
    private Context context;

    /**
     * Constructor
     *
     * @param fm
     *            interface for interacting with Fragment objects inside of an
     *            Activity
     */
    public MyFragmentPagerAdapter(FragmentManager fm,Context contexto) {
        super(fm);
        this.fragments = new ArrayList<Fragment>();
        context = contexto;
    }

    /**
     * Add a new fragment in the list.
     *
     * @param fragment
     *            a new fragment
     */
    public void addFragment(Fragment fragment) {
        this.fragments.add(fragment);
    }

    @Override
    public Fragment getItem(int arg0) {
        return this.fragments.get(arg0);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    /**
     *  Devuelve el numero de pagina
     * @param position numero de pagina
     * @return
     */
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";

        return title;
    }
}