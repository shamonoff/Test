package oracle.fodemo.storefront.store.view;

import oracle.adf.share.security.authorization.ADFPermission;
import oracle.adf.share.security.authorization.PermissionActionDescriptor;
import oracle.adf.share.security.authorization.PermissionTargetDescriptor;

public class AccountPermission extends ADFPermission {
    private static final PermissionActionDescriptor[] actions =
    {new PermissionActionDescriptor("view", "view")};
    private static final PermissionTargetDescriptor[] targets =
    {new PermissionTargetDescriptor("attributeValue", "Attribute")};

    public AccountPermission(String name, String actions) {
        super(name, actions);
    }

    public static PermissionActionDescriptor[] getPermissionActionDescriptors() {
        return actions;
    }

    public static PermissionTargetDescriptor[] getPermissionTargetDescriptors() {
        return targets;
    }
}
