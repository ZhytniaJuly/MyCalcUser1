package com.company.operations.myOperations;

import com.company.operations.Operation;

public class OpPlus implements Operation {
    @Override
    public double doOperation(double a, double b) {
        return a + b;
    }
}
