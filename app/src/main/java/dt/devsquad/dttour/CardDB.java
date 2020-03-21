package dt.devsquad.dttour;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CardDB {
    ArrayList<Card> cardSet = new ArrayList<>();
    String[] textFirst;
    String[] textSecond;
    int[] value;
    int[] id;
    Map<String, Integer> map = new HashMap<>();

    CardDB(JSONArray array){
        map.put("moscow",R.drawable.moscow);
        map.put("sochi",R.drawable.sochi);
        map.put("rim",R.drawable.rim);
        map.put("nur",R.drawable.nur);
        map.put("la",R.drawable.la);
        map.put("trip",R.drawable.trip);
        map.put("alcho",R.drawable.alcho);

        cardSet.clear();
        for (Object o : array) {
            org.json.simple.JSONObject equip = (JSONObject) o;
            cardSet.add(new Card((String) equip.get("first"),(String) equip.get("second"),(Integer) equip.get("value"),map.get((String) equip.get("image"))));
        }

//        for (int i = 0; i < textFirst.length; i++){
//            cardSet.add(i,new Card(textFirst[i],textSecond[i],value[i],id[i]));
//        }
    }

    private ArrayList<String> jsToArray(JSONArray mat) {
        ArrayList<String> matArray = new ArrayList<>();
        for (Object m : mat) {
            matArray.add((String) m);
        }
        return matArray;
    }
}
