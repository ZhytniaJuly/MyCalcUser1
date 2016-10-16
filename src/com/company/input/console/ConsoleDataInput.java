package com.company.input.console;

import java.util.Scanner;
import com.company.input.DataInput;



public class ConsoleDataInput implements DataInput{
    @Override
    public Double getDouble() {
        String inputLine;
        Scanner cs = new Scanner(System.in);
        inputLine = cs.nextLine();
        return Double.parseDouble(inputLine);
    }

    @Override
    public String getString() {
        Scanner cs = new Scanner(System.in);
        return cs.nextLine();
    }
}
