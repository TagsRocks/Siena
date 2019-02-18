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

import com.siena.nashorn.functions.impl.EntityInAreaFunction;
import com.siena.nashorn.functions.impl.PerformAnimationFunction;
import com.siena.nashorn.functions.impl.ShowGameMessageFunction;
import com.siena.nashorn.functions.impl.WaitForCallbackFunction;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;

/**
 * An engine for the compilation and execution of java-script files within the
 * Java virtual machine.
 * @author Dylan Vicchiarelli
 */
public class NashornScriptEngine {

    /**
     * The table of compiled scripts.
     */
    private final HashMap<String, NashornScript> scripts = new HashMap<>();

    /**
     * Instantiates this engine.
     */
    private final ScriptEngineManager manager = new ScriptEngineManager();

    /**
     * Provides basic scripting functionality.
     */
    private final ScriptEngine engine = manager.getEngineByName("nashorn");

    /**
     * A set of named attributes whose values can be set and retrieved.
     */
    private final ScriptContext context = new SimpleScriptContext();

    /**
     * A mapping of engine attributes.
     */
    private final Bindings bindings = context.getBindings(ScriptContext.ENGINE_SCOPE);

    /**
     * Creates a thread pool that can schedule commands to run after a given
     * delay, or to execute periodically.
     */
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    /**
     * The default class constructor.
     */
    public NashornScriptEngine() {
        bindings.put("in_area", new EntityInAreaFunction());
        bindings.put("do_anim", new PerformAnimationFunction());
        bindings.put("chat_message", new ShowGameMessageFunction());
        bindings.put("wait_for", new WaitForCallbackFunction(executor));
    }

    /**
     * Calls an existing script that was already compiled with a given set of
     * bindings.
     * @param namespace The name-space for the script to be executed. This does
     *                  not include the path.
     * @param variables The variables to be bound. Variables will be overwritten
     *                  if duplicate names are encountered.
     */
    public void call(String namespace, BoundVariable[] variables) {
        final NashornScript script = scripts.get(namespace);
        if (script == null)
            throw new InvalidParameterException("Couldn't find " + namespace + ".");
        CompiledScript compilation = script.getCompilation();
        ScriptContext context_ = new SimpleScriptContext();

        /**
         * An individual set of bindings for this invocation. Prevents
         * synchronization issues among parallel executions.
         */
        Bindings bindings_ = context_.getBindings(ScriptContext.ENGINE_SCOPE);

        /**
         * Exposes this script to the global attributes of the engine.
         */
        bindings_.putAll(bindings);
        for (BoundVariable variable : variables) {
            if (variable == null)
                return;
            context_.setAttribute(variable.getNamespace(), variable.getValue(), ScriptContext.ENGINE_SCOPE);
        }
        try {

            /**
             * Executes this script from the top down.
             */
            compilation.eval(context_);
        } catch (ScriptException exception) {
            exception.printStackTrace(System.out);
        }
    }

    /**
     * Compiles and tables an entire directory of java-script files. The
     * compiled scripts are identified in the table by their name. Duplicates
     * will be overwritten.
     * @see com.sienna.nashorn.NashornScriptEngine#compile(File)
     * @param directory The path to this directory.
     * @throws javax.script.ScriptException The exception thrown if an error
     *                                      occurs while loading a script.
     */
    public void load(File directory) throws ScriptException {
        if (directory.isFile())
            throw new InvalidParameterException("Please specify the directory rather than "
                    + "the individual file.");
        File[] files = directory.listFiles();
        int count = 0;
        for (File script : files) {
            if (script == null)
                continue;
            String namespace = script.getName();

            CompiledScript compilation = compile(script);
            NashornScript nashorn_script = new NashornScript(compilation);

            scripts.put(namespace, nashorn_script);

            /**
             * Accumulate the counter for each successfully compiled script.
             */
            count++;
        }
        System.out.println("Loaded and compiled " + count + " scripts from " + directory.getPath());
    }

    /**
     * Compiles a java-script file and returns that compilation.
     * @param script The file to be compiled.
     * @return The returned compilation.
     */
    public CompiledScript compile(File script) {
        String namespace = script.getName();
        if (!namespace.endsWith(".js"))
            throw new InvalidParameterException("Only java-script files can be compiled.");
        try {
            return ((Compilable) engine).compile(new FileReader(script));
        } catch (FileNotFoundException | ScriptException exception) {
            exception.printStackTrace(System.out);
        }

        /**
         * The script couldn't be compiled.
         */
        return null;
    }
}
