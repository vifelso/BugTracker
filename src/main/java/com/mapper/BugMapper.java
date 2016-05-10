package com.mapper;

import com.dto.BugDto;
import com.model.Bug;

import java.util.Set;


public interface BugMapper {
    BugDto bugToBugDTO(Bug bug);

    Bug bugDtoToBug(BugDto bugDto);

    Set<BugDto> bugsToBugDtos(Set<Bug> bugs);

    Set<Bug> bugDtosToBugs(Set<BugDto> bugDtos);
}
