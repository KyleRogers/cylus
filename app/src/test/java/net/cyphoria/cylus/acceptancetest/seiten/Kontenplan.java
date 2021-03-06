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

package net.cyphoria.cylus.acceptancetest.seiten;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.fluentlenium.core.filter.FilterConstructor.withText;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Stefan Penndorf
 */
public class Kontenplan extends FluentPage {

    @FindBy(css = "#neuesKontoAnlegen")
    FluentWebElement neuesKontoAnlegenButton;

    @Override
    public String getUrl() {
        return "/kontenplan";
    }

    @Override
    public void isAt() {
        assertThat("Title tag", title(), containsString("Kontenplan"));
        assertThat("Ueberschrift",findFirst("h1#title").getText(), is("Kontenplan"));
    }

    public void zeigtKonto(final Integer kontoNummer, final String kontoName) {
        final FluentWebElement kontoElem = find(".konto").first();

        kontoElem.findFirst(".kontoNummer", withText(kontoNummer.toString()));
        kontoElem.findFirst(".kontoName", withText(kontoName));
    }

    public void legeNeuesKontoAn(
            final Integer kontoNummer,
            final String kontoName,
            final String kontoArt) {

        neuesKontoAnlegenButton.click();

        final NeuesKontoSeite neuesKontoSeite = createPage(NeuesKontoSeite.class);
        neuesKontoSeite.isAt();
        neuesKontoSeite.legeKontoAn(kontoNummer, kontoName, kontoArt);
    }

    public void benenneKontoUm(final Integer kontoNummer, final String neuerKontoName) {
        final FluentWebElement kontoElem =
                find(".konto", withText().contains(kontoNummer.toString()))
                .first();

        kontoElem.findFirst(".btn-rename").click();

        final KontoUmbenennenSeite kontoUmbenennenSeite = createPage(KontoUmbenennenSeite.class);

        kontoUmbenennenSeite.für(kontoNummer).isAt();
        kontoUmbenennenSeite.benenneKontoUmIn(neuerKontoName);
    }
}
