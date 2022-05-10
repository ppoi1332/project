package boot_project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public DeleteDAO () {
		jdbcTemplate = JdbcTemplate.getInstance();
	}
	
	public boolean deleteDAO(String name) {
		boolean ret = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete from \"SOLDIER\" where \"NAME\" = '"+name+"'";	
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
