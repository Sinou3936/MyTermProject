package gamePackage;

import java.util.Scanner;

public class GameMeun {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i=0;
		while(true) {
			System.out.println("==============================================");
			System.out.println("===================���� ����=====================");
			System.out.println("===<1.���������� | 2.�������| 3.Up&Down| 4.����>=====");
			System.out.println("==============================================");
			System.out.println("==============================================");
			System.out.print("����>>> ");
			i = input.nextInt();

			if(i==1) {
				while(true) {
					User user = new User();
					//Ŭ������ �ʵ带 �ҷ��ͼ� Stop �Է½� �����ϴ� ���
					if(User.user.equals("Stop")) {
						System.out.println("����  ����");
						break;
					}
					user.Show();
				}
			}else if(i==2) {
				System.out.println("Catch The Thief Game");
				Gameplay gp = new Gameplay();
				gp.play();
				//���⼭ n ��ư�� ������ �ϸ� ���� �����
				if(gp.restartgame.equals("n")) {
					gp.ReStartGame();
				}

			}else if(i==3) {
				System.out.println("Up&Down Game");
				UpNDown upndown = new UpNDown();
				System.out.println("0~99 ������ ���ڸ� �Է��Ͽ� �ּ���");
				while(true) {
					//���� ������ ���� ���� �ҷ��� -1�� �Է��ϸ� �ȴ�.
					if(UpNDown.number == -1) {
						System.out.println("���� ���� ����");
						break;
					}
					upndown.UpNDown();
					
					if(upndown.number<-1) {
						System.out.println("�ٽ� �Է��ϼ���");
						upndown.number = 0;
						continue;
					}
					if(upndown.number>99) {
						System.out.println("�ٽ� �Է��ϼ���");
						upndown.number = 99;
						continue;
					}
					
					
					//Ŭ������ ���� �ҷ��� ����ϱ�
					if(upndown.random>upndown.number) {
						//Up�޼ҵ� �ҷ��� ���
						upndown.Up(); 
						//���� ���� �Է��� ���� ���� ��쿡��  �����ٴ� ���� ���� �ٽ� �����ϰڴٴ� ���� ó��
						if(upndown.random == upndown.number) {
							System.out.println((upndown.count-1)+" �� �����������ϴ�.");
							System.out.print("������ ���� �Ͻðڽ��ϱ�?(y/n)>>> ");
							upndown.restart = input.next();
							if(upndown.restart.equals("y")) {
								System.out.println("������ ���� �մϴ�.");
								break;
							}
							// n��ư�� ������ ���� �����
							else if(upndown.restart.equals("n")) {
								System.out.println("������ �ٽ� �����մϴ�.");
							}
						}
					}else {
						//Down �޼ҵ� �ҷ��� ���
						upndown.Down();
						//���� ���� �Է��� ���� ���� ��쿡��  �����ٴ� ���� ���� �ٽ� �����ϰڴٴ� ���� ó��
						if(upndown.random == upndown.number) {
							System.out.println((upndown.count-1)+" �� �� �������ϴ�.");
							System.out.print("������ ���� �Ͻðڽ��ϱ�?(y/n)>>> ");
							upndown.restart = input.next();
							if(upndown.restart.equals("y")) {
								System.out.println("������ ���� �մϴ�.");
								break;
							}
							// n��ư�� ������ ���� �����
							else if(upndown.restart.equals("n")) {
								System.out.println("������ �ٽ� �����մϴ�.");
								upndown.ReStartgame();
							}
						}
					}

				}
			}
			else if(i==4) {
				System.out.println("���α׷��� �����մϴ�.");
				break;
			}
		}
	}

}
