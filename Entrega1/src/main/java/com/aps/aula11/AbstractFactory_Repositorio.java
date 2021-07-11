package com.aps.aula11;
import java.util.ArrayList;
import java.util.Deque;

public interface AbstractFactory_Repositorio {
	public Deque<Integer> getMusicsFromPlaylist(int playlistId);
	public ArrayList<User> getUsers();
}