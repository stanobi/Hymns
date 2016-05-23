package stanlee.project.com.hymns;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class main_hymn_activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 2;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;
    private int number;
    private Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hymn_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        Intent intent = new Intent(this,SearchDialog.class);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(main_hymn_activity.this,SearchDialog.class));
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new main_hymn_activityPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        number = getIntent().getIntExtra("userHymnNumber",1);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(mPager);

        setActionBarTitle("HYMN "+number);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                hymn_screen hymnScreen = (hymn_screen)mPager.getAdapter().instantiateItem(mPager,position);
                hymnScreen.setHymnContent(ApplicationSession.getInstance().getEnglishHymns().get(number-1));
                if(position == 0){
                    setActionBarTitle("HYMN "+number);
//                    hymnScreen.setHymnContent(hymnScreen.getEnglishHymn(number));
                    hymnScreen.setHymnContent(ApplicationSession.getInstance().getEnglishHymns().get(number-1));
                }else{
                    setActionBarTitle("HYMN "+number);
                    //hymnScreen.setHymnContent(hymnScreen.getEfikHymn(number));
                    hymnScreen.setHymnContent(ApplicationSession.getInstance().getEfikHymns().get(number-1));
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_hymn_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            startActivity(new Intent(main_hymn_activity.this,SettingsActivity.class));
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Hymn) {
            // Handle the camera action
//        } else if (id == R.id.nav_Setting) {
//            startActivity(new Intent(main_hymn_activity.this,SettingsActivity.class));
        } else if (id == R.id.nav_About) {
            startActivity(new Intent(main_hymn_activity.this,AboutActivity.class));
        } else if (id == R.id.nav_Help) {
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{"success4stan@gmail.com"});
            emailIntent.putExtra(Intent.EXTRA_CC,new String[]{"cjajomiwe@gmail.com"});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT,"The Hymn Book "+BuildConfig.VERSION_NAME);
            emailIntent.setType("message/rfc82");
            startActivity(Intent.createChooser(emailIntent,"Send Email Using ...."));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    private class main_hymn_activityPagerAdapter extends FragmentPagerAdapter {

        private String tabTitles[] = new String[] { "English", "Efik" };
        private Context context;

        public main_hymn_activityPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = new hymn_screen();
            Bundle bundle = new Bundle();
            bundle.putInt("hymnNumber",number);
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];
        }
    }
}
