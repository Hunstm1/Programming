package ppublicplacecrimes;

import java.util.Comparator;

public class AreaLocationCompare implements Comparator<Crime>{

	@Override
	public int compare(Crime c1, Crime c2) {
		// TODO Auto-generated method stub
		return c1.getAreaLocation().compareTo(c2.getAreaLocation());
	}
	
}


