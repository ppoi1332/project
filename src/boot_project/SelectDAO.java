package boot_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SelectDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public SelectDAO () {
		jdbcTemplate = JdbcTemplate.getInstance();
	}
	
	public List<DivisionVO> selectDivision(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		List<DivisionVO> ls = new ArrayList<>();	
		String sql = "select * from \"DIVISION\" order by \"NUMBER\" asc";
		try {
			conn = jdbcTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				DivisionVO tmp = new DivisionVO(
						rs.getLong(1),
						rs.getString("DIVISION_NAME")
						);
				ls.add(tmp);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return (ls.size() == 0) ? null : ls;
	}
	
	public List<PositionVO> selectPosition(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		List<PositionVO> ls = new ArrayList<>();	
		String sql = "select * from \"POSITION\" order by \"NUMBER\" asc";
		try {
			conn = jdbcTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PositionVO tmp = new PositionVO(
						rs.getLong(1),
						rs.getString("POSITION_NAME")
						);
				ls.add(tmp);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return (ls.size() == 0) ? null : ls;
	}
	
	public List<SoldierVO> selectDivisionAll(long number) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		List<SoldierVO> ls = new ArrayList<>();	
		String sql = "select \"SD\".\"NAME\", \"SD\".\"BIRTH\",\"DS\".\"DIVISION_NAME\", \"PS\".\"POSITION_NAME\", \"SD\".\"INDAY\", \"SD\".\"OUTDAY\", \"YR\".\"YEAR\" "
				+ "from \"SOLDIER\" \"SD\", \"DIVISION\" \"DS\", \"POSITION\" \"PS\", \"YEAR\" \"YR\""
				+ " where \"SD\".\"DIVISION_CODE\" = \"DS\".\"NUMBER\" and \"SD\".\"POSITION_CODE\" = \"PS\".\"NUMBER\" and \"SD\".\"YEAR\" = \"YR\".\"NUMBER\" and \"SD\".\"DIVISION_CODE\" = '"+number+"'";	
		try {
			conn = jdbcTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SoldierVO tmp = new SoldierVO(
						rs.getString("NAME"),
						LocalDate.parse(rs.getDate("BIRTH").toString()),
						rs.getString("DIVISION_NAME"),
						rs.getString("POSITION_NAME"),
						LocalDate.parse(rs.getDate("INDAY").toString()),
						LocalDate.parse(rs.getDate("OUTDAY").toString()),
						rs.getString("YEAR")
						);
				ls.add(tmp);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return (ls.size() == 0) ? null : ls;
	}

	
}
