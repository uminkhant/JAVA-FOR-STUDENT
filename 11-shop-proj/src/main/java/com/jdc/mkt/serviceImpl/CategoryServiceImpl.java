package com.jdc.mkt.serviceImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.model.Category;
import com.jdc.mkt.service.CategoryService;
import static com.jdc.mkt.utils.ConnectionManager.getConnection;

public class CategoryServiceImpl implements CategoryService {

	@Override
	public List<Category> getAllCatgory() {

		String sql = "select * from category_tbl ";

		List<Category> list = new ArrayList<>();
		try (Connection conn = getConnection(); var stmt = conn.prepareStatement(sql)) {

			var rs = stmt.executeQuery();

			while (rs.next()) {
				Category c = new Category(rs.getString("cat_name"), rs.getString("cat_size"), rs.getString("cat_sex"));
				list.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void createCategory(Category cat) {

	}

}
