package com.company.input.console;

import java.util.Scanner;
import com.company.input.DataInput;



public class ConsoleDataInput implements DataInput{
    @Override
    public Integer getInteger() {
        String inputLine;
        Scanner cs = new Scanner(System.in);
        inputLine = cs.nextLine();
        return Integer.parseInt(inputLine);
    }

    @Override
    public String getString() {
        Scanner cs = new Scanner(System.in);
        return cs.nextLine();
    }
}
