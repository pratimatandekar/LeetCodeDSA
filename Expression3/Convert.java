package dsa.Expression3;
import java.util.Stack;
public class Convert {
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
                    boolean resutl = precedence(ch, st.peek());
                    if (resutl == true)
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

    public boolean isOperator(char ch) {
        if (ch >= 65 && ch <= 90 || ch >= 48 && ch <= 57)
            return true;
        return false;
    }

    public boolean precedence(char op1, char op2) {
        if (op2 == '$')
            return false;
        else if (op1 == '$')
            return true;
        else if (op2 == '/' || op2 == '%' || op2 == '*')
            return false;
        else if (op1 == '/' || op1 == '%' || op1 == '*')
            return true;
        else if (op2 == '+' || op2 == '-')
            return false;
        else
            return true;
    }
    @Override
    public String toString() {
        return "infix=" + infix +", postfix=" + postfix ;
    }
}
