package org.example.calculator.api;

public interface Calculator<INPUT_TYPE, RESULT_TYPE extends CalculationResult<?>> {

	RESULT_TYPE calculate(INPUT_TYPE input);
}
