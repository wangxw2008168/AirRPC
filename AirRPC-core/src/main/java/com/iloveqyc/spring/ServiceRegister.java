package com.iloveqyc.spring;

import com.iloveqyc.bean.ProviderParam;
import com.iloveqyc.bean.ServerParam;
import com.iloveqyc.constants.PropertyConstant;
import com.iloveqyc.service.ServiceFactory;
import com.iloveqyc.utils.ConfigLoader;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: qiuyongchen Nicolas.David
 * Date: 2017/4/9
 * Time: 上午4:19
 * Usage: 用于调用端，注册某个或某些服务
 */
public class ServiceRegister {

    /**
     * 用于注册的服务
     *   String:服务的名称，serviceName
     *   Object:服务的实例
     */
    public Map<String, Object> services;

    public void init() {

        // 获取服务器配置
        ServerParam serverParam = new ServerParam(ConfigLoader.loadPropertyByKey(PropertyConstant.LOCAL_IP),"4080");

        // 获取所有的服务提供者配置（来自xml文件）
        List<ProviderParam> providerParams = getAllProvider();
        ServiceFactory.addServices(providerParams, serverParam);
    }

    private List<ProviderParam> getAllProvider() {
        List<ProviderParam> providerParams = new ArrayList<>();
        for (String serviceName : services.keySet()) {
            ProviderParam provider = new ProviderParam();
            provider.setServiceName(serviceName);
            provider.setServiceInstance(services.get(serviceName));
            providerParams.add(provider);
        }
        return providerParams;
    }

    public void setServices(Map<String, Object> services) {
        this.services = services;
    }
}
