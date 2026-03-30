package com.example.wek11final;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.wek11final.models.SoccerEntity;
import java.util.ArrayList;
import java.util.List;

public class EntityFragment extends Fragment {
    private RecyclerView recyclerView;
    private EntityAdapter adapter;
    private List<? extends SoccerEntity> dataList;

    public EntityFragment(List<? extends SoccerEntity> dataList) {
        this.dataList = dataList;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        recyclerView = new RecyclerView(requireContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new EntityAdapter(dataList != null ? dataList : new ArrayList<>());
        recyclerView.setAdapter(adapter);

        return recyclerView;
    }

    public void filterData(List<? extends SoccerEntity> filteredList) {
        if (adapter != null) {
            adapter.updateData(filteredList);
        }
    }
}