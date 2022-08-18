package run_2022.run_2022_08;

import java.util.Iterator;

/**
 * @author lihaoyu
 * @date 2022/8/14 22:57
 */
public class Main284 {


    class PeekingIterator implements Iterator<Integer> {
        Integer temp = 0;
        int last = 0;
        Iterator<Integer> iterator;


        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            temp = this.iterator.next();
            if(!iterator.hasNext()){
                last++;
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return temp;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            int a = temp;
            if(iterator.hasNext()){
                temp = iterator.next();
                if(!iterator.hasNext()){
                    last++;
                }
            }else{
                last++;
            }
            return a;
        }

        @Override
        public boolean hasNext() {
            return last != 2;
        }
    }


}
