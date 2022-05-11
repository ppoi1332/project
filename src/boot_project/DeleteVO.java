package boot_project;

import java.time.LocalDate;

public class DeleteVO extends SoldierVO {
	
	public DeleteVO (long number, String name, LocalDate birth) {
		super.number = number;
		super.name = name;
		super.birth = birth;
	}
	
	@Override
	public String toString() {
		return "��ȣ : " + number + "\t�̸� : " + name + "\t������� : " + birth;
	}

}
