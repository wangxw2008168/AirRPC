package com.iloveqyc.test.service.Impl;

import com.iloveqyc.sample.api.ILoveYouService;
import org.springframework.stereotype.Service;

/**
 * User: qiuyongchen Nicolas.David
 * Date: 2017/4/10
 * Time: 下午11:38
 * Usage: xxx
 */
public class ILoveYouServiceImpl implements ILoveYouService {
    public String iLoveYou(String yourName, String yourLoverName) {
        return "this is " + yourName + "'s love letter for his girlfriend " + yourLoverName + " hahaha";
    }
}
