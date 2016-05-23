package stanlee.project.com.hymns;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

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
