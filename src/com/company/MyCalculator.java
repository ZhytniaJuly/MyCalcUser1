package com.company;

import com.company.countSystem.CountSystem;
import com.company.input.DataInput;
import com.company.input.console.ConsoleDataInput;
import com.company.opFactory.OperationFactory;
import com.company.output.DataOutput;
import com.company.output.console.ConsoleDataOutput;
import com.company.operations.Operation;
import com.company.math.OperationNotFoundException;


import java.util.*;


public class MyCalculator {
    private OperationFactory operFact;
    private DataInput dataInput = new ConsoleDataInput();
    private DataOutput dataOutput = new ConsoleDataOutput();
    private String argument1, argument2, nameOperator, menuOption;
    private Operation operation;
    private CountSystem countSystem;
    private Integer result;
    private Map<String, List<Integer>> newMap = new HashMap<>();


    MyCalculator(OperationFactory opFact) {
        operFact = opFact;
    }

    void exec() {
        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Cоздать/сменить пользователя");
            System.out.println("2. Продолжить работу с текущим пользователем");
            System.out.println("3. Отменить последнее действие");
            System.out.println("4. Распечатать результаты текущего пользователя");
            System.out.println("5. Распечатать все результаты пользователей");
            System.out.println("6. Выход");
            System.out.print("Сделайте выбор ");
            menuOption = dataInput.getString();
            switch (menuOption) {
                case "1":
                    operatorInputConsole();
                    dataInputConsole();
                    makeOperation();
                    dataOutputConsoleResultOfOperation();
                    //dataOutputConsoleResultOfOperation();
                    continue;
                case "2":
                    dataInputConsole();
                    makeOperation();
                    //dataOutputConsoleResultOfOperation();
                    continue;
                case "3":
                    returnLastAction();
                    System.out.println("Состояние Map после отмены действия ");
                    dataOutputRezOfCurrentUser();
                    System.out.println("");
                    continue;
                case "4":
                    dataOutputRezOfCurrentUser();
                    continue;
                case "5":
                    dataOutputConsoleResultOfAllUsers();
                    continue;
                case "6":
                    System.exit(0);

            }
        }
    }

    private void returnLastAction() {
        List<Integer> resultsByOperator = newMap.get(nameOperator);
        resultsByOperator.remove(resultsByOperator.size()-1);
        System.out.println();
        System.out.println("Пoследний результат после удаления ");
        dataOutput.outputRez(resultsByOperator.get(resultsByOperator.size()-1), countSystem);
        System.out.println("");
    }


    public void operatorInputConsole() {
        System.out.printf("Введите оператора ");
        nameOperator = dataInput.getString();
        newMap.putIfAbsent(nameOperator, new ArrayList<>());
//        System.out.print("Введите систему счисления(2, 10, 16): ");
//        countSystem = CountSystem.getCountSystemByRange(dataInput.getInteger());

    }


    public void dataInputConsole() {
        System.out.print("Введите систему счисления(2, 10, 16): ");
        countSystem = CountSystem.getCountSystemByRange(dataInput.getInteger());

        System.out.print("Введите первый аргумент: ");
        argument1 = dataInput.getString();

        System.out.print("Введите операцию(+,-,*,/): ");
        String op;
        op = dataInput.getString();
        try {
            operation = operFact.getOpInstance(op);
        } catch (OperationNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.print("Введите второй аргумент: ");
        argument2 = dataInput.getString();

    }

    public void makeOperation() {
        result = operation.doOperation(Integer.parseInt(argument1, countSystem.getRang()), Integer.parseInt(argument2, countSystem.getRang()));
        newMap.get(nameOperator).add(result);
    }

    public void dataOutputConsoleResultOfOperation() {
        System.out.print("Results ");
        dataOutput.outputRez(result, countSystem);
    }

    public void dataOutputConsoleResultOfAllUsers() {
        for (Map.Entry<String, List<Integer>> entry : newMap.entrySet()) {
            System.out.print(entry.getKey() + " | ");
            List<Integer> value = entry.getValue();
            for (int i = 0; i < value.size(); i++) {
                int result = value.get(i);
                dataOutput.outputRez(result, countSystem);
            }
            System.out.println();
        }
    }

    public void dataOutputRezOfCurrentUser() {
        List<Integer> resultsByOperator = newMap.get(nameOperator);
        System.out.print(nameOperator + " | ");
        for (int i = 0; i < resultsByOperator.size(); i++) {
            Integer result = resultsByOperator.get(i);
            dataOutput.outputRez(result, countSystem);
        }
        System.out.println();
    }
}


