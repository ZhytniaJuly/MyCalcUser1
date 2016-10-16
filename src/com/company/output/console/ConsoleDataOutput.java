package com.company.output.console;

import com.company.output.DataOutput;


public class ConsoleDataOutput implements DataOutput {
    @Override
    public void Output(String outLine) {
        System.out.println(outLine);
    }
}
