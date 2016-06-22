package stanlee.project.com.hymns.dataTransaction;

import com.orm.SugarRecord;

/**
 * Created by Seamfixer on 6/21/2016.
 */
public class settings extends SugarRecord {

    String fontType;
    int fontSize;
    String themeColor;

    public settings(){

    }

    public settings(String fontType, int fontSize, String themeColor){
        this.fontType = fontType;
        this.fontSize = fontSize;
        this.themeColor = themeColor;
    }
}

