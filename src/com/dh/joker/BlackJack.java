package com.dh.joker;

import java.util.Arrays;

public class BlackJack {

	public static void main(String[] args) {
		// cardArr : 전체 카드 52장 넣는 배열
		// cardNumArr : A~K까지 넣는 배열
		// cardKind : 문양 4개 넣은배열
		String[] cardArr = new String[52];
		String[] cardNumArr = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] cardKind = {"♥", "♠", "◆", "♣"};
		
		// cardArr에 cardNumArr와 cardKind를 사용하여 배열 만들기
		int num = 0;
		for(int i=0; i<cardKind.length;i++) {
			for(int j=0; j<cardNumArr.length;j++) {
				cardArr[num] = cardKind[i]+cardNumArr[j];
				num++;
			}
		}
		
		// 카드 섞는 단계 1000번 섞음
		for(int i=0; i<1000; i++) {
			int num1 = (int)Math.floor(Math.random()*52);
			int num2 = (int)Math.floor(Math.random()*52);
			String temp;
			temp = cardArr[num1];
			cardArr[num1] = cardArr[num2];
			cardArr[num2] = temp;
		}
		
		// 카드 잘섞였나 배열 출력해봄
		System.out.println(Arrays.toString(cardArr));
		
		// 딜러 2장, 플레이어 2장 배분(어차피 섞여있으니 배열의 앞에서부터 나눠줌)
		String[] dealerCard = new String[4];
		String[] playerCard = new String[4];
		dealerCard[0] = cardArr[0];
		dealerCard[1] = cardArr[1];
		playerCard[0] = cardArr[2];
		playerCard[1] = cardArr[3];
		
		// 카드 2장 받은거 확인하는 실행문
		System.out.println("====================");
		System.out.print("딜러카드 : ");
		for(int i=0; i<2; i++) {
			System.out.printf(dealerCard[i] + " ");
		}
		System.out.print("\n플레이어카드 : ");
		for(int i=0; i<2; i++) {
			System.out.printf(playerCard[i] + " ");
		}
		
		// 카드 값 변환(캐릭터형 2번째 값을받아 변환하여 아스키코드값을 INT형으로 형변환)
		// A- > 1
		// 10,J,Q,K -> 10
		int[] dealerValue = new int[4];
		int[] playerValue = new int[4];
		dealerValue[0] = (int)(dealerCard[0].charAt(1));
		dealerValue[1] = (int)(dealerCard[1].charAt(1));
		playerValue[0] = (int)(playerCard[0].charAt(1));
		playerValue[1] = (int)(playerCard[1].charAt(1));
		for(int i=0; i<dealerValue.length; i++) {
			switch(dealerValue[i]) {
			case 65:
				dealerValue[i] = 1;
				break;
			case 49:
			case 74:
			case 81:
			case 75:
				dealerValue[i] = 10;
				break;
			}
			if(dealerValue[i] >= 50) {
				dealerValue[i] -= 48;
			}
			
			switch(playerValue[i]) {
			case 65:
				playerValue[i] = 1;
				break;
			case 49:
			case 74:
			case 81:
			case 75:
				playerValue[i] = 10;
				break;
			}
			if(playerValue[i] >= 50) {
				playerValue[i] -= 48;
			}
		}
		
		// 카드 값 확인
		System.out.println("\n====================");
		System.out.println(Arrays.toString(dealerValue));
		System.out.println(Arrays.toString(playerValue));
		
		// 카드 값 총합 확인
		int dealerTotal = 0;
		int playerTotal = 0;
		for(int i=0; i<dealerValue.length; i++) {
			dealerTotal += dealerValue[i];
		}
		for(int i=0; i<playerValue.length; i++) {
			playerTotal += playerValue[i];
		}
		System.out.println("\n====================");
		System.out.println(dealerTotal);
		System.out.println(playerTotal);
		
		// 3번째 카드 뽑기
		
	}
	/* 아스키코드 값
	 * A: 65
	 * 2: 50
	 * 3: 51
	 * 4: 52
	 * 5: 53
	 * 6: 54
	 * 7: 55
	 * 8: 56
	 * 9: 57
	 * 10: 58
	 * J: 74
	 * Q: 81
	 * K: 75
	 */
}