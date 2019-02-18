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
package com.siena.nashorn.functions.impl;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import jdk.nashorn.api.scripting.ScriptObjectMirror;

/**
 * A custom java-script function that waits a set amount of milliseconds before
 * invoking a callback on a separate java-script function with no arguments. Only
 * functions defined in the file itself will be able to be called by this function.
 * Functions attributed to the engine won't be usable.
 * 
 * Implementation of {@link java.util.function.BiFunction}.
 * @author Dylan Vicchiarelli
 */
public class WaitForCallbackFunction implements BiFunction<Integer, ScriptObjectMirror, Boolean> {

    /**
     * Schedules commands to run after a given delay, or to execute
     * periodically.
     */
    private final ScheduledExecutorService executor;

    /**
     * The class constructor.
     * @param executor The command scheduler.
     */
    public WaitForCallbackFunction(ScheduledExecutorService executor) {
        this.executor = executor;
    }

    @Override
    public Boolean apply(Integer milliseconds, ScriptObjectMirror callback) {
        executor.schedule(() -> {
            callback.call(this);
        }, milliseconds, TimeUnit.MILLISECONDS);
        return true;
    }
}
