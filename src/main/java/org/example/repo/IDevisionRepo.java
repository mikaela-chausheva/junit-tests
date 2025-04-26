package org.example.repo;

import model.Calculator;

public interface IDevisionRepo {
//    double devisionResult(double x, double y);
    double divisionResult(Calculator calculator);
    boolean checkIfXIsZero(double x);
    boolean checkIfYIsZero(double y);
}

