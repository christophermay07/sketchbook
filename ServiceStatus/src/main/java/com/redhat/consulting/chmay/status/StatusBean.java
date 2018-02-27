package com.redhat.consulting.chmay.status;

import java.io.Serializable;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.ReflectionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SessionScoped
@ManagedBean(name="status")
public class StatusBean implements Serializable {

    private static final long serialVersionUID = 3788986366020354891L;

    private static final Logger LOG = LoggerFactory.getLogger(StatusBean.class);
    private static MBeanServer server = ManagementFactory.getPlatformMBeanServer();
    
    private static final String MBEAN_ATTR_ADDRESS = "Address";
    private static final String OBJ_NAME_WS_ENDPOINTS = "jboss.ws:context=*,endpoint=*";
    
    public StatusBean() {

    }
    
    public List<ServiceEndpointModel> getServiceEndpoints() {
        List<ServiceEndpointModel> serviceEndpoints = new ArrayList<>();
        
        for (ObjectInstance mBean : getMBeans(OBJ_NAME_WS_ENDPOINTS)) {
            ServiceEndpointModel serviceEndpoint = new ServiceEndpointModel();
            serviceEndpoint.setObjectName(mBean.getObjectName().toString());
            serviceEndpoint.setEndpoint(getStringAttrFromMBean(mBean, MBEAN_ATTR_ADDRESS));
            
            serviceEndpoints.add(serviceEndpoint);
        }
        
        return serviceEndpoints;
    }
    
    private Set<ObjectInstance> getMBeans(String objectNameStr) {
        Set<ObjectInstance> mBeans = null;
        
        try {
            mBeans = server.queryMBeans(new ObjectName(objectNameStr), null);
        } catch (MalformedObjectNameException e) {
            LOG.error("Unable to construct ObjectName for MBean query; {}", e.getLocalizedMessage(), e);
        }
        
        return mBeans;
    }
    
    private String getStringAttrFromMBean(ObjectInstance mBean, String attrName) {
        String attr = null;
        
        
        try {
            attr = (String) server.getAttribute(mBean.getObjectName(), attrName);
        } catch (InstanceNotFoundException | AttributeNotFoundException | ReflectionException | MBeanException e) {
            LOG.error("Unable to get attribute '{}' from MBean; {}", attrName, e.getLocalizedMessage(), e);
        }
        
        return attr;
    }
}
