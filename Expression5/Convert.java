package dsa.Expression5;
import java.util.Stack;
public class Convert {
    private String infix, prefix;

    public Convert(String infix) {
        this.infix = infix;
        prefix= "";
    }

    public void toPrefix() {
        Stack<Character> st = new Stack<>();
        for (int i = infix.length()-1; i >=0; i--) {
            char ch = infix.charAt(i);
            if (isOperator(ch) == true) {
                prefix = prefix + ch;
            } else {
                while (st.empty() == false) {
                   if (precedence(ch)>=precedence(st.peek()))
                        break;
                    prefix = prefix + st.pop();
                }
                st.push(ch);
            }
        }
        while ((st.empty() == false)) {
            prefix = prefix + st.pop();
        }
        StringBuilder sb=new StringBuilder(prefix);
        sb.reverse();
        prefix=sb.toString();
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
        return "infix=" + infix +", prefix=" + prefix ;
    }
}
