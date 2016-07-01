package stanlee.project.com.hymns;


import android.graphics.Typeface;
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

    private TextView textView1;

    public hymn_screen() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup view = (ViewGroup)inflater.inflate(R.layout.fragment_hymn_screen, container, false);
        textView1 = (TextView) view.findViewById(R.id.number1);
        textView1.setTextSize(ApplicationSession.getInstance().getSelectedTextSize());
        textView1.setTypeface(Typeface.create(ApplicationSession.getInstance().getSelectedFontStyle() ,Typeface.BOLD));
        setHymnContent(ApplicationSession.getInstance().getEnglishHymns().get(getArguments().getInt("hymnNumber")-1));
        return view;
    }

    public void changeText(String values){
        textView1.setText(values);
    }

    /**
     * Set the hymn on the textView
     * @param hymns
     */
    public void setHymnContent(String hymns) {

        textView1.setText(hymns != null ? hymns.replace("@","\n") : "Error Loading Hymn");
    }

}
