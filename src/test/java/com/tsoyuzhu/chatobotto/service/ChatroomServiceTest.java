package com.tsoyuzhu.chatobotto.service;

import com.tsoyuzhu.chatobotto.domain.ChatHandle;
import com.tsoyuzhu.chatobotto.domain.ConnectionRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ChatroomServiceTest {

    @Mock
    private SessionManager sessionManager;

    @Mock
    private ChatHandleService chatHandleService;

    @InjectMocks
    private ChatroomService chatroomService;

    @Test
    public void getHandleReturnsConnectionRequestOK() {
        ChatHandle dummyHandle = new ChatHandle("XXawesomeHandle82XX");
        when(chatHandleService.getRandomHandle()).thenReturn(dummyHandle);
        ConnectionRequest request = chatroomService.getHandle("someSessionId");
        assertTrue(request.isConnectionSuccessful());
        assertEquals(dummyHandle, request.getChatHandle());
    }

    @Test
    public void getHandleReturnsConnectionRequestKO() throws Exception {
        String sessionId = "someSessionId";
        ChatHandle dummyHandle = new ChatHandle("XXawesomeHandle82XX");
        when(chatHandleService.getRandomHandle()).thenReturn(dummyHandle);
        doThrow(new Exception("Cannot connect. Chat room is at maximum capacity."))
                .when(sessionManager).registerSession(any(),any());
        ConnectionRequest request = chatroomService.getHandle(sessionId);
        assertFalse(request.isConnectionSuccessful());
        assertNull(request.getChatHandle());
    }
}