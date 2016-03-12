package ch19;

import auxillary.CollectionsViewer;

import java.util.Currency;
import java.util.Locale;

/**
 * Created by ierus on 7/17/15.
 */
public class _Currency {
    public static void main(String[] args) {
        Currency localCurrency = Currency.getInstance(Locale.getDefault());
        String[] currVals = new String[]{localCurrency.getDisplayName(),localCurrency.getSymbol()};
        Appendable app;
        CollectionsViewer.viewArray(currVals);
    }
}
