package gamePackage;

import java.util.Scanner;
//사용자가 움직일수 있는 클래스 생성후 추상화 클래스 GameObject를 상속 받아 사용
class Police extends GameObject{
	public static String location;
	//GameObject에서 설정자 메소드 불러와서 재정의
	public Police(int x, int y ,int dist) {
		// TODO Auto-generated constructor stub
		super(x, y, dist);
	}
	//move 메소드 불러와 재정의
	@Override
	public void move() { 
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("왼쪽(a),위쪽(w),아래쪽(s),오른쪽(d)>>> ");
		location = input.next();
		// 게임이 움직이지 않을 때에는 "-"로 표시
		Gameplay.map[x][y] = '-';
		// 상,하,좌,우 움직이는 것 만약에 밖으로 나가지 못하게 범위 설정한 값들로 지정해준다.
		if(location.equals("a")) {
			if(y==0) {
				y=0;
			}
			else
				y -=distance;
		}else if(location.equals("w")) {
			if (x==0) {
				x=0;
			}
			else
				x -= distance;
		}else if(location.equals("d")) {
			if(y ==9) {
				y=9;
			}
			else
				y += distance;
		}else if(location.equals("s")) {
			if(x==9) {
				x=9;
			}
			else
				x += distance;
		}
		//게임 지도의 위치에 모양 메소드 불러서 보여준다.
		Gameplay.map[x][y] =getShape();
	}
	//GameObjects 의 모양 메소드 불러와서 재정의
	@Override
	public char getShape() {
		// TODO Auto-generated method stub
		return 'P';
	}

}
//컴퓨터가 움직일 Thief 클래스 생성 후 추상 클래스 상속받아서 사용
class Thief extends GameObject{
	//GameObject에서 설정자 메소드 불러와서 재정의
	public Thief(int x, int y ,int distance) {
		// TODO Auto-generated constructor stub
		super(x, y, distance);
	}
	//move 메소드 불러와 재정의
	@Override
	public void move() {
		// TODO Auto-generated method stub
		int num = (int)(Math.random()*4); //상,하,좌,우 움직일 수 있게 0~3번으로 위치 이동 시키는 랜덤 함수 생성
		//초기 화면 모습 "-" 표기
		Gameplay.map[x][y] = '-';
		//상,하,좌,우 중 num의 값에 따라서 움직임 만약 맵의 밖으로 나가지 못하게 하기 위해 범위 설정
		if(num == 0) {
			if(y==0)
				y=0;
			else
				y -=distance;
		}else if(num ==1) {
			if(x==0)
				x=0;
			else
				x -= distance;
		}
		else if(num == 2) {
			if(y==9)
				y =9;
			else
				y += distance;
		}else if(num == 3) {
			if(x==9)
				x=9;
			else 
				x += distance;
		}
		// 현재 맵에 모양 메소드 불러와서 보여줌
		Gameplay.map[x][y] =getShape();
	}
	//GameObejcts의 모양 메소드 불러와 재정의
	@Override
	public char getShape() {
		// TODO Auto-generated method stub
		return 'T';
	}

}

class Gameplay {
	//게임의 맵 크기를 설정 다른 클래스에도 map 사용 할 수 있게 정적 변수 사용
	public static char map[][]= new char[10][10];
	// 각 클래스 마다 이름 생성
	Police police;
	Thief thief;
	// 게임을 20턴 사용
	int count =20;
	// 게임을 다시 시작할 수 이름 생성
	static String restartgame;
	// 게임 초기화 메소드 
	public void Gameplay() {
		Scanner player = new Scanner(System.in);
		Scanner computer = new Scanner(System.in);
		//캐릭터 별 위치를 선정해준다.
		System.out.print("사용자 위치 선정>>> ");
		int px = player.nextInt();
		int py = player.nextInt();
		System.out.print("컴퓨터 위치 선정>>> ");
		int cx = computer.nextInt();
		int cy = computer.nextInt();
		//입력 받은 값의 위치에 출력하게 되어 준다.
		police = new Police(px, py, 1);
		thief = new Thief(cx, cy, 1);
		
		
		// 맵의 크기를 표현 해주기 위해 반복문 사용
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++)
				map[i][j] = '-';
		}
		// 위치에 사용자와 컴퓨터가 있는 것을 화면에 보여주기 위해 사용
		map[police.x][police.y] = police.getShape();
		map[thief.x][thief.y] = thief.getShape();

	}
	// 움직일 때 지도 표기
	public void MapView() {
		// 움직임 있을 때에도 변화 해줄 수 있게 지도로 보여준다.
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) 
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
	}
	// 이길때 보여주는 지도 표기
	public void WinView() {
		// 사용자(경찰)가 (이) 컴퓨터(도둑)을 잡았을 때 사용자만 나오게 하는 보여준다.
		map[police.x][police.y] = police.getShape();
		// 사용자의 위치를 보여주기 위해 반복문 사용
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) 
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
	}
	//게임 시작 메소드
	public void play() {
		Gameplay(); // 초기 게임 설정
		while(true) {
			// 움직일때 맵을 보여주고 사용자와 컴퓨터가 움직으는 걸 보여준다.
			MapView();
			police.move();
			//만약 게임을 강제 종료 하고 싶으면 q 버튼 이용
			if(Police.location.equals("q")) {
				System.out.println("게임 강제 종료");
				break;
			}
			thief.move();
			// count를 20으로 초기화 한 값을 한번 할 때 마다 빼주면서 사용
			System.out.println("남은 횟수:"+(count--));
			// 경찰 모양이 도둑 모양과 일치하면 게임을 승리 하게 된다.
			if(police.collide(thief) == true) {
				WinView();
				System.out.println("경찰이 도둑을 잡았습니다.");
				System.out.print("게임을 종료 하겠습니까??(y/n)>> ");
				Scanner input = new Scanner(System.in);
				restartgame = input.nextLine();
				if(restartgame.equals("y")) {
					System.out.println("게임 종료..");
					break;
				}
				// 게임을 종료하지 않고 다시 하고 싶으면 n을 눌러서 게임 재시작한다.
				else {
					System.out.println("게임을 다시 시작합니다.");
					ReStartGame();
				}
			}
			//게임에서 질 경우 그리고 남은 턴이 0과 같이 종료 될 경우를 보여준다.
			else if((police.collide(thief)==false) && count==0){
				System.out.println("도둑이 도망갔습니다.");
				System.out.print("게임을 종료 하겠습니까??(y/n)>> ");
				Scanner input = new Scanner(System.in);
				restartgame = input.nextLine();
				if(restartgame.equals("y")) {
					System.out.println("게임 종료..");
					break;
				}
				// 게임을 종료하지 않고 다시 하고 싶으면 n을 눌러서 게임 재시작한다.
				else {
					System.out.println("게임을 다시 시작합니다.");
					ReStartGame();
					
				}
			}
		}
	}
	//재시작 메소드 초기화 하여 생성
	public void ReStartGame() {
		Gameplay();
		count =20;
	}
	
}
