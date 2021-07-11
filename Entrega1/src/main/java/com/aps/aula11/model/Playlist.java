package com.aps.aula11;
import java.util.Deque;
import java.util.ArrayDeque;

public class Playlist {
    private String name;
    private int ownerId;
    private int playlistId;
    private Deque<Integer> musicsId;
    private boolean isPrivate;

    public Playlist(String name, int ownerId, boolean isPrivate, int[] musics){
        this.name = name;
        this.ownerId = ownerId;
        this.isPrivate = isPrivate;
        this.musicsId = new ArrayDeque<Integer>();
        for(int m : musics) {
        	this.musicsId.add(m);
        }
    }

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Deque<Integer> getMusicsId() {
		return musicsId;
	}

	public void setMusicsId(Deque<Integer> musicsId) {
		this.musicsId = musicsId;
	}

	public void addOneMusic(int musicId) {
		this.musicsId.add(musicId);
	}

	public boolean isPrivate() {
		return isPrivate;
	}

	public void setPrivate(boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public int getPlaylistId() {
		return playlistId;
	}
	
}