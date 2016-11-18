package stanlee.project.com.efikhymns;


import android.content.Intent;
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
                Intent intent = new Intent(getActivity(), main_hymn_activity.class);
                intent.putExtra("userHymnNumber",1);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        },3000L);
        return view;
    }


}
