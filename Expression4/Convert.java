package dsa.Expression4;
import java.util.Stack;
public class Convert {   //ye infix to postfix ka hi version hai.
    private String infix, postfix;

    public Convert(String infix) {
        this.infix = infix;
        postfix = "";
    }

    public void toPostfix() {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            if (isOperator(ch) == true) {
                postfix = postfix + ch;
            } else {
                while (st.empty() == false) {
                   if (precedence(ch)>precedence(st.peek()))
                        break;
                    postfix = postfix + st.pop();
                }
                st.push(ch);
            }
        }
        while ((st.empty() == false)) {
            postfix = postfix + st.pop();
        }
    }

    public int precedence(char op) {
        if (op == '$')
            return 3;
        else if (op== '/' || op == '%' || op == '*')
            return 2;
        else if (op == '+' || op == '-')
            return 1;
        else
            return 0;
    }
    public boolean isOperator(char ch) {
        if (ch >= 65 && ch <= 90 || ch >= 48 && ch <= 57)
            return true;
        return false;
    }
    @Override
    public String toString() {
        return "infix=" + infix +", postfix=" + postfix ;
    }
}
