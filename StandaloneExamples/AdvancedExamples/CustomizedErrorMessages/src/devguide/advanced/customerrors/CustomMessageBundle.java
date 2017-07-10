package devguide.advanced.customerrors;

import java.util.ListResourceBundle;

public class CustomMessageBundle extends ListResourceBundle {
    private static final Object[][] sMessageStrings 
        = new String[][] {
       {"27014","You must provide a value for {2}"},
       {"NAME_CANNOT_BEGIN_WITH_U",
        "The name cannot begin with the letter u!"}
       };

    /**Return String Identifiers and corresponding Messages in a two-dimensional array.
     */
    protected Object[][] getContents() {
        return sMessageStrings;
    }
}
