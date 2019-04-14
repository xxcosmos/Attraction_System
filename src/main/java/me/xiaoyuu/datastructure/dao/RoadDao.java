package me.xiaoyuu.datastructure.dao;

import me.xiaoyuu.datastructure.entity.Road;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoadDao {

    /**
     * 查询所有道路信息
     * @return
     */
    List<Road> getAll();

    /**
     *
     * @param road
     * @return
     */
    int insertRoad(@Param("road") Road road);

    /**
     * 通过景点id查询与其有关的道路
     * @param id
     * @return
     */
    List<Road> getRoadsByAttractionId(@Param("id") int id);
    Road getRoadByAttractionId(@Param("firstId") int firstId,@Param("secondId")int secondId);

    /**
     *
     * @param firstId
     * @param secondId
     * @return
     */
    int deleteRoadByAttractionId(@Param("firstId") int firstId,@Param("secondId") int secondId);

    /**
     * 修改道路信息
     * @param road
     * @return
     */
    int updateRoad(@Param("road") Road road);

    int deleteAll();


}
