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
	
	String division;
	String position;
	String year;
	
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
	
	public SoldierVO(String name, LocalDate birth, String division , String position , LocalDate in_Day, LocalDate out_Day, String year) {
		this.name = name;
		this.birth = birth;
		this.division = division;
		this.position = position;
		this.in_Day = in_Day;
		this.out_Day = out_Day;
		this.year = year;
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

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "이름 : " + name + "\t생년월일 : " + birth + "\t사단 : " + division + "\t보직 : " + position + "\t입대날 : " + in_Day + "\t전역날 : " + out_Day + "\t예비군 년차 : " + year ;
	}
	
	

}
