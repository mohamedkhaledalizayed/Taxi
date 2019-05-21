package smile.algeria.khadamet.view.adapters;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import smile.algeria.khadamet.R;
import smile.algeria.khadamet.databinding.OrderItemBinding;
import smile.algeria.khadamet.view.interfaces.IOrderHandler;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {

    private List<String> recentList;
    private Context context;
    private LayoutInflater layoutInflater;
    private IOrderHandler handler;
    public OrderAdapter(Context context, List<String> recentList) {
        this.recentList = recentList;
        this.context=context;
        this.handler = (IOrderHandler) context;
    }

    @Override
    public OrderAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater==null){
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        OrderItemBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.order_item, parent, false);


        return  new OrderAdapter.MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(final OrderAdapter.MyViewHolder holder, final int position) {

        holder.binding.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.onClick();
            }
        });

        holder.binding.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.onAcceptClick();
            }
        });

        holder.binding.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.onCancelClick();
            }
        });

        holder.binding.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.onCallClick();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 25;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        OrderItemBinding binding;
        public MyViewHolder(OrderItemBinding view) {
            super(view.getRoot());
            this.binding = view;
        }
    }

}