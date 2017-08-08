package org.jon.lv.es.impl;

import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.jon.lv.es.PlotSearchService;
import org.jon.lv.repository.PlotSearchRepository;
import org.jon.lv.vo.PlotVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: PlotSearchServiceImpl
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/8/8 9:52
 * version V1.0.0
 */
@Service
public class PlotSearchServiceImpl implements PlotSearchService {
    @Autowired
    private PlotSearchRepository plotSearchRepository;
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public Page<PlotVO> findByPlotNameLike(String plotName, Integer pageNumber, Integer pageSize) {

        org.springframework.data.domain.Page<PlotVO> page =  plotSearchRepository.findByPlotNameLike(plotName,
                new PageRequest(pageNumber, pageSize, new Sort(new Sort.Order(Sort.Direction.DESC, "_score"))));
        return page;
    }

    @Override
    public Page<PlotVO> findByPlotNameFuzzy(String plotName, Integer pageNumber, Integer pageSize) {

        // 分页参数
        Pageable pageable = new PageRequest(pageNumber, pageSize);

        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(plotName,
                "plotName").fuzziness(Fuzziness.AUTO).analyzer("ik");

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(multiMatchQueryBuilder).build();

        System.out.println("\n findByPlotNameFuzzy(): searchContent [" + plotName + "] \n DSL  = \n " + searchQuery.getQuery().toString());


        org.springframework.data.domain.Page<PlotVO> page = plotSearchRepository.search(searchQuery);


        return page;
    }

    @Override
    public List<PlotVO> searchPlotByScore(Integer pageNumber, Integer pageSize, String searchContent) {

        // 分页参数
        Pageable pageable = new PageRequest(pageNumber, pageSize);
        // Function Score Query
        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("plotName", searchContent)),
                        ScoreFunctionBuilders.weightFactorFunction(1000))
                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("plotAddress", searchContent)),
                        ScoreFunctionBuilders.weightFactorFunction(100));

        // 创建搜索 DSL 查询
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();
        System.out.println("\n searchPlotByScore(): searchContent [" + searchContent + "] \n DSL  = \n " + searchQuery.getQuery().toString());

        org.springframework.data.domain.Page<PlotVO> searchPageResults = plotSearchRepository.search(searchQuery);


        return searchPageResults.getContent();

    }

    public void nearbyPlot(double lat, double lng, float distance){
        QueryBuilders.geoDistanceRangeQuery("location").point(lat, lng).lt(distance);
    }
}
