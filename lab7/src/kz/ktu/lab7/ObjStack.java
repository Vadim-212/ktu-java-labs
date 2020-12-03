package kz.ktu.lab7;

import java.util.Collection;
import java.util.Stack;

public class ObjStack<T> {
    private Stack<T> stack;

    public ObjStack() {
        this.stack = new Stack<>();
    }

    public ObjStack(Stack<T> stack) {
        this.stack = stack;
    }

    public void addToStack(T obj) {
        stack.push(obj);
    }

    public void addCollectionToStack(Collection<T> c) {
        stack.addAll(c);
    }

    public void printStack() {
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
