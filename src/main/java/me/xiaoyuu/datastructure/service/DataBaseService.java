package me.xiaoyuu.datastructure.service;

import me.xiaoyuu.datastructure.dto.AttractionInfo;
import me.xiaoyuu.datastructure.entity.Attraction;
import me.xiaoyuu.datastructure.entity.Road;

import java.util.List;

public interface DataBaseService {

    AttractionInfo getAttractionInfoById(int id);

    List<Attraction> getAllAttraction();

    int addAttraction(Attraction attraction);

    int deleteAttraction(Integer id);

    int updateAttraction(Attraction attraction);

    int addRoad(Road road);

    int deleteRoad(Integer firstId,Integer secondId);
    int updateRoad(Road road);

}
