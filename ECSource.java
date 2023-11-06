import java.util.HashMap;
import java.util.HashSet;

class ECSource {

    /*
    return true if there is EXACTLY one unique value in the list
    */
    public static <T> boolean isOnlyOneUniqueValueList(Node<T> head) {
        var freqMap = new HashMap<T, Integer>();
        var uniqueCount = 0;
        while ( head != null ) {
            var currFreq = freqMap.putIfAbsent(head.val, 1);
            if ( currFreq == null ) { // first time seeing val
                uniqueCount++;  // increment uniqueCount
            } else {    // already saw val, we know it's not unique
                if ( currFreq == 1 ) {     // this is EXACTLY the second time we're seeing val
                    uniqueCount--;    // decrement uniqueCount SOLELY on the second time we're seeing val
                    freqMap.put(head.val, -1);  // mark that we now know this val is not unique, so we don't
                                                // decrement uniqueCount again for other occurrences of val
                }
            }
            head = head.next;
        }
        return uniqueCount==1;
    }

    public static <T> boolean isUnivalueList(Node<T> head) {
        var set = new HashSet<T>();
        while ( head != null ) {
            set.add(head.val);
            if ( set.size() > 1 ) return false;
            head = head.next;
        }
        return (set.size()==1);
    }

    public static <T> boolean isUnivalueListRecursive(Node<T> head) {
        if ( head == null || head.next == null ) return true;
        return head.val == head.next.val && isUnivalueListRecursive(head.next);
    }


        public static void main(String[] args) {
        System.out.println("Test 1: ");
        Node<String> z = new Node<>("z");
        // z
        System.out.println("z->null");
        System.out.println(ECSource.isUnivalueList(z)); // true
        System.out.println(ECSource.isUnivalueListRecursive(z)); // true
        System.out.println((ECSource.isOnlyOneUniqueValueList(z))); // true

        System.out.println("\nTest 2: ");
        Node<Integer> u = new Node<>(2);
        Node<Integer> v = new Node<>(2);
        Node<Integer> w = new Node<>(2);
        Node<Integer> x = new Node<>(2);
        Node<Integer> y = new Node<>(2);

        u.next = v;
        v.next = w;
        w.next = x;
        x.next = y;

        // 2 -> 2 -> 2 -> 2 -> 2

        System.out.println("2 -> 2 -> 2 -> 2 -> 2");
        System.out.println(ECSource.isUnivalueList(u)); // true
        System.out.println(ECSource.isUnivalueListRecursive(u)); // true
        System.out.println(ECSource.isOnlyOneUniqueValueList(u)); // false

        System.out.println("\nTest 3: ");
        u = new Node<>(2);
        v = new Node<>(2);
        w = new Node<>(3);
        x = new Node<>(2);
        y = new Node<>(2);

        u.next = v;
        v.next = w;
        w.next = x;
        x.next = y;

        // 2 -> 2 -> 3 -> 2 -> 2

        System.out.println("2 -> 2 -> 3 -> 2 -> 2");
        System.out.println(ECSource.isUnivalueList(u)); // false
        System.out.println(ECSource.isUnivalueListRecursive(u)); // false
        System.out.println(ECSource.isOnlyOneUniqueValueList(u)); // true

        System.out.println("\nTest 4: ");
        u = new Node<>(2);
        v = new Node<>(5);
        w = new Node<>(3);
        x = new Node<>(6);
        y = new Node<>(6);
        var l = new Node<>(5);

        u.next = v;
        v.next = w;
        w.next = x;
        x.next = y;
        y.next = l;

        // 2 -> 5 -> 3 -> 6 -> 6 -> 5

        System.out.println("2 -> 5 -> 3 -> 6 -> 6 -> 5");
        System.out.println(ECSource.isUnivalueList(u)); // false
        System.out.println(ECSource.isUnivalueListRecursive(u)); // false
        System.out.println(ECSource.isOnlyOneUniqueValueList(u)); // false
    }
}
