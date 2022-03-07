package com.joker.blackjack;

import java.util.Scanner;

public class CardMain {

	public static void main(String[] args) {
		
		Story.gameStart();
		boolean flag = true;
		while (flag) {
			run();
			flag = Story.gameEnd(flag);
		}
	}

	public static void run() {
		try {
			boolean flag1 = true;
			Story.regret();
			Card.bet();
			Scanner sc = new Scanner(System.in);
			Card card = new Card();
			card.cardList.clear();
			System.out.println("<< 카드를 섞는 중입니다~ 잠시만 기다려주세요. >>");
			card.makeCard();
			card.shuffleCard();
			Thread.sleep(3000);
			System.out.println("TIP : 명심하십쇼, 손은 눈보다 빠릅니다.");
			Thread.sleep(2000);
			Dealer dealer = new Dealer();
			Player player = new Player();
			dealer.dealerCard.clear();
			player.playerCard.clear();
			System.out.println("<< 게임을 시작합니다 >>");
			Thread.sleep(1000);
			System.out.println("<< 딜러 한장 >>");
			dealer.hit(card.cardList);
			Thread.sleep(1500);
			System.out.println("<< 플레이어 한장 >>");
			player.hit(card.cardList);
			Thread.sleep(1500);
			System.out.println("<< 딜러 한장 >>");
			dealer.hit(card.cardList);
			Thread.sleep(1500);
			System.out.println("<< 플레이어 한장 >>");
			Thread.sleep(1500);
			System.out.println("======================");
			player.hit(card.cardList);
			Thread.sleep(1500);
			System.out.println(dealer.showCard());
			System.out.println("======================");
			Thread.sleep(1500);
			while (flag1) {
				System.out.println("카드를 한 장 더 받으시겠어요?");
				Thread.sleep(1000);
				System.out.println("1. 예(HIT)");
				System.out.println("2. 아니오(STAY)");
				Thread.sleep(500);
				System.out.print(">> ");
				if (sc.nextInt() == 1) {
					Thread.sleep(500);
					player.hit(card.cardList);
					Thread.sleep(500);
					player.changeA();
					Thread.sleep(500);
					player.calTotal();
					Thread.sleep(500);
					flag1 = player.checkBust(flag1);
				} else {
					Thread.sleep(1000);
					player.changeA();
					player.calTotal();
					flag1 = false;
				}
			}
			flag1 = true;
			boolean flag2 = true;
			while (flag2) {
				if (player.checkBlackJack()) {
					flag2=false;
				}
				if(player.checkBust(flag1) == false) {
					dealer.total = 20;
					flag2 = false;
				}
				dealer.dealerAlgorithm();
				dealer.calTotal();
				if (dealer.total < 17) {
					dealer.hit(card.cardList);
					dealer.calTotal();
					Thread.sleep(500);
					flag2 = dealer.checkBust(flag2);
				} else {
					flag2 = false;
				}
			}
			if (player.blackJack) {
				Thread.sleep(1000);
				System.out.println("Black Jack!!!");
				Player.win++;
				Player.money += (int) (Player.bet * 1.5);
			} else {
				Story.showResult();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
