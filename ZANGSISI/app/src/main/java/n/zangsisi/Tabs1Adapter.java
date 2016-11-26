package n.zangsisi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by CY on 2016. 11. 24..
 */

public class Tabs1Adapter extends RecyclerView.Adapter<Tabs1Adapter.MyViewHolder> {

    public List<Tabs1> tabs1List;
    OnItemClickListener mItemClickListener;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView items;

        public MyViewHolder(View view) {
            super(view);
            items = (TextView) view.findViewById(R.id.items);
            items.setOnClickListener(this);
        }

        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(itemView, getPosition());
            }
        }
    }

    public Tabs1Adapter(List<Tabs1> tabs1List) {
        this.tabs1List = tabs1List;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.tabs_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Tabs1 tabs1 = tabs1List.get(position);
        holder.items.setText(tabs1.getItems());
    }

    @Override
    public int getItemCount() {
        return tabs1List.size();
    }

}
