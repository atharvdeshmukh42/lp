import java.util.*;

class Node {
    char ch;
    int freq;
    Node left, right;

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}

public class HuffmanSimple {

    public static void printCode(Node root, String code) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            return;
        }

        printCode(root.left, code + "0");
        printCode(root.right, code + "1");
    }

    public static void main(String[] args) {

        char[] chars = { 'a', 'b', 'c', 'd' };
        int[] freq = { 5, 9, 12, 13 };

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.freq));

        for (int i = 0; i < chars.length; i++)
            pq.add(new Node(chars[i], freq[i]));

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node newNode = new Node('-', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;
            pq.add(newNode);
        }

        Node root = pq.poll();
        System.out.println("Huffman Codes:");
        printCode(root, "");
    }
}
