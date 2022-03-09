package com.joker.blackjack;

import java.util.ArrayList;
import java.util.Scanner;

public class Dealer implements Human {

	ArrayList<String> dealerCard = dCard;
	static int total = 0;
	Scanner sc = new Scanner(System.in);

	@Override
	public void hit(ArrayList<String> card) {
		dealerCard.add(card.get(card.size() - 1));
		card.remove(card.size() - 1);
	}

	@Override
	public void calTotal() {
		total = 0;
		for (int i = 0; i < dealerCard.size(); i++) {
			int getValue = 0;
			switch (dealerCard.get(i).charAt(1)) {
			case '1':
			case 'J':
			case 'Q':
			case 'K':
				getValue = 10;
				break;
			case 'B':
				getValue = 11;
				break;
			case 'A':
				getValue = 1;
				break;
			default:
				getValue = dealerCard.get(i).charAt(1) - 48;
			}

			total += getValue;
		}
	}

	@Override
	public boolean checkBust(boolean flag) {
		if (total > 21) {
			System.out.println("Dealer bust");
			total = 0;
			flag = false;
		}
		return flag;
	}

	public String showCard() {
		return "딜러의 1번째 카드 : [" + dealerCard.get(0) + "]";
	}

	public void changeA() {
		int cnt = 0;
		for (int i = 0; i < dealerCard.size(); i++) {
			if ((dealerCard.get(i).charAt(1) == 'A')) {
				cnt++;
			}
		}
		if (cnt <= 2) {
			for (int i = 0; i < dealerCard.size(); i++) {
				if (dealerCard.get(i).charAt(1) == 'A') {
					dealerCard.set(i, dealerCard.get(i).charAt(0) + "B");
					break;
				}
			}
		}
	}
}