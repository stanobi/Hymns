package stanlee.project.com.hymns.HymnMenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import stanlee.project.com.hymns.BuildConfig;
import stanlee.project.com.hymns.R;

public class About extends AppCompatActivity {

    private TextView version;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        version = (TextView)findViewById(R.id.versionNumner);
        version.setText("v"+ BuildConfig.VERSION_CODE+"");
    }
}
