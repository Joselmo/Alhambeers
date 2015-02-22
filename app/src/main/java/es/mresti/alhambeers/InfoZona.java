package es.mresti.alhambeers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import es.mresti.alhambeers.animation.DepthPageTransformer;


public class InfoZona extends FragmentActivity  {


    ViewPager pager = null;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    MyFragmentPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        this.setContentView(R.layout.activity_info_zona);

        // Instantiate a ViewPager
        this.pager = (ViewPager) findViewById(R.id.pager);

        // Set a custom animation
        this.pager.setPageTransformer(true, new DepthPageTransformer());

        // Create an adapter with the fragments we show on the ViewPager
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(
                getSupportFragmentManager(),this);
        adapter.addFragment(ScreenSlidePageFragment.newInstance(1));
        adapter.addFragment(ScreenSlidePageFragment.newInstance(2));
        adapter.addFragment(ScreenSlidePageFragment.newInstance(3));
        adapter.addFragment(ScreenSlidePageFragment.newInstance(4));
        this.pager.setAdapter(adapter);



      /*  // Bind the title indicator to the adapter
        TitlePageIndicator titleIndicator = (TitlePageIndicator) findViewById(R.id.indicator);
        titleIndicator.setViewPager(pager);
        titleIndicator.setBackgroundColor(getResources().getColor(R.color.grey_900));
        titleIndicator.setFooterColor(getResources().getColor(R.color.blue_300));
*/
    }

    public void btnSiguiente (View v){
        Toast.makeText(this,"Siguiente",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext() ,ZonaActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);

    }

    @Override
    public void onBackPressed() {

        // Return to previous page when we press back button
        if (this.pager.getCurrentItem() == 0)
            super.onBackPressed();
        else
            this.pager.setCurrentItem(this.pager.getCurrentItem() - 1);

    }



}