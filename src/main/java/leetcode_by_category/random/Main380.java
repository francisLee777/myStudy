package leetcode_by_category.random;

import java.util.*;

/*
手动收藏
实现RandomizedSet 类：
RandomizedSet() 初始化 RandomizedSet 对象
bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
 */
public class Main380 {

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.insert(1));

        System.out.println(set.insert(2));
        System.out.println(set.insert(3));
        int count = 0;
        for (int i = 0; i < 10000; i++) {
            count += set.getRandom();
        }
        System.out.println(count / 10000);
    }

    static class RandomizedSet {

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Random random = new Random();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            boolean contains = map.containsKey(val);
            if (contains) {
                return false;
            }
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }

        public boolean remove(int val) {
            boolean contains = map.containsKey(val);
            if (!contains) {
                return false;
            }
            Integer index = map.remove(val);
            // 交换数组中的位置到最后一个
            Integer last = list.get(list.size() - 1);
            list.set(index, last);
            list.remove(list.size() - 1);
            if (index != list.size()) {
                map.put(last, index);
            }
            return true;
        }

        public int getRandom() {
            if (list.size() == 1) return list.get(0);
            return list.get(random.nextInt(list.size()));
        }
    }


}
