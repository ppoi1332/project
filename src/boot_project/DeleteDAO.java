package boot_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DeleteDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public DeleteDAO () {
		jdbcTemplate = JdbcTemplate.getInstance();
	}
	
	public List<SoldierVO> selectAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		List<SoldierVO> ls = new ArrayList<>();	
		String sql = "select \"NUMBER\", \"NAME\", \"BIRTH\" from \"SOLDIER\" order by \"NUMBER\" asc";	
		try {
			conn = jdbcTemplate.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SoldierVOex tmp = new SoldierVOex(
						rs.getLong("NUMBER"),
						rs.getString("NAME"),
						LocalDate.parse(rs.getDate("BIRTH").toString())
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
	
	public boolean deleteDAO(long number) {
		boolean ret = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete from \"SOLDIER\" where \"NUMBER\" = '"+number+"'";	
		try {
			con = jdbcTemplate.getConnection();
			pstmt = con.prepareStatement(sql);
			int res = pstmt.executeUpdate();
			System.out.println("삭제 완료");
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
