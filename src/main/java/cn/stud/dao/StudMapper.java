package cn.stud.dao;

import cn.stud.entity.Stud;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface StudMapper {

    int deleteByPrimaryKey(String id);

    int insert(Stud record);

    int insertSelective(Stud record);

    Stud selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Stud record);

    int updateByPrimaryKey(Stud record);

    List<Stud> findUsers(Map<String, Object> map);

    Long getTotalUser(Map<String, Object> map);

}