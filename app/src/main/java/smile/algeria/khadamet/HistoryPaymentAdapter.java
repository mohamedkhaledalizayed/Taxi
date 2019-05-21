package smile.algeria.khadamet;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import smile.algeria.khadamet.databinding.HistoryPaymentLayoutBinding;

public class HistoryPaymentAdapter  extends RecyclerView.Adapter<HistoryPaymentAdapter.MyViewHolder> {

    private List<String> recentList;
    private Context context;
    private LayoutInflater layoutInflater;

    public HistoryPaymentAdapter(Context context, List<String> recentList) {
        this.recentList = recentList;
        this.context=context;
    }

    @Override
    public HistoryPaymentAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater==null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        HistoryPaymentLayoutBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.history_payment_layout, parent, false);


        return new HistoryPaymentAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final HistoryPaymentAdapter.MyViewHolder holder, final int position) {
    }

    @Override
    public int getItemCount() {
        return 25;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        HistoryPaymentLayoutBinding binding;
        public MyViewHolder(HistoryPaymentLayoutBinding view) {
            super(view.getRoot());
            this.binding = view;
        }
    }

}
