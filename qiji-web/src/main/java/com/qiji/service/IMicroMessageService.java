package com.qiji.service;

import com.qiji.domain.MicroMessage;

import java.util.List;

public interface IMicroMessageService {
    List<MicroMessage> selectList(MicroMessage param);
}
