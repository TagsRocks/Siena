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
package com.siena;

import com.siena.model.Player;
import com.siena.model.Position;
import com.siena.nashorn.BoundVariable;
import com.siena.nashorn.NashornScriptEngine;
import java.io.File;
import javax.script.ScriptException;

/**
 * The main class for the application.
 * @author Dylan Vicchiarelli
 */
public class Siena {

    /**
     * The entry point for the application.
     * @param commands The command line arguments.
     */
    public static void main(String[] commands) {
        NashornScriptEngine engine = new NashornScriptEngine();
        try {
            engine.load(new File("./data/scripts/"));
        } catch (ScriptException exception) {
            exception.printStackTrace(System.out);
        }

        Player player = new Player();
        player.setIndex(1);
        player.setPosition(new Position(3239, 3203, 0));
        
        Player player_ = new Player();
        player_.setIndex(2);
        player_.setPosition(new Position(3239, 3203, 0));
        
        engine.call("test.js", new BoundVariable[]{
            new BoundVariable("player", player)
        });
        
        engine.call("test.js", new BoundVariable[]{
            new BoundVariable("player", player_)
        });
    }
}
