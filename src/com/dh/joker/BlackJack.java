package com.dh.joker;

import java.util.Arrays;

public class BlackJack {

	public static void main(String[] args) {
		// cardArr : ��ü ī�� 52�� �ִ� �迭
		// cardNumArr : A~K���� �ִ� �迭
		// cardKind : ���� 4�� �����迭
		String[] cardArr = new String[52];
		String[] cardNumArr = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		String[] cardKind = {"��", "��", "��", "��"};
		
		// cardArr�� cardNumArr�� cardKind�� ����Ͽ� �迭 �����
		int num = 0;
		for(int i=0; i<cardKind.length;i++) {
			for(int j=0; j<cardNumArr.length;j++) {
				cardArr[num] = cardKind[i]+cardNumArr[j];
				num++;
			}
		}
		
		// ī�� ���� �ܰ� 1000�� ����
		for(int i=0; i<1000; i++) {
			int num1 = (int)Math.floor(Math.random()*52);
			int num2 = (int)Math.floor(Math.random()*52);
			String temp;
			temp = cardArr[num1];
			cardArr[num1] = cardArr[num2];
			cardArr[num2] = temp;
		}
		
		// ī�� �߼����� �迭 ����غ�
		System.out.println(Arrays.toString(cardArr));
		
		// ���� 2��, �÷��̾� 2�� ���(������ ���������� �迭�� �տ������� ������)
		String[] dealerCard = new String[4];
		String[] playerCard = new String[4];
		dealerCard[0] = cardArr[0];
		dealerCard[1] = cardArr[1];
		playerCard[0] = cardArr[2];
		playerCard[1] = cardArr[3];
		
		// ī�� 2�� ������ Ȯ���ϴ� ���๮
		System.out.println("====================");
		System.out.print("����ī�� : ");
		for(int i=0; i<2; i++) {
			System.out.printf(dealerCard[i] + " ");
		}
		System.out.print("\n�÷��̾�ī�� : ");
		for(int i=0; i<2; i++) {
			System.out.printf(playerCard[i] + " ");
		}
		
		// ī�� �� ��ȯ(ĳ������ 2��° �����޾� ��ȯ�Ͽ� �ƽ�Ű�ڵ尪�� INT������ ����ȯ)
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
		
		// ī�� �� Ȯ��
		System.out.println("\n====================");
		System.out.println(Arrays.toString(dealerValue));
		System.out.println(Arrays.toString(playerValue));
		
		// ī�� �� ���� Ȯ��
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
		
		// 3��° ī�� �̱�
		
	}
	/* �ƽ�Ű�ڵ� ��
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