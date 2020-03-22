package dt.devsquad.dttour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.simple.JSONObject;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Bundle arguments = getIntent().getExtras();
        final Card card;
        if(arguments!=null){
            card = (Card) arguments.getSerializable(Card.class.getSimpleName());
        }else {
            card = new Card("pizdec","nahui","blyat",new JSONObject());
            card.setUrl("https://dt-tour.tk/api/v2/Api.php?apicall=gettour&id=2");
        }

        Picasso.with(this).load(card.id).resize(1200, 300).centerCrop().into(((ImageView) findViewById(R.id.imageUrlEnd)));
        ((TextView) findViewById(R.id.textName)).setText(card.textFirst);
        ((TextView) findViewById(R.id.textAuthor)).setText((String)card.array.get("owner"));
        ((TextView) findViewById(R.id.textPeople)).setText((String)card.array.get("people"));
        ((TextView) findViewById(R.id.textMoney)).setText(card.textSecond);
        ((TextView) findViewById(R.id.textDate)).setText((String)card.array.get("datestart"));
        ((TextView) findViewById(R.id.textMarker)).setText((String)card.array.get("place"));
        ((TextView) findViewById(R.id.textKura)).setText((String)card.array.get("owner"));

    }

    public void onButtonLogin(View view){
        //startActivity(new Intent(StartActivity.this, CityActivity.class));
    }
}
