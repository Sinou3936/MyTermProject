package gamePackage;

import java.util.Scanner;

class UpNDown implements UpNDownGame { // 인터페이스 사용
	//필드 생성
	static int Min = 0;
	static int Max = 99;
	int random = (int)(Math.random()*100);
	static int number =0;
	static int count = 1;
	static String restart;
	Scanner input = new Scanner(System.in);

	// UpNDown 입력 값 설정
	public void UpNDown() {
		System.out.println(Min+"-"+Max);
		System.out.print(count+"번 >>> ");
		number = input.nextInt();
		count++;

	}
	//게임 재시작 메소드 생성하여 게임 초기화
	public void ReStartgame() {
		Min =0;
		Max =99;
		random = (int)(Math.random()*100);
		number =0;
		count =1;
		System.out.println(Min+"-"+Max);
		System.out.print(count+"번 >>> ");
		number = input.nextInt();
		count++;
	}

	@Override
	public void Up() { // 인터페이스의 메소드 재정의
		// TODO Auto-generated method stub
		if(random>number) {
				System.out.println("더 높게");
				Min = number;
		}

	}

	@Override
	public void Down() { // 인터페이스의 메소드 재정의
		// TODO Auto-generated method stub
		if(random<number) {
				System.out.println("더 낮게");
				Max = number;		
			}

	}

}