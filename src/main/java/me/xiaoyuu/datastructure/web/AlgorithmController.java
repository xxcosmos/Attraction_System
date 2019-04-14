package me.xiaoyuu.datastructure.web;

import me.xiaoyuu.datastructure.dto.PrimInfo;
import me.xiaoyuu.datastructure.dto.ShortestPathInfo;
import me.xiaoyuu.datastructure.service.AlgorithmService;
import me.xiaoyuu.datastructure.service.DataBaseService;
import me.xiaoyuu.datastructure.util.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/algorithm")
public class AlgorithmController {

    @Autowired
    AlgorithmService algorithmService;
    @Autowired
    DataBaseService dataBaseService;


    @RequestMapping(value = "/nav", method = RequestMethod.POST)
    public String getMethodsByAttractionId(@RequestParam(value = "attractionId") String id, HttpSession session) {

        Session.dataManageSessionRemove(session);
        if (dataBaseService.getAttractionInfoById(Integer.valueOf(id)).getAttraction() == null) {
            session.setAttribute("algorithm_error", "景点输入有误!");
        } else {
            List<String> stringList = algorithmService.getNavigationMethods(Integer.valueOf(id));
            session.setAttribute("methods", stringList);
        }

        return "redirect:/attraction_nav.jsp";
    }

    @RequestMapping(value = "/shortest_path", method = RequestMethod.POST)
    public String getShortestPath(HttpSession session, @RequestParam("beginID") Integer beginID, @RequestParam("endID") Integer endID) {
        Session.dataManageSessionRemove(session);
        if (dataBaseService.getAttractionInfoById(endID).getAttraction() == null || dataBaseService.getAttractionInfoById(beginID).getAttraction()== null) {
            session.setAttribute("error_msg", "输入的景点编号不存在");
        } else {
            ShortestPathInfo method = algorithmService.getShortestPath(beginID, endID);
            session.setAttribute("shortestPath", method);
        }
        return "redirect:/shortest_path.jsp";
    }
    @RequestMapping(value = "/prim",method = RequestMethod.GET)
    public String getPrim(HttpSession session){
        Session.dataManageSessionRemove(session);
        PrimInfo prim = algorithmService.prim();
        session.setAttribute("prim",prim);
        return "redirect:/prim.jsp";

    }
}
