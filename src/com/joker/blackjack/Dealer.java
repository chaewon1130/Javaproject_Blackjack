package com.joker.blackjack;

import java.util.*;

public class Dealer implements Human{

	ArrayList<String> dealerCard = dCard;
	int total = 0;
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void hit(ArrayList<String> card) {
		dealerCard.add(card.get(card.size()-1));
		card.remove(card.size()-1);
//		System.out.println(dealerCard);
	}

	@Override
	public void calTotal() {
		total = 0;
		for(int i=0; i < dealerCard.size(); i++) {
			int getValue = 0;
			switch(dealerCard.get(i).charAt(1)) {
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
				getValue = dealerCard.get(i).charAt(1) - 48;
			}
			
			total += getValue;
		}
//		System.out.println(total);
	}

	@Override
	public void checkBust() {
		if(total > 21) {
			System.out.println("Dealer bust");
		}else {
//			System.out.println("total : " + total);
		}
	}
	
	public void showCard() {
		System.out.println("����ī�� : [" + dealerCard.get(0) +"]");
	}
	
//	public void changeA() {
//		for(int i=0; i<dealerCard.size(); i++) {
//			if(dealerCard.get(i).charAt(1) == 'A') {
//				System.out.println((i+1) + "��° Aī�带 11�� �ٲٽðڽ��ϱ�?");
//				System.out.println("1. ��");
//				System.out.println("2. �ƴϿ�");
//				if(sc.nextInt() == 1) {
//					dealerCard.set(i, dealerCard.get(i).charAt(0) + "B");
//				}
//			}else {
//				System.out.println("�ٲ�a����!");
//			}
//		}
//	}
	// A�� ����
	// A�� 1��
	// A�� 2��
	// A�� 3��
	// A�� 4��
	public void dealerAlgorithm() {
		int cnt = 0;
		for(int i=0; i<dealerCard.size(); i++) {
			if((dealerCard.get(i).charAt(1) == 'A')) {
				cnt++;
			}
		}
		if(cnt <= 2) {
			for(int i=0; i<dealerCard.size(); i++) {
				if(dealerCard.get(i).charAt(1) == 'A') {
					dealerCard.set(i, dealerCard.get(i).charAt(0) + "B");
					break;
				}
			}
		}
	}
}
