package gamePackage;

import java.util.Scanner;

public class GameMeun {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i=0;
		while(true) {
			System.out.println("==============================================");
			System.out.println("===================게임 모음=====================");
			System.out.println("===<1.가위바위보 | 2.도둑잡기| 3.Up&Down| 4.종료>=====");
			System.out.println("==============================================");
			System.out.println("==============================================");
			System.out.print("선택>>> ");
			i = input.nextInt();

			if(i==1) {
				while(true) {
					User user = new User();
					//클래스의 필드를 불러와서 Stop 입력시 종료하는 경우
					if(User.user.equals("Stop")) {
						System.out.println("게임  종료");
						break;
					}
					user.Show();
				}
			}else if(i==2) {
				System.out.println("Catch The Thief Game");
				Gameplay gp = new Gameplay();
				gp.play();
				//여기서 n 버튼을 눌러서 하면 게임 재시작
				if(gp.restartgame.equals("n")) {
					gp.ReStartGame();
				}

			}else if(i==3) {
				System.out.println("Up&Down Game");
				UpNDown upndown = new UpNDown();
				System.out.println("0~99 사이의 숫자를 입력하여 주세요");
				while(true) {
					//만약 게임을 강제 종료 할려면 -1을 입력하면 된다.
					if(UpNDown.number == -1) {
						System.out.println("게임 강제 종료");
						break;
					}
					upndown.UpNDown();
					
					if(upndown.number<-1) {
						System.out.println("다시 입력하세요");
						upndown.number = 0;
						continue;
					}
					if(upndown.number>99) {
						System.out.println("다시 입력하세요");
						upndown.number = 99;
						continue;
					}
					
					
					//클래스의 변수 불러서 사용하기
					if(upndown.random>upndown.number) {
						//Up메소드 불러서 사용
						upndown.Up(); 
						//랜덤 값과 입력한 값이 같을 경우에는  맞혔다는 문구 띄우고 다시 시작하겠다는 문구 처리
						if(upndown.random == upndown.number) {
							System.out.println((upndown.count-1)+" 번 만에맞혔습니다.");
							System.out.print("게임을 종료 하시겠습니까?(y/n)>>> ");
							upndown.restart = input.next();
							if(upndown.restart.equals("y")) {
								System.out.println("게임을 종료 합니다.");
								break;
							}
							// n버튼을 눌러서 게임 재시작
							else if(upndown.restart.equals("n")) {
								System.out.println("게임을 다시 시작합니다.");
							}
						}
					}else {
						//Down 메소드 불러서 사용
						upndown.Down();
						//랜덤 값과 입력한 값이 같을 경우에는  맞혔다는 문구 띄우고 다시 시작하겠다는 문구 처리
						if(upndown.random == upndown.number) {
							System.out.println((upndown.count-1)+" 번 만 맞혔습니다.");
							System.out.print("게임을 종료 하시겠습니까?(y/n)>>> ");
							upndown.restart = input.next();
							if(upndown.restart.equals("y")) {
								System.out.println("게임을 종료 합니다.");
								break;
							}
							// n버튼을 눌러서 게임 재시작
							else if(upndown.restart.equals("n")) {
								System.out.println("게임을 다시 시작합니다.");
								upndown.ReStartgame();
							}
						}
					}

				}
			}
			else if(i==4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}

}
