package com.gwtplatform.dispatch.rest.client.parameters;

public class HeaderParameter extends CollectionSupportedParameter {
    public HeaderParameter(
            String name,
            Object object,
            String dateFormat) {
        super(Type.HEADER, name, object, dateFormat);
    }
}
