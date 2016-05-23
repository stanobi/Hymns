package stanlee.project.com.hymns;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Seamfixer on 5/20/2016.
 */
public class ApplicationSession {
    ArrayList<String> englishHymns;
    ArrayList<String> efikHymns;
    private static ApplicationSession ourInstance = new ApplicationSession();

    public static ApplicationSession getInstance() {
        return ourInstance;
    }

    private ApplicationSession() {
    }

    public ArrayList<String> getEnglishHymns() {
        return englishHymns;
    }

    public void setEnglishHymns(ArrayList<String> englishHymns) {
        this.englishHymns = englishHymns;
    }

    public ArrayList<String> getEfikHymns() {
        return efikHymns;
    }

    public void setEfikHymns(ArrayList<String> efikHymns) {
        this.efikHymns = efikHymns;
    }

    public static ArrayList<String> loadHymns(Context context, String fileName){
        StringBuilder buf=new StringBuilder();
        ArrayList<String> hymnList = new ArrayList<>();
        InputStream json = null;
        try {
            json = context.getAssets().open(fileName);
            BufferedReader in= new BufferedReader(new InputStreamReader(json, "UTF-8"));
            String str;
            while ((str=in.readLine()) != null) {
//                buf.append();
                hymnList.add(str);
            }
            in.close();
            return hymnList;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
