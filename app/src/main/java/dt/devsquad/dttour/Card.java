package dt.devsquad.dttour;

import org.json.simple.JSONArray;

import java.io.Serializable;

public class Card implements Serializable {
    String textFirst;
    String textSecond;
    //int value;
    String id;
    private String url;

    Card(String textFirst, String textSecond, String id) {
        this.textFirst = textFirst;
        this.textSecond = textSecond;
        //this.value = value;
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
