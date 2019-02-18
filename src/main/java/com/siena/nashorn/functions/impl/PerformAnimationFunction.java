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

import com.siena.model.Animation;
import com.siena.model.Entity;
import java.util.function.BiFunction;

/**
 * A custom java-script function that causes an {@link com.siena.model.Entity} to
 * perform an animation. Implementation of {@link java.util.function.BiFunction}.
 * @author Dylan Vicchiarelli
 */
public class PerformAnimationFunction implements BiFunction<Entity, Integer, Boolean> {

    @Override
    public Boolean apply(Entity entity, Integer animation) {
        entity.setAnimation(new Animation(animation, 0));
        return true;
    }    
}
