package stanlee.project.com.efikhymns.HymnMenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import stanlee.project.com.efikhymns.ApplicationSession;
import stanlee.project.com.efikhymns.R;
import stanlee.project.com.efikhymns.dataTransaction.Settings;

public class Setting extends AppCompatActivity {

    Spinner textSize;
    Spinner fontStyle;
    Spinner themeColor;
    Button okButton, cancelButton;
    Settings s = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        textSize = (Spinner) findViewById(R.id.textsizes);
        textSize.setSelection(getIndexFromElement(textSize.getAdapter(),ApplicationSession.getInstance().getSelectedTextSize()+""));

        fontStyle = (Spinner) findViewById(R.id.styles);
        fontStyle.setSelection(getIndexFromElement(fontStyle.getAdapter(),ApplicationSession.getInstance().getSelectedFontStyle()));

        themeColor = (Spinner) findViewById(R.id.themes);
        themeColor.setSelection(getIndexFromElement(themeColor.getAdapter(),ApplicationSession.getInstance().getSelectedTheme()));

        okButton = (Button)findViewById(R.id.OKbutton);
        cancelButton = (Button)findViewById(R.id.CANCELbutton);

       s = Settings.findById(Settings.class,1);

        textSize.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ApplicationSession.getInstance().setSelectedTextSize(Integer.parseInt(parent.getItemAtPosition(position).toString()));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        fontStyle.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ApplicationSession.getInstance().setSelectedFontStyle(parent.getItemAtPosition(position).toString());
                fontStyle.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        themeColor.setOnItemSelectedListener (new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               ApplicationSession.getInstance().setSelectedTheme(parent.getItemAtPosition(position).toString());
                themeColor.setSelection(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s.setFontSize(ApplicationSession.getInstance().getSelectedTextSize());
                s.setFontType(ApplicationSession.getInstance().getSelectedFontStyle());
                s.setThemeColor(ApplicationSession.getInstance().getSelectedTheme());
                s.save();
                Log.d("Saving Settings :","Selected Options saved into the database");

                Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public int getIndexFromElement(SpinnerAdapter adapter, String element) {
        for(int i = 0; i < adapter.getCount(); i++) {
            if(adapter.getItem(i).equals(element)) {
                return i;
            }
        }
        return 0;
    }

}

