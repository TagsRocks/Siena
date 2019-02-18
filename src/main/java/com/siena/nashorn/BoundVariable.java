/*
 * Copyright (C) 2019 Dylan Vicchiarelli
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.siena.nashorn;

/**
 * Represents a variable bound to a {@link ScriptContext}.
 * @author Dylan Vicchiarelli
 */
public class BoundVariable {
    
    /**
     * The name of this variable.
     */
    private String namespace;
    
    /**
     * The value of this variable.
     */
    private Object value;
    
    /**
     * The class constructor.
     * @param namespace The name of this variable.
     * @param value The value of this variable.
     */
    public BoundVariable(String namespace, Object value) {
        this.namespace = namespace;
        this.value = value;
    }

    /**
     * Returns the name of this variable.
     * @return The returned name.
     */
    public String getNamespace() {
        return namespace;
    }

    /**
     * Mutates the name of this variable.
     * @param namespace The mutation.
     */
    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    /**
     * Returns the value of this variable.
     * @return The returned value.
     */
    public Object getValue() {
        return value;
    }

    /**
     * Mutates the value of this variable.
     * @param value The mutation.
     */
    public void setValue(Object value) {
        this.value = value;
    }  
}
