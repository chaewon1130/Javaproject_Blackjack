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
			boolean flag = true;
			Story.regret();
			Card.bet();
			Scanner sc = new Scanner(System.in);
			Card card = new Card();
			card.cardList.clear();
			System.out.println("<< ī�带 ���� ���Դϴ�~ ��ø� ��ٷ��ּ���. >>");
			card.makeCard();
			card.shuffleCard();
			Thread.sleep(3000);
			System.out.println("TIP : ����Ͻʼ�, ���� ������ �����ϴ�.");
			Thread.sleep(2000);
			Dealer dealer = new Dealer();
			Player player = new Player();
			dealer.dealerCard.clear();
			player.playerCard.clear();
			System.out.println("<< ������ �����մϴ� >>");
			Thread.sleep(1000);
			System.out.println("<< ���� ���� >>");
			dealer.hit(card.cardList);
			Thread.sleep(1500);
			System.out.println("<< �÷��̾� ���� >>");
			player.hit(card.cardList);
			Thread.sleep(1500);
			System.out.println("<< ���� ���� >>");
			dealer.hit(card.cardList);
			Thread.sleep(1500);
			System.out.println("<< �÷��̾� ���� >>");
			Thread.sleep(1500);
			System.out.println("======================");
			player.hit(card.cardList);
			Thread.sleep(1500);
			System.out.println(dealer.showCard());
			System.out.println("======================");
			Thread.sleep(1500);
			while (flag) {
				System.out.println("ī�带 �� �� �� �����ðھ��?");
				Thread.sleep(1000);
				System.out.println("1. ��(HIT)");
				System.out.println("2. �ƴϿ�(STAY)");
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
					flag = player.checkBust(flag);
				} else {
					Thread.sleep(1000);
					player.changeA();
					player.calTotal();
					flag = false;
				}
			}
			flag = true;
			while (flag) {
				if (player.blackJack) {
					break;
				}
				dealer.dealerAlgorithm();
				dealer.calTotal();
				if (dealer.total < 17) {
					dealer.hit(card.cardList);
					dealer.calTotal();
					Thread.sleep(500);
					flag = dealer.checkBust(flag);
				} else {
					flag = false;
				}
			}
			player.checkBlackJack();
			if (player.blackJack) {
				Thread.sleep(1000);
				System.out.println("Black Jack!!!");
				Card.win++;
				Player.money += (int) (Card.bet * 1.5);
			} else {
				Story.showResult();
			}
			player.blackJack = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
