/**
 * File Name: AppBasics.java<br>
 * Munteanu, Alex<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jan 14, 2017
 */
package com.amunteanu.helpers;

import java.util.*;

/**
 * AppBasics //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Munteanu, Alex
 * @version 1.0.0
 * @since 1.0
 */
public class AppBasics {

	static Scanner scanner = new Scanner(System.in);

	public static void farewellUser(String userName, String nameOfApp) {
		System.out.println("Bye " + userName + "\nThanks for using " + nameOfApp);
	}

	public static String greetUserAndGetName(String nameOfApp) {
		System.out.println("Hello\nWelcome to " + nameOfApp);
		System.out.println("Can I get your name?");
		return scanner.nextLine();
	}

	public static boolean requestbooleanFromUser(String question) {
		String response;
		boolean answerReceived = false;
		boolean answer = true;
		while (!answerReceived) {
			System.out.print(question + " ");
			response = scanner.nextLine();
			if (response.equalsIgnoreCase("yes")) {
				answerReceived = true;
				answer = true;
			} else if (response.equalsIgnoreCase("no")) {
				answerReceived = true;
				answer = false;
			}
		}
		return answer;
	}

	public static String requestInfoFromUser(String question) {
		String response;
		System.out.print(question + " ");
		response = scanner.nextLine();
		return response;
	}

	public static int requestIntFromUser(String question) {
		String input;
		int result;
		System.out.print(question + " ");
		input = scanner.nextLine();
		result = Integer.parseInt(input);
		return result;
	}
}
