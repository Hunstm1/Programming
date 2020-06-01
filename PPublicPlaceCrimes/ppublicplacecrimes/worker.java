package ppublicplacecrimes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Worker {

	File data = new File("data.csv");
	Utilites utilites = new Utilites();
	
	
	int index = 0;
	int areaCode;
	String areaLocation;
	int victims;
	int popAtMid2015;
	int ratePer10000 = 0;
	double nzAdvrage = 0;
	
	int urbanAreaCode;
	String urbanAreaName;
	UrbanArea urbanAreaType;
	
	int territorialCode;
	String territorialName;
	
	int regionCode;
	String regionName;
	
	//reads in an external CSV file. 
	public void readFile(ArrayList<Crime> dataList) {
		try {
			Scanner scan = new Scanner(data);
			
			scan.nextLine().split(",");
			
			while (scan.hasNextLine()) {
				String[] feilds = scan.nextLine().split(",");
				int count = 0;
				for(String item:feilds) {

					if (item.contains("-")) { 			//Smoothes data for use, getting rid of "bad data" 
						count++;
					}
				}
				if (count == 0) {
				index++;
				areaCode = Integer.parseInt(feilds[1]);
				areaLocation = feilds[2];
				victims = Integer.parseInt(feilds[3]);
				popAtMid2015 = Integer.parseInt(feilds[4]);				
				ratePer10000 = Integer.parseInt(feilds[5]);
				nzAdvrage = Double.parseDouble(feilds[6]);
				
				urbanAreaCode = Integer.parseInt(feilds[7]);
				urbanAreaName = feilds[8];
				switch(feilds[9]) {
				case "Main urban area":
					urbanAreaType = UrbanArea.MAIN_URBAN_AREA;
					break;
				case "Secondary urban area":
					urbanAreaType = UrbanArea.SECONDARY_URBAN_AREA;
					break;
				case "Rural area":
					urbanAreaType = UrbanArea.RURAL_AREA;
				}
				//urbanAreaType = feilds[9];
				
				territorialCode = Integer.parseInt(feilds[10]);
				territorialName = feilds[11];
				
				regionCode = Integer.parseInt(feilds[12]);
				regionName = feilds[13];
				
				dataList.add(new Crime(index, areaCode, areaLocation, victims, popAtMid2015, ratePer10000, nzAdvrage, urbanAreaCode, urbanAreaName, urbanAreaType, territorialCode, territorialName, regionCode, regionName));			
				//dataList.
			}
			}
			scan.close();
		}
		catch(IOException e){
			System.out.println("there was a problem with this file");
			e.printStackTrace();
		}
				
	}
	//searches the main data for a area name from the inputed string, returns a single entry
	public void areaSearch(ArrayList<Crime> dataList, String search, ArrayList<Crime> selected) {	
		utilites.locationSearch(dataList, search, selected);
	}
	//searches the main data for a territory name from the imputed string. returns a array list of all of the matches
	public void territorySearch(ArrayList<Crime> dataList, String search, ArrayList<Crime> selected) {	
		utilites.territorysearch(dataList, search, selected);
	}
	//calls the getMax method in the utilities class, 
	public void getMax(ArrayList<Crime> dataList, ArrayList<Crime> selected) {
		utilites.getMax(dataList, selected);
	}	
	//calls the getMin method in the utilities class, 
	public void getMin(ArrayList<Crime> dataList, ArrayList<Crime> selected) {
		utilites.getMin(dataList, selected);
	}
	
	
	//Calls the Sorting methods
	public void sortByregion(ArrayList<Crime> dataList) {utilites.regionCompare(dataList);}
	public void sortByVictims(ArrayList<Crime> dataList) {utilites.victimsCompare(dataList);}
	public void sortByTerratory(ArrayList<Crime> dataList) {utilites.terratroyCompare(dataList);}
	public void sortByArea(ArrayList<Crime> dataList) {utilites.areaLocationCompare(dataList);}
	
	
	
}
