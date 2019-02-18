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
 * Represents a position on the world map.
 * @author Dylan Vicchiarelli
 */
public class Position {

    /**
     * The X coordinate.
     */
    private int x;

    /**
     * The Y coordinate.
     */
    private int y;

    /**
     * The coordinate plane.
     */
    private int z;

    /**
     * The class constructor.
     * @param x The X coordinate.
     * @param y The Y coordinate.
     * @param z The coordinate plane.
     */
    public Position(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Mutates the coordinates.
     * @param x The new X coordinate.
     * @param y The new Y coordinate.
     * @param z The new coordinate plane.
     */
    public void set(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * Returns the X coordinate.
     * @return The returned coordinate.
     */
    public int getX() {
        return x;
    }

    /**
     * Mutates the X coordinate.
     * @param x The mutation.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the Y coordinate.
     * @return The returned coordinate.
     */
    public int getY() {
        return y;
    }

    /**
     * Mutates the Y coordinate.
     * @param y The mutation.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns the coordinate plane.
     * @return The returned coordinate plane.
     */
    public int getZ() {
        return z;
    }

    /**
     * Mutates the coordinate plane.
     * @param z The mutation.
     */
    public void setZ(int z) {
        this.z = z;
    }
}
