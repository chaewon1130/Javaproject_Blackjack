package com.dh.joker;

import java.util.Scanner;

public class BlackJackMain {

	public static void main(String[] args) {
		boolean go = true;
		while(go) {
			System.out.println("===================");
			System.out.println("�ȳ��ϼ���~ �����Դϴ�!");
			System.out.println("1. ���ӽ���");
			System.out.println("2. ��������");
			System.out.println("===================");
			Scanner sc = new Scanner(System.in);
			switch(sc.nextInt()) {
			case 1:
				// ���ӽ���
				Card p1 = new Card();
				System.out.println("<<ī�带 ���� ���Դϴ�>>");
				p1.makeCardArr();
				
				System.out.println("<<ī�带 Ȯ�����ּ���>>");
				p1.giveCard(p1.cardArr);
				p1.cardToNum(p1.dealerCard, p1.playerCard);
				
				System.out.println("<<ī�带 �� �����ðڽ��ϱ�>>");
				System.out.println("1. �� �ޱ�");
				System.out.println("2. �׸� �ޱ�");
				
				if(sc.nextInt() == 1) {
					// ī�� ���޴� �޼ҵ� �����ؾ���
					System.out.println("ī�� ���ֱ�");
					p1.giveAnotherCard();
					p1.giveCard(p1.cardArr);
					p1.cardToNum(p1.dealerCard, p1.playerCard);
				}else {
					System.out.println("�� ����");
				}
				break;
			case 2:
				// ��������
				go = false;
				System.out.println("�̿����ּż� �����մϴ�!");
				break;
			default:
				System.out.println("�߸������̽��ϴ�!");
			}
		}
	}
}
