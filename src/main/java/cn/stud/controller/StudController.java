package cn.stud.controller;

import cn.stud.common.Result;
import cn.stud.common.ResultGenerator;
import cn.stud.entity.PageBean;
import cn.stud.entity.Stud;
import cn.stud.service.StudService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import util.ResponseUtil;
import util.StringUtil;
import org.apache.log4j.Logger;

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

    List<Stud>  studList = studService.finduser(map);
    long total = studService.getTotalUser(map);
    JSONObject result = new JSONObject();
    JSONArray jsonArray = JSONArray.fromObject(studList);
    result.put("rows",jsonArray);
    result.put("total",total);
    ResponseUtil.write(response,result);


    return null;
}
@RequestMapping(value="/{ids}",method = RequestMethod.DELETE)
@ResponseBody
public Result Delete(@PathVariable(value ="ids") String ids)
{
    if(ids.length()>20){
        return ResultGenerator.genFailResult("ERROR");
    }
    String[] idsstr = ids.split(",");
    System.out.println(idsstr);
    for (int i = 0; i < idsstr.length; i++) {
        studService.deleteUser(idsstr[i]);
    }
   return ResultGenerator.genSuccessResult();

}
@RequestMapping(value="",method =RequestMethod.POST)
@ResponseBody
public Result Add(@RequestBody Stud stud){
     int resultTotal = 0;
     resultTotal = studService.addUser(stud);

    if (resultTotal > 0) {
        return ResultGenerator.genSuccessResult();
    } else {
        return ResultGenerator.genFailResult("FAIL");
    }
}
    @RequestMapping(value="",method =RequestMethod.PUT)
    @ResponseBody
    public Result update(@RequestBody Stud stud){
        int resultTotal = studService.update(stud);

        if (resultTotal > 0) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("FAIL");
        }
    }
}
