package stanlee.project.com.hymns;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import stanlee.project.com.hymns.webService.IHymnBook;

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
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://192.168.4.16:8090/testingWebService/webapi/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                IHymnBook webservice = retrofit.create(IHymnBook.class);
                Call<String> theString = webservice.getString();
                theString.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(getApplicationContext(),"Response Code--------->"+response.code(),Toast.LENGTH_LONG).show();
                        Toast.makeText(getApplicationContext(),"Response List--------->"+response.body(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                       Toast.makeText(getApplicationContext(),"Exception on "+t,Toast.LENGTH_LONG).show();
                    }
                });


//                Intent intent = new Intent(SearchDialog.this, main_hymn_activity.class);
//                try{
//                    hymnValue = Integer.valueOf(hymnNumberInputField.getText().toString());
//                    if(hymnValue < 1 || hymnValue > 366){
//                        Toast.makeText( SearchDialog.this,"Invalid Hymn Number. Hymn number range from 1-366",Toast.LENGTH_LONG).show();
//                    }else{
//                        intent.putExtra("userHymnNumber",hymnValue);
//                        startActivity(intent);
//                        finish();
//                    }
//
//                }catch (NumberFormatException ex){
//                    Toast.makeText(SearchDialog.this,"Invalid Hymn Number. Hymn number range from 1-366", Toast.LENGTH_LONG).show();
//                }

            }
        });
    }
}
