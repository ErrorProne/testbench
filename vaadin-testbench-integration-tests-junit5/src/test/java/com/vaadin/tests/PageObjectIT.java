package com.vaadin.tests;

import java.util.List;

import org.junit.jupiter.api.Assertions;

import com.vaadin.flow.component.Component;
import com.vaadin.testUI.PageObjectView;
import com.vaadin.testbench.BrowserTest;

public class PageObjectIT extends AbstractBrowserTB9Test {

    @Override
    protected Class<? extends Component> getTestView() {
        return PageObjectView.class;
    }

    @BrowserTest
    public void findUsingValueAnnotation() {
        openTestURL();
        List<MyComponentWithIdElement> components = $(
                MyComponentWithIdElement.class).all();

        Assertions.assertEquals(1, components.size());
        Assertions.assertEquals("MyComponentWithId",
                components.get(0).getText());
    }

    @BrowserTest
    public void findUsingContainsAnnotation() {
        openTestURL();
        List<MyComponentWithClassesElement> components = $(
                MyComponentWithClassesElement.class).all();

        Assertions.assertEquals(1, components.size());
        Assertions.assertEquals("MyComponentWithClasses",
                components.get(0).getText());
    }

}