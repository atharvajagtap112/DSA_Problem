package Heaps;

import java.util.*;

public class Design_Twitter {


    class Tweet implements Comparable<Tweet>{
        int id;
        int time;
           Tweet(int id, int time){
               this.id=id;
               this.time=time;
           }
        @Override
        public int compareTo(Tweet that) {
            return this.time-that.time; //Dec
        }
    }

    class User{
        int userId;
        HashSet<Integer> followerList;
        List<Tweet> tweetList;
        User(int userId){
            this.userId=userId;
            followerList=new HashSet<>();
            tweetList =new LinkedList<>();
            addFollower(userId);
        }

        void addTweet(Tweet tweet){
            tweetList.add(0,tweet); // add at the head
        }

        void addFollower(int followeeId){
            followerList.add(followeeId);
        }

        void removeFollower(int followeeId){
            followerList.remove(followeeId);
        }
    }
    class Twitter {
        HashMap<Integer,User> map;
        int timeCounter;
        public Twitter() {
            this.map=new HashMap<>();
            this.timeCounter =0;
        }

        public void postTweet(int userId, int tweetId) {
            timeCounter++;

           if (!map.containsKey(userId)) {
              map.put(userId,new User(userId)) ;
           }
           Tweet tweet=new Tweet(tweetId, timeCounter);
           User user=map.get(userId);
           user.addTweet(tweet);

        }

        public List<Integer> getNewsFeed(int userId) {
            if (!map.containsKey(userId)) return new ArrayList<>();
            PriorityQueue<Tweet> pq=new PriorityQueue<>();
            User user=map.get(userId);
            for( int followerId:user.followerList ){
                int count=0;
                 for( Tweet tweet: map.get(followerId).tweetList){
                     count++;
                      pq.add(tweet);
                      if (count>10) break;
                 }

            }
            ArrayList<Integer> list=new ArrayList<>();
            int count=0;
            while (!pq.isEmpty()&& count<10){
                list.add(pq.poll().id);
                
            }
                      return list;
        }

        public void follow(int followerId, int followeeId) {
            if (!map.containsKey(followerId)) {
                map.put(followerId,new User(followerId)) ;
            }
            if (!map.containsKey(followeeId)) {
                map.put(followeeId,new User(followeeId)) ;
            }

            User user=map.get(followerId);
            user.addFollower(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
           if (!map.containsKey(followerId) || !map.containsKey(followeeId)) return;
           User user=map.get(followerId);
           user.removeFollower(followeeId);
        }
    }

}
