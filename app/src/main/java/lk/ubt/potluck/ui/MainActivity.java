package lk.ubt.potluck.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import lk.ubt.potluck.R;
import lk.ubt.potluck.ui.fragments.HomeFragment;
import lk.ubt.potluck.ui.fragments.OrdersFragment;
import lk.ubt.potluck.ui.fragments.ProfileFragment;
import lk.ubt.potluck.ui.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bnvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnvMain = findViewById(R.id.bottom_navigation_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.flContent, new HomeFragment()).commit();

        bnvMain.setSelectedItemId(R.id.menu_item_home);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
                switch(item.getItemId()){
                    case R.id.menu_item_home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.menu_item_search:
                        fragment = new SearchFragment();
                        break;
                    case R.id.menu_item_orders:
                        fragment = new OrdersFragment();
                        break;
                    case R.id.menu_item_profile:
                        fragment = new ProfileFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.flContent, fragment).commit();
        return true;
    }
}