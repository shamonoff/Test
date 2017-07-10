package oracle.fodemo.supplier.model;

import java.sql.Timestamp;

public interface Auditable {

    public void setCreatedBy(String createdBy);

    public String getCreatedBy();

    public void setCreationDate(Timestamp creationDate);

    public Timestamp getCreationDate();

    public void setLastUpdatedBy(String lastUpdatedBy);

    public String getLastUpdatedBy();

    public void setLastUpdateDate(Timestamp lastUpdateDate);

    public Timestamp getLastUpdateDate();

    public void setObjectVersionId(Long objectVersionId);

    public Long getObjectVersionId();
}
