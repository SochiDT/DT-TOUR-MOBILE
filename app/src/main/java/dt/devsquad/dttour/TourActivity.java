package dt.devsquad.dttour;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TourActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<String> nameEquip = new ArrayList<>();
    List<Map<String, String>> data = new ArrayList<Map<String, String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);

        Bundle arguments = getIntent().getExtras();
        final Card card;
        if(arguments!=null){
            card = (Card) arguments.getSerializable(Card.class.getSimpleName());
        }else {
            card = new Card("pizdec","nahui","blyat",new JSONObject());
            card.setUrl("https://dt-tour.tk/api/v2/Api.php?apicall=gettour&id=2");
        }
        nameEquip.add("Загрузка...");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view2);
        navigationView.setNavigationItemSelectedListener(this);

        final ListView listViewMenu = this.findViewById(R.id.listCity);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nameEquip);
        listViewMenu.setAdapter(adapter);

        new JsonUrlReader(listViewMenu,"https://dt-tour.tk/api/v2/Api.php?apicall=gettourcal&id=",this,R.layout.list_card2,1000,265).execute(card.getUrl(),"");

        listViewMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                Card card = (Card)listViewMenu.getItemAtPosition(position);
                Intent intent =new Intent(TourActivity.this, InfoActivity.class);
                intent.putExtra(Card.class.getSimpleName(), card);
                startActivity(intent);
            }
        });
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout2);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
