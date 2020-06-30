package ir.sinasoheili.news.VIEW;

import android.content.Intent;
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

    protected class CountryItemAdapter_ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private ImageView iv_flag_country;
        private TextView tv_country;
        private TextView tv_source_count;
        private CountryCount cc;

        public CountryItemAdapter_ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            iv_flag_country = itemView.findViewById(R.id.iv_flag_country);
            tv_country = itemView.findViewById(R.id.tv_country);
            tv_source_count = itemView.findViewById(R.id.tv_country_source_count);

            itemView.setOnClickListener(this);
        }

        public void fill(CountryCount cc)
        {
            this.cc = cc;
            tv_country.setText(cc.getCountryName());
            tv_source_count.setText(String.valueOf(cc.getCount()));
        }

        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent(v.getContext() , SourceList.class);

            intent.putExtra("COUNTRY_COUNT" , cc);

            v.getContext().startActivity(intent);
        }
    }
}
