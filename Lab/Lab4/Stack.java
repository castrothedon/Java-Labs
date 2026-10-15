package Lab.Lab4;

import java.util.ArrayList;

public class Stack {
    private final ArrayList<String> items = new ArrayList<>();

    public void push(String item) {
        items.add(item);
    }

    public String pop() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return items.remove(items.size() - 1);
    }

    public String peek() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}

class StackDemo {
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push("A");
        stack.push("B");
        stack.push("C");

        System.out.println("Top: " + stack.peek());
        System.out.println("Removed: " + stack.pop());
        System.out.println("Removed: " + stack.pop());
        System.out.println("Empty: " + stack.isEmpty());
    }
}
