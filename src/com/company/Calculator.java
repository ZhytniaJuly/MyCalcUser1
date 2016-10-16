package com.company;

import com.company.input.DataInput;
import com.company.input.console.ConsoleDataInput;
import com.company.opFactory.OperationFactory;
import com.company.output.DataOutput;
import com.company.output.console.ConsoleDataOutput;
import com.company.operations.Operation;
import com.company.math.OperationNotFoundException;


public class Calculator {
    private OperationFactory operFact;
    private DataInput dataInput = new ConsoleDataInput();
    private DataOutput dataOutput = new ConsoleDataOutput();

    Calculator(OperationFactory opFact) {
        operFact = opFact;
    }

    void exec() {
        while (true) {
            double a, b;
            String op;
            System.out.print("Введите первый аргумент: ");
            try {
                a = dataInput.getDouble();
            } catch (NumberFormatException e) {
                if (e.getMessage().equalsIgnoreCase("Empty string")) {
                    System.out.println("Выход !!!");
                    break;
                } else {
                    System.out.println("Аргумент задан неверно !!!");
                    continue;
                }
            }
            System.out.print("Введите операцию(+,-,*,/): ");
            op = dataInput.getString();
            Operation operation;
            try {
                operation = operFact.getOpInstance(op);
            } catch (OperationNotFoundException e) {
                System.out.println(e.getMessage());
                continue;
            }
            System.out.print("Введите второй аргумент: ");
            try {
                b = dataInput.getDouble();
            } catch (NumberFormatException e) {
                System.out.println("Аргумент задан неверно !!!");
                continue;
            }
            dataOutput.Output(a + op + b + "=" + operation.doOperation(a, b));

        }

    }
}
