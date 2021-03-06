/*
 * Copyright (c) Stefan Penndorf 2014
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

package net.cyphoria.cylus.domain.validierung;

/**
 * @author Stefan Penndorf
 */
public abstract class Ergebnis {

    private static final Ergebnis GUELTIG = new Gueltig();

    public static Ergebnis gueltig() {
        return GUELTIG;
    }

    public static Ergebnis fehlerhaft() {
        return new Fehlerhaft();
    }

    public static final class Gueltig extends Ergebnis {

        private Gueltig() {}
    }

    public static final class Fehlerhaft extends Ergebnis {
        private Fehlerhaft() {}

    }


}
