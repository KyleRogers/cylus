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

package net.cyphoria.cylus.forms;

import net.cyphoria.cylus.domain.KontenArt;
import net.cyphoria.cylus.domain.Konto;

/**
 * @author Stefan Pennndorf <stefan@cyphoria.net>
 */
public class KontoForm {
    private String kontoNummer;
    private String kontoName;
    private String kontenArt;

    public KontoForm withKontoNummer(final int kontoNummer) {
        this.kontoNummer = Integer.toString(kontoNummer);
        return this;
    }


    public KontoForm withKontoName(final String kontoName) {
        this.kontoName = kontoName;
        return this;
    }

    public KontoForm withKontenArt(final String kontenArt) {
        this.kontenArt = kontenArt;
        return this;
    }

    public Konto toKonto() {
        return new Konto(Integer.valueOf(kontoNummer), kontoName, new KontenArt(kontenArt));
    }
}
