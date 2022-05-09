package boot_project;

public class YearVO {

	long number;
	String year;
	
	public YearVO() {}
	
	public YearVO(long number, String year) {
		this.number = number;
		this.year = year;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return number + "." + year;
	}
	
	
}
