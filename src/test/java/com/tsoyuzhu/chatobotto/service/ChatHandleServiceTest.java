package com.tsoyuzhu.chatobotto.service;

import com.tsoyuzhu.chatobotto.domain.ChatHandle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ChatHandleServiceTest {

    @Mock
    private SessionManager sessionManager;

    @InjectMocks
    private ChatHandleService chatHandleService;

    @Test
    public void chatHandleServiceInitOK() {
        // Check handle list is populated correctly
        assertTrue(chatHandleService.getHandles().size() > 0);
    }

    @Test
    public void getRandomHandle() {
        // Eliminate randomness by assuming all handles are in use except for one.
        List<ChatHandle> allHandles = chatHandleService.getHandles();
        List<ChatHandle> handlesInUse = new ArrayList<>(allHandles);

        ChatHandle notInUse = handlesInUse.remove(0);
        when(sessionManager.getHandlesInUse()).thenReturn(handlesInUse);
        ChatHandle randomHandle = chatHandleService.getRandomHandle();
        assertEquals(notInUse, randomHandle);
    }

}