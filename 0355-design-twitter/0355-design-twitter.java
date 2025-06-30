class Twitter {
    private HashMap<Integer, HashSet<Integer>> followList;
    private List<Tweet> posts;

    public Twitter() {
        posts = new ArrayList<>();
        followList = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        posts.add(new Tweet(tweetId, userId));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        HashSet<Integer> followees = followList.getOrDefault(userId, new HashSet<>());
        followees.add(userId);  

        for (int i = posts.size() - 1; i >= 0 && feed.size() < 10; i--) {
            Tweet tweet = posts.get(i);
            if (followees.contains(tweet.getUserID())) {
                feed.add(tweet.getTweetID());
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        followList.putIfAbsent(followerId, new HashSet<>());
        followList.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followList.containsKey(followerId)) {
            followList.get(followerId).remove(followeeId);
        }
    }

    class Tweet {
        private int id;
        private int user;

        public Tweet(int id, int user) {
            this.id = id;
            this.user = user;
        }

        public int getTweetID() {
            return id;
        }

        public int getUserID() {
            return user;
        }
    }
}
