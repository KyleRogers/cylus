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

package net.cyphoria.cylus.web.controller;

import net.cyphoria.cylus.domain.Kontenplan;
import net.cyphoria.cylus.service.konto.KontoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Stefan Penndorf
 */
@Controller
@RequestMapping("/kontenplan")
public class KontenplanController {

    private final KontoService kontoService;

    @Autowired
    public KontenplanController(final KontoService kontoService) {
        this.kontoService = kontoService;
    }

    @RequestMapping
    public String zeigeKontenplan(final Model model) {
        final Kontenplan kontenplan = kontoService.ladeKontenplan();
        model.addAttribute("kontenplan", kontenplan);
        return "kontenplan";
    }


}
