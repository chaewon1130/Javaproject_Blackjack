package com.dh.joker;

import java.util.Scanner;

public class BlackJackMain {

	public static void main(String[] args) {
		boolean go = true;
		while(go) {
			System.out.println("===================");
			System.out.println("안녕하세요~ 블랙잭입니다!");
			System.out.println("1. 게임시작");
			System.out.println("2. 게임종료");
			System.out.println("===================");
			Scanner sc = new Scanner(System.in);
			switch(sc.nextInt()) {
			case 1:
				// 게임시작
				Card p1 = new Card();
				System.out.println("<<카드를 섞는 중입니다>>");
				p1.makeCardArr();
				
				System.out.println("<<카드를 확인해주세요>>");
				p1.giveCard(p1.cardArr);
				p1.cardToNum(p1.dealerCard, p1.playerCard);
				
				System.out.println("<<카드를 더 받으시겠습니까>>");
				System.out.println("1. 더 받기");
				System.out.println("2. 그만 받기");
				
				if(sc.nextInt() == 1) {
					// 카드 더받는 메소드 구현해야함
					System.out.println("카드 더주기");
					p1.giveAnotherCard();
					p1.giveCard(p1.cardArr);
					p1.cardToNum(p1.dealerCard, p1.playerCard);
				}else {
					System.out.println("턴 종료");
				}
				break;
			case 2:
				// 게임종료
				go = false;
				System.out.println("이용해주셔서 감사합니다!");
				break;
			default:
				System.out.println("잘못누르셨습니다!");
			}
		}
	}
}
