import java.util.HashMap;

class ECSource {

    public static <T> boolean isUnivalueList(Node<T> head) {
        var freqMap = new HashMap<T, Integer>();
        var count = 0;
        while ( head != null ) {
            var currFreq = freqMap.putIfAbsent(head.val, 1);
            if ( currFreq == null ) {
                count++;
            } else {
                if ( currFreq != -1 ) count--;
                freqMap.put(head.val, -1);
            }
            head = head.next;
        }
        return count==1;
    }

    /*
    public static <T> boolean isUnivalueListRecursive(Node<T> head) {
        if (head == null) {
            return true;
        } else - if () {

        }

        return isUnivalueList(head.next)
        return true;
    }
     */

    public static void main(String[] args) {
        System.out.println("Test 1: ");
        Node<String> z = new Node<>("z");
        // z

        System.out.println((ECSource.isUnivalueList(z))); // true

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

        System.out.println(ECSource.isUnivalueList(u)); // false

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

        System.out.println(ECSource.isUnivalueList(u)); // true

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

        System.out.println(ECSource.isUnivalueList(u)); // false
    }
}
