package com.example.wek11final;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.wek11final.repository.MatchRepository;
import com.example.wek11final.repository.PlayerRepository;
import com.example.wek11final.repository.TeamRepository;
import com.example.wek11final.utils.DataProvider;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    // Initialize our specific repositories.
    // Because they extend our generic Repository<T>, they already know how to handle lists!
    private TeamRepository teamRepo = new TeamRepository();
    private PlayerRepository playerRepo = new PlayerRepository();
    private MatchRepository matchRepo = new MatchRepository();

    // Declare our fragments using the generic EntityFragment class.
    // This saves us from having to create 3 separate fragment files.
    private EntityFragment teamFragment;
    private EntityFragment playerFragment;
    private EntityFragment matchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // REQUIREMENT 3: Data Provider
        // Load our hardcoded sample data into ALL THREE repositories when the app starts.
        teamRepo.getAll().addAll(DataProvider.createSampleTeams());
        playerRepo.getAll().addAll(DataProvider.createSamplePlayers());
        matchRepo.getAll().addAll(DataProvider.createSampleMatches());

        // REQUIREMENT 1: Generics
        // Create the UI fragments, passing in the generic lists from our repositories.
        teamFragment = new EntityFragment(teamRepo.getAll());
        playerFragment = new EntityFragment(playerRepo.getAll());
        matchFragment = new EntityFragment(matchRepo.getAll());

        // Link our Java variables to the UI elements in our XML layout
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager = findViewById(R.id.viewPager);
        EditText searchBar = findViewById(R.id.searchEditText);

        // Set up the ViewPager adapter to switch between our 3 fragments
        viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                if (position == 0) return teamFragment;
                if (position == 1) return playerFragment;
                return matchFragment;
            }
            @Override
            public int getItemCount() {
                return 3; // We have 3 tabs total
            }
        });

        // REQUIREMENT 4: Lambda Expressions
        // Using a Lambda expression to dynamically set the text titles for our tabs
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            if (position == 0) tab.setText("Teams");
            if (position == 1) tab.setText("Players");
            if (position == 2) tab.setText("Matches");
        }).attach();

        // REQUIREMENT 4: Lambda Expressions for Search/Filter
        // Listen for any text typed into the search bar
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Get the typed text and make it lowercase for easier searching
                String query = s.toString().toLowerCase();

                // Call the filter() method on our repositories using a Lambda expression.
                // It checks if the entity's name contains the letters typed in the search bar,
                // and then updates the fragment with the filtered list.
                teamFragment.filterData(teamRepo.filter(team -> team.getName().toLowerCase().contains(query)));
                playerFragment.filterData(playerRepo.filter(player -> player.getName().toLowerCase().contains(query)));
                matchFragment.filterData(matchRepo.filter(match -> match.getName().toLowerCase().contains(query)));
            }
        });
    }
}