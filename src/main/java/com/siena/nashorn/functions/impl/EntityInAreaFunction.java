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

import com.siena.nashorn.functions.QuintFunction;
import com.siena.model.Entity;
import com.siena.model.Position;

/**
 * A custom java-script function that denotes if an
 * {@link com.siena.model.Entity} is within a specific boundary. Implementation
 * of {@link com.siena.nashorn.functions.impl.QuintFunction}.
 * @author Dylan Vicchiarelli
 */
public class EntityInAreaFunction implements
        QuintFunction<Entity, Integer, Integer, Integer, Integer, Boolean> {

    @Override
    public Boolean call(Entity entity, Integer minX, Integer minY, Integer maxX, Integer maxY) {
        Position position = entity.getPosition();
        return position.getX() >= minX && position.getX() <= maxX && position.getY() >= minY &&
                position.getX() <= maxY;
    }
}
