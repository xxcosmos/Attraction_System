package me.xiaoyuu.datastructure.serviceImpl;

import me.xiaoyuu.datastructure.dao.AttractionDao;
import me.xiaoyuu.datastructure.dao.RoadDao;
import me.xiaoyuu.datastructure.dto.ShortestPathInfo;
import me.xiaoyuu.datastructure.dto.PrimInfo;
import me.xiaoyuu.datastructure.entity.Attraction;
import me.xiaoyuu.datastructure.entity.Graph;
import me.xiaoyuu.datastructure.entity.Road;
import me.xiaoyuu.datastructure.service.AlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlgorithmServiceImpl implements AlgorithmService {
    @Autowired
    AttractionDao attractionDao;
    @Autowired
    RoadDao roadDao;

    private List<List<Integer>> roads;


    /**
     * (3) 旅游景点导航
     * 输入：起始景点的编号。
     * 处理：使用深度优先搜索(DFS)算法，查询以该景点为起点，无回路游览整个景区的路线。
     * 输出：所有符合要求的导航路线。
     *
     * @param id
     * @return
     */
    @Override
    public List<String> getNavigationMethods(Integer id) {
        List<String> methods = new ArrayList<>();
        roads = new ArrayList<>();
        DFS(id, new ArrayList<Integer>());
        for (List<Integer> list : roads) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer integer : list) {
                stringBuilder.append(attractionDao.getAttractionById(integer).getName());
                if (!(list.indexOf(integer) == list.size() - 1)) {
                    stringBuilder.append("-->");
                }
            }
            methods.add(stringBuilder.toString());
        }
        return methods;
    }

    public void DFS(Integer id, List<Integer> road) {
        road.add(id);
        if (road.size() == attractionDao.getAll().size()) {
            roads.add(road);
            return;
        }
        //得到相邻景点ID的集合
        Set<Integer> idSet = new HashSet<>();
        List<Road> roadList = roadDao.getRoadsByAttractionId(id);
        for (Road road1 : roadList) {
            idSet.add(road1.getAttractionFirstId());
            idSet.add(road1.getAttractionSecondId());
        }
        idSet.remove(id);
        //深度优先遍历
        for (Integer integer : idSet) {
            List<Integer> integerList = new ArrayList<>(road);
            if (!integerList.contains(integer)) {
                DFS(integer, integerList);
            }
        }
    }

    public void getAllPath(Integer end, Integer id, List<Integer> road) {
        road.add(id);
        if (id.equals(end)) {
            roads.add(road);
            return;
        }
        Set<Integer> idSet = new HashSet<>();
        List<Road> roadList = roadDao.getRoadsByAttractionId(id);
        for (Road road1 : roadList) {
            idSet.add(road1.getAttractionFirstId());
            idSet.add(road1.getAttractionSecondId());
        }
        for (Integer integer : idSet) {
            List<Integer> integerList = new ArrayList<>(road);
            if (!integerList.contains(integer)) {
                getAllPath(end, integer, integerList);
            }
        }
    }

    /**
     * (4) 搜索最短路径
     * 输入：
     * ① 起始景点的编号
     * ② 终点的编号。
     * 处理：使用迪杰斯特拉(Dijkstra)算法，求得从起始景点到终点之间的最短路径，计算路径总长度。
     * 输出：
     * ① 最短路线
     * ② 路径总长度
     *
     * @param begin 起始景点
     * @param end   终点
     * @return
     */
    @Override
    public ShortestPathInfo getShortestPath(int begin, int end) {
        roads = new ArrayList<>();
        getAllPath(end, begin, new ArrayList<>());
        int min = Integer.MAX_VALUE;
        List<List<Integer>> shortestPath = new ArrayList<>();
        for (List<Integer> list : roads) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += roadDao.getRoadByAttractionId(list.get(i), list.get(i + 1)).getDistance();
            }
            if (sum < min) {
                min = sum;
                shortestPath = new ArrayList<>();
                shortestPath.add(list);
            } else if (sum==min) {
                shortestPath.add(list);

            }
        }
        List<String>stringList = new ArrayList<>();
        for (List<Integer>list : shortestPath) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Integer integer :list) {
                stringBuilder.append(attractionDao.getAttractionById(integer).getName());
                if (list.indexOf(integer) != list.size() - 1) {
                    stringBuilder.append("-->");
                }
            }
            stringList.add(stringBuilder.toString());
        }
        return new ShortestPathInfo(min, stringList);
    }


    /**
     * 生成图的邻接矩阵
     *
     * @return
     */
    @Override
    public Graph getGraph() {
        List<Attraction> attractions = attractionDao.getAll();
        Map<Integer,Integer> map = new HashMap<>();
        int num = 0;
        for (Attraction attraction:attractions){
            map.put(attraction.getId(),num);
            num++;
        }
        List<Road> roads = roadDao.getAll();
        Graph graph = new Graph(attractions.size(), roads.size(),attractions);
        for (Road road : roads) {
            graph.setValue(map.get(road.getAttractionFirstId()),map.get(road.getAttractionSecondId()), road.getDistance());
            graph.setValue(map.get(road.getAttractionSecondId()), map.get(road.getAttractionFirstId()), road.getDistance());
        }
        return graph;
    }

    /**
     * (5) 铺设电路规划
     * 处理：根据景区景点图使用普里姆(Prim)算法构造最小生成树，设计出一套铺设线路最短，但能满足每个景点都能通电的方案。
     * 输出：
     * ① 需要铺设电路的道路
     * ② 每条道路铺设电路的长度
     * ③ 铺设电路的总长度
     * @return
     */
    @Override
    public PrimInfo prim() {
        Set<Road> nearRoad = new HashSet<>(roadDao.getRoadsByAttractionId(attractionDao.getAll().get(0).getId()));
        Set<Integer> attractionNum = new HashSet<>();
        Set<Road>answer = new HashSet<>();
        int length=0;
        while(attractionNum.size()!=attractionDao.getAll().size()){
            int min = Integer.MAX_VALUE;
            Road road = new Road();
            for (Road road1:nearRoad){
                if (road1.getDistance()<min&&!answer.contains(road1)&& (!attractionNum.contains(road1.getAttractionFirstId()) || !attractionNum.contains(road1.getAttractionSecondId()))){
                    min=road1.getDistance();
                    road=road1;
                }
            }
            nearRoad.addAll(roadDao.getRoadsByAttractionId(road.getAttractionFirstId()));
            nearRoad.addAll(roadDao.getRoadsByAttractionId(road.getAttractionSecondId()));
            attractionNum.add(road.getAttractionFirstId());
            attractionNum.add(road.getAttractionSecondId());
            answer.add(road);
            length+=min;
        }
       return new PrimInfo(length,answer);
    }

}
