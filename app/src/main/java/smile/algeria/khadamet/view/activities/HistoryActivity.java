package smile.algeria.khadamet.view.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import smile.algeria.khadamet.R;
import smile.algeria.khadamet.databinding.ActivityHistoryBinding;
import smile.algeria.khadamet.view.adapters.HistoryAdapter;

public class HistoryActivity extends AppCompatActivity {

    private ActivityHistoryBinding binding;
    private Toolbar toolbar;
    private Date currentDate;
    private Calendar mCalendar;
    private DateFormat format;
    private HistoryAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_history);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);

        currentDate = new Date();
        format = new SimpleDateFormat("EEEE dd",new Locale("en"));
        binding.date.setText(format.format(currentDate));

        mCalendar = Calendar.getInstance();
        binding.incrDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalendar.add(Calendar.DATE,1);
                currentDate = mCalendar.getTime();
                binding.date.setText(format.format(currentDate));
            }
        });

        binding.decrDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCalendar.add(Calendar.DATE,-1);
                currentDate = mCalendar.getTime();
                binding.date.setText(format.format(currentDate));
            }
        });

        mAdapter = new HistoryAdapter(this,new ArrayList<String>());
        binding.historyRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.historyRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.historyRecycler.setAdapter(mAdapter);
    }
}
