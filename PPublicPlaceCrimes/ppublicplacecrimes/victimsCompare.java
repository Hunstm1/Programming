package ppublicplacecrimes;

import java.util.Comparator;

public class VictimsCompare implements Comparator<Crime>{

	@Override
	public int compare(Crime c1, Crime c2) {
		// TODO Auto-generated method stub
		return c1.getVictims() - c2.getVictims();
	}

}
