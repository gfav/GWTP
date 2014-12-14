package com.gwtplatform.dispatch.rest.client.parameters;

import com.gwtplatform.dispatch.rest.shared.HttpParameter;

public interface HttpParameterFactory {
    HttpParameter create(HttpParameter.Type type, String name, Object object);

    HttpParameter create(HttpParameter.Type type, String name, Object object, String dateFormat);
}
