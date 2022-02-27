package com.joker.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Card {

	public static int win = 0;
	public static int draw = 0;
	public static int lose = 0;
	
	ArrayList<String> cardList = new ArrayList<>();
	
	ArrayList<String> cardNum = new ArrayList<>(List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"));
	ArrayList<String> cardKind = new ArrayList<>(List.of("¢¾", "¢¼", "¡ß", "¢À"));
	
	ArrayList<String> dealerCard = new ArrayList<>();
	ArrayList<String> playerCard = new ArrayList<>();
	
	void makeCard() {
		for(int i = 0; i<cardKind.size(); i++) {
			for(int j = 0; j<cardNum.size(); j++) {
				cardList.add(cardKind.get(i) + cardNum.get(j));
			}
		}
	}
	
	void shuffleCard() {
		for(int i = 0; i < 1000; i++) {
			int num1 = (int)Math.floor(Math.random() * 52);
			int num2 = (int)Math.floor(Math.random() * 52);
			String temp = cardList.get(num1);
			cardList.set(num1, cardList.get(num2));
			cardList.set(num2, temp);
		}
	}
}
