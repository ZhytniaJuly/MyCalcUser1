package com.company.output.console;

import com.company.countSystem.CountSystem;
import com.company.output.DataOutput;


public class ConsoleDataOutput implements DataOutput {
    @Override
    public void outputRez(Integer outLine, CountSystem sc) {
        System.out.print(sc.printValue(outLine)+" ");
    }


}

