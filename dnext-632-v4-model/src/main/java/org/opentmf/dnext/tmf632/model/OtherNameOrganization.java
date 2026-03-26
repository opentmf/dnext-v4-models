package org.opentmf.dnext.tmf632.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.NamedEntity;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.tmf632.model.IOtherNameOrganization;

/**
 * Keeps track of other names, for example the old name of an organization.
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
 * </ul>
 * </p>
 *
 * @author Gökhan Demir
 */
@Getter
@Setter
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    visible = true,
    include = JsonTypeInfo.As.EXISTING_PROPERTY,
    defaultImpl = OtherNameOrganization.class
)
public class OtherNameOrganization extends NamedEntity implements IOtherNameOrganization {

  /**
   * Co. , Inc. , Ltd. , Pty Ltd. , Plc; , Gmbh.
   */
  private @SafeText String nameType;

  /**
   * The name that the organization trades under.
   */
  private @SafeText String tradingName;

  private @Valid TimePeriod validFor;
}