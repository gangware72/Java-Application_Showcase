package finalProject;

public class GeoLocation {

	protected double latitude; //instance variable latitude
	protected double longitude; //instance variable longitude
	
	public GeoLocation(){ //default constructor
		latitude = 0;
		longitude = 0;
	}
	
	public GeoLocation(double lat){ //non-default constructor for just latitude
		latitude = lat;
		longitude = 0;
		
	}
	
	public GeoLocation(double lat, double lon){ //non-default constructor for both latitude and longitude
		latitude = lat;
		longitude = lon;
	}
	
	public double getLatitude(){ //getter for latitude
		return latitude;
	}
	
	public double getLongitude(){ //getter for longitude
		return longitude;
	}
	
	public void setLatitude(double latitude){ //setter for latitude
		this.latitude = latitude;
	}
	
	public void setLongitude(double longitude){ //setter for latitude
		this.longitude = longitude;
	}
	
	public String toString(){ //to string function
		return latitude + "," + longitude + ",";
	}
	
	public boolean equals(GeoLocation location){ //equals function
		return (Math.abs(location.getLatitude()-latitude)<0.001) && (Math.abs((location.getLongitude()-longitude)) < .001)? true:false;
	}
	
	public double calcDistance(GeoLocation location){ // ((x1-x2)^2 + (y1-y2)^2)^(1/2), calculate geolocation distance
		return Math.pow(Math.pow((this.latitude-location.getLatitude()), 2) + Math.pow((this.longitude-location.getLongitude()),2),.5);
	}

	public double calcDistance(double lat, double lon){ //calculate distance given a lat and lon points
		return Math.pow(Math.pow(this.latitude-lat, 2) + Math.pow(this.longitude-lon, 2), .5);
	}
}
