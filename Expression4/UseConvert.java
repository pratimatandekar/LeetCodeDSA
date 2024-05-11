package dsa.Expression4;

import java.util.Scanner;

public class UseConvert {
    public static void main(String[] args) {
        Scanner kb=new Scanner(System.in);
        System.out.println("Enter the vailid infix exp:");
        String infix=kb.next();
        Convert conv=new Convert(infix);
        conv.toPostfix();
        System.out.println(conv);
    }
}
