/*
 * Copyright 2000-2014 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.vaadin.tests;

import io.github.bonigarcia.seljup.DriverCapabilities;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Example of how to use SeleniumJupiter together with TestBench 9+ features.
 *
 * @author Vaadin Ltd
 */
public abstract class AbstractSeleniumChromeTB9Test
        extends AbstractSeleniumTB9Test {

    @DriverCapabilities
    ChromeOptions options = new ChromeOptions();

    @BeforeEach
    public void setDriver(ChromeDriver driver) {
        super.setDriver(driver);
    }

}