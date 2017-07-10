package oracle.fodemo.common.service;

import java.util.List;

import javax.ejb.Remote;

import oracle.fodemo.supplier.model.LookupCode;

@Remote
public interface GenericServiceFacade {
    Object queryByRange(String jpqlStmt, int firstResult, int maxResults);

    LookupCode persistLookupCode(LookupCode lookupCode);

    LookupCode mergeLookupCode(LookupCode lookupCode);

    void removeLookupCode(LookupCode lookupCode);

    List<LookupCode> getLookupCodeFindAll();

    List<LookupCode> getLookupCodeFindCodesByType(String language,
                                                  String lookupType);
}
