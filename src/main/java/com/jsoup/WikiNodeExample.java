package com.jsoup;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class WikiNodeExample {
    public static void main(String[] args) throws IOException {
        String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";

        //지정한 URL의 HTML문서를 가져와서 파싱
        Connection conn = Jsoup.connect(url);
        Document doc = conn.get();

        //지정한 id를 가진 콘텐츠 텍스틀를 가져온다.
        Element content = doc.getElementById("mw-content-text");

        //지정한 콘텐츠 텍스트에서 p 태그 요소만을 선택한다.
        Elements paras = content.select("p");
        Element firstPara = paras.get(0);

        recursiveDFS(firstPara);
        System.out.println();
        iterativeDFS(firstPara);
        System.out.println();

        Iterable<Node> iter = new WikiNodeIterable(firstPara);
        for (Node node : iter) {
            if (node instanceof TextNode) {
                System.out.println(node);
            }
        }

    }

    private static void iterativeDFS(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);

        //stack이 비어있다면 끝난 것
        while (!stack.isEmpty()) {
            //otherwise pop the next Node off the stack
            Node node = stack.pop();
            if (node instanceof TextNode) {
                System.out.println(node);
            }

            //push the children onto the stack in reverse order
            List<Node> nodes = new ArrayList<Node>(node.childNodes());
            Collections.reverse(nodes);

            for (Node child : nodes) {
                stack.push(child);
            }
        }
    }

    private static void recursiveDFS(Node node) {
        if (node instanceof TextNode) {
            System.out.println(node);
        }
        for (Node child : node.childNodes()) {
            recursiveDFS(child);
        }
    }
}
