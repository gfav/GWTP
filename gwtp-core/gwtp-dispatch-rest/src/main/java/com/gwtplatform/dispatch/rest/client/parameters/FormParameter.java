package com.gwtplatform.dispatch.rest.client.parameters;

import com.gwtplatform.common.shared.UrlUtils;

public class FormParameter extends CollectionSupportedParameter {
    public FormParameter(
            String name,
            Object object,
            String dateFormat) {
        super(Type.FORM, name, object, dateFormat);
    }

    @Override
    protected String encode(UrlUtils urlUtils, String value) {
        return urlUtils.encodeQueryString(value);
    }
}
