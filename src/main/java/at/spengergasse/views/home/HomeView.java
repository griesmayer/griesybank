package at.spengergasse.views.home;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Home")
@Route("")
@Menu(order = 0, icon = LineAwesomeIconUrl.HOME_SOLID)
public class HomeView extends VerticalLayout {

    public HomeView() {
        setSpacing(true);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(getHeader());

        Image img = new Image("images/logo.png", "das logo der Bank");
        img.setWidth("220px");
        img.setHeight("220px");
        add(img);

        Paragraph p1 = new Paragraph("Die GriesyBank ist ein modernes Finanzinstitut, das Tradition und Innovation auf einzigartige Weise verbindet. Gegründet mit dem Ziel, Kundennähe und Vertrauen in den Mittelpunkt zu stellen, hat sich die Bank als verlässlicher Partner für Privatkunden, Unternehmen und institutionelle Anleger etabliert.");
        p1.getStyle()
                .set("font-size", "22px")
                .set("line-height", "1.6")
                .set("text-align", "left");
        Paragraph p2 = new Paragraph("Die GriesyBank zeichnet sich besonders durch ihren persönlichen Service aus. Kunden werden individuell betreut und erhalten maßgeschneiderte Lösungen – von klassischen Spar- und Girokonten bis hin zu komplexen Finanzierungs- und Anlagekonzepten. Dabei legt die Bank großen Wert auf Transparenz, Sicherheit und langfristige Beziehungen.");
        p2.getStyle()
                .set("font-size", "22px")
                .set("line-height", "1.6")
                .set("text-align", "left");
        Paragraph p3 = new Paragraph("Ein weiterer Schwerpunkt liegt auf Digitalisierung und Nachhaltigkeit. Die GriesyBank bietet moderne Online- und Mobile-Banking-Lösungen, die eine einfache und sichere Verwaltung der Finanzen ermöglichen. Gleichzeitig investiert sie gezielt in nachhaltige Projekte und fördert verantwortungsbewusstes Wirtschaften.");
        p3.getStyle()
                .set("font-size", "22px")
                .set("line-height", "1.6")
                .set("text-align", "left");
        Paragraph p4 = new Paragraph("Mit ihrem engagierten Team, innovativen Produkten und einem klaren Werteverständnis steht die GriesyBank für Stabilität, Fortschritt und Vertrauen – eine Bank, die mit ihren Kunden wächst und ihre Zukunft aktiv mitgestaltet.");
        p4.getStyle()
                .set("font-size", "22px")
                .set("line-height", "1.6")
                .set("text-align", "left");

        HorizontalLayout logoText = new HorizontalLayout(img, new VerticalLayout(p1, p2, p3, p4));
        logoText.setWidth("500px");
        add(logoText);

        H3 name = new H3("Griesy Bank GmbH");
        H3 street = new H3("Spengergasse 20");
        H3 city = new H3("1050 Wien");
        HorizontalLayout adress = new HorizontalLayout(name, street, city);
        adress.getStyle().set("gap", "40px");
        add(adress);
    }

    public static Component getHeader() {
        H1 companyName = new H1("Griesy Bank");
        companyName.getStyle()
                .set("font-family", "cursive")
                .set("font-size", "6rem")
                .set("margin", "0");
        
        H2 subtitle = new H2("... the best bank ...");
        subtitle.getStyle()
                .set("margin", "0")
                .set("color", "gray");

        VerticalLayout header = new VerticalLayout(companyName, subtitle);
        return header;
    }

}
