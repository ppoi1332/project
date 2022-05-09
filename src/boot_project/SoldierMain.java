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
			
			System.out.println("1.설문 입력  2.출력");
			int sel = scan.nextInt();
			
			switch(sel) {
			case 1:
				System.out.print("이름 입력 : ");
				String name = scan.next();
				System.out.print("생년월일 입력 : ");
				String birth = scan.next();
				System.out.println("사단 입력");
				System.out.println("1.육군  2.공군  3.해군  4.해병대  0.기타");
				long division_Code = scan.nextLong();
				if (division_Code == 0) {
					System.out.print("추가할 사단 입력 :");
					String division = scan.next();
					dv = new DivisionVO(0L, division);
					isD.insertDivision(dv);
				}
				System.out.println("보직 입력");
				System.out.println("1.보병  2.행정병  3.운전병  4.의무병  5.취사병  0.기타");
				long position = scan.nextLong();
				System.out.print("입대일 입력 : ");
				String in_Day = scan.next();
				System.out.print("전역일 입력 : ");
				String out_Day = scan.next();
				System.out.println("예비군 년차 입력");
				System.out.println("1.1년차  2.2년차  3.3년차  4.4년차  5.5년차  6.6년차  7.7년차~");
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
