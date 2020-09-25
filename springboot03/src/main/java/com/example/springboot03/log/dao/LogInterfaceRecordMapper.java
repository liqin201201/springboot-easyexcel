package com.example.springboot03.log.dao;

import com.example.springboot03.log.model.LogInterfaceRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author liqin
 * @date 2020/9/25 14:43
 */
@Mapper
public interface LogInterfaceRecordMapper {

    /**
     * 添加日志
     * @param logInterfaceRecord
     * @return
     */
    @Insert("insert into log_interface_record  (log_id,url,params,user_id,method_name,create_time,update_time ) values (?,?,?,?,?,?,? )")
    int add(LogInterfaceRecord logInterfaceRecord);

    /**
     * 修改日志
     * @param logInterfaceRecord
     * @return
     */
    int update(LogInterfaceRecord logInterfaceRecord);

    /**
     * 删除日志
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 查询日志
     * @param id
     * @return
     */
    LogInterfaceRecord findById(int id);

    /**
     * 查询日志
     * @param param
     * @return
     */
    List<LogInterfaceRecord> findAllList(Map<String,Object> param);

}
