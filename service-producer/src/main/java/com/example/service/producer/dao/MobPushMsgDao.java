package com.example.service.producer.dao;


import com.example.service.exception.ServiceException;
import com.example.service.param.MobPushMsgQueryParams;
import com.example.service.vo.MobPushMsgVo;
import com.sina.dina.common.dao.JdbcDao;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guiqiang on 2016/7/27.
 */
@Repository
public class MobPushMsgDao extends JdbcDao {
    /**
     * Count代码前缀
     */
    private static final String COUNT_SQL_PRE = "select count(1) as count from (";

    /**
     * Count代码后缀
     */
    private static final String COUNT_SQL_ESUF = ") as _count";

    /**
     * SQL前缀
     */
    private static final String SQL_PRE = "SELECT "
            + "stat_date, push_id, push_name, ssp_name, industry_type, "
            + "sum(impress_num) as impress_num, "
            + "sum(click_num) as click_num, "
            + "sum(fuyi_cost) as fuyi_cost ";

    /**
     * 获取满足查询条件的总记录数
     *
     * @param params 查询条件
     * @return
     */
    public long count(MobPushMsgQueryParams params) {
        SqlAndParams sqlAndParams = build(params, false);
        Map<String, Object> results = jdbc.queryForMap(COUNT_SQL_PRE +
                sqlAndParams.getSql() + COUNT_SQL_ESUF,
                sqlAndParams.getParams());
        if (results != null) {
            Object object = results.get("count");
            if (object != null) {
                return (Long) object;
            }
        }
        return 0L;
    }

    /**
     * 获取满足查询条件的数据总和
     *
     * @param params 查询条件
     * @return
     */
    public MobPushMsgVo sum(MobPushMsgQueryParams params) {
        SqlAndParams sqlAndParams = build(params,true);
        return get(sqlAndParams.getSql(),sqlAndParams.getParams(),MobPushMsgVo.class);
    }

    /**
     * 获取满足查询条件的详细数据
     *
     * @param params 查询条件
     * @return
     * @throws ServiceException
     */
    public List<MobPushMsgVo> list(MobPushMsgQueryParams params,int start,int limit) {
        SqlAndParams sqlAndParams = build(params,false);
        Map<String,Object> paramsMap = sqlAndParams.getParams();
        String sql = sqlAndParams.getSql();
        sql += " limit :start,:limit";
        paramsMap.put("start",start);
        paramsMap.put("limit",limit);
        return list(sql,paramsMap,MobPushMsgVo.class);
    }


    private SqlAndParams build(MobPushMsgQueryParams params, boolean isSum) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Map<String, Object> paramsMap = new HashMap<>();
        StringBuilder sql = new StringBuilder(SQL_PRE);

        sql.append(" FROM mob_push_msg_stat WHERE stat_date BETWEEN :startDate AND :endDate ");
        paramsMap.put("startDate", Integer.parseInt(sdf.format(params.getStartDate())));
        paramsMap.put("endDate", Integer.parseInt(sdf.format(params.getEndDate())));

        if (params.getPushId() != null && params.getPushId() > 0) {
            sql.append(" and push_id = :push_id");
            paramsMap.put("push_id", params.getPushId());
        }
        if (params.getPushName() != null && !"".equals(params.getPushName().trim())) {
            sql.append(" and push_name LIKE :push_name ");
            paramsMap.put("push_name", "%" + params.getPushName().trim() + "%");
        }
        if (params.getSspName() != null && !"".equals(params.getSspName().trim())) {
            sql.append(" and ssp_name LIKE :ssp_name ");
            paramsMap.put("ssp_name", "%" + params.getSspName().trim() + "%");
        }
        if (!isSum) {
            sql.append(" GROUP BY stat_date,push_id,ssp_id ");
            sql.append(" ORDER BY stat_date desc,push_id desc,ssp_id asc");
        }
        System.out.println(sql.toString() + " :--" + paramsMap.get("ssp_name"));
        return new SqlAndParams(sql.toString(), paramsMap);
    }
}
