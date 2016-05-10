package stanlee.project.com.hymns;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class hymn_screen extends Fragment {

    private TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8;
    private Resources resources;

    public hymn_screen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.fragment_hymn_screen, container, false);
        textView1 = (TextView) view.findViewById(R.id.number1);
        textView2 = (TextView) view.findViewById(R.id.number2);
        textView3 = (TextView) view.findViewById(R.id.number3);
        textView4 = (TextView) view.findViewById(R.id.number4);
        textView5 = (TextView) view.findViewById(R.id.number5);
        textView6 = (TextView) view.findViewById(R.id.number6);
        textView7 = (TextView) view.findViewById(R.id.number7);
        textView8 = (TextView) view.findViewById(R.id.number8);

        resources = getResources();
        setHymnContent(getEnglishHymn(getArguments().getInt("hymnNumber")));

        return view;
    }

    public void changeText(String values){
        textView1.setText(values);
    }

    /**
     * Set the hymn on the textView
     * @param hymns
     */
    public void setHymnContent(String[] hymns) {

            int counter = 1;
            for(Object hymn : hymns){
                if(counter == 1){
                    textView1.setText(hymn != null ? hymn.toString() : null);
                }
                if(counter == 2){
                    textView2.setText(hymn != null ? hymn.toString() : null);
                }
                if(counter == 3){
                    textView3.setText(hymn != null ? hymn.toString() : null);
                }
                if(counter == 4){
                    textView4.setText(hymn != null ? hymn.toString() : null);
                }
                if(counter == 5){
                    textView5.setText(hymn != null ? hymn.toString() : null);
                }
                if(counter == 6){
                    textView6.setText(hymn != null ? hymn.toString() : null);
                }
                if(counter == 7){
                    textView7.setText(hymn != null ? hymn.toString() : null);
                }
                if(counter == 8){
                    textView8.setText(hymn != null ? hymn.toString() : null);
                }
                counter++;
            }

    }

    public String[] getEnglishHymn(int hymnNumber){

        switch (hymnNumber){
            case 1:
                return resources.getStringArray(R.array.English_Hymn1);
            case 2:
                return resources.getStringArray(R.array.English_Hymn2);
            case 3:
                return resources.getStringArray(R.array.English_Hymn3);
            default:
                return resources.getStringArray(R.array.English_Hymn1);
        }
    }

    public String[] getEfikHymn(int hymnNumber){

        switch (hymnNumber){
            case 1:
                return resources.getStringArray(R.array.Efik_hymn1);
            case 2:
                return resources.getStringArray(R.array.Efik_hymn2);
            case 3:
                return resources.getStringArray(R.array.Efik_hymn3);
            default:
                return resources.getStringArray(R.array.Efik_hymn1);
        }
    }
}
