package com.haiyangroup.education.view;

import com.haiyangroup.education.data.AbsReturn;
import com.haiyangroup.education.data.DefaultObj;
import com.haiyangroup.education.entity.TestEntity;

/**
 * Created by Administrator on 2015/11/13.
 */
public interface TestView {
    void show(AbsReturn<TestEntity> test);
}
