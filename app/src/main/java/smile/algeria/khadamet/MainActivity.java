package smile.algeria.khadamet;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

import smile.algeria.khadamet.view.activities.HistoryActivity;
import smile.algeria.khadamet.view.activities.InviteFreiendActivity;
import smile.algeria.khadamet.view.activities.NotificationActivity;
import smile.algeria.khadamet.view.activities.OrderDetailsActivity;
import smile.algeria.khadamet.view.activities.SettingsActivity;
import smile.algeria.khadamet.view.adapters.OrderAdapter;
import smile.algeria.khadamet.view.interfaces.IOrderHandler;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener, IOrderHandler {

    private static final String TAG = "Tag";
    private DrawerLayout drawer;
    private Toolbar toolbar;
    private Switch aSwitch;
    private RecyclerView ordersRecyclerView;
    private OrderAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        final TextView textView = findViewById(R.id.toolbar_title);
        textView.setText("Offline");
        drawer = findViewById(R.id.drawer_layout);
        aSwitch = findViewById(R.id.switch_btn);
        ordersRecyclerView = findViewById(R.id.orders_recycler);
        mAdapter = new OrderAdapter(this,new ArrayList<String>());
        ordersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ordersRecyclerView.setItemAnimator(new DefaultItemAnimator());
        ordersRecyclerView.setAdapter(mAdapter);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    textView.setText("Online");
//                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }else {
                    textView.setText("Offline");
//                    sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            finish();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.my_wallet:
                startActivity(new Intent(MainActivity.this,MyWalletActivity.class));
                break;

            case R.id.history:
                startActivity(new Intent(MainActivity.this, HistoryActivity.class));
                break;

            case R.id.notification:
                startActivity(new Intent(MainActivity.this, NotificationActivity.class));
                break;

            case R.id.invite:
                startActivity(new Intent(MainActivity.this, InviteFreiendActivity.class));
                break;

            case R.id.setting:
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                break;

            case R.id.share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,
                        "Hey check out my app at: https://play.google.com/store/apps/details?id=com.google.android.apps.plus");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;

            case R.id.logout:

                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick() {
        startActivity(new Intent(this, OrderDetailsActivity.class));
    }

    @Override
    public void onCallClick() {
        call(this,"1234567890");
    }

    @Override
    public void onAcceptClick() {

    }

    @Override
    public void onCancelClick() {

    }

    public static void call(Context context, String number){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));
        try {
            context.startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//Functions with unlimited parameters //vararg
// val x: Int  get() = x + 1
//Enum ?