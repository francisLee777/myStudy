package leetcode_by_category.stack_and_queue;

import java.util.*;

public class Main355 {

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5); // 用户 1 发送了一条新推文 (用户 id = 1, 推文 id = 5)
        System.out.println(twitter.getNewsFeed(1));  // 用户 1 的获取推文应当返回一个列表，其中包含一个 id 为 5 的推文
        twitter.follow(1, 2);    // 用户 1 关注了用户 2
        twitter.postTweet(2, 6); // 用户 2 发送了一个新推文 (推文 id = 6)
        twitter.getNewsFeed(1);  // 用户 1 的获取推文应当返回一个列表，其中包含两个推文，id 分别为 -> [6, 5] 。推文 id 6 应当在推文 id 5 之前，因为它是在 5 之后发送的
        twitter.unfollow(1, 2);  // 用户 1 取消关注了用户 2
        twitter.getNewsFeed(1);  // 用户 1 获取推文应当返回一个列表，其中包含一个 id 为 5 的推文。因为用户 1 已经不再关注用户 2
    }

    static class PostInfo {
        int tweetId;
        int incrementID;

        public PostInfo(int tweetId, int incrementID) {
            this.tweetId = tweetId;
            this.incrementID = incrementID;
        }
    }


    static class Twitter {
        int incrementID = 0; // 全局自增id，用于时间排序。 不考虑并发

        // 用户关系  用户-关注集合
        Map<Integer, Set<Integer>> userRelation = new HashMap<>();

        Map<Integer, List<PostInfo>> userPostList = new HashMap<>();

        public Twitter() {

        }

        // 发推
        public void postTweet(int userId, int tweetId) {
            List<PostInfo> temp = userPostList.getOrDefault(userId, new ArrayList<>());
            // 每次都往头部加，最新的在前面
            temp.add(0, new PostInfo(tweetId, incrementID++));
            userPostList.put(userId, temp);
        }

        // 读扩散而非写扩散. 不考虑并发
        public List<Integer> getNewsFeed(int userId) {
            // 多路归并，取前10个
            List<Integer> resList = new ArrayList<>();
            List<List<PostInfo>> tempList = new ArrayList<>();
            if (userPostList.get(userId) != null && !userPostList.get(userId).isEmpty()) {
                tempList.add(userPostList.get(userId));
            }
            Set<Integer> followSet = userRelation.getOrDefault(userId, new HashSet<>());
            for (Integer id : followSet) {
                if (userPostList.get(id) != null && !userPostList.get(id).isEmpty()) {
                    tempList.add(userPostList.get(id));
                }
            }
            if (tempList.isEmpty()) return new ArrayList<>();
            // 执行多路归并
            int[] indexList = new int[tempList.size()];
            while (resList.size() < 10) {
                PostInfo newest = new PostInfo(-1, -1);
                int tempIndex = 0;
                int flag = 0;
                for (int i = 0; i < indexList.length; i++) {
                    if (tempList.get(i).size() > indexList[i] &&
                            tempList.get(i).get(indexList[i]).incrementID >= newest.incrementID) {
                        newest = tempList.get(i).get(indexList[i]);
                        tempIndex = i;
                        flag = 1;
                    }
                }
                // 多路加起来都不到10个
                if (flag == 0) {
                    break;
                }
                indexList[tempIndex]++;
                resList.add(newest.tweetId);
            }
            return resList;
        }

        // 关注
        public void follow(int followerId, int followeeId) {
            Set<Integer> temp = userRelation.getOrDefault(followerId, new HashSet<>());
            temp.add(followeeId);
            userRelation.put(followerId, temp);
        }

        // 取关
        public void unfollow(int followerId, int followeeId) {
            if (userRelation.get(followerId) != null) {
                userRelation.get(followerId).remove(followeeId);
            }
        }
    }
}
