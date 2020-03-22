package dt.devsquad.dttour;

import org.json.simple.JSONArray;

import java.io.Serializable;

public class Card implements Serializable {
    String textFirst;
    String textSecond;
    int value;
    int id;
    private JSONArray array;

    Card(String textFirst, String textSecond,int value, int id){
        this.textFirst = textFirst;
        this.textSecond = textSecond;
        this.value = value;
        this.id = id;
    }

    public JSONArray getArray() {
        return array;
    }

    public void setArray(JSONArray array) {
        this.array = array;
    }
}
