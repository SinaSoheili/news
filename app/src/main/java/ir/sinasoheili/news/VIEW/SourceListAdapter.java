package ir.sinasoheili.news.VIEW;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ir.sinasoheili.news.MODEL.Source;
import ir.sinasoheili.news.R;

public class SourceListAdapter extends RecyclerView.Adapter<SourceListAdapter.SourceListAdapter_viewHolder>
{
    private Context context;
    private ArrayList<Source> allItem;

    public SourceListAdapter(Context context , ArrayList<Source> allItem)
    {
        this.context = context;
        this.allItem = allItem;
    }

    @NonNull
    @Override
    public SourceListAdapter_viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(context).inflate(R.layout.source_list_item , parent , false);
        SourceListAdapter_viewHolder holder = new SourceListAdapter_viewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SourceListAdapter_viewHolder holder, int position)
    {
        holder.fill(allItem.get(position));
    }

    @Override
    public int getItemCount()
    {
        return allItem.size();
    }

    protected class SourceListAdapter_viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private Source source;
        private TextView tv_name;
        private TextView tv_category;
        private TextView tv_country;

        public SourceListAdapter_viewHolder(@NonNull View itemView)
        {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_source_name);
            tv_category = itemView.findViewById(R.id.tv_source_category);
            tv_country = itemView.findViewById(R.id.tv_source_country);

            itemView.setOnClickListener(this);
        }

        public void fill(Source source)
        {
            this.source = source;
            tv_name.setText(source.getName());
            tv_category.setText(source.getCategory());
            tv_country.setText(source.getCountry());
        }

        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent(v.getContext() , ArticleListActivity.class);
            intent.putExtra("SOURCE" , source);
            v.getContext().startActivity(intent);
        }
    }
}
