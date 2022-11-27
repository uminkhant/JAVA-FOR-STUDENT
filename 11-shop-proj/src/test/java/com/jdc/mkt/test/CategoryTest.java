package com.jdc.mkt.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.model.Category;
import com.jdc.mkt.service.CategoryService;

class CategoryTest {
	
	private static CategoryService catService;

	@BeforeAll
	static void init(){
		catService=CategoryService.getCategoryService();
	}

//	@ParameterizedTest
//	@CsvSource(
//		{ 	"Trouser,Medium,Female",
//			"Trouser,Small,Female",
//			"Trouser,Large,Female"
//		}
//			)
//	@Order(1)
//	void crateCategory(String name,String size,String sex) {
//		Category c=new Category(name, size, sex);
//		catService.createCategory(c);
//		
//	}
	
	@Test
	@Order(2)
	void findBy() {
		assertEquals(8, catService.findBy(0,null, null, null).size());
	}

}
