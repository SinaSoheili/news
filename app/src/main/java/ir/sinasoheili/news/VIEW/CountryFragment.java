package ir.sinasoheili.news.VIEW;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
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

import ir.sinasoheili.news.MODEL.CountryCount;
import ir.sinasoheili.news.PRESENTER.CountryFragmentContract;
import ir.sinasoheili.news.PRESENTER.CountryFragmentPresenter;
import ir.sinasoheili.news.R;

public class CountryFragment extends Fragment implements CountryFragmentContract.CountryFragmentContract_view
{
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    private CountryFragmentContract.CountryFragmentContract_presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.country_fragment_layout , container , false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        InitObj(view);

        progressBar.setVisibility(View.VISIBLE);
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
        presenter = new CountryFragmentPresenter(getContext() , this);

        recyclerView = view.findViewById(R.id.RecyclerView_Country_Fragment);
        progressBar = view.findViewById(R.id.country_progressbar);
    }

    @Override
    public void showRecyclerView(ArrayList<CountryCount> cc)
    {
        progressBar.setVisibility(View.GONE);

        CountryItemAdapter adapter = new CountryItemAdapter(cc);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext() , 2));

        LayoutAnimationController animator = AnimationUtils.loadLayoutAnimation(getContext() , R.anim.grid_layout_list_item_anim);
        recyclerView.setLayoutAnimation(animator);

        recyclerView.setAdapter(adapter);
    }

    @Subscribe()
    public void Result(Boolean b)
    {
        presenter.readAllCountry();
    }
}
