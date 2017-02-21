package com.example.service.producer.api.impl;


import com.example.service.DinaMobileToolsConstant;
import com.example.service.api.IMobPushMsgService;
import com.example.service.exception.ParamsException;
import com.example.service.exception.ServiceException;
import com.example.service.param.MobPushMsgQueryParams;
import com.example.service.producer.dao.MobPushMsgDao;
import com.example.service.vo.MobPushMsgVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by guiqiang on 2016/7/27.
 */
@Service("mobPushMsgService")
public class MobPushMsgServiceImpl implements IMobPushMsgService {

    @Resource
    private MobPushMsgDao mobPushMsgDao;

    @Override
    public long count(MobPushMsgQueryParams params) throws ServiceException {
        valid(params);
        return mobPushMsgDao.count(params);
    }



    @Override
    public MobPushMsgVo sum(MobPushMsgQueryParams params) throws ServiceException {
        valid(params);
        return mobPushMsgDao.sum(params);
    }

    @Override
    public List<MobPushMsgVo> list(MobPushMsgQueryParams params, final int start, final int limit) throws ServiceException {
        valid(params);
        int l = limit;
        if (l < 0) {
            l = DinaMobileToolsConstant.DEFAULT_LIMIT;
        }
        int s = start;
        if (s < 0) {
            s = DinaMobileToolsConstant.DEFAULT_START;
        }
        return mobPushMsgDao.list(params,s,l);
    }
    private void valid(MobPushMsgQueryParams params) throws ParamsException {
        if (params == null || params.getStartDate() == null
                || params.getEndDate() == null) {
            throw new ParamsException(
                    "params must not be null or params.startDate and params.endDate both must not be null!");
        }
    }
}
