package cn.stud.service;

import cn.stud.entity.Stud;

import java.util.List;
import java.util.Map;

/**
 * Created by Mr.K on 2018/6/9.
 */
public interface StudService {

    Stud  getStudById(String id);
    List<Stud> finduser(Map<String,Object> map);
    long getTotalUser(Map<String,Object> map);
    int deleteUser(String id);
    int addUser(Stud stud);
    int update (Stud stud);
}
