package com.interview.truist.interview_truist.java8;

@FunctionalInterface
public interface MathOperation
{
//	Predicate<T>: Tests a condition.
//	Function<T, R>: Transforms an input into a result.
//	Consumer<T>: Performs an action on an input.
//	Supplier<T>: Supplies a value without input.
	
	int operate(int a, int b);
}
