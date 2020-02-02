package com.junit5.demo.extensionModelDemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@ExtendWith({CustomExecutionCondition.class, CustomLifeCycleMethods.class, CustomParameterResolver.class,
        CustomTestExecutionExceptionHandler.class, CustomTestInstancePostProcessor.class})
public class ExtensionModelCustomTests {

    public ExtensionModelCustomTests(Integer count){
        System.out.println("After Parameter Resolver:"+count);
    }
    @Test
    public void testScenarios(){
        assertTrue("Extending extension points related interfaces", true);
    }
}

//JUnit 5 extensions are related to a certain event in the execution of a test, referred to as an extension point.
// When a certain life cycle phase is reached, the JUnit engine calls registered extensions.
//
//Five main types of extension points can be used:
//
//        test instance post-processing -> TestInstancePostProcessor
//        conditional test execution -> ExecutionCondition
//        life-cycle callbacks -> BeforeAllCallback, AfterAllCallback, BeforeEachCallback, AfterEachCallback
//        parameter resolution -> ParameterResolver
//        exception handling -> TestExecutionExceptionHandler

