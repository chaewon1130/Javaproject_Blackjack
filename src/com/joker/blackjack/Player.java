package com.joker.blackjack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Player implements Human {

	ArrayList<String> playerCard = pCard;
	static int total = 0;
	int num = 1;
	static String inputId = "";
	static int money = 1_000_000;
	static int bet = 0;
	static int win = 0;
	static int draw = 0;
	static int lose = 0;
	static boolean blackJack = false;
	static String filePath = "C:\\Users\\chaew\\Desktop\\java1\\BlackJack\\src\\com\\joker\\blackjack\\log.csv";
	static Scanner sc = new Scanner(System.in);
	
	public static void saveLog(String Id) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))){
			DecimalFormat decfm = new DecimalFormat("###,###");
			bw.write(Id + " / " + win + " / " + draw + " / " + lose + " / " + decfm.format(money) + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void hit(ArrayList<String> card) {
		playerCard.add(card.get(card.size() - 1));
		card.remove(card.size() - 1);
		if (num > 1) {
			System.out.println("내 카드 : " + playerCard);
		}
		num++;
	}

	@Override
	public void calTotal() {
		total = 0;
		for (int i = 0; i < playerCard.size(); i++) {
			int getValue = 0;
			switch (playerCard.get(i).charAt(1)) {
			case '1':// 10인경우
			case 'J':
			case 'Q':
			case 'K':
				getValue = 10;
				break;
			case 'B':
				getValue = 11;
				break;
			case 'A':
				getValue = 1;
				break;
			default:
				getValue = playerCard.get(i).charAt(1) - 48;
			}

			total += getValue;
		}
		System.out.println("현재 내 카드 총합 : " + total);
	}

	@Override
	public boolean checkBust(boolean flag) {
		if (total > 21) {
			System.out.println("Player bust");
			total = 0;
			flag = false;
		}
		return flag;
	}

	public void changeA() {
		for (int i = 0; i < playerCard.size(); i++) {
			if (playerCard.get(i).charAt(1) == 'A') {
				System.out.println((i + 1) + "번째 A카드를 11로 바꾸시겠습니까?");
				System.out.println("1. 예");
				System.out.println("2. 아니오");
				System.out.print(">> ");
				if (sc.nextInt() == 1) {
					playerCard.set(i, playerCard.get(i).charAt(0) + "B");
				}
			}
		}
	}

	public boolean checkBlackJack() {
		blackJack = false;
		char[] blackJackCard = new char[2];
		for (int i = 0; i < 2; i++) {
			blackJackCard[i] = playerCard.get(i).charAt(1);
		}
		if (blackJackCard[0] == 'B') {
			if ((blackJackCard[1] == 'J') || (blackJackCard[1] == 'Q') || (blackJackCard[1] == 'K')) {
				blackJack = true;
			}
		}
		if ((blackJackCard[0] == 'J') || (blackJackCard[0] == 'Q') || (blackJackCard[0] == 'K')) {
			if (blackJackCard[1] == 'B') {
				blackJack = true;
			}
		}
		return blackJack;
	}
}
