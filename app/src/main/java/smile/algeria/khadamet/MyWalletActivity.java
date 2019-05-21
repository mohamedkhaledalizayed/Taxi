package smile.algeria.khadamet;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import smile.algeria.khadamet.databinding.ActivityMyWalletBinding;

public class MyWalletActivity extends AppCompatActivity {

    private ActivityMyWalletBinding binding;
    private HistoryPaymentAdapter mAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_my_wallet);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        mAdapter = new HistoryPaymentAdapter(this,new ArrayList<String>());
        binding.historyPaymentRecycler.setLayoutManager(new LinearLayoutManager(this));
        binding.historyPaymentRecycler.setItemAnimator(new DefaultItemAnimator());
        binding.historyPaymentRecycler.setAdapter(mAdapter);

    }
}
