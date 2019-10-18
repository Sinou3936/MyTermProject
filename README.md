# MyTermProject

각각의 클래스에 대하여 나타내었다.

첫번째는 컴퓨터와 가위 바위 보 게임

두번째는 도둑 잡기 게임(카드 게임 X)

세번째는 Up & Down 게임 


메뉴 모음의 메인 클래스 생성 -> 첫 번째 게임 클래스를 생성 -> 두 번째 도둑 잡기 클래스 생성 -> 세 번째 Up & Down 게임 생성


#첫 번째 게임 클래스 생성

class RockPaperScissors { }

class Computer extends RockPaperScissors { ... }

class User extends RockPaperScissors { ... }

#두 번째 도둑 잡기 클래스 생성

class Police extends GameObjects{}

class Thife extends  GameObjects{}

class GamePlay extends GameObjects(){}

public abstract class GameObject {
	// x,y 거리를 추상 클래스에서 상속 받는 클래스들을 모두 사용 할 수 있게 해주는 변수들
	protected int distance;
	protected int x, y;
	//클래스 설정자로 위치와 거리 이동을 해주는 메소드 생성
	public GameObject(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.distance =dist;
	}
	// x위치 움직일 때 사용하는 get함수 메소드 생성
	public int getX() {
		return x;
	}
	// y위치 움직일 때 사용하는 get함수 메소드 생성
	public int getY() {
		return y;
	}
	// x위치 와 y 위치가 동일 한지 아닌지 판별하는 메소드 생성
	public boolean collide(GameObject p) {
		if(this.x == p.getX() && this.y == p.getY())
			return true;
		else 
			return false;
	}
	// 움직이는 메소드와 게임의 모양 표시하는 메소드 생성
	public abstract void move();
	public abstract char getShape();
}
