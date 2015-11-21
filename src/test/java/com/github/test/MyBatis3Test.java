package com.github.test;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.nivance.test.entity.PersonExample;
import com.github.nivance.test.entity.PersonKey;
import com.github.nivance.test.entity.PersonWithBLOBs;
import com.github.nivance.test.mapper.PersonMapper;

/**
 * Copyright (C) 2015 Baidu, Inc. All Rights Reserved.
 */

/**
 * @author limingjian
 *
 */
@ContextConfiguration("classpath:appplication-common.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class MyBatis3Test {

    @Autowired
    PersonMapper personMapper;
    
    @Test
    public void testInsert() {
        PersonWithBLOBs persion = new PersonWithBLOBs();
        long r = new Random().nextLong();
        persion.setFirstname("Jim" + r);
        persion.setSurname("Kenidy");
        int count = personMapper.insertSelective(persion);
        Assert.assertEquals(count, 1);
    }
    
    @Test
    public void testCountByExample() {
        PersonExample example = new PersonExample();
        int count = personMapper.countByExample(example);
        Assert.assertEquals(count, 1);
    }
    
    @Test
    public void testSelectByPrimaryKey() {
    	PersonKey key = new PersonKey();
        key.setId(1);
        PersonWithBLOBs person = personMapper.selectByPrimaryKey(key);
        Assert.assertNotNull(person);
    }
    
    @Test
    public void testUpdateByExampleSelective() {
        PersonWithBLOBs record = new PersonWithBLOBs();
        record.setFirstname("Jim9999999999999");
        PersonExample example = new PersonExample();
        example.createCriteria().andIdEqualTo(1);
        int updates = personMapper.updateByExampleSelective(record, example );
        // updates = personMapper.updateByPrimaryKeySelective(record);
        Assert.assertEquals(updates, 1);
    }

}
