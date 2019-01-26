package objectstructures;

public class Partner {
	
	private final String name;
	
	private Partner partner;
	
	
	public Partner(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Partner getPartner() {
		return partner;
	}
	
	public void setPartner(Partner partner) {
		if (this.partner == partner) {
			return;
		}
		Partner oldPartner = this.partner;
		this.partner = partner;
		
		if (oldPartner != null && oldPartner.getPartner() == this) {
			oldPartner.setPartner(null);
		}
		if (this.partner != null) {
			this.partner.setPartner(this);
		}
	}
	
	public static void main(String[] args) {
		Partner p1 = new Partner("Martin");
		Partner p2 = new Partner("Andre");
		Partner p3 = new Partner("Mamma");
		
		p1.setPartner(p2);
		System.out.println(p1.getName());
		System.out.println(p1.getPartner());
		p1.setPartner(p3);
		System.out.println(p2.getPartner());

	}
	
}
