package stanlee.project.com.efikhymns;

import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;

import stanlee.project.com.efikhymns.dataTransaction.Settings;

public class Hymns extends AppCompatActivity{

    ApplicationSession session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Database initialization
        Settings st = null;
        try{
            st  = Settings.first(Settings.class);
        }catch (SQLiteException sqlEx){
            Toast.makeText(this,"SqliteException Occured while trying to get Settings",Toast.LENGTH_LONG).show();
        }
        if(st == null){

            //insert default values
            st = new Settings("DEFAULT",18,"BLUE");
            st.save();
            ApplicationSession.getInstance().setSelectedFontStyle("DEFAULT");
            ApplicationSession.getInstance().setSelectedTextSize(18);
            ApplicationSession.getInstance().setSelectedTheme("BLUE");

        }else{
            ApplicationSession.getInstance().setSelectedFontStyle(st.getFontType());
            ApplicationSession.getInstance().setSelectedTextSize(st.getFontSize());
            ApplicationSession.getInstance().setSelectedTheme(st.getThemeColor());
        }

        //Setting the Theme
        if(ApplicationSession.getInstance().getSelectedTheme().equalsIgnoreCase("BLUE")){
            setTheme(R.style.MyMaterialTheme);
        }else{
            setTheme(R.style.MyMaterialThemeRed);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hymns);
        switchFragments(R.id.FragmentContainer,new SplashScreen());
        session = ApplicationSession.getInstance();
        ArrayList<String> efikHymns = ApplicationSession.loadHymns(this,"efikHymn.txt");
        ArrayList<String> englishHymns = ApplicationSession.loadHymns(this,"englishHymn.txt");
        session.setEfikHymns(efikHymns);
        session.setEnglishHymns(englishHymns);

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
