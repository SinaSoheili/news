package ir.sinasoheili.news.VIEW;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import ir.sinasoheili.news.MODEL.Article;
import ir.sinasoheili.news.R;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ArticleListAdapter_viewHolder>
{
    private Context context;
    private Article[] items;

    public ArticleListAdapter(Context context , Article[] items)
    {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ArticleListAdapter_viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(context).inflate(R.layout.article_list_item , parent , false);
        ArticleListAdapter_viewHolder holder = new ArticleListAdapter_viewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleListAdapter_viewHolder holder, int position)
    {
        holder.fill(items[position]);
    }

    @Override
    public int getItemCount()
    {
        return items.length;
    }

    protected class ArticleListAdapter_viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        private TextView tv_title;
        private TextView tv_description;
        private TextView tv_date;

        private Article article;

        public ArticleListAdapter_viewHolder(@NonNull View itemView)
        {
            super(itemView);

            tv_title = itemView.findViewById(R.id.article_list_title);
            tv_date = itemView.findViewById(R.id.article_list_date);
            tv_description = itemView.findViewById(R.id.article_list_description);

            itemView.setOnClickListener(this);
        }

        public void fill(Article ar)
        {
            this.article = ar;

            tv_title.setText(ar.getTitle());
            String[] date = ar.getPublishedAt().split("T");
            tv_date.setText("published at : "+date[0]);
            tv_description.setText(ar.getDescription());
        }

        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent(v.getContext() , ArticleActivity.class);
            intent.putExtra("ARTICLE" , article);
            v.getContext().startActivity(intent);
        }
    }
}
