package stanlee.project.com.hymns;

import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import stanlee.project.com.hymns.dataTransaction.Settings;

public class Hymns extends AppCompatActivity {
    ApplicationSession session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hymns);
        switchFragments(R.id.FragmentContainer,new SplashScreen());
        session = ApplicationSession.getInstance();
        ArrayList<String> efikHymns = ApplicationSession.loadHymns(this,"efikHymn.txt");
        ArrayList<String> englishHymns = ApplicationSession.loadHymns(this,"englishHymn.txt");
        session.setEfikHymns(efikHymns);
        session.setEnglishHymns(englishHymns);

        //Database initialization
        Settings st = null;
        try{
            st  = Settings.first(Settings.class);
        }catch (SQLiteException sqlEx){
            Log.d("SqLiteExce : ","SqliteException Occured while trying to get Settings");
            Toast.makeText(this,"SqliteException Occured while trying to get Settings",Toast.LENGTH_LONG).show();
        }
        if(st == null){
            Toast.makeText(this,"There is no setting.",Toast.LENGTH_LONG).show();
            //insert default values
            st = new Settings("Ludacris",10,"Blue");
            st.save();
            ApplicationSession.getInstance().setSelectedFontStyle("Ludacris");
            ApplicationSession.getInstance().setSelectedTextSize(10);
            ApplicationSession.getInstance().setSelectedTheme("Blue");

            Snackbar.make(null ,"Record inserted!!",Snackbar.LENGTH_LONG).show();

        }else{
            ApplicationSession.getInstance().setSelectedFontStyle(st.getFontType());
            ApplicationSession.getInstance().setSelectedTextSize(st.getFontSize());
            ApplicationSession.getInstance().setSelectedTheme(st.getThemeColor());
        }
    }

    public void switchFragments(int contentFrameId, android.support.v4.app.Fragment replacingFragment) {
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.abc_grow_fade_in_from_bottom,R.anim.abc_shrink_fade_out_from_bottom)
                .replace(contentFrameId, replacingFragment).commitAllowingStateLoss();
    }

    public void switchFragmentsAddToBackStack(int contentFrameId, android.support.v4.app.Fragment replacingFragment){
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.abc_grow_fade_in_from_bottom,R.anim.abc_shrink_fade_out_from_bottom)
                .replace(contentFrameId, replacingFragment)
                .addToBackStack(replacingFragment.getClass().getSimpleName())
                .commit();
    }



}
