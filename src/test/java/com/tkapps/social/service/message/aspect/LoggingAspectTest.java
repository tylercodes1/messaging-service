package com.tkapps.social.service.message.aspect;

import com.tkapps.social.service.message.controller.HelloController;
import com.tkapps.social.service.message.controller.MessageController;
import com.tkapps.social.service.message.service.MessageService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

// TODO finish loggin aspect unit tests
@ExtendWith(MockitoExtension.class)
public class LoggingAspectTest {
    @Mock
    private MessageService messageService;

    @InjectMocks
    private static MessageController messageController;

    private static LoggingAspect loggingAspect;

    @InjectMocks
    private static HelloController helloController;

    @Test
    void testSpringBeanPointcut() {
        // There has got to be a better way to add @BeforeEach or @BeforeAll
        loggingAspect = new LoggingAspect();
        AspectJProxyFactory factory = new AspectJProxyFactory(messageController);
        factory.addAspect(loggingAspect);

        MessageController proxyMc = factory.getProxy();
        when(proxyMc.findAll()).thenReturn(null);
        assertNull(proxyMc.findAll());
    }

    // TODO study this later
//    @Test
//    void testException() throws TestControllerException {
//        loggingAspect = new LoggingAspect();
//        AspectJProxyFactory factory = new AspectJProxyFactory(messageController);
//        factory.addAspect(loggingAspect);
//
//        MessageController proxyMc = factory.getProxy();
//        when(proxyMc.findAll()).thenThrow(Exception.class);
//        assertThrows(Exception.class, () -> {
//            proxyMc.findAll();
//        });
//    }
}
