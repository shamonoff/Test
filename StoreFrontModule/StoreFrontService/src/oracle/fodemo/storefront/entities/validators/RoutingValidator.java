package oracle.fodemo.storefront.entities.validators;

import oracle.jbo.ValidationException;
import oracle.jbo.rules.JboValidatorContext;
import oracle.jbo.rules.JboValidatorInterface;

public class RoutingValidator implements JboValidatorInterface {
    private String description = "";

    public RoutingValidator() {
    }

    /**Return true if value is valid.
     * @param value
     * @return
     */
    public boolean validateValue(Object value) {
        return true;
    }

    /**Invoked by framework for validation.
     * @param ctx
     */
    public void validate(JboValidatorContext ctx) {
        Integer n = 0;
        String t = (String)ctx.getNewValue();
        if (t.length() < 9) {
            return;
        }
        System.out.println(t);
        for (int i = 0; i < t.length(); i += 3) {
            Character first = t.charAt(i);
            Character middle = t.charAt(i+1);
            Character last = t.charAt(i+2);
            n += (Integer.parseInt(first.toString(), 10)) * 3
            + (Integer.parseInt(middle.toString(), 10)) * 7
            + Integer.parseInt(last.toString(), 10);

        }
        //If the resulting sum is an even multiple of ten (but not zero), 
        //the aba routing number is valid.
        if (n != 0 && n % 10 == 0){ 
            System.out.println("valid number");
        } else 
        {
            System.out.println("invalid number");
            throw new ValidationException("oracle.fodemo.storefront.entities.validators.RoutingValidator validation failed");
        }
    }

    /**Description of what this class validates.
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**Description of what this class validates.
     * @param str
     */
    public void setDescription(String str) {
        description = str;
    }
}
