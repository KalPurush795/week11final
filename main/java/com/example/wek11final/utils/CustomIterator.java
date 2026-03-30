package com.example.wek11final.utils;

/**
 * A generic interface for implementing the Iterator pattern.
 * Allows traversal of any collection of generic entities.
 */
public interface CustomIterator<T> {
    boolean hasNext();
    T next();
}