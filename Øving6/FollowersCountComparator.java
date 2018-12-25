package interfaces.twitter;

import java.util.Comparator;

public class FollowersCountComparator implements Comparator<TwitterAccount> {
	
	public int compare(TwitterAccount acc1, TwitterAccount acc2) {
		return acc2.getFollowerCount() - acc1.getFollowerCount();
	}
	
}
