package org.store.song;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * In this implementation, the RecentlyPlayedStore class has a capacity field that determines the
 * maximum number of songs that can be stored per user. It also has a recentlyPlayed field, which
 * is a Map that maps each user to a Deque of their recently played songs.
 */
public class RecentlyPlayedStore {

  private final int capacity;
  private final Map<String, Deque<String>> recentlyPlayed;

  public RecentlyPlayedStore(int capacity) {
    this.capacity = capacity;
    this.recentlyPlayed = new HashMap<>();
  }

  /**
   * Adds a new song to the store for the given user. It first gets the
   * Deque of recently played songs for the user, creating a new one if necessary using
   * computeIfAbsent. It then adds the new song to the front of the deque using offerFirst, and
   * if the deque exceeds the capacity, it removes the least recently
   * played song from the end using pollLast.
   *
   * @param user
   * @param song
   */
  public void addSong(String user, String song) {
    Deque<String> songs = recentlyPlayed.computeIfAbsent(user, k -> new LinkedList<>());
    songs.offerFirst(song);
    if (songs.size() > capacity) {
      songs.pollLast();
    }
  }

  /**
   * returns a list of the recently played songs for the given user, or an empty list if there
   * are none. It gets the Deque of recently played songs for the
   * user using get, and if it is null, returns an empty list. Otherwise, it creates a new
   * ArrayList containing the songs from the deque and returns it.
   *
   * @param user
   *
   * @return
   */
  public List<String> getRecentlyPlayed(String user) {
    Deque<String> songs = recentlyPlayed.get(user);
    if (songs == null) {
      return Collections.emptyList();
    }
    return new ArrayList<>(songs);
  }

}