package com.jdc;

import org.junit.jupiter.api.BeforeAll;

import static com.jdc.mkt.utils.ConnectionManager.getConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

class ConnectionTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

	}

	private void testConnection() {

		String sql = "select * from user_tbl";
		// String sql="insert into stu_tbl values(?,?)";
		try (Connection con = getConnector(); PreparedStatement stmt = con.prepareStatement(sql)) {

//					stmt.setInt(1, 2);
//					stmt.setString(2, "hi");
//					stmt.executeUpdate();

			var rs = stmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
//	@Test
//	void test() {
//		List<Member>list = con.testConnection();
//		assertEquals(2, list.size());
//	}

}
