package org.store;

import org.store.song.RecentlyPlayedStore;

public class Main {
  public static void main(String[] args) {
    RecentlyPlayedStore store = new RecentlyPlayedStore(3);

    store.addSong("user1", "S1");
    store.addSong("user1", "S2");
    store.addSong("user1", "S3");
    System.out.println(store.getRecentlyPlayed("user1")); // [S3, S2, S1]

    store.addSong("user1", "S4");
    System.out.println(store.getRecentlyPlayed("user1")); // [S4, S3, S2]

    store.addSong("user1", "S2");
    System.out.println(store.getRecentlyPlayed("user1")); // [S2, S4, S3]

    store.addSong("user1", "S1");
    System.out.println(store.getRecentlyPlayed("user1")); // [S1, S2, S4]
  }
}