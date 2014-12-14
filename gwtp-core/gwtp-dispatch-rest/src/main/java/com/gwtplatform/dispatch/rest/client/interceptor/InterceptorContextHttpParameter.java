package com.gwtplatform.dispatch.rest.client.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.gwtplatform.common.shared.UrlUtils;
import com.gwtplatform.dispatch.rest.shared.HttpParameter;

class InterceptorContextHttpParameter implements HttpParameter {
    private final String name;
    private final String value;

    InterceptorContextHttpParameter(
            String name,
            String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Object getObject() {
        return value;
    }

    @Override
    public Type getType() {
        return Type.QUERY;
    }

    @Override
    public List<Entry<String, String>> getEntries(UrlUtils urlUtils) {
        return new ArrayList<Entry<String, String>>();
    }
}
