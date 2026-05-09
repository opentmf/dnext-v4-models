package org.opentmf.dnext.tmf666.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.tmf666.model.IAccountTaxExemption;

/**
 * Proof of freedom from taxes imposed by a taxing jurisdiction.
 *
 * <p><br/>
 * <strong>Required:</strong> issuingJurisdiction, validFor<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-666: Account Management API</li>
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
    defaultImpl = AccountTaxExemption.class
)
@Required(fields = {"validFor", "issuingJurisdiction"})
public class AccountTaxExemption extends Extensible implements IAccountTaxExemption {

  /**
   * Identifier of a document that shows proof of exemption from taxes for the
   * taxing jurisdiction.
   */
  private @SafeText String certificateNumber;

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Unique identifier of the entity.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Name of the taxing jurisdiction for which taxes are exempt.
   */
  private @SafeText String issuingJurisdiction;

  /**
   * Reason of the tax exemption.
   */
  private @SafeText String reason;

  /**
   * Period for which the exemption is valid.
   */
  private @Valid TimePeriod validFor;
}