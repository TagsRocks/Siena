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

import com.siena.model.Player;
import java.util.function.BiFunction;

/**
 * Displays a message in the chat-box of an {@link com.siena.model.Player).
 * Implementation of {@link java.util.function.BiFunction}.
 * @author Dylan Vicchiarelli
 */
public class ShowGameMessageFunction implements BiFunction<Player, String, Boolean> {

    @Override
    public Boolean apply(Player player, String message) {
        System.out.println(message);
        return true;
    } 
}
