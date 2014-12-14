package com.gwtplatform.dispatch.rest.client.parameters;

import javax.inject.Inject;

import com.gwtplatform.dispatch.rest.shared.HttpParameter;
import com.gwtplatform.dispatch.rest.shared.HttpParameter.Type;

public class DefaultHttpParameterFactory implements HttpParameterFactory {
    private final String defaultDateFormat;

    @Inject
    public DefaultHttpParameterFactory(
            String defaultDateFormat) {
        this.defaultDateFormat = defaultDateFormat;
    }

    @Override
    public HttpParameter create(Type type, String name, Object object) {
        return create(type, name, object, defaultDateFormat);
    }

    @Override
    public HttpParameter create(HttpParameter.Type type, String name, Object object, String dateFormat) {
        switch (type) {
            case FORM:
                return new FormParameter(name, object, dateFormat);
            case HEADER:
                return new HeaderParameter(name, object, dateFormat);
            case PATH:
                return new PathParameter(name, object, dateFormat);
            case QUERY:
                return new QueryParameter(name, object, dateFormat);
            default:
                return new ClientHttpParameter(type, name, object, dateFormat);
        }
    }
}
