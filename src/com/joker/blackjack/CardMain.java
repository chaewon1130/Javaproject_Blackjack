package com.joker.blackjack;

import java.util.Scanner;

public class CardMain {

	public static void main(String[] args) {
		System.out.println("������ ���ӿ� ���Ű� ȯ���մϴ�.");
		System.out.println("���� �����մϴ�. ���� 21�� �ѱ��� �ʰ� ");
		System.out.println("21�� ���� �����ϸ� �Ǵ� �����Դϴ�.");
		System.out.println("������ �����Ͻ÷��� <ENTERŰ>�� �����ּ���");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		boolean flag = true;
		while(flag) {
			run();
			System.out.println("������ �������� EXIT�� �Է��ϼ���.");
			System.out.println("���ϰ� ������ EnterŰ�� ��������.");
			String quit = sc.nextLine().toUpperCase();
			if(quit.equals("EXIT")) {
				System.out.println("<<< �� �� �� �� >>>");
				System.out.println("���� : " + Card.win + "�� " + Card.draw + "�� " + Card.lose + "��");
				System.out.println("�̿��� �ּż� �����մϴ�!");
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
			System.out.println("ī�带 �� �� �� �����ðھ��(HIT)?");
			System.out.println("1. ��");
			System.out.println("2. �ƴϿ�");
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
			System.out.println("Player �¸�");
			Card.win++;
		}else if(player.total == dealer.total) {
			System.out.println("�����ϴ�");
			Card.draw++;
		}else {
			System.out.println("Dealer �¸�");
			Card.lose++;
		}
	}
}