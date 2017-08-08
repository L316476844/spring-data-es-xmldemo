package org.jon.lv.es;

import org.jon.lv.vo.PlotVO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @Description: 小区搜索
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/8/8 9:52
 * version V1.0.0
 */
public interface PlotSearchService {

    /**
     * 根据小区名称查询
     * @param plotName
     * @param pageNumber
     * @param pageSize
     * @return
     */
    Page<PlotVO> findByPlotNameLike(String plotName, Integer pageNumber, Integer pageSize);

    /**
     * 模糊查找
     * @param plotName
     * @param pageNumber
     * @param pageSize
     * @return
     */
    Page<PlotVO> findByPlotNameFuzzy(String plotName, Integer pageNumber, Integer pageSize);

    /**
     * 按分值查询
     * @param pageNumber
     * @param pageSize
     * @param searchContent
     * @return
     */
    List<PlotVO> searchPlotByScore(Integer pageNumber, Integer pageSize, String searchContent);


}
