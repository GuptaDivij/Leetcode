import java.util.*;

class Twitter {
    private static int timestamp = 0;

    // user -> set of followees
    private Map<Integer, Set<Integer>> followList;

    // user -> list of tweets
    private Map<Integer, List<Tweet>> userTweets;

    // Max number of tweets in feed
    private static final int FEED_SIZE = 10;

    public Twitter() {
        followList = new HashMap<>();
        userTweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        // Auto-follow self
        follow(userId, userId);

        userTweets.putIfAbsent(userId, new ArrayList<>());
        userTweets.get(userId).add(new Tweet(tweetId, timestamp++, userId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);

        Set<Integer> followees = followList.getOrDefault(userId, new HashSet<>());

        for (int followee : followees) {
            List<Tweet> tweets = userTweets.getOrDefault(followee, new ArrayList<>());
            for (int i = tweets.size() - 1; i >= 0 && i >= tweets.size() - FEED_SIZE; i--) {
                maxHeap.offer(tweets.get(i));
            }
        }

        while (!maxHeap.isEmpty() && feed.size() < FEED_SIZE) {
            feed.add(maxHeap.poll().id);
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        followList.putIfAbsent(followerId, new HashSet<>());
        followList.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return; // cannot unfollow self
        if (followList.containsKey(followerId)) {
            followList.get(followerId).remove(followeeId);
        }
    }

    private static class Tweet {
        int id;
        int timestamp;
        int userId;

        public Tweet(int id, int timestamp, int userId) {
            this.id = id;
            this.timestamp = timestamp;
            this.userId = userId;
        }
    }
}
