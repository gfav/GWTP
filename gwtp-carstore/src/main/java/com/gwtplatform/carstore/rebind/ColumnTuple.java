/**
 * Copyright 2013 ArcBees Inc.
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.carstore.rebind;

import com.google.gwt.core.ext.typeinfo.JMethod;
import com.gwtplatform.carstore.client.columninitializer.Column;

public class ColumnTuple {
    private JMethod method;
    private Column column;

    public JMethod getMethod() {
        return method;
    }

    public Column getColumn() {
        return column;
    }

    public String getCellCanonicalName() {
        return column.cellType().getCanonicalName();
    }

    public String getReturnCellCanonicalName() {
        return column.cellReturnType().getCanonicalName();
    }

    public String getMethodCapitalizedName() {
        return method.getName();
    }

    public static ColumnTuple createFrom(JMethod method) {
        ColumnTuple columnTuple = new ColumnTuple();

        columnTuple.method = method;
        columnTuple.column = method.getAnnotation(Column.class);

        return columnTuple;
    }
}
