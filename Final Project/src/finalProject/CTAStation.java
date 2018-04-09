package finalProject;

import java.util.ArrayList;

public class CTAStation extends GeoLocation {
	
	private String name; //Holds a string for the name of the station
	private String location; //desecribes if the station is elevated, subway or ground level
	private boolean wheelchair; //boolean value that returns true if there is a wheelchair
	private int[] position; //int array that holds the position of the station on a given line. 0-red, 1-green, etc.
	
	public CTAStation(){ //automatically calls the default constructor of the superclass (GeoLocation). This is the non default constructor.
		name = "";
		location = "";
		wheelchair = false;
		position = new int[8];
	}
	
	public CTAStation(String n, double latitude, double longitude, String l, boolean w, int[] p){ //non default constructor
		super(latitude, longitude);
		name = n;
		location = l;
		wheelchair = w;
		position = p;
	}
	
	
	public String getName(){ //getter
		return name;
	}
	
	public String getLocation(){ //getter
		return location;
	}

	public boolean getWheelchair(){ //getter
		return wheelchair;
	}
	
	public int[] getArrayofPositions(){ //getter
		return position;
	}
	
	public void setName(String n){ //setter
		name = n;
	}
	
	public void setLocation(String l){ //setter
		location = l;
	}
	
	public void setWheelchair(boolean w){ //setter
		wheelchair = w;
	}
	
	public void setPosition(int index, int pos){ //setposition, given the index for the line and then the int position this station holds on that line
		position[index] = pos;
	}
	
	public String toString(){ //toString
		return name + "," + super.toString() + location + "," +  (wheelchair?true:false) + "," + position[0] + "," + position[1] + ","+ position[2] + ","+ position[3] + ","+position[4] +"," + position[5] + "," +position[6] +","+ position[7];
	}
	
	public boolean equals(CTAStation ctastation){ //equals method
		return (super.equals(ctastation)  && (ctastation.getWheelchair() == this.wheelchair) && (ctastation.getLocation().equals(this.location)) && (this.name.equals(ctastation.getName()))) ;
	}
	
	public double calcDistance(CTAStation location){ //calls calcDistance of superclass on object
		return super.calcDistance(location);
	}
	
	public double calcDistance(double lat, double lon){ //calls calcDistance of superclass Geolocation
		return super.calcDistance(lat, lon);
	}
	
	public String displayStationNames(){ //displays the station name
		return this.getName();
			
		}

}
	
	

