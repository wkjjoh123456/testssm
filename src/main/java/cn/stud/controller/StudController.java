package cn.stud.controller;

import cn.stud.entity.PageBean;
import cn.stud.entity.Stud;
import cn.stud.service.StudService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.iterators.ObjectArrayIterator;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import util.ResponseUtil;
import util.StringUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Mr.K on 2018/6/9.
 */
@Controller
@RequestMapping("/stud")
public class StudController {
@Resource
    StudService studService;
    @RequestMapping("/{id}/show")
    public String show(@PathVariable String id, HttpServletRequest request){
        System.out.println(id);
        Stud s = studService.getStudById(id);
        request.setAttribute("stud",s);
        return  "show";
    }

    @RequestMapping("/show1")
    public String show1( HttpServletRequest request){
        System.out.println("123");
        Stud s = studService.getStudById("s001");
        request.setAttribute("stud",s);
        return  "show";
    }
@RequestMapping(value="/datagrid",method = RequestMethod.POST)
    public String list(@RequestParam(value = "page", required = false) String page, @RequestParam(value = "rows", required = false) String rows,Stud stud,HttpServletResponse response) throws Exception {
    PageBean  pageBean = new PageBean(Integer.parseInt(page),Integer.parseInt(rows));

    Map<String, Object> map = new HashMap<String, Object>();
    map.put("name", StringUtil.formatLike(stud.getName()));
    map.put("start", pageBean.getStart());
    map.put("size", pageBean.getPagesize());
    System.out.println("123123123123");
    List<Stud>  studList = studService.finduser(map);
    long total = studService.getTotalUser(map);
    JSONObject result = new JSONObject();
    JSONArray jsonArray = JSONArray.fromObject(studList);
    result.put("rows",jsonArray);
    result.put("total",total);
    ResponseUtil.write(response,result);


    return null;
}
}
