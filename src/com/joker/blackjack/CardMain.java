package com.joker.blackjack;

import java.util.Scanner;

public class CardMain {

	public static void main(String[] args) {
		System.out.println("블랙잭 게임에 오신걸 환영합니다.");
		System.out.println("룰은 간단합니다. 합을 21을 넘기지 않고 ");
		System.out.println("21에 가장 근접하면 되는 게임입니다.");
		System.out.println("게임을 시작하시려면 <ENTER키>를 눌러주세요");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		boolean flag = true;
		while(flag) {
			run();
			System.out.println("게임을 끝내려면 EXIT을 입력하세요.");
			System.out.println("더하고 싶으면 Enter키를 누르세요.");
			String quit = sc.nextLine().toUpperCase();
			if(quit.equals("EXIT")) {
				System.out.println("<<< 게 임 종 료 >>>");
				System.out.println("전적 : " + Card.win + "승 " + Card.draw + "무 " + Card.lose + "패");
				System.out.println("이용해 주셔서 감사합니다!");
				flag=false;
			}
		}
	}
	public static void run() {
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		Card card = new Card();
		card.cardList.clear();
		card.makeCard();
		card.shuffleCard();
		
		Dealer dealer = new Dealer();
		Player player = new Player();
		dealer.dealerCard.clear();
		player.playerCard.clear();
		dealer.hit(card.cardList);
		player.hit(card.cardList);
		dealer.hit(card.cardList);
		player.hit(card.cardList);
		dealer.showCard();
		while(flag) {
			System.out.println("카드를 한 장 더 받으시겠어요(HIT)?");
			System.out.println("1. 예");
			System.out.println("2. 아니오");
			if(sc.nextInt() == 1) {
				player.hit(card.cardList);
				player.changeA();
				player.calTotal();
				player.checkBust();
				if(player.total > 21) {
					player.total = 0;
					flag = false;
				}
			}else {
				player.changeA();
				player.calTotal();
				flag = false;
			}
		}
		flag = true;
		while(flag) {
			dealer.dealerAlgorithm();
			dealer.calTotal();			
			if(dealer.total < 17) {
				dealer.hit(card.cardList);
				dealer.calTotal();
				dealer.checkBust();
				if(dealer.total > 21) {
					dealer.total = 0;
					flag = false;
				}
			}else {
				flag = false;
			}
		}
		if(player.total > dealer.total) {
			System.out.println("Player 승리");
			Card.win++;
		}else if(player.total == dealer.total) {
			System.out.println("비겼습니다");
			Card.draw++;
		}else {
			System.out.println("Dealer 승리");
			Card.lose++;
		}
	}
}
