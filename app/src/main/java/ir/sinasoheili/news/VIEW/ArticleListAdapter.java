package ir.sinasoheili.news.VIEW;

import android.content.Context;
import android.text.Layout;
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

    protected class ArticleListAdapter_viewHolder extends RecyclerView.ViewHolder
    {
        private TextView tv_title;
        private TextView tv_author;
        private TextView tv_description;

        public ArticleListAdapter_viewHolder(@NonNull View itemView)
        {
            super(itemView);

            tv_title = itemView.findViewById(R.id.article_list_title);
            tv_author = itemView.findViewById(R.id.article_list_author);
            tv_description = itemView.findViewById(R.id.article_list_description);
        }

        public void fill(Article ar)
        {
            tv_title.setText(ar.getTitle());
            tv_author.setText(ar.getAuthor());
            tv_description.setText(ar.getDescription());
        }
    }
}
