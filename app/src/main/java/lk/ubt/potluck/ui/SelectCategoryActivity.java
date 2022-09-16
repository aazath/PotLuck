package lk.ubt.potluck.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import lk.ubt.potluck.R;

public class SelectCategoryActivity extends AppCompatActivity {

    String[] items = {"Rice and Curry", "Biryani","Short Eats","Breakfast","Dessert"};
    AutoCompleteTextView autocomplete_tv;
    ArrayAdapter<String> adapterItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_category);

        autocomplete_tv = findViewById(R.id.auto_complete_tv);
        adapterItems = new ArrayAdapter<String>(this,R.layout.category_list,items);
        autocomplete_tv.setAdapter(adapterItems);
        autocomplete_tv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), item, Toast.LENGTH_SHORT).show();
            }
        });
    }
}