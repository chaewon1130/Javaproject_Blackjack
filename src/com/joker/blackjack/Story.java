package com.joker.blackjack;

import java.util.Scanner;
import java.text.DecimalFormat;

public class Story {
	public static void gameStart() {
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
	}

	public static boolean gameEnd(boolean flag) {
		try {
			Thread.sleep(1000);
			Scanner sc = new Scanner(System.in);
			System.out.println("================================");
			System.out.println("<< 게임을 끝내려면 EXIT을 입력하세요. >>");
			System.out.println("<< 더하고 싶으면 Enter키를 누르세요. >>");
			System.out.println("================================");
			System.out.print(">> ");
			String quit = sc.nextLine().toUpperCase();
			if (quit.equals("EXIT")) {
				System.out.println("<<< 게 임 종 료 >>>");
				Thread.sleep(1000);
				System.out.println("전적 : " + Player.win + "승 " + Player.draw + "무 " + Player.lose + "패");
				DecimalFormat decfm = new DecimalFormat("###,###");
				System.out.println("남은금액 : " + decfm.format(Player.money));
				Thread.sleep(1000);
				System.out.println("로그 저장을 위한 아이디를 작성해주세요!");
				System.out.printf(">> ");
				Player.saveLog(sc.nextLine());
				System.out.println("저장되었습니다. 이용해 주셔서 감사합니다!");
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
				System.out.println("가진 돈이 0원 입니다.");
				Thread.sleep(1000);
				System.out.println("\"다시는 도박을 하지 않겠습니다\"를 작성하시면 기회를 드리겠습니다.");
				System.out.print(">> ");
				Scanner sc = new Scanner(System.in);
				String regret = "다시는 도박을 하지 않겠습니다";
				while (true) {
					if (sc.nextLine().equals(regret)) {
						Thread.sleep(1000);
						System.out.println("기회준다는 것은 거짓말이었습니다.");
						Thread.sleep(1000);
						System.out.println("이제 도박장에 발도 디디지 마십시오.");
						Thread.sleep(1000);
						System.out.println("종료합니다.");
						System.exit(0);
					} else {
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
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
			System.out.println("<< 결과를 계산합니다. >>");
			Thread.sleep(2000);
			if (Player.total > Dealer.total) {
				System.out.println("Player 승리");
				Player.win++;
				Player.money += Player.bet;
			} else if (Player.total == Dealer.total) {
				System.out.println("비겼습니다");
				Player.draw++;
			} else {
				System.out.println("Dealer 승리");
				Player.lose++;
				Player.money -= Player.bet;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}