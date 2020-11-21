package ir.sinasoheili.news.VIEW;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import ir.sinasoheili.news.MODEL.CategoryCount;
import ir.sinasoheili.news.MODEL.CountryCount;
import ir.sinasoheili.news.PRESENTER.ChooseFragmentContract;
import ir.sinasoheili.news.PRESENTER.ChooseFragmentPresenter;
import ir.sinasoheili.news.R;

public class ChooseFragment extends Fragment implements ChooseFragmentContract.ChooseFragmentContractView, View.OnClickListener {
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private FloatingActionButton fab;

    private ChooseFragmentContract.ChooseFragmentContractPresenter presenter;
    private int showWitch = 0; //0=country and 1=category

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.choose_fragment_layout , container , false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        initObj(view);

        progressBar.setVisibility(View.VISIBLE);
        readRequest();
    }

    @Override
    public void onResume()
    {
        super.onResume();

        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop()
    {
        super.onStop();

        EventBus.getDefault().unregister(this);
    }

    private void initObj(View view)
    {
        presenter = new ChooseFragmentPresenter(getContext() , this);

        this.progressBar = view.findViewById(R.id.choose_progressbar);
        this.recyclerView = view.findViewById(R.id.RecyclerView_choose_Fragment);

        this.fab = view.findViewById(R.id.choose_floating_button);
        fab.setOnClickListener(this);
    }

    @Override
    public void showCountry(ArrayList<CountryCount> cc)
    {
        progressBar.setVisibility(View.GONE);

        CountryItemAdapter adapter = new CountryItemAdapter(cc );
        recyclerView.setLayoutManager(new GridLayoutManager(getContext() , 2));

        LayoutAnimationController anim = AnimationUtils.loadLayoutAnimation(getContext() , R.anim.grid_layout_list_item_anim);
        recyclerView.setLayoutAnimation(anim);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showCategory(ArrayList<CategoryCount> cc)
    {
        progressBar.setVisibility(View.GONE);

        CategoryItemAdapter adapter = new CategoryItemAdapter(cc);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext() , 2));

        LayoutAnimationController anim = AnimationUtils.loadLayoutAnimation(getContext() , R.anim.grid_layout_list_item_anim);
        recyclerView.setLayoutAnimation(anim);

        recyclerView.setAdapter(adapter);
    }

    @Subscribe()
    public void Result(Boolean b)
    {
        if(b)
        {
            readRequest();
        }
    }

    private void readRequest() //request to presenter to show and get items
    {
        if(showWitch == 0)
        {
            presenter.readAllCountry();
        }
        else
        {
            presenter.readAllCategory();
        }
    }

    @Override
    public void onClick(View v)
    {
        if(v.equals(fab))
        {
            showChooseDialog();
        }
    }

    private void showChooseDialog()
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());

        String[] items = {"Country" , "Category"};
        dialog.setSingleChoiceItems(items, showWitch, new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                showWitch = which;
                readRequest();
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
