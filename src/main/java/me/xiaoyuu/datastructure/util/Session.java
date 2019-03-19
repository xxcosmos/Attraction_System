package me.xiaoyuu.datastructure.util;

import javax.servlet.http.HttpSession;

public class Session {
    public static void dataManageSessionRemove(HttpSession session ){
        session.removeAttribute("attraction_add_msg");
        session.removeAttribute("attraction_delete_msg");
        session.removeAttribute("attraction_update_msg");
        session.removeAttribute("road_add_msg");
        session.removeAttribute("road_delete_msg");
        session.removeAttribute("road_update_msg");
        session.removeAttribute("attractionInfo");
        session.removeAttribute("error");
        session.removeAttribute("graph");
        session.removeAttribute("attractionList");
        session.removeAttribute("result");
        session.removeAttribute("error_msg");
        session.removeAttribute("shortestPath");
        session.removeAttribute("prim");
        session.removeAttribute("methods");
        session.removeAttribute("algorithm_error");

    }
}
