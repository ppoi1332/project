package boot_project;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class SoldierMain {
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		
		DivisionVO dv;
		PositionVO pv;
		SoldierVO sv;
		
		InsertDAO isD = new InsertDAO();
		SelectDAO slD = new SelectDAO();
		List<DivisionVO> retDiv;
		List<PositionVO> retPos;
		List<SoldierVO> retSol;
		SelectManager slm = new SelectManager();
		
		while (true) {		
			System.out.println("1.���� �Է�  2.���  0.����");
			int sel = scan.nextInt();
			
			switch(sel) {
			case 1:
				System.out.print("�̸� �Է� : ");
				String name = scan.next();
				
				System.out.println("������� �Է�");
				System.out.println("��) 2022-02-22");
				System.out.print("�Է� : ");
				String birth = scan.next();
				
				System.out.println("��� �Է�");
				slm.DivisionManager(slD);
				System.out.println("0.��Ÿ");
				System.out.print("�Է� : ");
				long division_Code = scan.nextLong();
				
				if (division_Code == 0) {
					System.out.print("�߰��� ��� �Է� : ");
					String division = scan.next();
					dv = new DivisionVO(0L, division);
					isD.insertDivision(dv);
					System.out.println("��� �Է�");
					slm.DivisionManager(slD);
					System.out.println("0.��Ÿ");
					System.out.print("�Է� : ");
					division_Code = scan.nextLong();
				}
				
				System.out.println("���� �Է�");
				slm.PositionMananger(slD);
				System.out.println("0.��Ÿ");
				System.out.print("�Է� : ");
				long position_Code = scan.nextLong();
				if (position_Code == 0) {
					System.out.print("�߰��� ���� �Է� : ");
					String position = scan.next();
					pv = new PositionVO(0L, position);
					isD.insertPosition(pv);
					
					System.out.println("���� �Է�");
					slm.PositionMananger(slD);
					System.out.println("0.��Ÿ");
					System.out.print("�Է� : ");
					position_Code = scan.nextLong();
				}
				
				System.out.println("�Դ���");
				System.out.println("��) 2022-02-22");
				System.out.println("�Է� : ");
				String in_Day = scan.next();
				
				System.out.println("������");
				System.out.println("��) 2022-02-22");
				System.out.print("�Է� : ");
				String out_Day = scan.next();
				
				System.out.println("���� ���� �Է�");
				System.out.println("1.1����  2.2����  3.3����  4.4����  5.5����  6.6����  7.7����~");
				long year = scan.nextLong();
				
				sv = new SoldierVO(0L, name, LocalDate.parse(birth), division_Code, position_Code, LocalDate.parse(in_Day), LocalDate.parse(out_Day), year);
				isD.insertSoldier(sv);		
				break;
			case 2:
				System.out.println("1.��ü ���  2.�������� ���  3.��ܺ��� ���  4.���� �������� ���");
				int num = scan.nextInt();
				switch (num) {
				case 1:
					break;
				case 2:
					System.out.println("��� ����");
					slm.DivisionManager(slD);
					System.out.print("�Է� : ");
					long diSel = scan.nextLong();
					retSol = slD.selectDivisionAll(diSel);
					for(SoldierVO tmp : retSol) {
						System.out.println(tmp);
					}
					System.out.println();
					break;
				case 3:
					System.out.println("���� ����");
					slm.PositionMananger(slD);
					break;
				case 4:
					break;
				}
				break;
			case 0:
				System.out.println("����");
				System.exit(0);
				break;
				default :
					System.exit(0);
					break;
			}	

		}
		
	}
}
