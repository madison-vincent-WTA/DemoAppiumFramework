package com.Framework.Listeners;

import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;

public class AssertionLogging extends SoftAssert {

    @Override
    public void onAssertSuccess(IAssert<?> assertCommand) {
        System.err.println("Assertion: " + assertCommand.getMessage() + " <PASSED> ");
    }

    @Override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError ex) {
        String suffix =
                String.format(
                        "Expected [%s] but found [%s]",
                        assertCommand.getExpected().toString(), assertCommand.getActual().toString());
        System.err.println("Assertion: " + assertCommand.getMessage() + " <FAILED>. " + suffix);
    }


}
