package utils;

public class HouseRecorder {
    public boolean record(String city, String district, String business_circle, 
    		              String price, String acreage, String room){
        SecondaryHouse secondaryHouse = new SecondaryHouse();  
        secondaryHouse.city = city; 
        secondaryHouse.district = district;
        secondaryHouse.business_circle = business_circle;
        secondaryHouse.acreage = acreage;
        secondaryHouse.price = price;
        secondaryHouse.room = room;
    	
    	return true;
    }
}
