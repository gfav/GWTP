package com.gwtplatform.dispatch.rest.client.parameters;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

import com.google.gwt.i18n.shared.DateTimeFormat;
import com.gwtplatform.common.shared.UrlUtils;
import com.gwtplatform.dispatch.rest.shared.HttpParameter;

public class ClientHttpParameter implements HttpParameter {
    private final Type type;
    private final String name;
    private final Object object;
    private final DateTimeFormat dateFormatter;

    public ClientHttpParameter(
            Type type,
            String name,
            Object object,
            String dateFormat) {
        this.type = type;
        this.name = name;
        this.object = object;
        this.dateFormatter = DateTimeFormat.getFormat(dateFormat);
    }

    @Override
    public Type getType() {
        return type;
    }

    /**
     * @return the name of this parameter.
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @return the object associated with this parameter.
     */
    @Override
    public Object getObject() {
        return object;
    }

    @Override
    public List<Entry<String, String>> getEntries(UrlUtils urlUtils) {
        List<Entry<String, String>> entries = new ArrayList<Entry<String, String>>();
        entries.add(createEntry(urlUtils, object));
        return entries;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "type=" + type +
                ", name='" + name + "'" +
                ", object=" + object +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ClientHttpParameter that = (ClientHttpParameter) o;

        return name.equals(that.name)
                || (object == null ? that.object == null : object.equals(that.object));
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + (object != null ? object.hashCode() : 0);
        return result;
    }

    protected Entry<String, String> createEntry(UrlUtils urlUtils, Object object) {
        String value = parseObject(object);
        String encoded = encode(urlUtils, value);

        return new SimpleEntry<String, String>(name, encoded);
    }

    protected String parseObject(Object object) {
        if (object == null) {
            return null;
        } else if (object instanceof Date) {
            return dateFormatter.format((Date) object);
        } else {
            return object.toString();
        }
    }

    protected String encode(UrlUtils urlUtils, String value) {
        return value;
    }
}
