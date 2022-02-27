package com.joker.blackjack;

import java.util.*;

public class Player implements Human{

	ArrayList<String> playerCard = pCard;
	int total = 0;
	Scanner sc = new Scanner(System.in);
	@Override
	public void hit(ArrayList<String> card) {
		playerCard.add(card.get(card.size()-1));
		card.remove(card.size()-1);
		System.out.println("�� ī�� : " + playerCard);
	}

	@Override
	public void calTotal() {
		total = 0;
		for(int i=0; i < playerCard.size(); i++) {
			int getValue = 0;
			switch(playerCard.get(i).charAt(1)) {
			case '1':// 10�ΰ��
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
				getValue = playerCard.get(i).charAt(1) - 48;
			}
			
			total += getValue;
		}
		System.out.println("���� �� ī�� ���� : " + total);
	}

	@Override
	public void checkBust() {
		if(total > 21) {
			System.out.println("Player bust");
			return;
		}
	}
	
	public void changeA() {
		for(int i=0; i<playerCard.size(); i++) {
			if(playerCard.get(i).charAt(1) == 'A') {
				System.out.println((i+1) + "��° Aī�带 11�� �ٲٽðڽ��ϱ�?");
				System.out.println("1. ��");
				System.out.println("2. �ƴϿ�");
				if(sc.nextInt() == 1) {
					playerCard.set(i, playerCard.get(i).charAt(0) + "B");
				}
			}
		}
	}
}
