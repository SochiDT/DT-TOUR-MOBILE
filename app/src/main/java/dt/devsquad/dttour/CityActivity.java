package dt.devsquad.dttour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import java.io.InputStream;
import java.util.ArrayList;


public class CityActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    CardDB cardDB;
    ArrayList<Card> nameEquip = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        JSONArray a = null;
        try {
            InputStream is = this.getAssets().open("db/equip.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            String bufferString = new String(buffer);
            JSONParser parser = new JSONParser();
            a = (JSONArray) parser.parse(bufferString);
        } catch (Exception e) {
            System.out.println(e);
        }

        cardDB = new CardDB(a);
        nameEquip = cardDB.getCardSet();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final ListView listViewMenu = this.findViewById(R.id.listCity);
        CardAdapter adapter = new CardAdapter(this,nameEquip,R.layout.list_card);
        listViewMenu.setAdapter(adapter);


        listViewMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                Card card = (Card)listViewMenu.getItemAtPosition(position);
                Intent intent = new Intent(CityActivity.this, TourActivity.class);
                intent.putExtra(CardDB.class.getSimpleName(), cardDB);
                intent.putExtra(Card.class.getSimpleName(), card);
                startActivity(intent);
            }
        });
    }

    public CardDB getCardDB() {
        return cardDB;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_camera:{

            } case R.id.nav_gallery:{

            } case R.id.nav_slideshow:{

            } case R.id.nav_manage:{

            } case R.id.nav_share:{

            } case R.id.nav_send:{

            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
