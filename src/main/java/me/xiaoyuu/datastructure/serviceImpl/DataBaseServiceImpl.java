package me.xiaoyuu.datastructure.serviceImpl;

import me.xiaoyuu.datastructure.dao.AttractionDao;
import me.xiaoyuu.datastructure.dao.RoadDao;
import me.xiaoyuu.datastructure.dto.AttractionInfo;
import me.xiaoyuu.datastructure.entity.Attraction;
import me.xiaoyuu.datastructure.entity.Road;
import me.xiaoyuu.datastructure.service.DataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataBaseServiceImpl implements DataBaseService {
    @Autowired
    AttractionDao attractionDao;
    @Autowired
    RoadDao roadDao;


    /**
     * (2) 查询景点
     * 输入：想要查询的景点的编号。
     * 处理：根据输入的景点编号，查询该景点及相邻景点的信息。
     * 输出：
     * ① 景点名字
     * ② 景点介绍
     * ③ 相邻景区的名字
     * ④ 到达相邻景区的路径长度
     *
     * @param id
     * @return
     */
    @Override
    public AttractionInfo getAttractionInfoById(int id) {
        Attraction attraction = attractionDao.getAttractionById(id);
        List<Road> roads = roadDao.getRoadsByAttractionId(id);
        return new AttractionInfo(attraction, roads);
    }

    @Override
    public List<Attraction> getAllAttraction() {
        return attractionDao.getAll();
    }

    @Override
    public int addAttraction(Attraction attraction) {
        return attractionDao.addAttraction(attraction);
    }

    @Override
    public int deleteAttraction(Integer id) {
        if (attractionDao.getAttractionById(id) == null) {
            return -1;
        } else {
            attractionDao.deleteAttractionById(id);
            return 0;
        }
    }

    @Override
    public int updateAttraction(Attraction attraction) {
        if (attractionDao.getAttractionById(attraction.getId()) == null) {
            return -1;
        } else {
            attractionDao.updateAttraction(attraction);
            return 0;
        }
    }

    @Override
    public int addRoad(Road road) {
        if (attractionDao.getAttractionById(road.getAttractionFirstId()) == null || attractionDao.getAttractionById(road.getAttractionSecondId()) == null) {
            return -2;
        } else if (roadDao.getRoadByAttractionId(road.getAttractionFirstId(), road.getAttractionSecondId()) != null) {
            return -1;
        } else if (road.getAttractionFirstId() == road.getAttractionSecondId()) {
            return -3;
        } else {
            roadDao.insertRoad(road);
            return 0;
        }


    }

    @Override
    public int deleteRoad(Integer firstId, Integer secondId) {
        if (roadDao.getRoadByAttractionId(firstId, secondId) != null) {
            roadDao.deleteRoadByAttractionId(firstId, secondId);
            return 0;
        } else {
            return -1;
        }
    }

    @Override
    public int updateRoad(Road road) {
        if (roadDao.getRoadByAttractionId(road.getAttractionFirstId(), road.getAttractionSecondId()) != null) {
            roadDao.updateRoad(road);
            return 0;
        } else {
            return -1;
        }
    }
}
