package br.com.leomanzini.threads.house.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class House {

	private List<Room> rooms;

	public House(Room... rooms) {
		this.rooms = Arrays.asList(rooms);
	}

	public List<Activity> obtainHouseTodo() {
		return this.rooms.stream().map(Room::obtainRoomTodo)
				.reduce(new ArrayList<Activity>(), (pivo, activities) -> {
					pivo.addAll(activities);
					return pivo;
		});
	}
}
