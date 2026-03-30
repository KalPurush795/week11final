package com.example.wek11final.utils;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wek11final.EntityAdapter;
import com.example.wek11final.models.SoccerEntity;
import com.example.wek11final.models.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * A custom iterator implementation specifically for traversing a list of Team objects.
 * Fulfills the requirement to use Java's Iterator pattern for data traversal.
 */
public class TeamIterator implements CustomIterator<Team> {
    private List<Team> teams;
    private int position;

    public TeamIterator(List<Team> teams) {
        this.teams = teams;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < teams.size();
    }

    @Override
    public Team next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Team team = teams.get(position);
        position++;
        return team;
    }

    public static class EntityFragment extends Fragment {
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
}