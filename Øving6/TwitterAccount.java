package interfaces.twitter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

public class TwitterAccount {
	public String account;
	private ArrayList <TwitterAccount> following; //brukeren følger
	private ArrayList <TwitterAccount> followedBy; //brukeren blir fulgt av
	private ArrayList <Tweet> tweets; //tweetsene til brukeren
	
	public TwitterAccount(String name) {
		this.account = name;
		this.following = new ArrayList<TwitterAccount>();
		this.followedBy = new ArrayList<TwitterAccount>();
		this.tweets = new ArrayList<Tweet>();

	}
	
	public String getUserName() {
		return this.account;
	}
	
	public int getFollowerCount() {
		return this.followedBy.size();
	}
	
	public void follow(TwitterAccount account) {
		if (account != this && following.contains(account)) {
			this.following.add(account);
			account.followedBy.add(this);
		}
	}
	
	public void unfollow(TwitterAccount account) {
		if (account != this && followedBy.contains(account)) {
			this.following.remove(account);
			account.followedBy.remove(this);
		}
	}
	
	public boolean isFollowing(TwitterAccount account) {
		if (this.following.contains(account)) return true;
		return false;
	}
	
	public boolean isFollowedBy(TwitterAccount account) {
		if (account.following.contains(this)) {
			return true;
		} return false;
	}
	
	public void tweet(String string) {
		Tweet tweet = new Tweet(this, string);
		this.tweets.add(tweet);
	}
	
	public void retweet(Tweet tweet) {
		tweets.add(new Tweet(this, tweet));
	}
	
	public Tweet getTweet(int i) {
		if (tweets.isEmpty()) {
			throw new IllegalArgumentException("Denne brukeren har ingen tweets");
		} else {
			return tweets.get(tweets.size() -i);
		}
	}
	
	public int getTweetCount() {
		return tweets.size();
	}
	
	public int getRetweetCount() {
		int counter = 0;
		for (Tweet tweet : tweets) {
			counter += tweet.getRetweetCount();
		}
		return counter;
	}
	
	public List<TwitterAccount> getFollowers(Comparator<TwitterAccount> comparator) {
		if (comparator == null) {
			throw new IllegalArgumentException("Må være brukere i listen");
		}
		
		List<TwitterAccount> liste = new ArrayList<TwitterAccount>(followedBy);
		Collections.sort(liste, comparator);
		return liste;
	}
	
}
