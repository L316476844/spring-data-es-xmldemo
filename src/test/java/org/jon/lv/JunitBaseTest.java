package org.jon.lv;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @Package com.dongtong.global.JunitBaseTest
 * @Description: JunitBaseTest
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/8/3 10:05
 * version V1.0.0
 */
@ContextConfiguration("classpath*:config/*.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Ignore
public class JunitBaseTest {

    @Test
    public void hello(){
        System.out.println("hello world!!");
    }
}
