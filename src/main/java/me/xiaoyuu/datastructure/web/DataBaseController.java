package me.xiaoyuu.datastructure.web;

import me.xiaoyuu.datastructure.dto.AttractionInfo;
import me.xiaoyuu.datastructure.entity.Attraction;
import me.xiaoyuu.datastructure.entity.Graph;
import me.xiaoyuu.datastructure.entity.Road;
import me.xiaoyuu.datastructure.service.AlgorithmService;
import me.xiaoyuu.datastructure.service.DataBaseService;
import me.xiaoyuu.datastructure.util.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/database")
public class DataBaseController {
    @Autowired
    DataBaseService dataBaseService;
    @Autowired
    AlgorithmService algorithmService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String getAttractionInfoById(@RequestParam("attractionId") String id, HttpSession session) {
        AttractionInfo attractionInfo = dataBaseService.getAttractionInfoById(Integer.valueOf(id));
        Session.dataManageSessionRemove(session);
        if (attractionInfo.getAttraction() == null) {
            session.setAttribute("error", "无法查询到id为" + id + "的景点");
        } else {
            session.setAttribute("attractionInfo", attractionInfo);
            List<Attraction> list = new ArrayList<>();
            list.add(attractionInfo.getAttraction());
            session.setAttribute("attractionList", list);
        }
        return "redirect:/attraction_search.jsp";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getAllAttraction(HttpSession session) {
        Session.dataManageSessionRemove(session);
        List<Attraction> list = dataBaseService.getAllAttraction();
        session.setAttribute("attractionList", list);
        return "redirect:/attraction_search.jsp";
    }

    @RequestMapping(value = "/graph", method = RequestMethod.GET)
    public String getGraph(HttpSession session) {
        Session.dataManageSessionRemove(session);
        Graph graph = algorithmService.getGraph();
        session.setAttribute("graph", graph);
        return "redirect:/attraction_search.jsp";
    }

    @RequestMapping(value = "/attraction/add", method = RequestMethod.POST)
    public String addAttraction(HttpSession session, Integer id, String name, String introduction) {
        Session.dataManageSessionRemove(session);
        Attraction attraction = new Attraction(id, name, introduction);
        if (dataBaseService.addAttraction(attraction) == 0) {
            session.setAttribute("attraction_add_msg", "插入失败，id已存在！");
        } else {
            session.setAttribute("attraction_add_msg", "插入成功");
        }
        return "redirect:/data_manage.jsp";
    }

    @RequestMapping(value = "/attraction/delete", method = RequestMethod.POST)
    public String deleteAttraction(HttpSession session, Integer deleteId) {
        Session.dataManageSessionRemove(session);
        if (dataBaseService.deleteAttraction(deleteId) == 0) {
            session.setAttribute("attraction_delete_msg", "删除成功！");
        } else {
            session.setAttribute("attraction_delete_msg", "删除失败，景点不存在！");
        }
        return "redirect:/data_manage.jsp";
    }

    @RequestMapping(value = "/attraction/update", method = RequestMethod.POST)
    public String updateAttraction(HttpServletRequest request, HttpSession session, Integer updateId, String updateName, String updateIntroduction) throws UnsupportedEncodingException {
        Session.dataManageSessionRemove(session);
        Attraction attraction = new Attraction(updateId, updateName, updateIntroduction);
        System.out.println(attraction);
        if (dataBaseService.updateAttraction(attraction) == 0) {
            session.setAttribute("attraction_update_msg", "修改成功！");
        } else {
            session.setAttribute("attraction_update_msg", "修改失败，景点不存在！");
        }
        return "redirect:/data_manage.jsp";
    }

    @RequestMapping(value = "/road/add", method = RequestMethod.POST)
    public String addRoad(HttpSession session, Integer addFirstId, Integer addSecondId, Integer addDistance) {
        Session.dataManageSessionRemove(session);
        Road road = new Road(addFirstId, addSecondId, addDistance);
        int result = dataBaseService.addRoad(road);
        if (result == 0) {
            session.setAttribute("road_add_msg", "新增道路成功！");
        } else if (result == -2) {
            session.setAttribute("road_add_msg", "新增道路失败，景点不存在！");
        } else if (result == -1) {
            session.setAttribute("road_add_msg", "新增道路失败，道路已存在！");

        } else {
            session.setAttribute("road_add_msg", "新增道路失败，输入有误！");

        }
        return "redirect:/data_manage.jsp";
    }


    @RequestMapping(value = "/road/delete", method = RequestMethod.POST)
    public String deleteRoad(HttpSession session, Integer deleteFirstId, Integer deleteSecondId) {
        Session.dataManageSessionRemove(session);
        if (dataBaseService.deleteRoad(deleteFirstId, deleteSecondId) == 0) {
            session.setAttribute("road_delete_msg", "删除道路成功！");
        } else {
            session.setAttribute("road_delete_msg", "删除道路失败，输入有误！");
        }
        return "redirect:/data_manage.jsp";
    }

    @RequestMapping(value = "/road/update", method = RequestMethod.POST)
    public String updateRoad(HttpSession session, Integer updateFirstId, Integer updateSecondId, Integer updateDistance) {
        Session.dataManageSessionRemove(session);
        Road road = new Road(updateFirstId, updateSecondId, updateDistance);
        if (dataBaseService.updateRoad(road) == 0) {
            session.setAttribute("road_update_msg", "修改道路成功！");
        } else {
            session.setAttribute("road_update_msg", "修改道路失败，景点不存在！");
        }
        return "redirect:/data_manage.jsp";
    }


}
