package stanlee.project.com.hymns.HymnMenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import stanlee.project.com.hymns.R;
import stanlee.project.com.hymns.dataTransaction.Settings;

public class Setting extends AppCompatActivity {

    Spinner textSize;
    Spinner fontStyle;
    Spinner themeColor;
    SpinnerAdapter adapter;

    String selectedTheme, selectedFontStyle, selectedTextSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        textSize = (Spinner) findViewById(R.id.textsizes);
        fontStyle = (Spinner) findViewById(R.id.styles);
        themeColor = (Spinner) findViewById(R.id.themes);

        Settings s = Settings.findById(Settings.class,1);

        textSize.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedTextSize = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"The selected Theme is "+selectedTextSize,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        fontStyle.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedFontStyle = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"The selected Theme is "+selectedFontStyle,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"Nothing was selected",Toast.LENGTH_LONG).show();
            }
        });

        themeColor.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               selectedTheme = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"The selected Theme is "+selectedTheme,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"Nothing was selected",Toast.LENGTH_LONG).show();
            }
        });
    }

}

