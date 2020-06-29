package ir.sinasoheili.news.VIEW;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import ir.sinasoheili.news.PRESENTER.CategoryFragmentContract;
import ir.sinasoheili.news.R;

public class CategoryFragment extends Fragment implements CategoryFragmentContract.CategoryFragmentContract_view
{
    private RecyclerView recyclerView;

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

    private void InitObj(View view)
    {
        recyclerView = view.findViewById(R.id.RecyclerView_Category_Fragment);
    }
}
