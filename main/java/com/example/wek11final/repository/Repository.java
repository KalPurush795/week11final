package com.example.wek11final.repository;

import com.example.wek11final.models.SoccerEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *  This is our Generic Data Repository.
 * Instead of writing a separate add() and getAll() for Teams, Players, and Matches,
 * the "<T extends SoccerEntity>" part means this class can handle ANY of them
 */
public class Repository<T extends SoccerEntity> {

    // This list holds all our items, no matter what type they are
    protected List<T> items;

    // Constructor to initialize the empty list
    public Repository() {
        this.items = new ArrayList<>();
    }

    // Returns the whole list
    public List<T> getAll() {
        return items;
    }

    // Adds a new item, but checks to make sure it isn't null first (Error handling requirement) [cite: 26]
    public void add(T item) {
        if (item != null) {
            items.add(item);
        }
    }

    /**
     *  This is one of our required Lambda implementations
     * We pass in a "Predicate" (a condition), and it uses the Java Streams API
     * to filter the list and return only the items that match the condition.
     */
    public List<T> filter(Predicate<T> predicate) {
        return items.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }
}