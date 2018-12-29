package com.guazi.test.layer1.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.guazi.test.layer1.service.Layer1TestService;
import com.guazi.test.layer1.vo.Layer1Req;
import com.guazi.test.layer1.vo.Layer1Response;
import com.guazi.test.layer2.api.Layer2Api;
import com.guazi.test.layer2.vo.Layer2RequestVo;
import com.guazi.test.layer2.vo.Layer2Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 2018-12-29 14:23
 */
@Service
@Slf4j
public class Layer1TestServiceImpl implements Layer1TestService {

    @Reference(check = false)
    private Layer2Api layer2Api;


    @Override
    public Layer1Response getlaLayer1Response(Layer1Req req) {
        Layer2RequestVo requestVo = new Layer2RequestVo();
        requestVo.setName(req.getName());
        requestVo.setAge(Integer.valueOf(req.getAge()));
        Layer2Response layer2Response = layer2Api.getLayer2Response(requestVo);
        Layer1Response layer1Response = new Layer1Response();
        layer1Response.setAge(String.valueOf(layer2Response.getAge()));
        layer1Response.setName(layer2Response.getName() + "layer1");
        return layer1Response;
    }
}
