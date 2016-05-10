package com.service.impl;


import com.dao.BugDAO;
import com.dto.BugDto;
import com.mapper.BugMapper;
import com.service.BugService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


@Service
@Transactional
public class BugServiceImpl implements BugService {
    private static final Logger log = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private BugMapper bugMapper;
    @Autowired
    private BugDAO bugDAO;

    @Override
    public BugDto getBug(int id) {
        return bugMapper.bugToBugDTO(bugDAO.getBug(id));
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<BugDto> getAllBugs() {
        return bugMapper.bugsToBugDtos(bugDAO.getAllBugs());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void addBug(BugDto bugDto) {
        bugDAO.addBug(bugMapper.bugDtoToBug(bugDto));
        log.debug("save bug with title:=" + bugDto.getTitle() + ", and status:=" + bugDto.getStatus() + ", and priority:=" + bugDto.getPrior() + ", and description:=" + bugDto.getDesc() + ", and autor:=" + bugDto.getAutor() + ",and date:=" + bugDto.getDate());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void editBug(BugDto bugDto) {
        bugDAO.editBug(bugMapper.bugDtoToBug(bugDto));
        log.debug("bug is edited with title:=" + bugDto.getTitle() + ", and status:=" + bugDto.getStatus() + ", and priority:=" + bugDto.getPrior() + ", and description:=" + bugDto.getDesc() + ", and autor:=" + bugDto.getAutor() + ",and date:=" + bugDto.getDate() + ", and idBug:=" + bugDto.getIdBug());

    }
}
