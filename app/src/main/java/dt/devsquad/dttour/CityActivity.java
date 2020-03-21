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


        try {
            InputStream is = this.getAssets().open("db/equip.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            String bufferString = new String(buffer);
            JSONParser parser = new JSONParser();
            JSONArray a = (JSONArray) parser.parse(bufferString);

            cardDB = new CardDB(a);

        } catch (Exception e) {
            System.out.println(e);
        }


        String[] first = new String[] {"Москва", "Сочи","Рим","Нурсултан","Лас-Вегас"};
        String[] second = new String[] {"2 тура","3 тура","1 тур","2 тура","3 тура"};
        int[] value = new int[] {2,3,1,2,3};
        int[] image = new int[] {R.drawable.moscow, R.drawable.sochi, R.drawable.rim, R.drawable.nur, R.drawable.la};


        nameEquip.clear();
        for (int i = 0; i < first.length; i++)
            nameEquip.add(new Card(first[i],second[i],value[i],image[i]));


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ListView listViewMenu = this.findViewById(R.id.listCity);
        CardAdapter adapter = new CardAdapter(this,nameEquip,R.layout.list_card);
        listViewMenu.setAdapter(adapter);



        listViewMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                startActivity(new Intent(CityActivity.this, TourActivity.class));
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
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
