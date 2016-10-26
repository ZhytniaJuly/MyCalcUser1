package com.company;

import com.company.opFactory.OperationFactory;
import com.company.opFactory.myOpFactory.MyOpFactory;

public class MyCalc {

    public static void main(String[] args) {
        OperationFactory opFact = new MyOpFactory();
        Calculator calc = new Calculator(opFact);
        calc.exec();
    }
}
