# AH9

Algo Hour 9

# Objective

Fork and clone this repository. Work on the objective(s). Then push up your changes to YOUR fork.

Write a method, `reverseList`, that takes in the head of a linked list as an argument. The method should reverse the order of the nodes in the linked list in-place and return the new head of the reversed linked list.

# Test Cases

```java
Node<String> x = new Node<>("x");
Node<String> y = new Node<>("y");

x.next = y; // x -> y

reverseList(x); // y -> x
```

```java
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

reverseList(a); // f -> e -> d -> c -> b -> a
```
# Extra Credit

## Objective

Write a method, `isUnivalueList`, that takes in the head of a linked list as an argument. The method should return a boolean indicating whether or not the linked list contains exactly one unique value.

You may assume that the input list is non-empty.

Extra Extra Credit: Can you accomplish this recursively?

## Test Cases

```java
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

Source.isUnivalueList(u); // true
```

```java
Node<Integer> u = new Node<>(2);
Node<Integer> v = new Node<>(2);
Node<Integer> w = new Node<>(3);
Node<Integer> x = new Node<>(3);
Node<Integer> y = new Node<>(2);

u.next = v;
v.next = w;
w.next = x;
x.next = y;

// 2 -> 2 -> 3 -> 3 -> 2

Source.isUnivalueList(u); // false
```

```java
Node<String> z = new Node<>("z");
// z

Source.isUnivalueList(z); // true
```
