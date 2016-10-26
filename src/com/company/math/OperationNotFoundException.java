package com.company.math;


public class OperationNotFoundException extends Exception{
    public OperationNotFoundException(String op) {
        super(op);
    }
}
