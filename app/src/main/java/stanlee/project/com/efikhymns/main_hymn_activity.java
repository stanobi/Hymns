package stanlee.project.com.efikhymns;

import android.annotation.SuppressLint;
<<<<<<< HEAD:app/src/main/java/stanlee/project/com/efikhymns/main_hymn_activity.java
import android.app.Dialog;
=======
>>>>>>> 25a72b7eb7f22bff9364dbdbed7f874872afaba5:app/src/main/java/stanlee/project/com/hymns/main_hymn_activity.java
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
<<<<<<< HEAD:app/src/main/java/stanlee/project/com/efikhymns/main_hymn_activity.java
import android.net.Uri;
=======
>>>>>>> 25a72b7eb7f22bff9364dbdbed7f874872afaba5:app/src/main/java/stanlee/project/com/hymns/main_hymn_activity.java
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.vending.licensing.AESObfuscator;
import com.google.android.vending.licensing.LicenseChecker;
import com.google.android.vending.licensing.LicenseCheckerCallback;
import com.google.android.vending.licensing.ServerManagedPolicy;

import stanlee.project.com.efikhymns.HymnMenu.About;
import stanlee.project.com.efikhymns.HymnMenu.Setting;

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
    private LinearLayout linearLayout;
<<<<<<< HEAD:app/src/main/java/stanlee/project/com/efikhymns/main_hymn_activity.java

    private Handler mHandler;
    private LicenseChecker mChecker;
    private LicenseCheckerCallback mLicenseCheckerCallback;
    boolean licensed;
    boolean checkingLicense;
    boolean didCheck;

    private static final String BASE64_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkvs+LBNYJPuimDUuCOHun0rtaerglH2nDfZwxFaZK/LAsanJLtPS28gSf6OZUwODQ1NFukQ+4h2T7CiXWgPmmvJRVnoEbNtoUbx8Kirl3mxKlWWmfYT+DoGkzBZcqP3/3UjJzZDZHuOlE2TRySt4m4bRtVVyIL7/eQoERq9mALFXHFgtJOIk2OGRdDaicDgKhJLdm6mIcaMIFTEe3DC+qs2DFxr35mv033XKjaJaz6jmdb2p8MnSPJe43lNrcpshJT4PxKNv+jugaRkp3qMvCfEkWzQX6/SElmJ4IZKm/DQKFKTqv+bX6y9wSY0RR8LAghmYJ9eXgKrHoman34UbWwIDAQAB";
    private static final byte[] SALT = new byte[] {04,80,00,45,55,37,98,72,86,57,40,77,41,99,89,68,79,48,47,90};

=======
>>>>>>> 25a72b7eb7f22bff9364dbdbed7f874872afaba5:app/src/main/java/stanlee/project/com/hymns/main_hymn_activity.java

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Setting the Theme
        if(ApplicationSession.getInstance().getSelectedTheme().equalsIgnoreCase("BLUE")){
            setTheme(R.style.MyMaterialTheme_App);
        }else{
            setTheme(R.style.MyMaterialThemeRed_App);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.hymn_layout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

<<<<<<< HEAD:app/src/main/java/stanlee/project/com/efikhymns/main_hymn_activity.java
        //License start
        String deviceId = android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
        Log.i("Device Id", deviceId);

        mHandler = new Handler();
        mLicenseCheckerCallback = new MyLicenseCheckerCallback();
        mChecker = new LicenseChecker(this, new ServerManagedPolicy(this, new AESObfuscator(SALT, getPackageName(), deviceId)), BASE64_PUBLIC_KEY);
        doCheck();
        //License stop

=======
>>>>>>> 25a72b7eb7f22bff9364dbdbed7f874872afaba5:app/src/main/java/stanlee/project/com/hymns/main_hymn_activity.java
        NavigationView navigationView = (NavigationView)findViewById(R.id.nav_view);
        linearLayout = (LinearLayout) navigationView.getHeaderView(0).findViewById(R.id.Navigation_background);

        //Changing the backGround of the NavigationView
        if(ApplicationSession.getInstance().getSelectedTheme().equalsIgnoreCase("BLUE")){
            setBackgroundDrawable(linearLayout,ContextCompat.getDrawable(getApplicationContext(),R.drawable.flyingdove));
        }else{
            setBackgroundDrawable(linearLayout,ContextCompat.getDrawable(getApplicationContext(),R.drawable.redthemebackground));
        }


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

//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
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
            //Takes you the Main Hymn
        } else if (id == R.id.setting) {
            startActivity(new Intent(main_hymn_activity.this,Setting.class));
        } else if (id == R.id.nav_About) {
            startActivity(new Intent(main_hymn_activity.this,About.class));
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

    @SuppressLint({"NewApi"})
    public static void setBackgroundDrawable(View view, Drawable drawable) {
        int sdk = Build.VERSION.SDK_INT;
        if(sdk < 17) {
            view.setBackgroundDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }
<<<<<<< HEAD:app/src/main/java/stanlee/project/com/efikhymns/main_hymn_activity.java

    //License Start
    public void doCheck() {

        didCheck = false;
        checkingLicense = true;
        setProgressBarIndeterminateVisibility(true);

        mChecker.checkAccess(mLicenseCheckerCallback);
    }

    private class MyLicenseCheckerCallback implements LicenseCheckerCallback {

        @SuppressWarnings("Deprecated")
        @Override
        public void allow(int reason) {

            if (isFinishing()) {
                // Don't update UI if Activity is finishing.
                return;
            }
            // Should allow user access.
            Log.i("License","Accepted!");

            //You can do other things here, like saving the licensed status to a
            //SharedPreference so the app only has to check the license once.

            licensed = true;
            checkingLicense = false;
            didCheck = true;

        }

        @SuppressWarnings("Deprecated")
        @Override
        public void dontAllow(int reason) {

            if (isFinishing()) {
                // Don't update UI if Activity is finishing.
                return;
            }

            Log.i("License","Reason for denial: "+reason);

            //You can do other things here, like saving the licensed status to a
            //SharedPreference so the app only has to check the license once.

            licensed = false;
            checkingLicense = false;
            didCheck = true;

            showDialog(0);

        }

        @SuppressWarnings("Deprecated")
        @Override
        public void applicationError(int errorCode) {

            Log.i("License", "Error: " + errorCode);
            if (isFinishing()) {
                // Don't update UI if Activity is finishing.
                return;
            }
            licensed = true;
            checkingLicense = false;
            didCheck = false;

            showDialog(0);
        }

    }

    protected Dialog onCreateDialog(int id) {
        // We have only one dialog.
        return new AlertDialog.Builder(this)
                .setTitle("UNLICENSED HYMN BOOK.")
                .setMessage("This application is not licensed, please buy it from the play store.")
                .setPositiveButton("Buy", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent marketIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                                "http://market.android.com/details?id=" + getPackageName()));
                        startActivity(marketIntent);
                        finish();
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNeutralButton("Re-Check", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        doCheck();
                    }
                })

                .setCancelable(false)
                .setOnKeyListener(new DialogInterface.OnKeyListener() {
                    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                        Log.i("License", "Key Listener");
                        finish();
                        return true;
                    }
                })
                .create();

    }
    //License Stop

=======
>>>>>>> 25a72b7eb7f22bff9364dbdbed7f874872afaba5:app/src/main/java/stanlee/project/com/hymns/main_hymn_activity.java
}
