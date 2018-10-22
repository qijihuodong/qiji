package com.qiji.service.impl;

import com.qiji.dao.MicroMessageMapper;
import com.qiji.domain.MicroMessage;
import com.qiji.service.IMicroMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MicroMessageService implements IMicroMessageService {

    @Autowired
    MicroMessageMapper microMessageMapper;

    @Override
    public List<MicroMessage> selectList(MicroMessage param) {
        return microMessageMapper.selectList(param);
    }
}
