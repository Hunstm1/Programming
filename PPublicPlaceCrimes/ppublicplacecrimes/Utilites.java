package ppublicplacecrimes;

import java.util.ArrayList;
import java.util.Collections;

public class Utilites {
	AreaLocationCompare alc = new AreaLocationCompare();
	VictimsCompare vc = new VictimsCompare();
	TerritoryCompare tc = new TerritoryCompare();
	
	//area location search
	public void locationSearch(ArrayList<Crime> dataList, String search, ArrayList<Crime> selected) {		
		
		Collections.sort(dataList, alc);
		
		for (Crime item:dataList) {
			
			if (item.getAreaLocation().contains(search)) {
				selected.add(item);
			}
		}
		
		
	}
	//territory name search
	public void territorysearch(ArrayList<Crime> dataList, String search, ArrayList<Crime> selected) {		
		
		terratroyCompare(dataList);
		
		for (Crime item:dataList) {
			
			if (item.getTerritorialName().contains(search)) {
				selected.add(item);
			}
		}
		
		Collections.sort(selected);
	}
	//returns an array list of the largest amount of crimes
	public void getMax(ArrayList<Crime> dataList, ArrayList<Crime> selected) {
		Crime max = dataList.get(0);
		
		for (Crime crime : dataList) {
			if (max.getVictims() == crime.getVictims()) {
				selected.add(crime);
			}
			else if (max.getVictims() < crime.getVictims()) {
				selected.clear();
				max = crime;
			}
		}		
		
	}
	//returns a array list of the smallest amount of crimes
	public void getMin(ArrayList<Crime> dataList, ArrayList<Crime> selected) {
		Crime min = dataList.get(0);
		
		for (Crime crime : dataList) {
			if (min.getVictims() == crime.getVictims()) {
				selected.add(crime);
			}
			if (crime.getVictims() < min.getVictims()) {
				selected.clear();
				min = crime;
			}
		}

	}
	//Compare Methods
	public void victimsCompare(ArrayList<Crime> dataList) {Collections.sort(dataList, vc);}
	public void regionCompare(ArrayList<Crime> dataList) {Collections.sort(dataList);}
	public void terratroyCompare(ArrayList<Crime> dataList) {Collections.sort(dataList, tc);} 
	public void areaLocationCompare(ArrayList<Crime> dataList) {Collections.sort(dataList, alc);}
}