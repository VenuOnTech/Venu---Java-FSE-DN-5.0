package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class InteractionOrderTest {

    @Test
    void testInteractionOrder() {

        ExternalApi mockApi = mock(ExternalApi.class);

        NotificationService service = new NotificationService(mockApi);

        service.process();

        InOrder order = inOrder(mockApi);

        order.verify(mockApi).sendData("Start");
        order.verify(mockApi).getData();
        order.verify(mockApi).deleteData();
    }
}