package com.jdc.mkt.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.model.Category;

import static com.jdc.mkt.utils.ConnectionManager.getConnection;

class CategoryServiceImpl implements CategoryService {

	

	@Override
	public void createCategory(Category c) {
		String sql = "insert into category_tbl (cat_name,cat_size,cat_sex)values(?,?,?)";
		try (Connection conn = getConnection(); var stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, c.name());
			stmt.setString(2, c.size());
			stmt.setString(3, c.sex());

			stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Category> findBy(String name, String size, String sex) {

		StringBuffer sb = new StringBuffer("select * from category_tbl where 1=1");
		List<Object> list = new ArrayList<>();
		List<Category>categories=new ArrayList<>();

		if (name != null && !name.isEmpty()) {
			sb.append(" and cat_name=?");
			list.add(name);
		}
		if (size != null && !size.isEmpty()) {
			sb.append(" and cat_size=?");
			list.add(size);
		}
		if (sex != null && !sex.isEmpty()) {
			sb.append(" and cat_sex=?");
			list.add(sex);
		}

		try (Connection conn = getConnection(); var stmt = conn.prepareStatement(sb.toString())) {

			for (int i = 0; i < list.size(); i++) {
				stmt.setObject(i + 1, list.get(i));
			}
			var rs = stmt.executeQuery();

			while (rs.next()) {
				Category c = new Category(
							rs.getString("cat_name"),
							rs.getString("cat_size"),
							rs.getString("cat_sex")
						);
				categories.add(c);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}

}
