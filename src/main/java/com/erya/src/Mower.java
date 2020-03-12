package com.erya.src;

import java.util.ArrayList;
import java.util.List;

/**
 * Class heritate Machine and redifine the command method
 * 
 * @author helkarii
 *
 */
public class Mower extends Machine {

	private String orientations = "NESO";

	public Mower() {

	}

	public Mower(Position position, String deplacements) {
		super(position, deplacements);
	}

	/**
	 * Allows to change direction of way when having 'G'
	 * @param orientation (N;E;S;O)
	 * @return a char representing an orientation
	 */
	public char turnToLeft(char orientation) {

		int index = orientations.indexOf(orientation);

		if (index == 3) {
			return 'N';
		} else {
			return orientations.charAt(index + 1);
		}
	}

	/**
	 * Allows to change direction of way when having 'D'
	 * @param orientation (N;E;S;O)
	 * @return a char representing an orientation
	 */
	public char turnToRight(char orientation) {

		int index = orientations.indexOf(orientation);

		if (index == 0) {
			return 'O';
		}
		else {
			return orientations.charAt(index - 1);
		}

	}

	@Override
	public List<Position> command(Field terrain) throws Exception {
		// TODO Auto-generated method stub

		List<Position> listPositions = new ArrayList<Position>();
		
		Position positionIntermediaire = new Position(this.getInitialPosition().getX(),
				this.getInitialPosition().getY(), this.getInitialPosition().getOrientation());

		String deplacements = this.getMovingInstructions();

		for (int i = 0; i < deplacements.length(); i++) {

			char character = deplacements.charAt(i);
			Position positionFinale = new Position();

			if (character == 'G') {

				char newOrientation = turnToLeft(positionIntermediaire.getOrientation());

				positionIntermediaire.setOrientation(newOrientation);

			} else if (character == 'D') {

				char newOrientation = turnToRight(positionIntermediaire.getOrientation());

				positionIntermediaire.setOrientation(newOrientation);

			} else if (character == 'A') {

				switch (positionIntermediaire.getOrientation()) {
				case 'S': {
					positionIntermediaire.setX((positionIntermediaire.getX()) - 1);
					break;
				}
				case 'N': {
					positionIntermediaire.setX((positionIntermediaire.getX()) + 1);
					break;
				}
				case 'O': {
					positionIntermediaire.setY(positionIntermediaire.getY() - 1);
					break;
				}
				case 'E': {
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

		System.out.println("la position initiale de la tondeuse est : \n" + this.getInitialPosition().getX() + " "
				+ this.getInitialPosition().getY() + " " + this.getInitialPosition().getOrientation());
		System.out.println("les positions intermédiaires sont : ");

		for (Position p : positions) {
			System.out.println(p.getX() + " " + p.getY() + " " + p.getOrientation());
		}
		System.out.println("la position finale de la tondeuse est : \n" + positionFinale.getX() + " "
				+ positionFinale.getY() + " " + positionFinale.getOrientation());

	}
}
