package smile.algeria.khadamet.view.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import smile.algeria.khadamet.HistoryPaymentAdapter;
import smile.algeria.khadamet.R;
import smile.algeria.khadamet.databinding.ActivityNotificationBinding;
import smile.algeria.khadamet.view.adapters.NotificationAdapter;

public class NotificationActivity extends AppCompatActivity {

    private ActivityNotificationBinding binding;
    private NotificationAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_notification);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Notifications");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        mAdapter = new NotificationAdapter(this,new ArrayList<String>());
        binding.notificationRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.notificationRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.notificationRecycler.setAdapter(mAdapter);
    }
}
