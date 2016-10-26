package com.company.output.console;

import com.company.countSystem.CountSystem;
import com.company.output.DataOutput;


public class ConsoleDataOutput implements DataOutput {
    @Override
    public void outputRez(Integer outLine, CountSystem sc) {
        System.out.println(sc.printValue(outLine));
    }

    @Override
    public void outputArgs(String args) {
        System.out.print(args);
    }
}

