package org.agoda.hiring;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.text.similarity.LevenshteinDistance;

/**
 * Password change app
 * 
 * @author Bharat Goel
 */
public class App {
	static String systemPassword = "@wqqq2q2#31!@QQ2QQ";

	public static void main(String[] args) {
		System.out.println(ChangePassword("@wqqq2q2#31!@QQ2QQ", "@wqqeab2#31!@QQ2QA"));
	}

	static boolean ChangePassword(String oldPassword, String newPassword) {

		// Check old and new password should not be empty or null
		if (oldPassword == null || newPassword == null || oldPassword.trim().isEmpty()
				|| newPassword.trim().isEmpty()) {
			return false;
		}

		// Old password should match with system
		if (oldPassword != systemPassword) {
			return false;
		}

		// Password requirement for new password
		// At least 18 alphanumeric characters and list of special chars !@#$&*
		// At least 1 Upper case, 1 lower case ,least 1 numeric, 1 special character
		if (newPassword.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$&*])(?=\\S+$).{18,}$")) {
			//Used apache lib to get the number of steps required to match the string
			int similarityIndex = LevenshteinDistance.getDefaultInstance().apply(oldPassword, newPassword);
			Map<Character, Integer> charCountMap = new HashMap<Character, Integer>();
			char[] ch = newPassword.toCharArray();
			String patternToMatch = "[!@#$&*]+";
			Pattern p = Pattern.compile(patternToMatch);
			int num = 0;
			int spChar = 0;
			int rpChar = 0;
			int similarityPercent = 0;
			for (int i = 0; i < newPassword.length(); i++) {
				//Counting the number of digit
				if (Character.isDigit(ch[i])) {
					num++;
				}
				//Counting the number of special character
				Matcher m = p.matcher(Character.toString(ch[i]));
				if (m.find()) {
					spChar++;
					if (spChar == 5)
						break;
				}
				//Counting the repetitive character
				if (charCountMap.containsKey(ch[i])) {
					charCountMap.put(ch[i], charCountMap.get(ch[i]) + 1);
					if (charCountMap.get(ch[i]) > 4) {
						rpChar++;
						break;
					}
				} else {
					charCountMap.put(ch[i], 1);
				}
			}
			//Calculating the % of similarity
			similarityPercent = (similarityIndex * 100 / oldPassword.length());
			// No duplicate repeat characters more than 4
			// No more than 4 special characters
			// 50 % of password should not be a number
			// password is not similar to old password < 80% match.
			if (rpChar == 0 && spChar < 5 && num < newPassword.length() / 2 && similarityPercent > 20) {
				return true;
			}
			return false;
		}
		return false;

	}
}
