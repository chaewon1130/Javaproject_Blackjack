package com.joker.blackjack;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Story {
	public static void gameStart() {
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
	}

	public static boolean gameEnd(boolean flag) {
		try {
			Thread.sleep(1000);
			Scanner sc = new Scanner(System.in);
			System.out.println("================================");
			System.out.println("<< ������ �������� EXIT�� �Է��ϼ���. >>");
			System.out.println("<< ���ϰ� ������ EnterŰ�� ��������. >>");
			System.out.println("================================");
			System.out.print(">> ");
			String quit = sc.nextLine().toUpperCase();
			if (quit.equals("EXIT")) {
				System.out.println("<<< �� �� �� �� >>>");
				Thread.sleep(1000);
				System.out.println("���� : " + Player.win + "�� " + Player.draw + "�� " + Player.lose + "��");
				DecimalFormat decfm = new DecimalFormat("###,###");
				System.out.println("�����ݾ� : " + decfm.format(Player.money));
				Thread.sleep(1000);
				System.out.println("�α� ������ ���� ���̵� �ۼ����ּ���!");
				System.out.printf(">> ");
				Player.saveLog(sc.nextLine());
				System.out.println("����Ǿ����ϴ�. �̿��� �ּż� �����մϴ�!");
				return false;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return true;
	}

	public static void regret() {
		try {
			if (Player.money <= 0) {
				System.out.println("���� ���� 0�� �Դϴ�.");
				Thread.sleep(1000);
				System.out.println("\"�ٽô� ������ ���� �ʰڽ��ϴ�\"�� �ۼ��Ͻø� ��ȸ�� �帮�ڽ��ϴ�.");
				System.out.print(">> ");
				Scanner sc = new Scanner(System.in);
				String regret = "�ٽô� ������ ���� �ʰڽ��ϴ�";
				while (true) {
					if (sc.nextLine().equals(regret)) {
						Thread.sleep(1000);
						System.out.println("��ȸ�شٴ� ���� �������̾����ϴ�.");
						Thread.sleep(1000);
						System.out.println("���� �����忡 �ߵ� ����� ���ʽÿ�.");
						Thread.sleep(1000);
						System.out.println("�����մϴ�.");
						System.exit(0);
					} else {
						System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
						System.out.print(">> ");
					}
				}
			}
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
				Player.win++;
				Player.money += Player.bet;
			} else if (Player.total == Dealer.total) {
				System.out.println("�����ϴ�");
				Player.draw++;
			} else {
				System.out.println("Dealer �¸�");
				Player.lose++;
				Player.money -= Player.bet;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
