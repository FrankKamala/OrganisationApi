package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getNameReturnsCorrectName() throws Exception {
        Department testDepartment = setupDepartment();
        assertEquals("Software", testDepartment.getName());
    }
    @Test
    public void getDescriptionReturnsCorrectDescription() throws Exception {
        Department testDepartment = setupDepartment();
        assertEquals("build and maintain", testDepartment.getDescription());
    }

    @Test
    public void getEmployeesReturnsNoOfEmployee() throws Exception {
        Department testRestaurant = setupDepartment();
        assertEquals(2, testRestaurant.getNoOfEmployees());
    }



    // my helper
    public Department setupDepartment(){
        return new Department("Software","build and maintain",2);
    }


}


