package gamePackage;

import java.util.Scanner;

class RockPaperScissors {
	//�� ���� Ŭ����  �ƹ��͵� ���� ���� �ʰ� ����
}
class Computer extends RockPaperScissors{ // �ֻ��� Ŭ������ ��� Ŭ������ Computer Ŭ����
	//��ǻ�Ͱ� ����� ���� ���� �� �迭 ��ü ����
	String gameset1[] = {"Scissors", "Rock", "Paper"};
	//�� �迭�� ������ �޾� �ü� �ְ� ���ִ� ����  ��ü ����
	int  n = (int)(Math.random()*2)+1;
	// �迭�� ���� ���ڿ�  ��ü����
	public String com;

	public Computer() {
		// TODO Auto-generated constructor stub
		//�������� ������ ���� com ���ڿ��� ����
		com = gameset1[n];
	}
	public void comshow() {
		//com ����  ������ �� ���� ������ �����Ͽ� ȭ�鿡 �����ش�.
		System.out.print("��ǻ�Ͱ� �� ���� "+com+" ");
	}
}

class User extends Computer{ // Computer Ŭ������ ��� Ŭ������ User Ŭ����
	Scanner input = new Scanner(System.in);
	//static�� �̿��Ͽ� user ��ü ����;
	public static String user;

	//User Ŭ���� ������ ����
	public User() {
		System.out.print("Scissors,Rock,Paper>>> ");
		user = input.next();
	}
	// �� Ŭ���� ���ϴ� �޼ҵ� ����
	public void Show() {

		System.out.print("����ڰ� �� ����"+ user+" ");
		super.comshow(); //UserŬ������ Computer Ŭ���� ��� ���Ѽ� ���

		// ����ڰ� ����, ����, ���� �� ��� �� ���Ͽ� ���� ���
		// ����� ������ �Է��Ͽ�����
		if(user.equals("Rock")) {
			if(com.equals("Rock")) 
				System.out.println("�����ϴ�."); 
			else if(com.equals("Scissors")) 
				System.out.println("����� �� �̰���ϴ�."); 
			else if(com.equals("Paper")) 
				System.out.println("��ǻ�� �� �̰���ϴ�."); 
		}
		// ����ڰ� ������ �Է��Ͽ�����
		else if(user.equals("Scissors")) {
			if(com.equals("Rock")) 
				System.out.println("��ǻ�� �� �̰���ϴ�."); 
			else if(com.equals("Scissors")) 
				System.out.println("�����ϴ�."); 
			else if(com.equals("Paper")) 
				System.out.println("����� �� �̰���ϴ�."); 
		}
		// ����ڰ� �� �� �Է��Ͽ��� ��
		else if(user.equals("Paper")) {
			if(com.equals("Rock")) 
				System.out.println("����� �� �̰���ϴ�.");
			else if(com.equals("Scissors")) 
				System.out.println("��ǻ�� �� �̰���ϴ�.");
			else if(com.equals("Paper")) 
				System.out.println("�����ϴ�.");
		}

	}
}


