package stanlee.project.com.hymns;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class SplashScreen extends Fragment {

    Handler splashScreenHandler;

    public SplashScreen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_splash_screen, container, false);
        ((Hymns)getActivity()).getSupportActionBar().hide();

        splashScreenHandler = new Handler();
        splashScreenHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ((Hymns)getActivity()).switchFragments(R.id.FragmentContainer,new searchSearch());
            }
        },3000L);
        return view;
    }


}
