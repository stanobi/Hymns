package stanlee.project.com.hymns;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class searchSearch extends Fragment {

    private Button searchHymnButton;
    private EditText hymnNumberInputField;
    private Hymns hymns;

    public searchSearch() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_search_search, container, false);

        ((Hymns)getActivity()).getSupportActionBar().show();
        searchHymnButton = (Button) view.findViewById(R.id.searchButton);
        hymnNumberInputField = (EditText) view.findViewById(R.id.hymnNumber);
        searchHymnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), ScreenSlidePagerActivity.class);
                intent.putExtra("userHymnNumber",Integer.valueOf(hymnNumberInputField.getText().toString()));
                getActivity().startActivity(intent);
            }
        });

        return view;
    }

}
