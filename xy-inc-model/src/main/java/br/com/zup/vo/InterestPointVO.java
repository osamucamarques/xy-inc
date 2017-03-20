package br.com.zup.vo;

public class InterestPointVO {

	private String name;
	private int x;
	private int y;

	public InterestPointVO(String name2, int x2, int y2) {
		this.name = name2;
		this.x = x2;
		this.y = y2;
	}

	public InterestPointVO() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "[name = " + name + ", x =" + x + ", y = " + y + "]";
	}
}
