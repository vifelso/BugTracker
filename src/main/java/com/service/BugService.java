package com.service;

import com.dto.BugDto;

import java.util.Set;


public interface BugService {
    BugDto getBug(int id);

    Set<BugDto> getAllBugs();

    void addBug(BugDto bugDto);

    void editBug(BugDto bugDto);
}
