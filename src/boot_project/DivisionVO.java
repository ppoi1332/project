package boot_project;

public class DivisionVO {

	long number;
	String division;
	
	public DivisionVO() {}
	
	public DivisionVO(long number, String division) {
		this.number = number;
		this.division = division;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}
	
}
