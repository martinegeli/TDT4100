package interfaces.twitter;

public class Tweet {
	private TwitterAccount account;
	private String text;
	private Tweet originalTweet;
	private int tweetCounter;
	
	public Tweet(TwitterAccount account, String string) {
		this.account = account;
		this.text = string;
		this.originalTweet = null;
	}
	
	public Tweet(TwitterAccount account, Tweet originalTweet) {
		/*if (account.equals(originalTweet.getOwner())) {
			throw new IllegalArgumentException("Ikke retweet egne");
		} 
		this.account = account;
		this.text = originalTweet.getOriginalTweet().getText();
		this.originalTweet = originalTweet;
		if (originalTweet.getOriginalTweet() == null) {
			this.originalTweet = originalTweet;
		} else {
			this.originalTweet = originalTweet.getOriginalTweet();
		}
		originalTweet.retweet(); */
		
		Tweet OTweet = originalTweet.getOriginalTweet();
		if (originalTweet.getOwner() == account || (OTweet != null && OTweet.getOwner() == account)) {
			throw new IllegalArgumentException("Kan ikke retweete egen tweet");
		}
		this.account = account;
		this.originalTweet = (OTweet != null ? OTweet : originalTweet);
		this.originalTweet.retweet();
		this.text = this.originalTweet.getText();
		
	}
	
	public String getText() {
		return this.text;
	}
	
	public TwitterAccount getOwner() {
		return this.account;
	}
	
	public Tweet getOriginalTweet() {
		return this.originalTweet;
	}
	
	public void retweet() {
		tweetCounter++;
	}
	
	public int getRetweetCount() {
		return this.tweetCounter;
	}
	
	public String toString() {
		return this.getOwner().getUserName() + ": " + this.getText();
	}
	
}
