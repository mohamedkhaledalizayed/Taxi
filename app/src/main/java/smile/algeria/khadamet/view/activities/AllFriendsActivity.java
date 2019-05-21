package smile.algeria.khadamet.view.activities;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import smile.algeria.khadamet.R;
import smile.algeria.khadamet.databinding.ActivityAllFriendsBinding;

public class AllFriendsActivity extends AppCompatActivity {

    private ActivityAllFriendsBinding binding;
    private final static int PERMISSION_REQEST_CODE = 101;
    private List<String> contacts = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_all_friends);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Invite Friends");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        /*
         * Android x
         * Dagger 2
         * RX
         * ConstraintLayout
         * Android Profiler
         * Break Point
         * */

        showContacts();
    }

    private void showContacts() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS},PERMISSION_REQEST_CODE);
        }else {
//            List<String> names = getContacts();
            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,contacts);
            binding.listContacts.setAdapter(adapter);
            getContacts();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQEST_CODE && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            showContacts();
        }else {
            Toast.makeText(this,"Accept Permissions First", Toast.LENGTH_LONG).show();
        }
    }

    private void getContacts(){

        ContentResolver resolver = getContentResolver();
        Cursor cursor = resolver.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null);

        if (cursor.moveToFirst()){
            do{
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                contacts.add(name);
            }while (cursor.moveToNext());
        }
        adapter.notifyDataSetChanged();

        cursor.close();
    }
}