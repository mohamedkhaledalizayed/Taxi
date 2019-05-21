package smile.algeria.khadamet.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import smile.algeria.khadamet.R;

public class AddNewVehicleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_vehicle);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add a new Vehicle");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
    }
}
