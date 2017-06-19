package com.example.springbootDemo;

import com.example.springbootDemo.domain.BlogProperties;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Administrator on 2017/6/19 0019.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesTest {

    @Autowired
    private BlogProperties blogProperties;

    @Test
    public void testProperties() {
//        Assert.assertEquals(blogProperties.getName(), "aaaa");
        System.out.print("blogProperties.getName():"+blogProperties.getName());
//        Assert.assertEquals(blogProperties.getTitle(), "bbb");
        System.out.print("blogProperties.getTitle():"+blogProperties.getTitle());
    }
}
