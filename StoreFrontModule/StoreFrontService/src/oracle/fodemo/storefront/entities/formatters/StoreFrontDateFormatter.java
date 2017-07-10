package oracle.fodemo.storefront.entities.formatters;

import oracle.jbo.format.DefaultDateFormatter;
import oracle.jbo.format.FormatErrorException;

public class StoreFrontDateFormatter extends DefaultDateFormatter {
      /**
       * Force the default date format to return an uppercase month name.
       * 
       * @param formatString
       * @param rawData
       * @return
       * @throws FormatErrorException
       */
      @Override
      public String format(String formatString, 
                           Object rawData) throws FormatErrorException
      {
        String ret = super.format(formatString, rawData);
        if (ret != null) 
        {
          ret = ret.toUpperCase();
        }
        return ret;
      }
}
