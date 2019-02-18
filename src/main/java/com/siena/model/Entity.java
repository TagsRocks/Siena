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
 * Represents an entity within the virtual world.
 * @author Dylan Vicchiarelli
 */
public abstract class Entity {

    /**
     * This entity's index.
     */
    private int index;

    /**
     * This entity's position.
     */
    private Position position;
    
    /**
     * This entity's current animation.
     */
    private Animation animation;

    /**
     * Adds this entity to the world.
     */
    public abstract void add();

    /**
     * Removes this entity from the world.
     */
    public abstract void remove();

    /**
     * Returns this entity's index.
     * @return The returned index.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Mutates this entity's index.
     * @param index The mutation.
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Returns this entity's position.
     * @return The returned position.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Mutates this entity's position.
     * @param position The mutation.
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Returns this entity's current animation.
     * @return The returned animation.
     */
    public Animation getAnimation() {
        return animation;
    }

    /**
     * Mutates this entity's current animation.
     * @param animation The mutation.
     */
    public void setAnimation(Animation animation) {
        this.animation = animation;
    }
}
