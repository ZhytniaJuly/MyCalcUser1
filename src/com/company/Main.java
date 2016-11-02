package com.company;

import com.company.opFactory.OperationFactory;
import com.company.opFactory.myOpFactory.MyOpFactory;

public class Main {


    public static void main(String[] args) {

        while (true) {
            OperationFactory opFact = new MyOpFactory();
            MyCalculator calc = new MyCalculator(opFact);
            calc.exec();

        }


    }
}