package smile.algeria.khadamet.view.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import smile.algeria.khadamet.R;
import smile.algeria.khadamet.databinding.NotificationItemLayoutBinding;


public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    private Context mContext;
    private List<String> historyList;
    private LayoutInflater layoutInflater;
    public NotificationAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.historyList = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        if (layoutInflater == null){
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }

        NotificationItemLayoutBinding layoutBinding =
                DataBindingUtil.inflate(layoutInflater, R.layout.notification_item_layout, viewGroup, false);

        return new NotificationAdapter.MyViewHolder(layoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 25;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        public NotificationItemLayoutBinding binding;
        public MyViewHolder(@NonNull NotificationItemLayoutBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
