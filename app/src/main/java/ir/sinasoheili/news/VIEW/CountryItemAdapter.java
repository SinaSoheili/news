package ir.sinasoheili.news.VIEW;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ir.sinasoheili.news.MODEL.CountryCount;
import ir.sinasoheili.news.R;

public class CountryItemAdapter extends RecyclerView.Adapter<CountryItemAdapter.CountryItemAdapter_ViewHolder>
{
    private ArrayList<CountryCount> allItem;

    public CountryItemAdapter(ArrayList<CountryCount> allItem)
    {
        this.allItem = allItem;
    }

    @NonNull
    @Override
    public CountryItemAdapter_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item , null , false);
        CountryItemAdapter_ViewHolder holder = new CountryItemAdapter_ViewHolder(v);
        return holder;
    }

    @Override
    public int getItemCount()
    {
        return allItem.size();
    }

    @Override
    public void onBindViewHolder(@NonNull CountryItemAdapter_ViewHolder holder, int position)
    {
        holder.fill(allItem.get(position));
    }

    protected class CountryItemAdapter_ViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView iv_flag_country;
        private TextView tv_country;
        private TextView tv_source_count;

        public CountryItemAdapter_ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            iv_flag_country = itemView.findViewById(R.id.iv_flag_country);
            tv_country = itemView.findViewById(R.id.tv_country);
            tv_source_count = itemView.findViewById(R.id.tv_country_source_count);
        }

        public void fill(CountryCount cc)
        {
            tv_country.setText(cc.getCountryName());
            tv_source_count.setText(String.valueOf(cc.getCount()));
        }
    }
}
