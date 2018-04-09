package finalProject;

import static org.junit.Assert.*;

import org.junit.Test;

public class CTAStationTest {

	@Test
	public void testCTAStation() {
		CTAStation station = new CTAStation();
		assertEquals("", station.getName());
		assertTrue(Math.abs(0.0-station.getLatitude())<=0.001);
		assertTrue(Math.abs(0.0-station.getLongitude())<=0.001);
		assertEquals("", station.getLocation());
		assertFalse(station.getWheelchair());
	}
	
	@Test
	public void testCTAStationStringDoubleDoubleStringBooleanIntArray() {
		String name = "other station";
		double lat = 44;
		double lon = 45;
		String location = "elevated";
		boolean wheelchair = true;
		int[] intArray = {0,0,-1,-1,2,-1,-1,-1};
		CTAStation station = new CTAStation(name, lat, lon, location, wheelchair, intArray);
		assertEquals("other station", station.getName());
		assertTrue(station.getLatitude()==44);
		assertTrue(station.getLongitude()==45);
		assertEquals(location, station.getLocation());
		assertTrue(station.getWheelchair());
	}
	
	@Test
	public void testEqualsMethod(){
		CTAStation stationOne = new CTAStation();
		stationOne.setLatitude(44.33333336);
		CTAStation stationTwo = new CTAStation();
		stationTwo.setLatitude(44.33333333);
		CTAStation stationThree = new CTAStation();
		stationThree.setName("farce");
		assertTrue(stationOne.equals(stationTwo));
		assertFalse(stationTwo.equals(stationThree));
		
	}
	
	@Test
	public void testCalcDistanceObjectMethod(){
		CTAStation stationOne = new CTAStation();
		CTAStation stationTwo = new CTAStation();
		assertTrue(stationOne.calcDistance(stationTwo)==0);
	}
	
	@Test
	public void testCalcDistanceLatLonMethod(){
		CTAStation stationOne = new CTAStation();
		assertTrue(stationOne.calcDistance(40, 40) < 100);
	}

}
