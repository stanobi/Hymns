package stanlee.project.com.hymns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SearchDialog extends AppCompatActivity {

    private AppCompatImageButton searchHymnButton;
    private EditText hymnNumberInputField;
    private Hymns hymns;
    private int hymnValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_dialog);
        searchHymnButton = (AppCompatImageButton) findViewById(R.id.searchButton);
        hymnNumberInputField = (EditText) findViewById(R.id.hymnNumber);
        searchHymnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent intent = new Intent(getActivity(), ScreenSlidePagerActivity.class);
                Intent intent = new Intent(SearchDialog.this, main_hymn_activity.class);
                try{
                    hymnValue = Integer.valueOf(hymnNumberInputField.getText().toString());
                    if(hymnValue < 1 || hymnValue > 366){
                        Toast.makeText( SearchDialog.this,"Invalid Hymn Number. Hymn number range from 1-366",Toast.LENGTH_LONG).show();
                    }else{
                        intent.putExtra("userHymnNumber",hymnValue);
                        startActivity(intent);
                        finish();
                    }

                }catch (NumberFormatException ex){
                    Toast.makeText(SearchDialog.this,"Invalid Hymn Number. Hymn number range from 1-366", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
