package com.gwtplatform.dispatch.rest.client.parameters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.gwtplatform.common.shared.UrlUtils;

public class CollectionSupportedParameter extends ClientHttpParameter {
    public CollectionSupportedParameter(
            Type type,
            String name,
            Object object,
            String dateFormat) {
        super(type, name, object, dateFormat);
    }

    @Override
    public List<Entry<String, String>> getEntries(UrlUtils urlUtils) {
        List<Map.Entry<String, String>> entries = new ArrayList<Entry<String, String>>();

        if (getObject() instanceof Collection) {
            // Spec. requires only List<T>, Set<T> or SortedSet<T>... but really?!
            for (Object item : ((Collection<?>) getObject())) {
                entries.add(createEntry(urlUtils, item));
            }
        } else {
            entries.add(createEntry(urlUtils, getObject()));
        }

        return entries;
    }
}
