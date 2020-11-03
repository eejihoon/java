package com.jsoup;

import org.jsoup.nodes.Node;

import java.util.*;

public class WikiNodeIterable implements Iterable<Node> {
    private Node root;

    public WikiNodeIterable(Node root) {
        this.root = root;
    }

    @Override
    public Iterator<Node> iterator() {
        return new WikiNodeIterator(root);
    }

    /*
     *   Iterator를 구현하는 내부 클래스
     * */
    private class WikiNodeIterator implements Iterator<Node> {
        //이 스택은 대기 중인 노드를 추적한다.
        Deque<Node> stack;

        public WikiNodeIterator(Node node) {
            stack = new ArrayDeque<Node>();
            stack.push(root);
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public Node next() {
            //스택이 비어있으면
            if (stack.isEmpty()) {
                throw new NoSuchElementException();
            }
            //아니라면 꺼낸다.
            Node node = stack.pop();

            //역순으로 자식으 스택에 넣는다.
            List<Node> nodes = new ArrayList<Node>(node.childNodes());
            Collections.reverse(nodes);
            for (Node child : nodes) {
                stack.push(child);
            }
            return node;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

