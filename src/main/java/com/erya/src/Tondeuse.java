package com.erya.src;

import java.util.ArrayList;
import java.util.List;

public class Tondeuse extends Machine {

	public Tondeuse() {

	}

	public Tondeuse(Position position, List<String> listCharMove) {
		// TODO Auto-generated constructor stub
		super(position, listCharMove);
	}

	@Override
	public List<Position> command(Terrain terrain) throws Exception {
		// TODO Auto-generated method stub

		List<Position> listPositions = new ArrayList<Position>();
		Position positionIntermediaire = new Position(this.getPositionIntiale().getX(),
				this.getPositionIntiale().getY(), this.getPositionIntiale().getOrientation());
		for (String character : this.getInstructionDeplacement()) {
			Position positionFinale = new Position();
			if (character.equals("G")) {
				switch (positionIntermediaire.getOrientation()) {
				case "S": {
					positionIntermediaire.setOrientation("O");
					break;
				}
				case "N": {
					positionIntermediaire.setOrientation("E");
					break;
				}
				case "O": {
					positionIntermediaire.setOrientation("N");
					break;
				}
				case "E": {
					positionIntermediaire.setOrientation("S");
					break;
				}
				}
			} else if (character.equals("D")) {
				switch (positionIntermediaire.getOrientation()) {
				case "S": {
					positionIntermediaire.setOrientation("E");
					break;
				}
				case "N": {
					positionIntermediaire.setOrientation("O");
					break;
				}
				case "O": {
					positionIntermediaire.setOrientation("S");
					break;
				}
				case "E": {
					positionIntermediaire.setOrientation("N");
					break;
				}
				}
			} else if (character.equals("A")) {
				switch (positionIntermediaire.getOrientation()) {
				case "S": {
					positionIntermediaire.setX((positionIntermediaire.getX()) - 1);
					break;
				}
				case "N": {
					positionIntermediaire.setX((positionIntermediaire.getX()) + 1);
					break;
				}
				case "O": {
					positionIntermediaire.setY(positionIntermediaire.getY() - 1);
					break;
				}
				case "E": {
					positionIntermediaire.setY(positionIntermediaire.getY() + 1);
					break;
				}
				}

			}

			positionFinale.setX(positionIntermediaire.getX());
			positionFinale.setY(positionIntermediaire.getY());
			positionFinale.setOrientation(positionIntermediaire.getOrientation());
			if (positionFinale.getX() > terrain.getXmax() || positionFinale.getX() < 0
					|| positionFinale.getY() > terrain.getYmax() || positionFinale.getY() < 0) {
				throw new Exception("La tondeuse ne peut pas sortir en dehors du terrain \n");
			}
			listPositions.add(positionFinale);

		}
		return listPositions;
	}

	@Override
	public void display(List<Position> positions) {
		Position positionFinale = positions.get(positions.size() - 1);
		System.out.println("la position initiale de la tondeuse est : \n" + this.getPositionIntiale().getX() + " "
				+ this.getPositionIntiale().getY() + " " + this.getPositionIntiale().getOrientation());
		System.out.println("les positions intermédiaires sont : ");
		for (Position p : positions) {
			System.out.println(p.getX() + " " + p.getY() + " " + p.getOrientation());
		}
		System.out.println("la position finale de la tondeuse est : \n" + positionFinale.getX() + " "
				+ positionFinale.getY() + " " + positionFinale.getOrientation());

	}
}
