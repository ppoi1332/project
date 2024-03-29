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
		DeleteDAO dlD = new DeleteDAO();
		List<DivisionVO> retDiv;
		List<PositionVO> retPos;
		List<SoldierVO> retSol;
		SelectManager slm = new SelectManager();
		
		while (true) {		
			System.out.println("1.설문 입력  2.출력  3.삭제  0.종료");
			int sel = scan.nextInt();
			
			switch(sel) {
			case 1:
				System.out.print("이름 입력 : ");
				String name = scan.next();
				
				System.out.println("생년월일 입력");
				System.out.println("예) 2022-02-22");
				System.out.print("입력 : ");
				String birth = scan.next();
				
				System.out.println("근무한 부대 입력");
				slm.DivisionManager(slD);
				System.out.println("0.기타");
				System.out.print("입력 : ");
				long division_Code = scan.nextLong();
				
				if (division_Code == 0) {
					System.out.print("추가할 부대 입력 : ");
					String division = scan.next();
					dv = new DivisionVO(0L, division);
					isD.insertDivision(dv);
					System.out.println("부대 입력");
					slm.DivisionManager(slD);
					System.out.println("0.기타");
					System.out.print("입력 : ");
					division_Code = scan.nextLong();
				}
				
				System.out.println("보직 입력");
				slm.PositionMananger(slD);
				System.out.println("0.기타");

				long position_Code = scan.nextLong();
				if (position_Code == 0) {
					System.out.print("추가할 보직 입력 : ");
					String position = scan.next();
					pv = new PositionVO(0L, position);
					isD.insertPosition(pv);
					System.out.println("보직 입력");
					slm.PositionMananger(slD);
					System.out.println("0.기타");
					System.out.print("입력 : ");
					position_Code = scan.nextLong();
				}
				
				System.out.println("입대일");
				System.out.println("예) 2022-02-22");
				System.out.print("입력 : ");
				String in_Day = scan.next();
				
				System.out.println("전역일");
				System.out.println("예) 2022-02-22");
				System.out.print("입력 : ");
				String out_Day = scan.next();
				
				System.out.println("예비군 년차 입력");
				System.out.println("1.1년차  2.2년차  3.3년차  4.4년차  5.5년차  6.6년차  7.7년차~");
				long year = scan.nextLong();
				
				sv = new SoldierVO(0L, name, LocalDate.parse(birth), division_Code, position_Code, LocalDate.parse(in_Day), LocalDate.parse(out_Day), year);
				isD.insertSoldier(sv);		
				break;
			case 2:
				System.out.println("1.전체 출력  2.부대별로 출력  3.보직별로 출력  4.예비군 년차별로 출력");
				int num = scan.nextInt();
				switch (num) {
				case 1:
					retSol = slD.selectAll();
					if (retSol != null) {
						for(SoldierVO tmp : retSol) {
							System.out.println(tmp);
						}
					} else {
						System.out.println("인원이 없습니다");
					}
					System.out.println();
					break;
				case 2:
					System.out.println("부대 선택");
					slm.DivisionManager(slD);
					System.out.print("입력 : ");
					long diSel = scan.nextLong();
					retSol = slD.selectDivisionAll(diSel);
					if (retSol != null) {
						for(SoldierVO tmp : retSol) {
							System.out.println(tmp);
						}
					} else {
						System.out.println("인원이 없습니다");
					}
					System.out.println();
					break;
				case 3:
					System.out.println("보직 선택");
					slm.PositionMananger(slD);	
					System.out.print("입력 : ");
					long poSel = scan.nextLong();
					retSol = slD.selectPositionAll(poSel);
					if (retSol != null) {
						for(SoldierVO tmp : retSol) {
							System.out.println(tmp);
						}
					} else {
						System.out.println("인원이 없습니다");
					}
					System.out.println();
					break;
				case 4:
					System.out.println("예비군 년차 선택");
					slm.YearManager(slD);
					System.out.print("입력 : ");
					long yeSel = scan.nextLong();
					retSol = slD.selectYearAll(yeSel);
					if (retSol != null) {
						for(SoldierVO tmp : retSol) {
							System.out.println(tmp);
						}
					} else {
						System.out.println("인원이 없습니다");
					}
 					System.out.println();
					break;
				}
				break;
			case 3:
				System.out.println("삭제할 사람 이름 입력");
				retSol = dlD.selectAll();
				if (retSol != null) {
					for(SoldierVO tmp : retSol) {
						System.out.println(tmp);
					}
					System.out.println();
					System.out.print("입력 : ");
					long dnum = scan.nextLong();
					dlD.deleteDAO(dnum);
				}
				else {
					System.out.println("인원이 없습니다");
				}
				break;
			case 0:
				System.out.println("종료");
				System.exit(0);
				break;
				default :
					System.exit(0);
					break;
			}	

		}
		
	}
}
