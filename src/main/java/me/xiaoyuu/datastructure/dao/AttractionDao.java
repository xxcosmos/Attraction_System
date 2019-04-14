package me.xiaoyuu.datastructure.dao;

import me.xiaoyuu.datastructure.entity.Attraction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttractionDao {

    /**
     * 查询数据库中所有道路
     * @return
     */
    List<Attraction>getAll();

    /**
     * 添加景点记录
     * @param attraction
     * @return
     */
    int addAttraction(@Param("attraction") Attraction attraction);

    /**
     * 通过ID查询景点
     * @param id
     * @return
     */
    Attraction getAttractionById(@Param("id") int id);

    /**
     * 通过ID删除景点信息
     * @param id
     * @return
     */
    int deleteAttractionById(@Param("id") int id);

    /**
     *
     * @param attraction
     * @return
     */
    int updateAttraction(@Param("attraction") Attraction attraction);

    int deleteAll();

}
