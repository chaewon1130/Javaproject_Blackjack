package com.joker.blackjack;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CardMain {

	public static void main(String[] args) {

		try {
			System.out.println("===============================");
			System.out.println("블랙잭 게임에 오신 여러분을 환영합니다.");
			Thread.sleep(2000);
			System.out.println("룰은 간단합니다. 숫자들의 합이 21을 넘기지 않고 ");
			Thread.sleep(2000);
			System.out.println("21에 가장 근접하면 되는 게임입니다.");
			Thread.sleep(2000);
			System.out.println("게임을 시작하시려면 <ENTER>를 눌러주세요");
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
				System.out.println("<< 게임을 끝내려면 EXIT을 입력하세요. >>");
				System.out.println("<< 더하고 싶으면 Enter키를 누르세요. >>");
				System.out.println("================================");
				System.out.print(">> ");
				String quit = sc.nextLine().toUpperCase();
				if (quit.equals("EXIT")) {
					System.out.println("<<< 게 임 종 료 >>>");
					Thread.sleep(1000);
					System.out.println("전적 : " + Card.win + "승 " + Card.draw + "무 " + Card.lose + "패");
					Thread.sleep(1000);
					System.out.println("이용해 주셔서 감사합니다!");
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
				System.out.println("가진 돈이 0원 입니다.");
				Thread.sleep(1000);
				System.out.println("\"다시는 도박을 하지 않겠습니다\"를 작성하시면 기회를 드리겠습니다.");
				System.out.print(">> ");
				Scanner sc = new Scanner(System.in);
				String regret = "다시는 도박을 하지 않겠습니다";
				while(true) {
					if(sc.nextLine().equals(regret)) {
						Thread.sleep(1000);
						System.out.println("기회준다는 것은 거짓말이었습니다.");
						Thread.sleep(1000);
						System.out.println("이제 도박장에 발도 디디지 마십시오.");
						Thread.sleep(1000);
						System.out.println("종료합니다.");
						System.exit(0);
					}else {
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
						System.out.print(">> ");
					}
				}
			}
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
			dealer.showCard();
			System.out.println("======================");
			Thread.sleep(1500);
			while (flag) {
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
			System.out.println("<< 결과를 계산합니다. >>");
			Thread.sleep(2000);
			if (Player.total > Dealer.total) {
				System.out.println("Player 승리");
				Card.win++;
				Player.money += Card.bet;
			} else if (Player.total == Dealer.total) {
				System.out.println("비겼습니다");
				Card.draw++;
			} else {
				System.out.println("Dealer 승리");
				Card.lose++;
				Player.money -= Card.bet;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
