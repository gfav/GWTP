package com.gwtplatform.dispatch.rest.client.parameters;

import com.gwtplatform.common.shared.UrlUtils;

public class QueryParameter extends CollectionSupportedParameter {
    public QueryParameter(
            String name,
            Object object,
            String dateFormat) {
        super(Type.QUERY, name, object, dateFormat);
    }

    @Override
    protected String encode(UrlUtils urlUtils, String value) {
        return urlUtils.encodeQueryString(value);
    }
}
