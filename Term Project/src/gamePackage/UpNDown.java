package gamePackage;

import java.util.Scanner;

class UpNDown implements UpNDownGame { // �������̽� ���
	//�ʵ� ����
	static int Min = 0;
	static int Max = 99;
	int random = (int)(Math.random()*100);
	static int number =0;
	static int count = 1;
	static String restart;
	Scanner input = new Scanner(System.in);

	// UpNDown �Է� �� ����
	public void UpNDown() {
		System.out.println(Min+"-"+Max);
		System.out.print(count+"�� >>> ");
		number = input.nextInt();
		count++;

	}
	//���� ����� �޼ҵ� �����Ͽ� ���� �ʱ�ȭ
	public void ReStartgame() {
		Min =0;
		Max =99;
		random = (int)(Math.random()*100);
		number =0;
		count =1;
		System.out.println(Min+"-"+Max);
		System.out.print(count+"�� >>> ");
		number = input.nextInt();
		count++;
	}

	@Override
	public void Up() { // �������̽��� �޼ҵ� ������
		// TODO Auto-generated method stub
		if(random>number) {
				System.out.println("�� ����");
				Min = number;
		}

	}

	@Override
	public void Down() { // �������̽��� �޼ҵ� ������
		// TODO Auto-generated method stub
		if(random<number) {
				System.out.println("�� ����");
				Max = number;		
			}

	}

}