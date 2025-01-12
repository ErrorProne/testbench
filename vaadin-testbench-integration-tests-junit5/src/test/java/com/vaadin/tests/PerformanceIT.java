/**
 * Copyright (C) 2000-2022 Vaadin Ltd
 *
 * This program is available under Vaadin Commercial License and Service Terms.
 *
 * See <https://vaadin.com/commercial-license-and-service-terms> for the full
 * license.
 */
package com.vaadin.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;

import com.vaadin.flow.component.Component;
import com.vaadin.testUI.PerformanceView;
import com.vaadin.testbench.BrowserTest;
import com.vaadin.tests.elements.NativeButtonElement;

public class PerformanceIT extends AbstractBrowserTB9Test {

    @Override
    protected Class<? extends Component> getTestView() {
        return PerformanceView.class;
    }

    @BrowserTest
    @Disabled("timeSpentServicingLastRequest test is unstable")
    public void serverTime() {
        openTestURL();
        $(NativeButtonElement.class).first().click();

        Assertions.assertEquals(1250.0,
                testBench().timeSpentServicingLastRequest(), 250.0);
        $(NativeButtonElement.class).first().click();
        Assertions.assertEquals(2500,
                testBench().totalTimeSpentServicingRequests(), 500.0);
    }

    @BrowserTest
    @Disabled("timeSpentServicingLastRequest does not work: https://github.com/vaadin/testbench/issues/1316")
    public void renderingTime() {
        openTestURL();
        long initialRendering = testBench().timeSpentRenderingLastRequest();
        // Assuming initial rendering is done in 1-299ms
        Assertions.assertEquals(150, initialRendering, 149);
        Assertions.assertEquals(initialRendering,
                testBench().totalTimeSpentRendering());
        $(NativeButtonElement.class).first().click();
        $(NativeButtonElement.class).first().click();
        $(NativeButtonElement.class).first().click();

        // Assuming rendering three poll responses is done in 50ms
        Assertions.assertTrue(
                testBench().totalTimeSpentRendering() > initialRendering,
                "totalTimeSpentRendering() > initialRendering");
        Assertions.assertEquals(initialRendering,
                testBench().totalTimeSpentRendering(), 50);
    }

}
