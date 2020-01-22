/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.WeatherWeb.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author xfilt
 */
public class UrlBuilderTest {
    
    public UrlBuilderTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of makeURL method, of class UrlBuilder.
     */
    @Test
    public void testMakeURL() {
        System.out.println("makeURL");
        int reason = 0;
        String inputA = "";
        String inputB = "";
        UrlBuilder instance = new UrlBuilder();
        String expResult = "";
        String result = instance.makeURL(reason, inputA, inputB);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
