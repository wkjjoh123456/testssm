package cn.stud.service.Impl;

import cn.stud.dao.StudMapper;
import cn.stud.entity.Stud;
import org.springframework.stereotype.Service;
import cn.stud.service.StudService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by Mr.K on 2018/6/9.
 */
@Service
public class StudServiceImpl implements StudService {
    @Resource
    private StudMapper studMapper;
    @Override
    public Stud getStudById(String id) {
        return studMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Stud> finduser(Map<String, Object> map) {
        return studMapper.findUsers(map);
    }

    @Override
    public long getTotalUser(Map<String, Object> map) {
        return studMapper.getTotalUser(map);
    }

}
