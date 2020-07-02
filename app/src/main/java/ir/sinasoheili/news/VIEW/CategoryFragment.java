package ir.sinasoheili.news.VIEW;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import ir.sinasoheili.news.MODEL.CategoryCount;
import ir.sinasoheili.news.PRESENTER.CategoryFragmentContract;
import ir.sinasoheili.news.PRESENTER.CategoryFragmentPresenter;
import ir.sinasoheili.news.R;

public class CategoryFragment extends Fragment implements CategoryFragmentContract.CategoryFragmentContract_view
{
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private CategoryFragmentContract.CategoryFragmentContract_presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.category_fragment_layout , container , false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        InitObj(view);
    }

    @Override
    public void onStart()
    {
        super.onStart();

        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop()
    {
        super.onStop();

        EventBus.getDefault().unregister(this);
    }

    private void InitObj(View view)
    {
        presenter = new CategoryFragmentPresenter(getContext() , this);

        recyclerView = view.findViewById(R.id.RecyclerView_Category_Fragment);
        progressBar = view.findViewById(R.id.category_progressbar);
    }

    @Override
    public void showRecyclerView(ArrayList<CategoryCount> cc)
    {
        progressBar.setVisibility(View.GONE);

        CategoryItemAdapter adapter = new CategoryItemAdapter(cc);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext() , 2));

        LayoutAnimationController animator = AnimationUtils.loadLayoutAnimation(getContext() , R.anim.layout_list_item_anim);
        recyclerView.setLayoutAnimation(animator);

        recyclerView.setAdapter(adapter);
    }

    @Subscribe
    public void Result(Boolean b)
    {
        presenter.readAllCategory();
    }
}
