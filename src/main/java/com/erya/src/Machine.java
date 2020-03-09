package com.erya.src;

import java.util.ArrayList;
import java.util.List;

public abstract class Machine {

	private Position positionIntiale;

	private List<String> instructionDeplacement = new ArrayList<String>();

	public Machine() {

	}

	public Machine(Position positionIntiale, List<String> instructionDeplacement) {
		super();
		this.positionIntiale = positionIntiale;
		this.instructionDeplacement = instructionDeplacement;
	}

	public Position getPositionIntiale() {
		return positionIntiale;
	}

	public void setPositionIntiale(Position positionIntiale) {
		this.positionIntiale = positionIntiale;
	}

	public List<String> getInstructionDeplacement() {
		return instructionDeplacement;
	}

	public void setInstructionDeplacement(List<String> instructionDeplacement) {
		this.instructionDeplacement = instructionDeplacement;
	}

	public abstract List<Position> command(Terrain terrain) throws Exception;

	public abstract void display(List<Position> positions);

}
