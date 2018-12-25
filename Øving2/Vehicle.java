package encapsulation;

public class Vehicle {
	
	public char kjøretøy;
	
	public char drivstoff;
	
	public String registnr;
	
	public Vehicle(char kjøretøy, char drivstoff, String registnr) {
		if (!(kjøretøy == 'C' || kjøretøy == 'M')) {
			throw new IllegalArgumentException("Kjøretøy må være enten bil eller motorsykkel");
		}
		this.kjøretøy = kjøretøy;
		if (!(drivstoff == 'H' || drivstoff == 'E' || drivstoff == 'D' || drivstoff == 'G')) {
			throw new IllegalArgumentException("Drivstoff må være gyldig");
		}
		this.drivstoff = drivstoff;
		if (drivstoff == 'E') {
			if( registnr.substring(0,2) == "EK" || registnr.substring(0,2) == "EL") {
				throw new IllegalArgumentException("Elbil må ha registnr 'EK' eller 'EL'");
			}
		}
		if (drivstoff == 'H') {
			if (registnr.substring(0,2) == "HY") {
				throw new IllegalArgumentException("Hydrogenbiler må begynne med HY");
			}
		}
		if (drivstoff == 'D' || drivstoff == 'B') {
			if (registnr.substring(0,2) == "HY" || registnr.substring(0,2) == "EL" || registnr.substring(0,2) == "EK") {
				throw new IllegalArgumentException("Bensin og diesel kan ikke starte som elbil eller hydrogenbil");
			}
		}
		if (registnr.contains("Æ") || registnr.contains("Ø") || registnr.contains("Å")) {
			throw new IllegalArgumentException("Må ha engelsk tastatur");
		}
		for (int i = 0; i < 2; i++) {
			if (!(Character.isUpperCase(registnr.charAt(i))))
			throw new IllegalArgumentException("Må ha store bokstaver");
		}
		if (kjøretøy == 'M') {
			String bokstav = registnr.substring(0,2);
			for (int i = 0; i < 2; i++) {
				char c = bokstav.charAt(i);
				if (!(Character.isLetter(c))) {	
					throw new IllegalArgumentException("De to første må være bokstaver");
				}
				
			}
			String siffer = registnr.substring(2);
			if (siffer.length() != 4) {
				throw new IllegalArgumentException("Må ha riktig lengde");
			}
			for (int i = 0; i < siffer.length(); i++) {
				char c = siffer.charAt(i);
				if(!(Character.isDigit(c))) {
					throw new IllegalArgumentException("De siste må være sifre");
				}
			}
		}
		if (kjøretøy == 'C') {
			String bokstav = registnr.substring(0,2);
			for (int i = 0; i < 2; i++) {
				char c = bokstav.charAt(i);
				if (!(Character.isLetter(c))) {	
					throw new IllegalArgumentException("De to første må være bokstaver");
				}	
			}
			String siffer = registnr.substring(2);
			if (siffer.length() != 5) {
				throw new IllegalArgumentException("Må ha riktig lengde");
			}
			for (int i = 0; i < siffer.length(); i++) {
				char c = siffer.charAt(i);
				if(!(Character.isDigit(c))) {
					throw new IllegalArgumentException("De siste må være sifre");
				}
			}
		}
		this.registnr = registnr;
	}
	
	public char getFuelType() {
		return drivstoff;
	}
	
	public String getRegistrationNumber() {
		return registnr;
	}
	
	public void setRegistrationNumber(String registnr) {
		if (drivstoff == 'E') {
			if(registnr.substring(0,2) == "EK" || registnr.substring(0,2) == "EL") {
				throw new IllegalArgumentException("Elbil må ha registnr 'EK' eller 'EL'");
			}
		}
		if (drivstoff == 'H') {
			if (registnr.substring(0,2) == "HY") {
				throw new IllegalArgumentException("Hydrogenbiler må begynne med HY");
			}
		}
		if (drivstoff == 'D' || drivstoff == 'B') {
			if (registnr.substring(0,2) == "HY" || registnr.substring(0,2) == "EL" || registnr.substring(0,2) == "EK") {
				throw new IllegalArgumentException("Bensin og diesel kan ikke starte som elbil eller hydrogenbil");
			}
		}
		if (registnr.contains("Æ") || registnr.contains("Ø") || registnr.contains("Å")) {
			throw new IllegalArgumentException("Må ha engelsk tastatur");
		}
		for (int i = 0; i < 2; i++) {
			if (!(Character.isUpperCase(registnr.charAt(i))))
			throw new IllegalArgumentException("Må ha store bokstaver");
		}
		if (kjøretøy == 'M') {
			String bokstav = registnr.substring(0,2);
			for (int i = 0; i < 2; i++) {
				char c = bokstav.charAt(i);
				if (!(Character.isLetter(c))) {	
					throw new IllegalArgumentException("De to første må være bokstaver");
				}
				
			}
			String siffer = registnr.substring(2);
			if (siffer.length() != 4) {
				throw new IllegalArgumentException("Må ha riktig lengde");
			}
			for (int i = 0; i < siffer.length(); i++) {
				char c = siffer.charAt(i);
				if(!(Character.isDigit(c))) {
					throw new IllegalArgumentException("De siste må være sifre");
				}
			}
		}
		if (kjøretøy == 'C') {
			String bokstav = registnr.substring(0,2);
			for (int i = 0; i < 2; i++) {
				char c = bokstav.charAt(i);
				if (!(Character.isLetter(c))) {	
					throw new IllegalArgumentException("De to første må være bokstaver");
				}	
			}
			String siffer = registnr.substring(2);
			if (siffer.length() != 5) {
				throw new IllegalArgumentException("Må ha riktig lengde");
			}
			for (int i = 0; i < siffer.length(); i++) {
				char c = siffer.charAt(i);
				if(!(Character.isDigit(c))) {
					throw new IllegalArgumentException("De siste må være sifre");
				}
			}
			
		}
		this.registnr = registnr;
	}
	
	
	public char getVehicleType(){
		return kjøretøy;
	}
	
	
	public static void main(String[] args) {
		String tester = "EK4574";
		System.out.println(tester.substring(0,2));
		System.out.println(tester.substring(2));
		
		Vehicle v = new Vehicle('C', 'D', "BE54875");
		System.out.println(v.getFuelType());
		System.out.println(v.getRegistrationNumber());
		System.out.println(v.getVehicleType());
	}
}
	
