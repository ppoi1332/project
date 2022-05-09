package boot_project;

import java.util.List;

public class SelectManager {
	
	List<DivisionVO> retDiv;
	List<PositionVO> retPos;
	List<YearVO> retYear;
	
	public SelectManager() {}
	
	public void DivisionManager(SelectDAO slD) {
		retDiv = slD.selectDivision();
		for(DivisionVO tmp : retDiv) {
			System.out.println(tmp);
		}		
	}
	
	public void PositionMananger(SelectDAO slD) {
		retPos = slD.selectPosition();
		for(PositionVO tmp : retPos) {
			System.out.println(tmp);
		}
	}
	
	public void YearManager (SelectDAO slD) {
		retYear = slD.selectYear();
		for(YearVO tmp : retYear) {
			System.out.println(tmp);
		}
	}
	
}
