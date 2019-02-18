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
package com.siena.model;

/**
 * Represents an animation that can be performed by an
 * {@link com.siena.model.Entity}.
 * @author Dylan Vicchiarelli
 */
public class Animation {
    
    /**
     * The index.
     */
    private int index;
    
    /**
     * The delay.
     */
    private int delay;
    
    /**
     * The class constructor.
     * @param index The index.
     * @param delay The delay.
     */
    public Animation(int index, int delay) {
        this.index = index;
        this.delay = delay;
    }

    /**
     * Returns the index.
     * @return The returned index.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Mutates the index.
     * @param index The mutation.
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Returns the delay.
     * @return The returned delay.
     */
    public int getDelay() {
        return delay;
    }

    /**
     * Mutates the delay.
     * @param delay The mutation.
     */
    public void setDelay(int delay) {
        this.delay = delay;
    }
}
