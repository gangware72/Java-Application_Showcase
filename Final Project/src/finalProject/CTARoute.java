package finalProject;

import java.util.ArrayList;
import java.util.Scanner;

public class CTARoute{

	private String lineColor; //instnce variable that holds a string for the line color
	private ArrayList<CTAStation> ctaRoute; //instance variable that holds one route of CTAStation arrays
	private int lineInt; //5 = Red, 6 = Green, 7 = Blue, 8 = Brown, 9 = Purple, 10 = Pink, 11 = Orange, 12 = Yellow
	
	public CTARoute(){ //default constructor
		lineColor = "";
		ctaRoute = new ArrayList<CTAStation>();
		lineInt = 0;
	}
	public CTARoute(String lineColor, ArrayList<CTAStation> ctaRoute, int lineInt) { //non default constructor
		this.lineColor = lineColor;
		this.ctaRoute = ctaRoute;
		this.lineInt = lineInt;
	}
	
	public String getLineColor(){ //getter
		return lineColor;
	}
	
	public int getLineInt(){ //getter for line Integers
		return lineInt;
	}
	
	public ArrayList<CTAStation> getCTARoute(){ //getter for the CTAStation ListArray
		return ctaRoute;
	}
	
	public void setLineColor(String c){ //setter for the name (string) of the line color
		lineColor = c;
	}
	
	public void setCTARoute(ArrayList<CTAStation> c){ //setter for the CTASTation Array
		ctaRoute = c;
	}
	
	public void setLineInt(int i){
		lineInt = i;
	}
	
	public void displayLineStations(){ //displays the stations of the given route
		int count =0;
		for (CTAStation c: ctaRoute){
			count++;
			System.out.println(count + ". " + c.getName());
		}
	}

	public  ArrayList<CTAStation> lookUpStation(String station){ //displays the information of a CTAStation in a route
		ArrayList<CTAStation> results = new ArrayList<CTAStation>();
		for (CTAStation a: ctaRoute){
			if (station.equalsIgnoreCase(a.getName())){
				results.add(a);
			}
		}
		return results;
	}
	
	public String displayClosestStation(double latitude, double longitude){ //THIS IS DISPLAYS NEAREST STATION METHODdisplays the closest station for given coordinates to a CTARoute
		double distance;
		String name = "";
		
		double shortestDistance = 1000000;
			for (CTAStation a: ctaRoute){
				
				distance = a.calcDistance(latitude, longitude);
				if (distance < shortestDistance){
						shortestDistance = distance;
						name = a.getName();
						
				}
		}
			return name;
		
	}	
	
	public void insertStation(CTAStation nu, int id){ //inserts a created CTA station into a CTA Route Array List. What i do if they put station further than yellow
		if (id > ctaRoute.size()){
			ctaRoute.add(nu);
			nu.setPosition(lineInt-5, ctaRoute.size());
		} else {
			ctaRoute.add(id, nu);
			for (int i= id+1; i < ctaRoute.size(); i++){
				ctaRoute.get(i).setPosition(this.getLineInt()-5, i);
			}
		}
	}
	
	public void removeStation(CTAStation nu){ //removes a given station from a CTA route, and then resets the int position for a route
		ctaRoute.remove(nu);
		for(int i=0; i <ctaRoute.size(); i++){
			ctaRoute.get(i).setPosition(this.getLineInt()-5, i);
		}
	}
	
	public void displayStationName(){ //displays a station name for all of the stations in a route
		int count = 1;
		for (CTAStation a: ctaRoute){
			System.out.println("(" + count+ ") " + a.getName());
			count++;
		}
	}
	
	public CTAStation findSameStop(CTARoute other){ //takes two CTAStations and finds a stop between them
		CTAStation sameStation = null;
			for (CTAStation a: other.getCTARoute()){
				for(CTAStation b: ctaRoute){
					if (a.equals(b)){
						sameStation = a;
						return sameStation;
					}
				}
			}
			return sameStation;
	}
	

	
	
	public void sortStations(){ //Uses bubble sort to sort the stations for a given route. I implement this before I create the route.
		boolean swapped;
		do{
			swapped = false;
			for (int i=1; i<ctaRoute.size(); i++){
				if (ctaRoute.get(i).getArrayofPositions()[lineInt-5] < ctaRoute.get(i-1).getArrayofPositions()[lineInt-5]){
					CTAStation temps = ctaRoute.get(i);
					ctaRoute.set(i, ctaRoute.get(i-1));
					ctaRoute.set(i-1, temps);
					swapped = true;
				}
			}
		} while (swapped == true);
	}
	public String toString(){
		String results = lineColor.toUpperCase() + "\n";
		results = results + "LineInt: " + lineInt + "\n";
		for (CTAStation a: ctaRoute){
			results = results + a.toString() + "\n";
		}
		return results;	
	}
	
	public boolean equals(CTARoute route){
		return (this.ctaRoute.equals(route.ctaRoute)) && (this.lineColor.equalsIgnoreCase(route.lineColor)) && (this.lineInt == route.lineInt);
	}
	
	public CTARoute findSameRoute(CTARoute other, ArrayList<CTARoute> fullRoutesList){ //takes two CTARoutes and finds the a route they share in common with their station
		for (CTAStation a: other.getCTARoute()){
			for (CTAStation b: this.getCTARoute()){
				for (int i = 0; i < 7; i++){
					if ((b.getArrayofPositions()[i] > -1) && (a.getArrayofPositions()[i] > -1)){
						return fullRoutesList.get(i);
					}
				}
			}
		}
		return null;	
	}
}
