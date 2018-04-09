package finalProject;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class CTARouteTest {
	
	protected ArrayList<CTAStation> allStationsArray;
	protected ArrayList<CTARoute> allRoutesArray;
	
	public void setup() {
		try {
			allStationsArray = Application.createAllCTAStationsArray();
			allRoutesArray = Application.createAllRoutesArray(allStationsArray);
		} catch(Exception e) {
			System.out.println("FAILED!!!");
		}
	}

	@Test
	public void testCTARoute() { //default constructor test
		String lineColor = "";
		int lineInt = 0;
		ArrayList<CTAStation> ctaRoute = new ArrayList<CTAStation>();
		CTARoute route = new CTARoute();
		
		assertEquals(route.getLineColor(), lineColor);
		assertEquals(route.getLineInt(), lineInt);
		assertEquals(route.getCTARoute(), ctaRoute);
	}
	
	@Test
	public void testCTARouteStringArraylistInt(){ //non default constructor test
		String lineColor = "green";
		int lineInt = 4;
		ArrayList<CTAStation> ctaRoute = new ArrayList<CTAStation>();
		CTARoute route = new CTARoute(lineColor, ctaRoute, lineInt);
		
		assertEquals(route.getLineColor(), "green");
		assertTrue(route.getLineInt() == 4);
		assertEquals(route.getCTARoute(), ctaRoute);
	}
	
	@Test
	public void testEqualsMethod(){ //tests if the equals method works
		CTARoute routeOne = new CTARoute();
		CTARoute routeTwo = new CTARoute();
		CTARoute routeThree = new CTARoute();
		routeThree.setLineInt(1);
		
		assertTrue(routeOne.equals(routeTwo));
		assertFalse(routeTwo.equals(routeThree));
	}
	
	//displayLineStation()?
	@Test
	public void testLookUpStation(){ //tests if the lookUpStation() method works.
		
		String stationName = "kedzie";
		ArrayList<CTAStation> ctaRoute = new ArrayList<CTAStation>();
		CTAStation stationOne = new CTAStation();
		ctaRoute.add(stationOne);
		CTAStation stationTwo = new CTAStation();
		stationTwo.setName("KEDZIE");
		ctaRoute.add(stationTwo);
		ArrayList<CTAStation> arrayList = new ArrayList<CTAStation>();
		arrayList.add(stationTwo);
		
		CTARoute randomRoute = new CTARoute("hamSandwhich", ctaRoute, 4);
		
		assertTrue(randomRoute.lookUpStation("kedzie").equals(arrayList));
		
	}
	
//	@Test
//	public void testDisplayClosestStation(){
//		double latitude = 44;
//		double longitude = 44;
//		
//		assertTrue(dis)
//	}
	

}
