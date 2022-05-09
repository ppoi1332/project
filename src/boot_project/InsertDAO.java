package boot_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public InsertDAO () {
		jdbcTemplate = JdbcTemplate.getInstance();
	}
	
	public boolean insertSoldier(SoldierVO sv) {
		boolean ret = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into \"SOLDIER\" values  (\"SEQ_SOLDIER\".nextval,?,?,?,?,?,?,?)";	
		try {
			con = jdbcTemplate.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sv.getName()); 
			pstmt.setObject(2, sv.getBirth());
			pstmt.setLong(3, sv.getDivision_Code());
			pstmt.setLong(4, sv.getPosition_Code());
			pstmt.setObject(5, sv.getIn_Day());
			pstmt.setObject(6, sv.getOut_Day());
			pstmt.setLong(7, sv.getYear_Code());
			int res = pstmt.executeUpdate();
			ret = true;			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}
	
	public boolean insertDivision(DivisionVO dv) {
		boolean ret = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into \"DIVISION\" values  (\"SEQ_SOLDIER\".nextval,?)";	
		try {
			con = jdbcTemplate.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dv.getDivision());
			int res = pstmt.executeUpdate();
			ret = true;			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}
	
	public boolean insertPosition(PositionVO pv) {
		boolean ret = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "insert into \"POSITION\" values  (\"SEQ_SOLDIER\".nextval,?)";	
		try {
			con = jdbcTemplate.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pv.getPosition());
			int res = pstmt.executeUpdate();
			ret = true;			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return ret;
	}

}
