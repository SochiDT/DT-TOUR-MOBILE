package dt.devsquad.dttour;

import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.Serializable;
import java.util.ArrayList;

class CardDB implements Serializable {
    private ArrayList<Card> cardSet = new ArrayList<>();
    String url;

    CardDB(String array,String url) {
        this.url = url;
        try {
            JSONParser parser = new JSONParser();
            JSONObject a = (JSONObject) parser.parse(array);
            JSONArray b = (JSONArray) a.get("stud");
            cardSet.clear();
            cardSet = createCardList(b);
        } catch (Exception e) { }
    }

    @NotNull
    private ArrayList<Card> createCardList(@NotNull JSONArray array) {
        ArrayList<Card> cardSet = new ArrayList<>();
        for (Object o : array) {
            org.json.simple.JSONObject equip = (JSONObject) o;
            Card card = new Card((String) equip.get("name"), (String) equip.get("numtour"), (String) equip.get("img"),equip);
            card.setUrl(url+equip.get("id"));
            if(card.id.getBytes().length>5)
            cardSet.add(card);
        }
        return cardSet;
    }

    @NotNull
    private ArrayList<String> jsToArray(@NotNull JSONArray mat) {
        ArrayList<String> matArray = new ArrayList<>();
        for (Object m : mat) {
            matArray.add((String) m);
        }
        return matArray;
    }

    ArrayList<Card> getCardSet() {
        return cardSet;
    }
}
