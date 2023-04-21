package com.theatre.dto;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class CinimaHall {
	private LinkedHashMap<Character, boolean[]> seats;
	public CinimaHall() {
		this.seats = new LinkedHashMap<>();
		initialise();
	}
	public void initialise(){
		for(int i =1;i<=10;i++) {
			seats.put((char) (64+i), new boolean[16]);
		}
	}
}	
