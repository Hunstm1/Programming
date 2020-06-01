package ppublicplacecrimes;

public class Crime implements Comparable<Crime>{//RegionName is the defult compare
	private int index;
	private int areaCode;
	private String areaLocation;//
	private int victims;//
	private int popAtMid2015;
	private double ratePer10000;
	private double nzAdvrage;
	
	private int urbanAreaCode;
	private String urbanAreaName;
	private UrbanArea urbanAreaType;
	
	private int territorialCode;
	private String territorialName;//
	
	private int regionCode;
	private String regionName;
	
	public Crime(int index, int areaCode, String areaLocation, int victims, int popAtMid2015, int ratePer10000, double nzAdvrage) {
		this.index = index;
		this.areaCode = areaCode;
		this.areaLocation = areaLocation;
		this.victims = victims;
		this.popAtMid2015 = popAtMid2015;
		this.ratePer10000 = ratePer10000;
		this.nzAdvrage = nzAdvrage;
	}
	public Crime(int index, int areaCode, String areaLocation, int victims, int popAtMid2015, int ratePer10000, double nzAdvrage, int urbanAreaCode, String urbanAreaName, UrbanArea urbanAreaType) {
		this(index, areaCode, areaLocation, victims, popAtMid2015, ratePer10000, nzAdvrage);
		
		this.urbanAreaCode = urbanAreaCode;
		this.urbanAreaName = urbanAreaName;
		this.urbanAreaType = urbanAreaType;
	}
	public Crime(int index, int areaCode, String areaLocation, int victims, int popAtMid2015, int ratePer10000, double nzAdvrage, int urbanAreaCode, String urbanAreaName ,UrbanArea urbanAreaType, int territorialCode, String territorialName) {
		this(index, areaCode, areaLocation, victims, popAtMid2015, ratePer10000, nzAdvrage, urbanAreaCode, urbanAreaName, urbanAreaType);
		
		this.territorialCode = territorialCode;
		this.territorialName = territorialName;
	}
	public Crime(int index, int areaCode, String areaLocation, int victims, int popAtMid2015, int ratePer10000, double nzAdvrage, int urbanAreaCode, String urbanAreaName, UrbanArea urbanAreaType, int territorialCode, String territorialName, int regionCode, String regionName) {
		this(index, areaCode, areaLocation, victims, popAtMid2015, ratePer10000, nzAdvrage, urbanAreaCode, urbanAreaName, urbanAreaType, territorialCode, territorialName);
		
		this.regionCode = regionCode;
		this.regionName = regionName;
	}
	
	
	public int getIndex() {return index;}
	public int getAreaCode() {return areaCode;}
	public String getAreaLocation() {return areaLocation;}
	public int getVictims() {return victims;}
	public int getPopAtMid2015() {return popAtMid2015;}
	public double getRatePer10000() {return ratePer10000;}
	public double getNzAdvrage() {return nzAdvrage;}
	
	public int getUrbanAreaCode() {return urbanAreaCode;}
	public String getUrbanAreaName() {return urbanAreaName;}
	
	public UrbanArea getUrbanAreaType() {return urbanAreaType;}
	public int getTerritorialCode() {return territorialCode;}
	public String getTerritorialName() {return territorialName;}
	
	public int getRegionCode() {return regionCode;}
	public String getRegionName() {return regionName;}
	
	
	
	public void setIndex(int index) {this.index = index;}
	public void setAreaCode(int areaCode) {this.areaCode = areaCode;}
	public void setAreaLocation(String areaLocation) {this.areaLocation = areaLocation;}
	public void setVictims(int victims) {this.victims = victims;}
	public void setPopAtMid2015(int popAtMid2015) {this.popAtMid2015 = popAtMid2015;}
	public void setRatePer10000(double ratePer10000) {this.ratePer10000 = ratePer10000;}
	public void setNzAdvrage(double nzAdvrage) {this.nzAdvrage = nzAdvrage;}
	
	public void setUrbanAreaCode(int urbanAreaCode) {this.urbanAreaCode = urbanAreaCode;}
	public void setUrbanAreaName(String urbanAreaName) {this.urbanAreaName = urbanAreaName;}
	public void setUrbanAreaType(UrbanArea urbanAreaType) {this.urbanAreaType = urbanAreaType;}
	
	public void setTerritorialCode(int territorialCode) {this.territorialCode = territorialCode;}
	public void setTerritorialName(String territorialName) {this.territorialName = territorialName;}
	
	public void setRegionCode(int regionCode) {this.regionCode = regionCode;}
	public void setRegionName(String regionName) {this.regionName = regionName;}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("\n");
		builder.append("Area Location: " + areaLocation);
		builder.append("\n" + "Area Code: " + areaCode);
		builder.append("\n" + "Amount of Victims: " + victims);
		builder.append("\n" + "Population at mid 2015: " + popAtMid2015);
		builder.append("\n" + "Rate of Crimes per 10,000 people: " + ratePer10000);
		builder.append("\n" + "New Zealand Average: " + nzAdvrage);
		
		if (urbanAreaName != null) {
			builder.append("\n" + "Urban Area Name: " + urbanAreaName);
			builder.append("\n" + "Urban Area Code: " + urbanAreaCode);
			builder.append("\n" + "Urban Area Type: " + urbanAreaType);			
		}
		
		if (territorialName != null) {
			builder.append("\n" + "Territory Name: " + territorialName);
			builder.append("\n" + "Territory Code: " + territorialCode);
		}
		
		if (regionName != null) {
			builder.append("\n" + "Region Name: " + regionName);
			builder.append("\n" + "Region Area Code: " + regionCode);
		}
		builder.append("\n");
		return builder.toString();
	}
	@Override
	public int compareTo(Crime c) {
		// sorts by region name, secondary sort by area name
		if (regionName.compareTo(c.getRegionName()) == 0){	return areaLocation.compareTo(c.getAreaLocation());	}
		else { return regionName.compareTo(c.getRegionName()); }
	}
}
