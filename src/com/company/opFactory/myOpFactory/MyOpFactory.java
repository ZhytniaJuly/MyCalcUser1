package com.company.opFactory.myOpFactory;

import com.company.math.OperationNotFoundException;
import com.company.opFactory.OperationFactory;
import com.company.operations.Operation;
import com.company.operations.myOperations.OpDiv;
import com.company.operations.myOperations.OpMinus;
import com.company.operations.myOperations.OpMul;
import com.company.operations.myOperations.OpPlus;


public class MyOpFactory implements OperationFactory {
    @Override
    public Operation getOpInstance(String op) throws OperationNotFoundException {
        switch (op) {
            case "+":
                return new OpPlus();
            case "-":
                return new OpMinus();
            case "*":
                return new OpMul();
            case "/":
                return new OpDiv();
            default:
                //return null;
                throw new OperationNotFoundException("Код операции задан неверно !!!  " + op);
        }
    }
}
