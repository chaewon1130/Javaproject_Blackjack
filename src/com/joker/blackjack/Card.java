package com.joker.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Card {
	// 카드 생성
	// 카드 셔플
	// 한장씩 나눠주기
	// 숫자합계산
	// 숫자비교
	
	// 52장 카드 선언할 리스트
	ArrayList<String> cardList = new ArrayList<>();
	
	// 카드조합을 위한 임시 리스트
	ArrayList<String> cardNum = new ArrayList<>(List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"));
	ArrayList<String> cardKind = new ArrayList<>(List.of("♥", "♠", "◆", "♣"));
	
	// 딜러, 플레이어 카드 리스트
	ArrayList<String> dealerCard = new ArrayList<>();
	ArrayList<String> playerCard = new ArrayList<>();
	
	
	// 52장 카드 선언 메소드
	void makeCard() {
		for(int i = 0; i<cardKind.size(); i++) {
			for(int j = 0; j<cardNum.size(); j++) {
				cardList.add(cardKind.get(i) + cardNum.get(j));
			}
		}
//		System.out.println(cardList);
	}
	
	// 카드 섞는 메소드
	void shuffleCard() {
		for(int i = 0; i < 1000; i++) {
			int num1 = (int)Math.floor(Math.random() * 52);
			int num2 = (int)Math.floor(Math.random() * 52);
			String temp = cardList.get(num1);
			cardList.set(num1, cardList.get(num2));
			cardList.set(num2, temp);
		}
//		System.out.println(cardList);
	}
}
