/**
 * File Name: DataHelper.java<br>
 * Munteanu, Alex<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jan 30, 2017
 */
package com.amunteanu.helpers;

/**
 * DataHelper //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Munteanu, Alex
 * @version 1.0.0
 * @since 1.0
 */
public class DataHelper {

	private Object[][] data;

	public DataHelper(Object[][] data) {
		super();
		this.data = data;
	}

	// Static method
	public static String displayData(Object[][] data) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				sb.append(data[i][j] + " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	// Instance method
	public String displayData() {
		return displayData(this.data);
	}
}
