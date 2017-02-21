package com.example.service.api;



import com.example.service.exception.ServiceException;
import com.example.service.param.MobPushMsgQueryParams;
import com.example.service.vo.MobPushMsgVo;

import java.util.List;

/**
 *
 * Created by guiqiang on 2016/7/26.
 */
public interface IMobPushMsgService {
    /**
     * 获取满足查询条件的数据总条数
     * @param params
     * @return
     * @throws ServiceException
     */
    public long count(MobPushMsgQueryParams params) throws ServiceException;

    /**
     * 获取满足查询条件的汇总数据
     * @param params
     * @return
     * @throws ServiceException
     */
    public MobPushMsgVo sum(MobPushMsgQueryParams params) throws ServiceException;

    /**
     * 获取满足查询条件的详细数据
     * @param params
     * @param start
     *              开始位置
     * @param limit
     *              最大数据量
     * @return
     * @throws ServiceException
     */
    public List<MobPushMsgVo> list(MobPushMsgQueryParams params, final int start, final int limit) throws ServiceException;
}
