package com.joker.blackjack;

import java.util.ArrayList;

public interface Human {
	public ArrayList<String> pCard = new ArrayList<>();
	public ArrayList<String> dCard = new ArrayList<>();
	
	void hit(ArrayList<String> card);
	
	void calTotal();
	
	void checkBust();
	
	
}
