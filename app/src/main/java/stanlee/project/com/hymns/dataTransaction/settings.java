package stanlee.project.com.hymns.dataTransaction;

import com.orm.SugarRecord;

/**
 * Created by Seamfixer on 6/21/2016.
 */
public class Settings extends SugarRecord {

    private String fontType;
    private int fontSize;
    private String themeColor;

    public Settings(){

    }

    public Settings(String fontType, int fontSize, String themeColor){
        super();
        this.fontType = fontType;
        this.fontSize = fontSize;
        this.themeColor = themeColor;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontType() {
        return fontType;
    }

    public void setFontType(String fontType) {
        this.fontType = fontType;
    }

    public String getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(String themeColor) {
        this.themeColor = themeColor;
    }
}

