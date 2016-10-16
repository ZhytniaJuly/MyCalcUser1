package com.company.opFactory;

import com.company.math.OperationNotFoundException;
import com.company.operations.Operation;


public interface OperationFactory {
    Operation getOpInstance(String op) throws OperationNotFoundException;
}
