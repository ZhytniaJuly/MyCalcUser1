package com.company;

import com.company.countSystem.CountSystem;
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
            CountSystem countSystem;
            String a,b;
            String op;

            System.out.print("Введите систему счисления(2, 10, 16): ");
            countSystem = CountSystem.getCountSystemByRange(dataInput.getInteger());

            System.out.print("Введите первый аргумент: ");
            a = dataInput.getString();

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
                b = dataInput.getString();

            try {
                dataOutput.outputArgs(a + op + b + "=");
                dataOutput.outputRez(operation.doOperation(Integer.parseInt(a, countSystem.getRang()), Integer.parseInt(b, countSystem.getRang())),countSystem);
            }catch (NumberFormatException e) {
                System.out.println("Аргументы заданы неверно !!!");
                continue;
            }
        }

}
}
