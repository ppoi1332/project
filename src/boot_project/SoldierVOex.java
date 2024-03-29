package boot_project;

import java.time.LocalDate;

public class SoldierVOex extends SoldierVO {
	
	public SoldierVOex (long number, String name, LocalDate birth) {
		super.number = number;
		super.name = name;
		super.birth = birth;
	}
	
	@Override
	public String toString() {
		return "번호 : " + number + "\t이름 : " + name + "\t생년월일 : " + birth;
	}

}
