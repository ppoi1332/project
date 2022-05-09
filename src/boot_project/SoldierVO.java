package boot_project;

import java.time.LocalDate;

public class SoldierVO {
	
	long number;
	String name;
	LocalDate birth;
	long division_Code;
	long position_Code;
	LocalDate in_Day;
	LocalDate out_Day;
	long year_Code;
	
	public SoldierVO() {}
	
	public SoldierVO(long number, String name, LocalDate birth, long division_Code, long position_Code, LocalDate in_Day, LocalDate out_Day, long year_Code) {
		this.number = number;
		this.name = name;
		this.birth = birth;
		this.division_Code = division_Code;
		this.position_Code = position_Code;
		this.in_Day = in_Day;
		this.out_Day = out_Day;
		this.year_Code = year_Code;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public long getDivision_Code() {
		return division_Code;
	}

	public void setDivision_Code(long division_Code) {
		this.division_Code = division_Code;
	}

	public long getPosition_Code() {
		return position_Code;
	}

	public void setPosition_Code(long position_Code) {
		this.position_Code = position_Code;
	}

	public LocalDate getIn_Day() {
		return in_Day;
	}

	public void setIn_Day(LocalDate in_Day) {
		this.in_Day = in_Day;
	}

	public LocalDate getOut_Day() {
		return out_Day;
	}

	public void setOut_Day(LocalDate out_Day) {
		this.out_Day = out_Day;
	}

	public long getYear_Code() {
		return year_Code;
	}

	public void setYear_Code(long year_Code) {
		this.year_Code = year_Code;
	}
	
	

}
