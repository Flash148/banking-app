package com.bank;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class AppTest {
    @Test 
    void junitWorks() {
        assertEquals(2, 1 + 1);
    }

    @Test 
    void mockitoWorks() {
        List<String> mockedList = mock(List.class);
        when(mockedList.get(0)).thenReturn("Hello");

        assertEquals("Hello", mockedList.get(0));
    }
    
}
