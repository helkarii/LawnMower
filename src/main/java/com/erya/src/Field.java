package com.erya.src;

public class Field {

	private int Xmax;

	private int Ymax;

	public Field(int Xmax, int Ymax) {
		super();
		this.Xmax = Xmax;
		this.Ymax = Ymax;
	}

	public int getXmax() {
		return Xmax;
	}

	public void setXmax(int xmax) {
		Xmax = xmax;
	}

	public int getYmax() {
		return Ymax;
	}

	public void setYmax(int ymax) {
		Ymax = ymax;
	}

}
