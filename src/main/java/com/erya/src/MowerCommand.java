package com.erya.src;

import java.util.ArrayList;
import java.util.List;


/**
 * this class allows the start of the project 
 * @author helkarii
 *
 */
public class MowerCommand {

	public static void main(String[] args) {

		List<Machine> listTondeuse = new ArrayList<>();
		List<Position> listPositions = new ArrayList<Position>();

		// Reading File
		List<String> listLinesFile = Utility.readFileLineByLine("././././src/main/resources/Command.txt");
		
		List<String> tailleTerrain = Utility.convertStringToListWithDelimiter(listLinesFile.get(0));
		// Create Terrain
		Field terrain = new Field(Integer.parseInt(String.valueOf(tailleTerrain.get(0))),
				Integer.parseInt(String.valueOf(tailleTerrain.get(1))));

		for (int i = 1; i < listLinesFile.size(); i = i + 2) {
			
			List<String> positionChaine = Utility.convertStringToListWithDelimiter(listLinesFile.get(i));

			String deplacements = listLinesFile.get(i + 1);
			
			//Create Position
			Position positionInitiale = new Position(Integer.parseInt(positionChaine.get(0)),
					Integer.parseInt(positionChaine.get(1)), positionChaine.get(2).charAt(0));

			// Create tondeuse
			Machine tondeuse = new Mower(positionInitiale, deplacements);

			listTondeuse.add(tondeuse);

		}
		
		for (Machine t : listTondeuse) {
			try {
				//Command tondeuse
				listPositions = t.command(terrain);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				continue;
			}
			t.display(listPositions);
		}
	}
}
