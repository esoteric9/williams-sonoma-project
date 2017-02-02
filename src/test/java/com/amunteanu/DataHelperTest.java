package com.amunteanu;

import org.testng.*;
import org.testng.annotations.*;

import com.amunteanu.helpers.*;

public class DataHelperTest {

	// @DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 3, 5, 4, 1 }, new Object[] { 3.1, 5.55, 4.1, 1.3 },
				new Object[] { "3", "5", "4", "1" }, new Object[] { '3', '5', '4', '1' } };
	}

	// @Test
	public void testStaticDataHelper() {
		Object[][] data = dp();
		String expected = "3 5 4 1 \n" + "3.1 5.55 4.1 1.3 \n" + "3 5 4 1 \n" + "3 5 4 1 \n";
		String actual = DataHelper.displayData(data);
		System.out.println(DataHelper.displayData(data));
		Assert.assertEquals(actual, expected, "does not work correctly");
	}

	@Test
	public void testDataHelper() {
		DataHelper helper = new DataHelper(this.dp());
		String expected = "3 5 4 1 \n" + "3.1 5.55 4.1 1.3 \n" + "3 5 4 1 \n" + "3 5 4 1 \n";
		String actual = helper.displayData();
		System.out.println(helper.displayData());
		Assert.assertEquals(actual, expected, "does not work correctly");
	}
}
