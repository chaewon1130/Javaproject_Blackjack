package com.joker.blackjack;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CardMain {

	public static void main(String[] args) {

		try {
			System.out.println("===============================");
			System.out.println("���� ���ӿ� ���� �������� ȯ���մϴ�.");
			Thread.sleep(2000);
			System.out.println("���� �����մϴ�. ���ڵ��� ���� 21�� �ѱ��� �ʰ� ");
			Thread.sleep(2000);
			System.out.println("21�� ���� �����ϸ� �Ǵ� �����Դϴ�.");
			Thread.sleep(2000);
			System.out.println("������ �����Ͻ÷��� <ENTER>�� �����ּ���");
			System.out.println("================================");
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		Scanner sc = new Scanner(System.in);
		System.out.print(">> ");
		sc.nextLine();
		boolean flag = true;
		while (flag) {
			run();
			try {
				Thread.sleep(1000);
				System.out.println("================================");
				System.out.println("<< ������ �������� EXIT�� �Է��ϼ���. >>");
				System.out.println("<< ���ϰ� ������ EnterŰ�� ��������. >>");
				System.out.println("================================");
				System.out.print(">> ");
				String quit = sc.nextLine().toUpperCase();
				if (quit.equals("EXIT")) {
					System.out.println("<<< �� �� �� �� >>>");
					Thread.sleep(1000);
					System.out.println("���� : " + Card.win + "�� " + Card.draw + "�� " + Card.lose + "��");
					Thread.sleep(1000);
					System.out.println("�̿��� �ּż� �����մϴ�!");
					flag = false;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void run() {
		try {
			boolean flag = true;
			if (Player.money <= 0) {
				System.out.println("���� ���� 0�� �Դϴ�.");
				Thread.sleep(1000);
				System.out.println("\"�ٽô� ������ ���� �ʰڽ��ϴ�\"�� �ۼ��Ͻø� ��ȸ�� �帮�ڽ��ϴ�.");
				System.out.print(">> ");
				Scanner sc = new Scanner(System.in);
				String regret = "�ٽô� ������ ���� �ʰڽ��ϴ�";
				while(true) {
					if(sc.nextLine().equals(regret)) {
						Thread.sleep(1000);
						System.out.println("��ȸ�شٴ� ���� �������̾����ϴ�.");
						Thread.sleep(1000);
						System.out.println("���� �����忡 �ߵ� ����� ���ʽÿ�.");
						Thread.sleep(1000);
						System.out.println("�����մϴ�.");
						System.exit(0);
					}else {
						System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
						System.out.print(">> ");
					}
				}
			}
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
			dealer.showCard();
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
					player.checkBust();
					if (player.total > 21) {
						player.total = 0;
						flag = false;
					}
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
					dealer.checkBust();
					if (dealer.total > 21) {
						dealer.total = 0;
						flag = false;
					}
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
				showResult();
			}
			player.blackJack = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void showResult() {
		try {
			System.out.println("<< ����� ����մϴ�. >>");
			Thread.sleep(2000);
			if (Player.total > Dealer.total) {
				System.out.println("Player �¸�");
				Card.win++;
				Player.money += Card.bet;
			} else if (Player.total == Dealer.total) {
				System.out.println("�����ϴ�");
				Card.draw++;
			} else {
				System.out.println("Dealer �¸�");
				Card.lose++;
				Player.money -= Card.bet;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
