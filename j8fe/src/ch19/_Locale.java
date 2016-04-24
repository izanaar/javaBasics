package ch19;

import auxillary.CollectionsViewer;

import java.util.Locale;

public class _Locale {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        String[] localeValues = new String[]{locale.getDisplayCountry(),locale.getDisplayLanguage(),
        locale.getDisplayName()};
        CollectionsViewer.viewArray(localeValues);
    }
}
