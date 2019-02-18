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
package com.siena.nashorn.functions;

/**
 * Represents a function that takes three arguments.
 * @author Dylan Vicchiarelli
 * @param <S> This function's first argument.
 * @param <U> This function's second argument.
 * @param <V> This function's third argument.
 * @param <T> This function's return type.
 */
@FunctionalInterface
public interface TriFunction<S, U, V, T> {

    /**
     * Calls this function.
     * @param first_argument  This function's first argument.
     * @param second_argument This function's second argument.
     * @param third_argument  This function's third argument.
     * @return The return type.
     */
    T call(S first_argument, U second_argument, V third_argument);
}
