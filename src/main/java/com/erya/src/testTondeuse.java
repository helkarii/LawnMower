package com.erya.src;

import java.util.ArrayList;
import java.util.List;

public class testTondeuse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> listLines = Utility.readFileLineByLine("././././src/main/resources/instuctionsToCommand.txt");
		
		List<String>  listString= Utility.convertStringToListWithDelimiter(listLines.get(0));
		Terrain terrain = new Terrain(Integer.parseInt(listString.get(0)), Integer.parseInt(listString.get(1)));
		List<Machine> listTondeuse = new ArrayList<>();
		List<Position> positions  = new ArrayList<Position>();
		for (int i = 1; i<listLines.size(); i = i + 2) { 
			List<String> listPositions = Utility.convertStringToListWithDelimiter(listLines.get(i));
			List<String> instrDeplacements= Utility.convertStringToListWithNoDelimiter(listLines.get(i + 1));
			Position positionInitiale = new Position(Integer.parseInt(listPositions.get(0)),
					Integer.parseInt(listPositions.get(1)), listPositions.get(2));
			Machine tondeuse = new Tondeuse ( positionInitiale, instrDeplacements);	
			listTondeuse.add(tondeuse);
		}
				for(Machine t: listTondeuse) {
					try {
						System.out.println("\n ---------------------- \n");
						positions = t.command(terrain);
				}catch(Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
					t.display(positions);
				}
		}
		}
