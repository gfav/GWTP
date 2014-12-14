package com.gwtplatform.dispatch.rest.client.parameters;

import com.gwtplatform.common.shared.UrlUtils;

public class PathParameter extends ClientHttpParameter {
    public PathParameter(
            String name,
            Object object,
            String dateFormat) {
        super(Type.PATH, name, object, dateFormat);
    }

    @Override
    protected String encode(UrlUtils urlUtils, String value) {
        return urlUtils.encodePathSegment(value);
    }
}
