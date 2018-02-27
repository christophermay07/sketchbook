package com.redhat.consulting.chmay.status;

public class ServiceEndpointModel {

    private String objectName = null;
    private String endpoint = null;
    
    public ServiceEndpointModel() {

    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
}
