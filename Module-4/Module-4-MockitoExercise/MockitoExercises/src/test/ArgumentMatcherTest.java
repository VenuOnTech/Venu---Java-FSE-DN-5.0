package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ArgumentMatcherTest {

    @Test
    void testArgumentMatcher() {

        ExternalApi mockApi = mock(ExternalApi.class);

        MyService service = new MyService(mockApi);

        service.send("Hello Mockito");

        verify(mockApi).sendData(anyString());
    }
}