package stanlee.project.com.hymns;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class searchSearch extends Fragment {

    private AppCompatImageButton searchHymnButton;
    private EditText hymnNumberInputField;
    private Hymns hymns;
    private int hymnValue;

    public searchSearch() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_search_search, container, false);

        ((Hymns)getActivity()).getSupportActionBar().show();
        searchHymnButton = (AppCompatImageButton) view.findViewById(R.id.searchButton);
        hymnNumberInputField = (EditText) view.findViewById(R.id.hymnNumber);
        searchHymnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent intent = new Intent(getActivity(), ScreenSlidePagerActivity.class);
                Intent intent = new Intent(getActivity(), main_hymn_activity.class);
                try{
                    hymnValue = Integer.valueOf(hymnNumberInputField.getText().toString());
                    if(hymnValue < 1 || hymnValue > 366){
                        Toast.makeText( getActivity(),"Invalid Hymn Number. Hymn number range from 1-369",Toast.LENGTH_LONG).show();
                    }else{
                        intent.putExtra("userHymnNumber",hymnValue);
                        getActivity().startActivity(intent);
                    }

                }catch (NumberFormatException ex){
                    Toast.makeText( getActivity(),"Invalid Hymn Number. Hymn number range from 1-369",Toast.LENGTH_LONG).show();
                }

            }
        });

        return view;
    }

}
