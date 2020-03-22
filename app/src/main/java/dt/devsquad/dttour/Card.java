package dt.devsquad.dttour;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.Serializable;

public class Card implements Serializable {
    String textFirst;
    String textSecond;
    //int value;
    String id;
    private String url;
    JSONObject array;

    Card(String textFirst, String textSecond, String id, JSONObject array) {
        this.textFirst = textFirst;
        this.textSecond = textSecond;
        //this.value = value;
        this.id = id;
        this.array = array;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
