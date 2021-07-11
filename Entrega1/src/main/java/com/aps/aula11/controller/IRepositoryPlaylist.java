package com.aps.aula11;
import java.util.Deque;

public interface IRepositoryPlaylist {
    // public ArrayList<Playlist> getUserPlaylists(int userId);
    public Deque getMusicsFromPlaylist(int playlistId);
}