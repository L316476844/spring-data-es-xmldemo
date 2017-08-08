package org.jon.lv.repository;

import org.jon.lv.vo.PlotVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description: PlotSearchRepository
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/8/7 10:32
 * version V1.0.0
 */
@Repository
public interface PlotSearchRepository extends ElasticsearchRepository<PlotVO, Long> {
    Page<PlotVO> findByPlotNameLike(String plotName, Pageable pageable);
}
