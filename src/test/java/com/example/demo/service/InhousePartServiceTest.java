package com.example.demo.service;

import com.example.demo.domain.InhousePart;
import com.example.demo.repositories.CardSinglesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Project: demo
 * Package: com.example.demo.service
 * <p>
 * User: carolyn.sher
 * Date: 5/3/2022
 * Time: 11:36 AM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
class InhousePartServiceTest {
    CardSinglesRepository cardSinglesRepository;
    InhousePartService inhousePartService;
    @BeforeEach
    void setUp() {
        cardSinglesRepository =mock(CardSinglesRepository.class);
        inhousePartService=new InhousePartServiceImpl(cardSinglesRepository);
    }

    @Test
    void findAll() {
        InhousePart part=new InhousePart();
        List partData=new ArrayList();
        partData.add(part);
        when(cardSinglesRepository.findAll()).thenReturn(partData);
        List<InhousePart> parts=inhousePartService.findAll();
        assertEquals(partData.size(),1);
    }
}