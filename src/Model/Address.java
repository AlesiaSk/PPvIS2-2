package Model;

public class Address {
	
		public String country;
		public String city;
		public String street;
		public Integer numOfHouse;
		
		public Address(String country, String city, String street, Integer house) {
	           this.country = new String(country);
	           this.city = new String(city);
	           this.street = new String(street);
	           this.numOfHouse = new Integer(house);
	           
	       
}
		public String getCountry() {
				return country;
			}

		public void setCountry(String country) {
				this.country = country;
			}
		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
		public String getSreet() {
			return street;
		}

		public void setStreet(String sreet) {
			this.street = sreet;
		}
		public Integer getNumOfHouse() {
			return numOfHouse;
		}

		public void setNumOfHouse(Integer house) {
			this.numOfHouse = house;
		}
}
