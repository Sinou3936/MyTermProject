package gamePackage;

import java.util.Scanner;

class RockPaperScissors {
	//최 상위 클래스  아무것도 설정 하지 않고 시작
}
class Computer extends RockPaperScissors{ // 최상위 클래스의 상속 클래스인 Computer 클래스
	//컴퓨터가 사용할 가위 바위 보 배열 객체 생성
	String gameset1[] = {"Scissors", "Rock", "Paper"};
	//각 배열를 랜덤을 받아 올수 있게 해주는 변수  객체 생성
	int  n = (int)(Math.random()*2)+1;
	// 배열을 담을 문자열  객체생성
	public String com;

	public Computer() {
		// TODO Auto-generated constructor stub
		//랜덤으로 생성한 값을 com 문자열에 대입
		com = gameset1[n];
	}
	public void comshow() {
		//com 값을  가져올 때 마다 랜덤을 생성하여 화면에 보여준다.
		System.out.print("컴퓨터가 낸 것은 "+com+" ");
	}
}

class User extends Computer{ // Computer 클래스의 상속 클래스인 User 클래스
	Scanner input = new Scanner(System.in);
	//static을 이용하여 user 객체 생성;
	public static String user;

	//User 클래스 설정자 생성
	public User() {
		System.out.print("Scissors,Rock,Paper>>> ");
		user = input.next();
	}
	// 두 클래스 비교하는 메소드 생성
	public void Show() {

		System.out.print("사용자가 낸 것은"+ user+" ");
		super.comshow(); //User클래스를 Computer 클래스 상속 시켜서 사용

		// 사용자가 가위, 바위, 보를 한 결과 값 비교하여 문자 출력
		// 사용자 바위를 입력하였을때
		if(user.equals("Rock")) {
			if(com.equals("Rock")) 
				System.out.println("비겼습니다."); 
			else if(com.equals("Scissors")) 
				System.out.println("사용자 가 이겼습니다."); 
			else if(com.equals("Paper")) 
				System.out.println("컴퓨터 가 이겼습니다."); 
		}
		// 사용자가 가위를 입력하였을때
		else if(user.equals("Scissors")) {
			if(com.equals("Rock")) 
				System.out.println("컴퓨터 가 이겼습니다."); 
			else if(com.equals("Scissors")) 
				System.out.println("비겼습니다."); 
			else if(com.equals("Paper")) 
				System.out.println("사용자 가 이겼습니다."); 
		}
		// 사용자가 보 를 입력하였을 때
		else if(user.equals("Paper")) {
			if(com.equals("Rock")) 
				System.out.println("사용자 가 이겼습니다.");
			else if(com.equals("Scissors")) 
				System.out.println("컴퓨터 가 이겼습니다.");
			else if(com.equals("Paper")) 
				System.out.println("비겼습니다.");
		}

	}
}


