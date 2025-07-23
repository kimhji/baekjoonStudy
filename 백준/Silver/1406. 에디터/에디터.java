import java.io.*;
import java.util.*;

class DequeHandler {

    Deque<Character> leftDeque = new LinkedList<>();
    Deque<Character> rightDeque = new LinkedList<>();

    DequeHandler(Deque<Character> leftDeque, Deque<Character> rightDeque) {
        this.leftDeque = leftDeque;
        this.rightDeque = rightDeque;
    }

    public void pushCharsFromString(String string) {
        for (char ch : string.toCharArray()) {
            leftDeque.addLast(ch);
        }
    }

    public char popLastLeft() {
        return leftDeque.removeLast();
    }

    public char popFirstLeft() {
        return leftDeque.removeFirst();
    }

    public char popFirstRight() {
        return rightDeque.removeFirst();
    }

    public void pushLastLeft(char poppedChar) {
        leftDeque.addLast(poppedChar);
    }

    public void pushFirstRight(char poppedChar) {
        rightDeque.addFirst(poppedChar);
    }

    public boolean isLeftDequeEmpty() {
        return leftDeque.isEmpty();
    }

    public boolean isRightDequeEmpty() {
        return rightDeque.isEmpty();
    }
}

class CommandLibrary {

    public static void L(DequeHandler dequeHandler) {

        if (dequeHandler.leftDeque.isEmpty()) {
            return;
        }

        char poppedChar = dequeHandler.popLastLeft();
        dequeHandler.pushFirstRight(poppedChar);
    }

    public static void D(DequeHandler dequeHandler) {

        if (dequeHandler.rightDeque.isEmpty()) {
            return;
        }

        char poppedChar = dequeHandler.popFirstRight();
        dequeHandler.pushLastLeft(poppedChar);
    }

    public static void B(DequeHandler dequeHandler) {

        if (dequeHandler.leftDeque.isEmpty()) {
            return;
        }

        dequeHandler.popLastLeft();
    }

    public static void P(DequeHandler dequeHandler, char insetChar) {
        dequeHandler.pushLastLeft(insetChar);
    }
}

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Character> leftDeque = new LinkedList<>();
        Deque<Character> rightDeque = new LinkedList<>();
        DequeHandler dequeHandler = new DequeHandler(leftDeque, rightDeque);
        
        dequeHandler.pushCharsFromString(br.readLine().trim());
        int N = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < N; i++) {
        	String cmd = br.readLine().trim();
            switch (cmd.charAt(0)) {
                case 'L':
                    CommandLibrary.L(dequeHandler);
                    break;
                case 'D':
                    CommandLibrary.D(dequeHandler);
                    break;
                case 'B':
                    CommandLibrary.B(dequeHandler);
                    break;
                case 'P':
                    CommandLibrary.P(dequeHandler, cmd.charAt(2));
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : leftDeque) sb.append(c);
        for (char c : rightDeque) sb.append(c);
        System.out.println(sb);
        
	}
}
