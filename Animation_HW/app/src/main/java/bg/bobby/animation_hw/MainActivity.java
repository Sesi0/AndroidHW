package bg.bobby.animation_hw;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import java.util.List;
import java.util.Vector;

public class MainActivity extends ActionBarActivity {

    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_pager);
        initialisePaging();
    }

    private void initialisePaging() {
        List<Fragment> fragments= new Vector<>();
        fragments.add(Fragment.instantiate(this,Fragment1.class.getName()));
        fragments.add(Fragment.instantiate(this,Fragment2.class.getName()));
        fragments.add(Fragment.instantiate(this,Fragment3.class.getName()));

        mPagerAdapter=new PageAdapter(this.getSupportFragmentManager(),fragments);
        ViewPager pager= (ViewPager) findViewById(R.id.viewpager);
        pager.setPageTransformer(true, new ZoomOutPageTransformer());
        pager.setAdapter(mPagerAdapter);
    }


}
