package com.example;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class VoidExceptionTest {

    @Test
    void testVoidException() {

        ExternalApi mockApi = mock(ExternalApi.class);

        doThrow(new RuntimeException("Delete Failed"))
                .when(mockApi)
                .deleteData();

        MyService service = new MyService(mockApi);

        assertThrows(RuntimeException.class, () -> {
            service.remove();
        });

        verify(mockApi).deleteData();
    }
}