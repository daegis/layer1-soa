package com.guazi.test.layer1.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.guazi.test.layer1.api.Layer1Api;
import com.guazi.test.layer1.service.Layer1TestService;
import com.guazi.test.layer1.vo.Layer1Req;
import com.guazi.test.layer1.vo.Layer1Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 2018-12-29 14:31
 */
@Component
@Service
@Slf4j
public class Layer1ApiImpl implements Layer1Api {

    @Autowired
    private Layer1TestService service;

    @Override
    public Layer1Response getLayer1Response(Layer1Req req) {
        return service.getlaLayer1Response(req);
    }
}
