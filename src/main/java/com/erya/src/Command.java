package com.erya.src;

import java.util.List;

/**
 * interface used to command different object 
 * @author helkarii
 *
 */
public interface Command {
	/**
	 * this method can command the lawn mower in a field
	 * @param terrain
	 * @return a list of position traveled by the mower
	 * @throws Exception generated if the lawn mower exceeds the boundaries of the field
	 */
	public abstract List<Position> command(Field terrain) throws Exception;


}
