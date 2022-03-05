# Javaproject_Blackjack
- Language : JAVA
***
## CLASS
1. CardMain : Main함수
2. Card : Card에 관련 정의된 클래스
3. Human : Player클래스와 Dealer클래스의 공통된 정의를 해놓은 인터페이스
4. Player : Human 인터페이스를 상속받아 플레이어에 관련된 것들을 정의해놓은 클래스
5. Dealer : Human 인터페이스를 상속받아 딜러에 관련된 것들을 정의해놓은 클래스
---
## METHOD
1. CardMain
- main(String[] args) : void
- run() : void
- showResult() : void
2. Card
- makeCard() : void
- shuffleCard() : void
- bet() : void
3. Human
- hit(ArrayList<String> card) : void
- calTotal() : void
- checkBust() : void
4. Player
- hit(ArrayList<String> card) : void
- calTotal() : void
- checkBust() : void
- changeA() : void
- checkBlackJack() : void
5. Dealer
- hit(ArrayList<String> card) : void
- calTotal() : void
- checkBust() : void
- showCard() : void
- dealerAlgorithm() : void
