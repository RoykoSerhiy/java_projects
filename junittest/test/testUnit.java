/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import junittest.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Serhiy
 */
public class testUnit {
    
    public testUnit() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void testName(){
       User user = new User("vasya" , 25);
        assertEquals("vasya", user.getName());
    }
    @Test
    public void testName2(){
        User user = new User("" , 27);
        user.setName("Vasya");
        assertEquals("Vasya", user.getName());
    }
}
