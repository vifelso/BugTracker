package com.service.impl;


import com.dao.BugDAO;
import com.dto.BugDto;
import com.mapper.BugMapper;
import com.service.BugService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * Created by Andrei on 07.05.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class BugServiceImplTest {

    @Mock
    BugDAO bugDAO;
    @Mock
    BugMapper bugMapper;
    @InjectMocks
    BugService bugService = new BugServiceImpl();
    @Spy
    BugDto bugDto = new BugDto();
    @Spy
    Set<BugDto> bugDtos = new HashSet<>();

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bugDto = getBugDto();
        bugDtos = getBugDtos();
        bugMapper.bugToBugDTO(bugDAO.getBug(anyInt()));
        bugMapper.bugsToBugDtos(bugDAO.getAllBugs());
    }

    @Test
    public void testGetBug() throws Exception {
        when(bugMapper.bugToBugDTO(bugDAO.getBug(anyInt()))).thenReturn(bugDto);
        assertEquals(bugDto, bugService.getBug(bugDto.getIdBug()));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void testGetAllBugs() throws Exception {
        when(bugMapper.bugsToBugDtos(bugDAO.getAllBugs())).thenReturn(bugDtos);
        assertEquals(false, bugService.getAllBugs().isEmpty());
    }


    public Set<BugDto> getBugDtos() {
        Set<BugDto> bugDtos1 = new HashSet<>();
        bugDtos1.add(getBugDto());
        bugDtos1.add(getBugDto());
        return bugDtos1;
    }

    public BugDto getBugDto() {
        BugDto bugDto1 = new BugDto();
        bugDto1.setTitle("first");
        bugDto1.setAutor("andrei");
        bugDto1.setDate(new Date());
        bugDto1.setDesc("andrei's bug");
        bugDto1.setPrior("Open");
        bugDto1.setStatus("Important");
        return bugDto1;
    }
}