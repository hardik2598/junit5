package com.junit5.demo.extensionModelDemo;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

public class CustomExecutionCondition implements ExecutionCondition {
    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext extensionContext) {
        System.out.println("Inside evalutionExecutionCondition");
        return ConditionEvaluationResult.enabled("Test enabled for every Test Case");
    }
}
