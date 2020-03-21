package dt.devsquad.dttour;

import org.json.simple.JSONArray;

public class Card {
    String textFirst;
    String textSecond;
    int value;
    int id;
    JSONArray array;

    Card(String textFirst, String textSecond,int value, int id){
        this.textFirst = textFirst;
        this.textSecond = textSecond;
        this.value = value;
        this.id = id;
    }
}
