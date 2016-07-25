package stanlee.project.com.hymns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageButton;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

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
                        .baseUrl("https://api.github.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                IHymnBook webservice = retrofit.create(IHymnBook.class);
                Call<List<String>> theList = webservice.getRepoList("octocat");
                theList.enqueue(new Callback<List<String>>() {
                    @Override
                    public void onResponse(Call<List<String>> call, Response<List<String>> response) {
                        Log.d("Response Code--------->",response.code()+"");
                        Log.d("Response List--------->",new Gson().toJson(response.body()));
                    }

                    @Override
                    public void onFailure(Call<List<String>> call, Throwable t) {
                        Log.d("Exception Occureeed---","Exception");
                    }
                });


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
