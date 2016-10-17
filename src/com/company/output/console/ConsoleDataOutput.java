package com.company.output.console;

import com.company.output.DataOutput;


public class ConsoleDataOutput implements DataOutput {
    @Override
    public void outputRez(Integer outLine, Integer sc) {

        switch (sc) {
            case 2:
                System.out.println(Integer.toBinaryString(outLine));
                return;
            case 10:
                System.out.println(Integer.toString(outLine));
                return;
            case 16:
                System.out.println(Integer.toHexString(outLine));
                return;

            default:
                //return null;

        }
    }

    @Override
    public void outputArgs(String args) {
        System.out.print(args);
    }
}

