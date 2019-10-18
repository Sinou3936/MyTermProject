package gamePackage;

import java.util.Scanner;
//����ڰ� �����ϼ� �ִ� Ŭ���� ������ �߻�ȭ Ŭ���� GameObject�� ��� �޾� ���
class Police extends GameObject{
	public static String location;
	//GameObject���� ������ �޼ҵ� �ҷ��ͼ� ������
	public Police(int x, int y ,int dist) {
		// TODO Auto-generated constructor stub
		super(x, y, dist);
	}
	//move �޼ҵ� �ҷ��� ������
	@Override
	public void move() { 
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("����(a),����(w),�Ʒ���(s),������(d)>>> ");
		location = input.next();
		// ������ �������� ���� ������ "-"�� ǥ��
		Gameplay.map[x][y] = '-';
		// ��,��,��,�� �����̴� �� ���࿡ ������ ������ ���ϰ� ���� ������ ����� �������ش�.
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
		//���� ������ ��ġ�� ��� �޼ҵ� �ҷ��� �����ش�.
		Gameplay.map[x][y] =getShape();
	}
	//GameObjects �� ��� �޼ҵ� �ҷ��ͼ� ������
	@Override
	public char getShape() {
		// TODO Auto-generated method stub
		return 'P';
	}

}
//��ǻ�Ͱ� ������ Thief Ŭ���� ���� �� �߻� Ŭ���� ��ӹ޾Ƽ� ���
class Thief extends GameObject{
	//GameObject���� ������ �޼ҵ� �ҷ��ͼ� ������
	public Thief(int x, int y ,int distance) {
		// TODO Auto-generated constructor stub
		super(x, y, distance);
	}
	//move �޼ҵ� �ҷ��� ������
	@Override
	public void move() {
		// TODO Auto-generated method stub
		int num = (int)(Math.random()*4); //��,��,��,�� ������ �� �ְ� 0~3������ ��ġ �̵� ��Ű�� ���� �Լ� ����
		//�ʱ� ȭ�� ��� "-" ǥ��
		Gameplay.map[x][y] = '-';
		//��,��,��,�� �� num�� ���� ���� ������ ���� ���� ������ ������ ���ϰ� �ϱ� ���� ���� ����
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
		// ���� �ʿ� ��� �޼ҵ� �ҷ��ͼ� ������
		Gameplay.map[x][y] =getShape();
	}
	//GameObejcts�� ��� �޼ҵ� �ҷ��� ������
	@Override
	public char getShape() {
		// TODO Auto-generated method stub
		return 'T';
	}

}

class Gameplay {
	//������ �� ũ�⸦ ���� �ٸ� Ŭ�������� map ��� �� �� �ְ� ���� ���� ���
	public static char map[][]= new char[10][10];
	// �� Ŭ���� ���� �̸� ����
	Police police;
	Thief thief;
	// ������ 20�� ���
	int count =20;
	// ������ �ٽ� ������ �� �̸� ����
	static String restartgame;
	// ���� �ʱ�ȭ �޼ҵ� 
	public void Gameplay() {
		Scanner player = new Scanner(System.in);
		Scanner computer = new Scanner(System.in);
		//ĳ���� �� ��ġ�� �������ش�.
		System.out.print("����� ��ġ ����>>> ");
		int px = player.nextInt();
		int py = player.nextInt();
		System.out.print("��ǻ�� ��ġ ����>>> ");
		int cx = computer.nextInt();
		int cy = computer.nextInt();
		//�Է� ���� ���� ��ġ�� ����ϰ� �Ǿ� �ش�.
		police = new Police(px, py, 1);
		thief = new Thief(cx, cy, 1);
		
		
		// ���� ũ�⸦ ǥ�� ���ֱ� ���� �ݺ��� ���
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++)
				map[i][j] = '-';
		}
		// ��ġ�� ����ڿ� ��ǻ�Ͱ� �ִ� ���� ȭ�鿡 �����ֱ� ���� ���
		map[police.x][police.y] = police.getShape();
		map[thief.x][thief.y] = thief.getShape();

	}
	// ������ �� ���� ǥ��
	public void MapView() {
		// ������ ���� ������ ��ȭ ���� �� �ְ� ������ �����ش�.
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) 
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
	}
	// �̱涧 �����ִ� ���� ǥ��
	public void WinView() {
		// �����(����)�� (��) ��ǻ��(����)�� ����� �� ����ڸ� ������ �ϴ� �����ش�.
		map[police.x][police.y] = police.getShape();
		// ������� ��ġ�� �����ֱ� ���� �ݺ��� ���
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[i].length; j++) 
				System.out.print(map[i][j]+" ");
			System.out.println();
		}
	}
	//���� ���� �޼ҵ�
	public void play() {
		Gameplay(); // �ʱ� ���� ����
		while(true) {
			// �����϶� ���� �����ְ� ����ڿ� ��ǻ�Ͱ� �������� �� �����ش�.
			MapView();
			police.move();
			//���� ������ ���� ���� �ϰ� ������ q ��ư �̿�
			if(Police.location.equals("q")) {
				System.out.println("���� ���� ����");
				break;
			}
			thief.move();
			// count�� 20���� �ʱ�ȭ �� ���� �ѹ� �� �� ���� ���ָ鼭 ���
			System.out.println("���� Ƚ��:"+(count--));
			// ���� ����� ���� ���� ��ġ�ϸ� ������ �¸� �ϰ� �ȴ�.
			if(police.collide(thief) == true) {
				WinView();
				System.out.println("������ ������ ��ҽ��ϴ�.");
				System.out.print("������ ���� �ϰڽ��ϱ�??(y/n)>> ");
				Scanner input = new Scanner(System.in);
				restartgame = input.nextLine();
				if(restartgame.equals("y")) {
					System.out.println("���� ����..");
					break;
				}
				// ������ �������� �ʰ� �ٽ� �ϰ� ������ n�� ������ ���� ������Ѵ�.
				else {
					System.out.println("������ �ٽ� �����մϴ�.");
					ReStartGame();
				}
			}
			//���ӿ��� �� ��� �׸��� ���� ���� 0�� ���� ���� �� ��츦 �����ش�.
			else if((police.collide(thief)==false) && count==0){
				System.out.println("������ ���������ϴ�.");
				System.out.print("������ ���� �ϰڽ��ϱ�??(y/n)>> ");
				Scanner input = new Scanner(System.in);
				restartgame = input.nextLine();
				if(restartgame.equals("y")) {
					System.out.println("���� ����..");
					break;
				}
				// ������ �������� �ʰ� �ٽ� �ϰ� ������ n�� ������ ���� ������Ѵ�.
				else {
					System.out.println("������ �ٽ� �����մϴ�.");
					ReStartGame();
					
				}
			}
		}
	}
	//����� �޼ҵ� �ʱ�ȭ �Ͽ� ����
	public void ReStartGame() {
		Gameplay();
		count =20;
	}
	
}
