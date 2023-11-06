import java.util.Stack;

class Node<T> {
    T val;
    Node<T> next;

    public Node(T val) {
        this.val = val;
        this.next = null;
    }
}

class Source {
    public static <T> Node<T> reverseList(Node<T> head) {
        var myStack = new Stack<T>();
        var ptr = head;
        while ( ptr != null ) {
            myStack.push(ptr.val);
            ptr = ptr.next;
        }
        ptr = head;
        while ( ptr != null ) {
            ptr.val = myStack.pop();
            ptr = ptr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println("Example 1: ");
        Node<String> x = new Node<>("x");
        Node<String> y = new Node<>("y");

        x.next = y; // x -> y

        // Printing solution
        Node<String> head = Source.reverseList(x);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

        System.out.println("\nExample 2: ");
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        // a -> b -> c -> d -> e -> f

        head = Source.reverseList(a); // f -> e -> d -> c -> b -> a
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}