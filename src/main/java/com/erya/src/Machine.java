package com.erya.src;

import java.util.List;

/**
 * class abstract can be used to instanciate different machine
 * @author helkarii
 *
 */
public abstract class Machine implements Command {

	private Position initialPosition;

	private String movingInstructions;

	public Machine() {

	}

	public Machine(Position initialPosition, String movingInstructions) {
		super();
		this.initialPosition = initialPosition;
		this.movingInstructions = movingInstructions;
	}

	public Position getInitialPosition() {
		return initialPosition;
	}

	public void setInitialPosition(Position initialPosition) {
		this.initialPosition = initialPosition;
	}

	public String getMovingInstructions() {
		return movingInstructions;
	}

	public void setMovingInstructions(String movingInstructions) {
		this.movingInstructions = movingInstructions;
	}

	public abstract void display(List<Position> positions);

}
