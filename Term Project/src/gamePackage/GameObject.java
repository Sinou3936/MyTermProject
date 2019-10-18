package gamePackage;

import java.util.Scanner;
//������ ��ġ ���� �� �����ϼ� �ְ� ���ִ� �߻� Ŭ���� ����
public abstract class GameObject {
	// x,y �Ÿ��� �߻� Ŭ�������� ��� �޴� Ŭ�������� ��� ��� �� �� �ְ� ���ִ� ������
	protected int distance;
	protected int x, y;
	//Ŭ���� �����ڷ� ��ġ�� �Ÿ� �̵��� ���ִ� �޼ҵ� ����
	public GameObject(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.distance =dist;
	}
	// x��ġ ������ �� ����ϴ� get�Լ� �޼ҵ� ����
	public int getX() {
		return x;
	}
	// y��ġ ������ �� ����ϴ� get�Լ� �޼ҵ� ����
	public int getY() {
		return y;
	}
	// x��ġ �� y ��ġ�� ���� ���� �ƴ��� �Ǻ��ϴ� �޼ҵ� ����
	public boolean collide(GameObject p) {
		if(this.x == p.getX() && this.y == p.getY())
			return true;
		else 
			return false;
	}
	// �����̴� �޼ҵ�� ������ ��� ǥ���ϴ� �޼ҵ� ����
	public abstract void move();
	public abstract char getShape();
}
