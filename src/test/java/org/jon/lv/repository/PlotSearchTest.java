package org.jon.lv.repository;

import org.jon.lv.JunitBaseTest;
import org.jon.lv.vo.PlotVO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * @Package org.jon.lv.repository.PlotSearchTest
 * @Description: PlotSearch
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/8/7 16:38
 * version V1.0.0
 */
public class PlotSearchTest extends JunitBaseTest {
    @Autowired
    private PlotSearchRepository plotSearchRepository;

    @Test
    public void testRep(){
        System.out.println(plotSearchRepository);
    }

    @Test
    public void findByPlotNameLike(){
        org.springframework.data.domain.Page<PlotVO> page =  plotSearchRepository.findByPlotNameLike("香苑",
                new PageRequest(1, 10, new Sort(new Sort.Order(Sort.Direction.DESC, "_score"))));

        for(PlotVO vo: page.getContent()){
            System.out.println(vo.getPlotName() + "--");
        }

        Assert.assertTrue(page != null);
    }
}
