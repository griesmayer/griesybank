package at.spengergasse.views.transfer;

import at.spengergasse.domain.Account;
import at.spengergasse.service.BankService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.lineawesome.LineAwesomeIconUrl;

@PageTitle("Transfer")
@Route("transfer")
@Menu(order = 1, icon = LineAwesomeIconUrl.DOLLAR_SIGN_SOLID)
public class TransferView extends VerticalLayout {
    private final Grid<Account> grid = new Grid<>(Account.class, true);
    private final BankService bankService;

    public TransferView(@Autowired BankService bankService) {
        this.bankService = bankService;
        setSpacing(true);

        setSizeFull();
        grid.setSizeFull();
        add(grid);
        reload();
    }

    private void reload() {
        grid.setItems(bankService.findAll());
    }
}
