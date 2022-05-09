package boot_project;

import java.time.LocalDate;
import java.util.Scanner;

public class SoldierMain {
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		DivisionVO dv;
		PositionVO pv;
		SoldierVO sv;
		
		InsertDAO isD = new InsertDAO();
		
		while (true) {
			
			System.out.println("1.���� �Է�  2.���");
			int sel = scan.nextInt();
			
			switch(sel) {
			case 1:
				System.out.print("�̸� �Է� : ");
				String name = scan.next();
				System.out.print("������� �Է� : ");
				String birth = scan.next();
				System.out.println("��� �Է�");
				System.out.println("1.����  2.����  3.�ر�  4.�غ���  0.��Ÿ");
				long division_Code = scan.nextLong();
				if (division_Code == 0) {
					System.out.print("�߰��� ��� �Է� :");
					String division = scan.next();
					dv = new DivisionVO(0L, division);
					isD.insertDivision(dv);
				}
				System.out.println("���� �Է�");
				System.out.println("1.����  2.������  3.������  4.�ǹ���  5.��纴  0.��Ÿ");
				long position = scan.nextLong();
				System.out.print("�Դ��� �Է� : ");
				String in_Day = scan.next();
				System.out.print("������ �Է� : ");
				String out_Day = scan.next();
				System.out.println("���� ���� �Է�");
				System.out.println("1.1����  2.2����  3.3����  4.4����  5.5����  6.6����  7.7����~");
				long year = scan.nextLong();
				
				sv = new SoldierVO(0L, name, LocalDate.parse(birth), division_Code, position, LocalDate.parse(in_Day), LocalDate.parse(out_Day), year);
				isD.insertSoldier(sv);
				
				break;
			case 2:
				break;
				default :
					System.exit(0);
			}
			
			
			
		}
		
	}
}
