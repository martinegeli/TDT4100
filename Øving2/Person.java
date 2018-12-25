package encapsulation;

import java.util.Date;

public class Person {
	private String name;
	
	private String email;
	
	private Date date;
	
	private char gender;
	
	public void setName(String name) {
		String[] split = name.split(" ");
		if (!(split.length == 2 )) {
			throw new IllegalArgumentException("Må være to navn og navnene må være lengre enn to bokstaver");
		}
		
		for (int i = 0; i < split.length; i++) {
			if (split[i].length() < 2) {
				throw new IllegalArgumentException("Må være to navn og navnene må være lengre enn to bokstaver");
			}
		}
		
		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);
			if (!(Character.isLetter(c) || Character.isSpaceChar(c))){
				throw new IllegalArgumentException("Må være to navn og navnene må være lengre enn to bokstaver");
			}
		}
		
		this.name = name;
	}
	
	public void setEmail(String email) {
		String[] split = email.split("@");
		split = split[0].split("\\.");
		// {fornavn, etternavn, domene.nasjon}
		split = split[2].split("\\.");
		if (split.length != 4) {
			throw new IllegalArgumentException("Må inneholde alle elementene til en email");
		}
		if (email.indexOf("@") < 0) {
			throw new IllegalArgumentException("Må inneholde alle elementene til en email");
		}
		
		String[] navn = name.split(" ");
		for (int i = 0; i < navn.length; i++) {
			navn[i].toLowerCase();
		}
		for (int i = 0; i < 2; i++) {
			if (!(navn[i] == split[i])) {
				throw new IllegalArgumentException("Stemmer ikke overrens");
			}
		}
		
		String[] nations = {"ad", "ae", "af", "ag", "ai", "al", "am", "ao", "aq", "ar", "as", "at", "au", "aw", "ax", "az", "ba", "bb", "bd", "be", "bf", "bg", "bh", "bi", "bj", "bl", "bm", "bn", "bo", "bq", "br", "bs", "bt", "bv", "bw", "by", "bz", "ca", "cc", "cd", "cf", "cg", "ch", "ci", "ck", "cl", "cm", "cn", "co", "cr", "cu", "cv", "cw", "cx", "cy", "cz", "de", "dj", "dk", "dm", "do", "dz", "ec", "ee", "eg", "eh", "er", "es", "et", "fi", "fj", "fk", "fm", "fo", "fr", "ga", "gb", "gd", "ge", "gf", "gg", "gh", "gi", "gl", "gm", "gn", "gp", "gq", "gr", "gs", "gt", "gu", "gw", "gy", "hk", "hm", "hn", "hr", "ht", "hu", "id", "ie", "il", "im", "in", "io", "iq", "ir", "is", "it", "je", "jm", "jo", "jp", "ke", "kg", "kh", "ki", "km", "kn", "kp", "kr", "kw", "ky", "kz", "la", "lb", "lc", "li", "lk", "lr", "ls", "lt", "lu", "lv", "ly", "ma", "mc", "md", "me", "mf", "mg", "mh", "mk", "ml", "mm", "mn", "mo", "mp", "mq", "mr", "ms", "mt", "mu", "mv", "mw", "mx", "my", "mz", "na", "nc", "ne", "nf", "ng", "ni", "nl", "no", "np", "nr", "nu", "nz", "om", "pa", "pe", "pf", "pg", "ph", "pk", "pl", "pm", "pn", "pr", "ps", "pt", "pw", "py", "qa", "re", "ro", "rs", "ru", "rw", "sa", "sb", "sc", "sd", "se", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", "sr", "ss", "st", "sv", "sx", "sy", "sz", "tc", "td", "tf", "tg", "th", "tj", "tk", "tl", "tm", "tn", "to", "tr", "tt", "tv", "tw", "tz", "ua", "ug", "um", "us", "uy", "uz", "va", "vc", "ve", "vg", "vi", "vn", "vu", "wf", "ws", "ye", "yt", "za", "zm", "zw"};
		for (int i = 0; i < nations.length; i++) {
			if (!(split[3].contains(nations[i]))) {
				throw new IllegalArgumentException("Ikke gyldig nasjonskode");
			}
		}
		this.email = email;
		
	}
	
	public void setBirthday(Date date) {
		long today = new Date().getTime();
		long datoTest = date.getTime();
		if (datoTest >= today) {
			throw new IllegalArgumentException("Datoen må være tidligere enn dette tidspunktet");
		}
		this.date = date;
		
	}
	
	public void setGender(char gender) {
		char[] charArray = {'m', 'M', 'f', 'F', '\0', '\0'};
		for (int i=0; i < charArray.length; i++) {
			if (gender != charArray[i]) {
				throw new IllegalArgumentException("Ikke gyldig kjønn");
			}
		}
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public Date getBirthday() {
		return date;
	}
	
	public char getGender() {
		return gender;
	}
	
	
	public static void main(String[] args) {
		String fullEmail = "Martin.egeli@ntnu.no";
		String[] split = fullEmail.split("@");
		System.out.println(split[0]);
		System.out.println(split[1]);
		split = split[0].split("\\.");
		System.out.println(split[0]);
		System.out.println(split[1]);
		String fulltNavn = "Martin Egeli";
		String[] navn = fulltNavn.split(" ");
		System.out.println(navn[1]);
		System.out.println(navn[0]);


	}
}
