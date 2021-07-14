package br.com.leomanzini.threads.house.example;

import java.util.Arrays;
import java.util.List;

public class Bedroom extends Room{

	@Override
	public List<Activity> obtainRoomTodo() {
		return Arrays.asList(
					this::getMakeTheBed,
					this::getSweepRoom,
					this::getTidyUpWardrobe);
	}
	
	private void getMakeTheBed() {
		System.out.println("Get make the bed");
	}
	
	private void getSweepRoom() {
		System.out.println("Get sweep room");
	}
	
	private void getTidyUpWardrobe() {
		System.out.println("Get tidy up wardrobe");
	}
}
