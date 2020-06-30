package ir.sinasoheili.news.VIEW;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ir.sinasoheili.news.MODEL.CategoryCount;
import ir.sinasoheili.news.R;

public class CategoryItemAdapter extends RecyclerView.Adapter<CategoryItemAdapter.CategoryItemAdapter_ViewHolder>
{
    private ArrayList<CategoryCount> allItem;

    public CategoryItemAdapter(ArrayList<CategoryCount> allItem)
    {
        this.allItem = allItem;
    }

    @NonNull
    @Override
    public CategoryItemAdapter_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item , null , false);
        CategoryItemAdapter_ViewHolder holder = new CategoryItemAdapter_ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryItemAdapter_ViewHolder holder, int position)
    {
        holder.fill(allItem.get(position));
    }

    @Override
    public int getItemCount()
    {
        return allItem.size();
    }

    protected class CategoryItemAdapter_ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView tv_category;
        private TextView tv_source_count;
        private CategoryCount cc;

        public CategoryItemAdapter_ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            tv_category = itemView.findViewById(R.id.tv_category);
            tv_source_count = itemView.findViewById(R.id.tv_category_source_count);

            itemView.setOnClickListener(this);
        }

        public void fill(CategoryCount cc)
        {
            this.cc = cc;
            tv_category.setText(cc.getCategory());
            tv_source_count.setText(String.valueOf(cc.getCount()));
        }

        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent(v.getContext() , SourceList.class);

            intent.putExtra("CATEGORY_COUNT" , cc);

            v.getContext().startActivity(intent);
        }
    }
}
