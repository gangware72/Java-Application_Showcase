package finalProject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {
	
	//my insert station doesn't increment if I put zero's in it
	//find where to place your Scanners up in here
	//does your search really find the station they are looking for? You should ask for the line too and use that
	//no such element on option 2
	
	//Hello there! Thanks for taking the time to grade this, I put some blood, sweat and tears into it for you. Methods are ordered by use.
	
	public static ArrayList<CTAStation> createAllCTAStationsArray() throws FileNotFoundException{ //method to create an array with all the ctastations. Used first and reads in from the csv file CTAStops
		ArrayList<CTAStation> allStations = new ArrayList<CTAStation>();
		File ctastationFile = new File("CTAStops.csv"); //file object of ctastations
		Scanner input = new Scanner(ctastationFile); //read in CTAStops from CSV file
		while(input.hasNextLine()){ //reads in station information, creates a list containing all the station names
			String holdStationData = input.nextLine();
			if (holdStationData.contains("Name") || holdStationData.contains("Null")){
			} else {
				String[] splitStationData = holdStationData.split(",");
				int[] stationNumbers = {Integer.parseInt(splitStationData[5]), Integer.parseInt(splitStationData[6]),Integer.parseInt(splitStationData[7]),Integer.parseInt(splitStationData[8]),Integer.parseInt(splitStationData[9]),Integer.parseInt(splitStationData[10]),Integer.parseInt(splitStationData[11]),Integer.parseInt(splitStationData[12])};
				CTAStation nu = new CTAStation(splitStationData[0], Double.parseDouble(splitStationData[1]), Double.parseDouble(splitStationData[2]), splitStationData[3], Boolean.parseBoolean(splitStationData[4].toLowerCase()), stationNumbers); 
				allStations.add(nu);
			}
		}
		input.close();
		return allStations;
	}

//I call this method to create CTARoutes. Once I create all the routes I store them in an ArrayList handled by the next method after this one.
	public static CTARoute createCTARoute(String color, int integerCode, ArrayList<CTAStation> stations){ //method to generate CTARoute objects
		int lineInteger = integerCode;
		ArrayList<CTAStation> aSpecificLine = new ArrayList<CTAStation>();
		for (CTAStation a: stations){
			if (a.getArrayofPositions()[integerCode-5] != -1){
				aSpecificLine.add(a);
			}
		}
		CTARoute nu = new CTARoute(color, aSpecificLine, integerCode);
		return nu;
	}
	
	public static ArrayList<CTARoute> createAllRoutesArray(ArrayList<CTAStation> allStationsArray){ //creates and sorts the CTARoutes for the given lines and then adds them to a giant Array of CTARoute lines. Used Second.
		ArrayList<CTARoute> allRoutesArray = new ArrayList<CTARoute>();
		CTARoute red = createCTARoute("Red", 5, allStationsArray);
		red.sortStations();
		CTARoute green = createCTARoute("Green", 6, allStationsArray);
		green.sortStations();
		CTARoute blue = createCTARoute("Blue", 7, allStationsArray);
		blue.sortStations();
		CTARoute brown = createCTARoute("Brown", 8, allStationsArray);
		brown.sortStations();
		CTARoute purple = createCTARoute("Purple", 9, allStationsArray);
		purple.sortStations();
		CTARoute pink = createCTARoute("Pink", 10, allStationsArray);
		pink.sortStations();
		CTARoute orange = createCTARoute("Orange", 11, allStationsArray);
		orange.sortStations();
		CTARoute yellow = createCTARoute("Yellow", 12, allStationsArray);
		yellow.sortStations();
		allRoutesArray.add(red);
		allRoutesArray.add(green);
		allRoutesArray.add(blue);
		allRoutesArray.add(brown);
		allRoutesArray.add(purple);
		allRoutesArray.add(pink);
		allRoutesArray.add(orange);
		allRoutesArray.add(yellow);
		return allRoutesArray;
	}
//now entering the menu. This will prompt the menu instructions each time.
	public static String generateMenuOptions(){
		return "Hello and welcome to the menu for CTA APP!" + "\n" + "Press (1) to display station names..." + "\n" + "Press (2) to search and display a station..." + "\n" + "Press (3) to add a specific station" + "\n" +"Press (4) to"
				+ " generate a route from a starting station to an ending station" + "\n" + "Press (5) to find the nearest station to your given location" + "\n" + "Press (6) to remove a given station" + "\n" + "Press (7) to print results to a csv file" +
				"\n" + "Press (-1) to exit the program at any time";
	}
	
//This is option (1).
	public static void displayAllStationNames(ArrayList<CTARoute> allRoutesArray){ //method that shows all of the stations for each route
		for (CTARoute a: allRoutesArray){
			System.out.println();
			System.out.println(a.getLineColor().toUpperCase());
			System.out.println();
			a.displayStationName();
		}
	}
//Menu option (2) part one.	
	public static CTAStation searchSpecificStation(ArrayList<CTARoute> fullRouteList){ //Takes input of the fullRoute list
		System.out.println("Type of the name of the station you would like to see.");
		CTAStation searchedForObject = null;
		Scanner input = new Scanner(System.in);
		String station = input.nextLine();
		for (int i=0; i< fullRouteList.size(); i++){
			for (int j=0; j < fullRouteList.get(i).getCTARoute().size(); j++){
				if (fullRouteList.get(i).getCTARoute().get(j).getName().equalsIgnoreCase(station)){
					searchedForObject = fullRouteList.get(i).getCTARoute().get(j);
				}
			}
		}
		
		return searchedForObject;
	}
//Menu option (2) part 2. Also used in menu option (5), part three, to display the information for a given station in either case.
	public static void isThere(CTAStation item){
		if (item == null){
			System.out.println("Your station does not exist.");
		} else {
			System.out.println("\n" + "Your station is there! Here is its information" + "\n");
			System.out.println(item);
		}
	}
	
	// Menu option (3) part one.
	public static CTAStation createStation(){ //method to create a new CTA Object, if the user wants to add a station. This will be called first.
		boolean correct = true;
		CTAStation nu = new CTAStation();
		do {
			try{
				Scanner userInput = new Scanner(System.in);
				System.out.println("Enter the name of the new station. Then press enter: ");
				String n = userInput.nextLine();
				nu.setName(n);
				System.out.println("Enter the latitutde of this station. Then press enter: ");
				double lat = userInput.nextDouble();
				nu.setLatitude(lat);
				System.out.println("Enter the longitude of this station. Then press enter: ");
				double lon = userInput.nextDouble();
				nu.setLongitude(lon);
				System.out.println("Enter the location of this station. Then press enter: ");
				userInput.nextLine();
				String l = userInput.nextLine();
				nu.setLocation(l);
				System.out.println("Is this stop wheelchair accessible? Type true if it is, and type false if it is not.");
				boolean w = userInput.hasNext();
				nu.setWheelchair(w);
				userInput.nextLine();
				System.out.println("What position is this on the red line? Press -1 if not on it.");
				int position = userInput.nextInt();
				nu.setPosition(0, position);
				System.out.println("What position is this on the green line? Press -1 if not on it.");
				position = userInput.nextInt();
				nu.setPosition(1, position);
				System.out.println("What position is this on the blue line? Press -1 if not on it.");
				position = userInput.nextInt();
				nu.setPosition(2, position);
				System.out.println("What position is this on the brown line? Press -1 if not on it.");
				position = userInput.nextInt();
				nu.setPosition(3, position);
				System.out.println("What position is this on the purple line? Press -1 if not on it.");
				position = userInput.nextInt();
				nu.setPosition(4, position);
				System.out.println("What position is this on the pink line? Press -1 if not on it.");
				position = userInput.nextInt();
				nu.setPosition(5, position);
				System.out.println("What position is this on the orange line? Press -1 if not on it.");
				position = userInput.nextInt();
				nu.setPosition(6, position);
				System.out.println("What position is this on the yellow line? Press -1 if not on it.");
				position = userInput.nextInt();
				nu.setPosition(7, position);
				correct = true;
			} catch (java.util.InputMismatchException e) {
				System.out.println("Enter the right name or number...");
				correct = false;
			}
		} while (correct == false);
		return nu;
	}

//Menu option (3) part two.
	public static void addStation(CTAStation nu, ArrayList<CTARoute> fullArrayList, ArrayList<CTAStation> fullStationsArray){ //inserts a created CTA station into a CTA Route Array List
		for (CTARoute a: fullArrayList){
			if (nu.getArrayofPositions()[a.getLineInt()-5] != -1){
				a.insertStation(nu, nu.getArrayofPositions()[a.getLineInt()-5]);
			}
		}
		fullStationsArray.add(nu);
	
	}
	
	public static void printRoute(ArrayList<CTAStation> results){
		for (CTAStation a: results){
			System.out.println(a.getName());
		}
	}
	
//Menu option(4).
	public static ArrayList<CTAStation> generateRoute(CTAStation start, CTARoute startRoute, CTAStation end, CTARoute endRoute, ArrayList<CTARoute> allRoutesArray){
//		CTAStation nextStation = startRoute.getCTARoute().get(startRoute.getCTARoute().indexOf(start)+1);
//		System.out.println(nextStation);
		
		CTAStation oneBeforeEnd = endRoute.getCTARoute().get(endRoute.getCTARoute().size()-2);
		
//		System.out.println(oneBeforeEnd);
		ArrayList<CTAStation> results = new ArrayList<CTAStation>();
//		System.out.println(startRoute.getLineInt() + ",  " + endRoute.getLineInt());	
		if (startRoute.getLineInt() == endRoute.getLineInt()){
			if (start.getArrayofPositions()[startRoute.getLineInt()-5] <= end.getArrayofPositions()[endRoute.getLineInt()-5]){
				for (int i = start.getArrayofPositions()[startRoute.getLineInt()-5]; i < end.getArrayofPositions()[endRoute.getLineInt()-5]; i++){
					results.add(startRoute.getCTARoute().get(i));
				}
			} else {
				for (int i = start.getArrayofPositions()[startRoute.getLineInt()-5]; i >= end.getArrayofPositions()[endRoute.getLineInt()-5]; i--){
					results.add(startRoute.getCTARoute().get(i));
				}		
			}
			return results;
		} else {
			CTAStation sameStation = startRoute.findSameStop(endRoute);
			if (sameStation == null){
				CTARoute commonRoute = startRoute.findSameRoute(endRoute, allRoutesArray);
				System.out.println(commonRoute.getLineColor());
				CTAStation stationBetweenStartCommon = commonRoute.findSameStop(startRoute);
				System.out.println(stationBetweenStartCommon);
				CTAStation stationBetweenCommonEnd = commonRoute.findSameStop(endRoute);
				results = generateRoute(start, startRoute, stationBetweenStartCommon, startRoute, allRoutesArray);
				ArrayList<CTAStation> results2 = generateRoute(stationBetweenStartCommon, commonRoute, stationBetweenCommonEnd, commonRoute, allRoutesArray);
				for (CTAStation a: results2){
					results.add(a);
				}
				ArrayList<CTAStation> results3 = generateRoute(stationBetweenCommonEnd, endRoute, end, endRoute, allRoutesArray);
				for (CTAStation a: results3){
					results.add(a);
				}
				return results;
			} else {
				System.out.println(sameStation);
				results = generateRoute(start, startRoute, sameStation, startRoute, allRoutesArray);
				ArrayList<CTAStation> results2 = generateRoute(sameStation, endRoute, end, endRoute, allRoutesArray);
				for (CTAStation a: results2){
					results.add(a);
				}
				return results;
			}
		}
	}

//Menu option (5). Part one.
		
	public static double[] getLattitudeLongitude(){ //prompt user for two doubles and stick them in array to return with the latitude first and longitude second.
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a latitude");
		double latitude = input.nextDouble();
		System.out.println("Enter a longitude");
		double longitude = input.nextDouble();
		double[] array = {latitude, longitude};
		return array;
	}
	
//Menu option (5) part two. Use isThere method for part three.
	public static CTAStation findClosestStation(double[] latLong, ArrayList<CTAStation> allStationsArray){ //returns the station that is closest.
		CTAStation minimumDistance = allStationsArray.get(0);
		for (CTAStation a: allStationsArray){
			if (a.calcDistance(latLong[0], latLong[1]) < minimumDistance.calcDistance(latLong[0], latLong[1])){
				minimumDistance = a;
			}
		}
	return minimumDistance;
	}

//Menu option (6) part one. Get the integer of the ACTUAL array spot for requested line so can access that array spot on any given CTA object using CTAStation.getArrayIndex[IDFROMTHISMETHOD]
	public static int determineCTARouteIDforArrays () { //returns the int id of a route the user would like to modify. Used to find a specific color line for the user
		int integer = -1;
		try {
			Scanner userInput = new Scanner(System.in);
			System.out.println("Enter the line color of this station: (Red-0, Green-1, Blue-2, Brown-3, Purple-4, Pink- 5, Orange-6, Yellow-7)");
			integer = userInput.nextInt(); //increment four to match number on the route
		} catch (Exception e) {
			System.out.println("Enter only one of the numbers provided...");
		}
		return integer;
	}

//Menu option (6) part two. Get the actual CTAStation the user would like to use using the name together with the line ID from the previous method.
	public static CTAStation askWhichStationRemove(ArrayList<CTAStation> allStationsArray, int lineID){
		System.out.println("Which station would you like to remove?");
		Scanner input = new Scanner(System.in);
		String requestedStationToRemove = input.nextLine().toLowerCase();
		CTAStation stationToRemove = null;
		for (CTAStation a: allStationsArray){
			if (a.getArrayofPositions()[lineID] != -1 && requestedStationToRemove.equalsIgnoreCase(a.getName())){
				System.out.println(a.getName());
				stationToRemove = a;
			} 
		}
		if (stationToRemove == null){
			System.out.println("The station you entered does not exist..." + "\n");
		}
		return stationToRemove;
	}

//Menu option (6) part three. Remove the actual station, but only from the different routes. I am keeping it in my huge ArrayList for fullStationsArray
	public static void removeStation(ArrayList<CTARoute> allRoutesArray, CTAStation nu){ //loop through all routes and remove station for each one
		for (CTARoute a: allRoutesArray){
			if (a.getCTARoute().contains(nu)){
				a.removeStation(nu);
			}
		}
	}
	
	public static CTAStation getSpecificStation(ArrayList<CTARoute> allRoutesArray){ //given line id and station this returns a CTA station
		int line = determineCTARouteIDforArrays();
		System.out.println("Pick which station you would like.");
		int counter = 1;
		for (CTAStation a: allRoutesArray.get(line).getCTARoute()){
			System.out.println(counter + ". " + a.getName());
			counter++;
		}
		Scanner input = new Scanner(System.in);
		int station = input.nextInt();
		return allRoutesArray.get(line).getCTARoute().get(station-1);
	}
	
//Menu option (7). Writes all the routes with stations to a txt file.
	public static void writeToFile (ArrayList<CTAStation> allStationsArray) throws IOException{
		FileWriter file = new FileWriter("output.txt"); //create a file with the name the user entered
		BufferedWriter output = new BufferedWriter(file);
		output.write("Name,Latitude,Longitude,Location,Wheelchair,Red,Green,Blue,Brown,Purple,Pink,Orange,Yellow" + "\n");
		output.write("null,null,null,null,null,null,null,null,Merchandise Mart,Merchandise Mart,Clinton,Roosevelt,null" + "\n");
		for (CTAStation a: allStationsArray){
			String str = a.toString();
			output.write(str + "\n");
			}
		output.close();
	}
	
	public static void main(String[] args) throws IOException{
		ArrayList<CTAStation> allStationsArray = createAllCTAStationsArray();
		ArrayList<CTARoute> allRoutesArray = createAllRoutesArray(allStationsArray);
		boolean correct;
		Scanner input = new Scanner(System.in);

		do {
			correct = true;
			try {
				int menuChoice = 0;
				
				while (menuChoice != -1) {
					System.out.println("\n" + generateMenuOptions());
					menuChoice = input.nextInt();
					switch (menuChoice){
					case 1: displayAllStationNames(allRoutesArray);
					break;
					case 2: isThere(searchSpecificStation(allRoutesArray));
					break;
					case 3: addStation(createStation(),allRoutesArray, allStationsArray); 
					break;
					case 4: 
						CTAStation start = getSpecificStation(allRoutesArray);
						CTAStation end = getSpecificStation(allRoutesArray);
						for (CTAStation a: generateRoute(start, allRoutesArray.get(determineCTARouteIDforArrays()), end, allRoutesArray.get(determineCTARouteIDforArrays()), allRoutesArray)){
							System.out.println(a.getName());
						}
					break;
					case 5: isThere(findClosestStation(getLattitudeLongitude(), allStationsArray));
					break;
					case 6: removeStation(allRoutesArray, askWhichStationRemove(allStationsArray,determineCTARouteIDforArrays()));
					break;
					case 7: writeToFile(allStationsArray);
					break;
					}
				}
			} catch (java.util.InputMismatchException e){
				System.out.println("\n" + "Enter an integer please." + "\n");
				correct = false;
			}
		} while (correct == false);
	}
}
