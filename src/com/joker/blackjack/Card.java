package com.joker.blackjack;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Card {

	

	ArrayList<String> cardList = new ArrayList<>();

	ArrayList<String> cardNum = new ArrayList<>(
			List.of("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"));
	ArrayList<String> cardKind = new ArrayList<>(List.of("♥", "♠", "◆", "♣"));

	ArrayList<String> dealerCard = new ArrayList<>();
	ArrayList<String> playerCard = new ArrayList<>();

	void makeCard() {
		for (int i = 0; i < cardKind.size(); i++) {
			for (int j = 0; j < cardNum.size(); j++) {
				cardList.add(cardKind.get(i) + cardNum.get(j));
			}
		}
	}

	void shuffleCard() {
		for (int i = 0; i < 1000; i++) {
			int num1 = (int) Math.floor(Math.random() * 52);
			int num2 = (int) Math.floor(Math.random() * 52);
			String temp = cardList.get(num1);
			cardList.set(num1, cardList.get(num2));
			cardList.set(num2, temp);
		}
	}

	public static void bet() {
		try {
			int money = Player.money;
			boolean flag = true;
			while (flag) {
				DecimalFormat decfm = new DecimalFormat("###,###");
				Thread.sleep(1000);
				System.out.println("<< 베팅금액을 입력해주세요 >>");
				Thread.sleep(1000);
				System.out.println("내가 가진 돈 : " + decfm.format(money));
				System.out.print(">> ");
				Scanner sc = new Scanner(System.in);
				Player.bet = sc.nextInt();
				if (Player.bet > money) {
					System.out.println(" 베팅금액이 가지고 계신 돈보다 큽니다. 다시 입력해주세요");
					Thread.sleep(1000);
				} else {
					System.out.println("베팅금액이 " + decfm.format(Player.bet) + "으로 설정되었습니다.");
					Thread.sleep(1000);
					flag = false;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
