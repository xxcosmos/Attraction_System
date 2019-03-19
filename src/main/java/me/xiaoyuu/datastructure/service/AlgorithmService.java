package me.xiaoyuu.datastructure.service;

import me.xiaoyuu.datastructure.dto.ShortestPathInfo;
import me.xiaoyuu.datastructure.dto.PrimInfo;
import me.xiaoyuu.datastructure.entity.Graph;

import java.util.List;

public interface AlgorithmService {


    List<String> getNavigationMethods(Integer id);

    ShortestPathInfo getShortestPath(int begin, int end);
    Graph getGraph();
    PrimInfo prim();
}
