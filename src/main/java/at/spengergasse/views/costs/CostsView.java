package at.spengergasse.views.costs;

import at.spengergasse.views.home.HomeView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

import java.util.OptionalDouble;

@PageTitle("Costs")
@Route("costs")
@Menu(order = 2, icon = LineAwesomeIconUrl.WALLET_SOLID)
public class CostsView extends VerticalLayout {

    public CostsView() {
        setSpacing(true);
        

        add(HomeView.getHeader());

        H2 costs = new H2("Transfer Costs");
        add(costs);

        Component card0 = getCard("Inland", 0, OptionalDouble.empty());
        Component card1 = getCard("Deutschland", 2, OptionalDouble.of(1000));
        Component card2 = getCard("Europa", 4, OptionalDouble.of(500));
        Component card3 = getCard("USA", 6, OptionalDouble.of(400));
        Component card4 = getCard("Welt", 15, OptionalDouble.of(200));

        FlexLayout cards = new FlexLayout(card0, card1, card2, card3, card4);
        cards.setWidthFull();
        cards.setJustifyContentMode(JustifyContentMode.CENTER);
        cards.setFlexWrap(FlexLayout.FlexWrap.WRAP);
        add(cards);

        Paragraph info = new Paragraph("Überweisungen werden am nächsten Tag durchgeführt!");
        info.setWidth("100%");
        info.getStyle().set("text-align", "center");
        add(info);
    }

    private VerticalLayout getCard(String country, double cost, OptionalDouble max) {
        Paragraph maxText;
        VerticalLayout card;

        H2 zone = new H2(country);
        Paragraph costText = new Paragraph("Kosten: " + cost + " Euro");
        if (max.isPresent())
            maxText  = new Paragraph("maximaler Betrag: " + max.getAsDouble() + " Euro");
        else
            maxText  = new Paragraph("maximaler Betrag: unlimitiert");
        card = new VerticalLayout(zone, costText, maxText);
        card.setWidth("350px");
        card.setPadding(true);
        card.setSpacing(false);

        card.getStyle()
                .set("border", "1px solid lightgray")
                .set("border-radius", "10px")
                .set("margin", "10px");
        return card;
    }

}
