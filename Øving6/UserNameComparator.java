package interfaces.twitter;

import java.util.Comparator;

public class UserNameComparator implements Comparator<TwitterAccount> {

	@Override
	public int compare(TwitterAccount acc1, TwitterAccount acc2) {
		/*String name1 = acc1.getUserName();
		String name2 = acc2.getUserName();
		for (int i = 0; i < name1.length(); i++) {
			if (name2.length() >= i) {
				char char1 = name1.charAt(i);
				char char2 = name2.charAt(i);
				if (Character.toLowerCase(char1) > Character.toLowerCase(char2)) {
					return 1;
				} if (Character.toLowerCase(char1) < Character.toLowerCase(char2)) {
					return -1;
				}
			}
		} */return acc1.getUserName().compareTo(acc2.getUserName());
	} 
}
