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

import javax.script.CompiledScript;

/**
 * Represents a compiled script.
 * @author Dylan Vicchiarelli
 */
public class NashornScript {

    /**
     * The compiled script code.
     */
    private CompiledScript compilation;

    /**
     * The class constructor.
     * @param compilation The compiled script code.
     */
    public NashornScript(CompiledScript compilation) {
        this.compilation = compilation;
    }

    /**
     * Returns the compiled script code.
     * @return The returned compilation.
     */
    public CompiledScript getCompilation() {
        return compilation;
    }

    /**
     * Mutates the compiled script code.
     * @param compilation The mutation.
     */
    public void setCompilation(CompiledScript compilation) {
        this.compilation = compilation;
    }
}
