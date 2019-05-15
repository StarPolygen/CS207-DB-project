package com.cs307.sustc.project.tools;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SearchTest {
    Search search=new Search();

    @Test
    public void searchTest(){
        System.out.println(search.search(List.of("ip","hone"),1));
    }
}
