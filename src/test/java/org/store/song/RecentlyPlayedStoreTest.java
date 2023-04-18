package org.store.song;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecentlyPlayedStoreTest {

    private RecentlyPlayedStore store;

    @BeforeEach
    void setUp() {
        store = new RecentlyPlayedStore(3);
    }

    @Test
    void testAddSong() {
        store.addSong("user1", "S1");
        store.addSong("user1", "S2");
        store.addSong("user1", "S3");
        store.addSong("user1", "S4");
        List<String> expected = Arrays.asList("S4", "S3", "S2");
        List<String> actual = store.getRecentlyPlayed("user1");
        assertEquals(expected, actual);
    }

    @Test
    void testGetRecentlyPlayed() {
        store.addSong("user1", "S1");
        store.addSong("user1", "S2");
        store.addSong("user1", "S3");
        store.addSong("user2", "S4");
        store.addSong("user2", "S5");
        List<String> expected1 = Arrays.asList("S3", "S2", "S1");
        List<String> actual1 = store.getRecentlyPlayed("user1");
        assertEquals(expected1, actual1);
        List<String> expected2 = Collections.emptyList();
        List<String> actual2 = store.getRecentlyPlayed("user3");
        assertEquals(expected2, actual2);
        List<String> expected3 = Arrays.asList("S5", "S4");
        List<String> actual3 = store.getRecentlyPlayed("user2");
        assertEquals(expected3, actual3);
    }

    @Test
    void testCapacity() {
        store.addSong("user1", "S1");
        store.addSong("user1", "S2");
        store.addSong("user1", "S3");
        store.addSong("user1", "S4");
        store.addSong("user1", "S5");
        List<String> expected = Arrays.asList("S5", "S4", "S3");
        List<String> actual = store.getRecentlyPlayed("user1");
        assertEquals(expected, actual);
    }

    @Test
    void testEmptyRecentlyPlayed() {
        List<String> expected = Collections.emptyList();
        List<String> actual = store.getRecentlyPlayed("user1");
        assertEquals(expected, actual);
    }
}