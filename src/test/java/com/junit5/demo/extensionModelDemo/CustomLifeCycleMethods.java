package com.junit5.demo.extensionModelDemo;

import org.junit.jupiter.api.extension.*;

public class CustomLifeCycleMethods implements BeforeAllCallback, BeforeEachCallback, AfterAllCallback, AfterEachCallback {
    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        System.out.println("Inside afterAll");
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("Inside afterEach");
    }

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        System.out.println("Inside beforeAll");
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        System.out.println("Inside beforeEach");
    }
}
