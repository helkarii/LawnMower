package com.erya.src;

public class Position {

	private int x;

	private int y;

	private String orientation;

	public Position(int x, int y, String orientation) {
		super();
		this.x = x;
		this.y = y;
		this.orientation = orientation;
	}

	public Position() {
		// TODO Auto-generated constructor stub
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

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

}
