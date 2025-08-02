class Twitter {
    HashMap<Integer, HashSet<Integer>> usersFollowingList;
    HashMap<Integer, List<Tweet>> tweetsPostedByUser;
    int timestamp;
    public Twitter() {
        usersFollowingList = new HashMap<>();
        tweetsPostedByUser = new HashMap<>();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, timestamp++);
        tweetsPostedByUser.putIfAbsent(userId, new ArrayList<>());
        tweetsPostedByUser.get(userId).add(tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        ArrayList<Integer> feed = new ArrayList<>();
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a,b)->b.timestamp-a.timestamp);

        usersFollowingList.putIfAbsent(userId, new HashSet<>());
        usersFollowingList.get(userId).add(userId);

        for(int followedUser : usersFollowingList.get(userId)){
            tweetsPostedByUser.putIfAbsent(followedUser, new ArrayList<>());
            List<Tweet> tweetPostedByFollowedUser = tweetsPostedByUser.get(followedUser);
            for(int i = tweetPostedByFollowedUser.size()-1; i>=0 && i>=tweetPostedByFollowedUser.size()-10; i--){
                pq.offer(tweetPostedByFollowedUser.get(i));
            }
        }
        for(int i = 1; i<=10; i++){
            if(pq.isEmpty()) break;
            feed.add(pq.poll().tweetId);
        }
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        usersFollowingList.putIfAbsent(followerId, new HashSet<>());
        usersFollowingList.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!usersFollowingList.containsKey(followerId) || !usersFollowingList.get(followerId).contains(followeeId) || followerId==followeeId) return;
        usersFollowingList.get(followerId).remove(followeeId);
    }

    class Tweet{
        int tweetId;
        int timestamp;
        public Tweet(int tweetId, int timestamp){
            this.tweetId = tweetId;
            this.timestamp = timestamp;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */