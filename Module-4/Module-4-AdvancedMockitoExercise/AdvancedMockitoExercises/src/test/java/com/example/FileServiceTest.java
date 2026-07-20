package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FileServiceTest {

    @Test
    void testServiceWithMockFileIO() {

        MyFileReader mockReader = mock(MyFileReader.class);

        MyFileWriter mockWriter = mock(MyFileWriter.class);

        when(mockReader.read()).thenReturn("Mock File Content");

        FileService fileService = new FileService(mockReader, mockWriter);

        String result = fileService.processFile();

        assertEquals("Processed Mock File Content", result);

        verify(mockWriter).write("Mock File Content");
    }
}