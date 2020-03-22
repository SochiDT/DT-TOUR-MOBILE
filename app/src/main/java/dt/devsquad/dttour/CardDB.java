package dt.devsquad.dttour;

import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class CardDB implements Serializable {
    private ArrayList<Card> cardSet = new ArrayList<>();
    private ArrayList<Card> tourSet = new ArrayList<>();
    private Map<String, Integer> map = new HashMap<>();

    CardDB(JSONArray array) {
        map.put("moscow", R.drawable.moscow);
        map.put("sochi", R.drawable.sochi);
        map.put("rim", R.drawable.rim);
        map.put("nur", R.drawable.nur);
        map.put("la", R.drawable.la);
        map.put("trip", R.drawable.trip);
        map.put("alcho", R.drawable.alcho);

        cardSet.clear();
        cardSet = createCardList(array);
    }

    @NotNull
    private ArrayList<Card> createCardList(@NotNull JSONArray array) {
        ArrayList<Card> cardSet = new ArrayList<>();
        for (Object o : array) {
            org.json.simple.JSONObject equip = (JSONObject) o;
            Card card = new Card((String) equip.get("first"), (String) equip.get("second"), Integer.parseInt((String) equip.get("value")), map.get((String) equip.get("image")));
            card.setArray((JSONArray) equip.get("array"));
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

    ArrayList<Card> getTourSet(JSONArray jsonArray) {
        tourSet.clear();
        return tourSet = createCardList(jsonArray);
    }

    ArrayList<Card> getCardSet() {
        return cardSet;
    }
}
