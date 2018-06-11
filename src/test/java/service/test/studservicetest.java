package service.test;

import cn.stud.entity.Stud;
import cn.stud.service.StudService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Mr.K on 2018/6/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class studservicetest {

    @Resource
    private StudService studService;

    Stud stud;

    @Test
    public void test(){
       stud= studService.getStudById("s001");
        System.out.println(stud.getName());
    }

}
