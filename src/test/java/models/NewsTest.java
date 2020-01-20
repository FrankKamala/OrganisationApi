package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NewsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getContent() {
        News testNews = setupNews();
        assertEquals("Employees party Tomorrow", testNews.getContent());
    }

    @Test
    public void setContent() {
        News testNews = setupNews();
        testNews.setContent("Wifi Down Tomorrow");
        assertNotEquals("Network available", testNews.getContent());
    }

    @Test
    public void getDepartmentId() {
        News testNews = setupNews();
        assertEquals(1, testNews.getDepartmentId());
    }

    @Test
    public void setDepartmentId() {
        News testNews = setupNews();
        testNews.setDepartmentId(10);
        assertNotEquals(1, testNews.getDepartmentId());
    }

    @Test
    public void setId() {
        News testNews = setupNews();
        testNews.setId(5);
        assertEquals(5, testNews.getId());
    }

    // helper
    public News setupNews (){
        return new News("Employees party Tomorrow", 1);
    }

}