package com.mapper.impl;

import com.dto.BugDto;
import com.mapper.BugMapper;
import com.model.Bug;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BugMapperImpl implements BugMapper {

    @Autowired
    private MapperFacade mapper;

    @Override
    public BugDto bugToBugDTO(Bug bug) {
        return mapper.map(bug, BugDto.class);
    }

    @Override
    public Bug bugDtoToBug(BugDto bugDto) {
        return mapper.map(bugDto, Bug.class);
    }

    @Override
    public Set<BugDto> bugsToBugDtos(Set<Bug> bugs) {
        if (bugs == null) {
            return null;
        }

        return bugs.stream().map(this::bugToBugDTO).collect(Collectors.toSet());
    }

    @Override
    public Set<Bug> bugDtosToBugs(Set<BugDto> bugDtos) {
        if (bugDtos == null) {
            return null;
        }

        return bugDtos.stream().map(this::bugDtoToBug).collect(Collectors.toSet());

    }

}

