package com.aps.aula11;
import java.util.Deque;

public interface IRepositorioPlaylist {
    // public ArrayList<Playlist> getUserPlaylists(int userId);
    public Deque getMusicsFromPlaylist(int playlistId);
}