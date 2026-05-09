package org.opentmf.dnext.partner.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.partner.model.IAgreementCreate;

/**
 * The Agreement to be created.
 *
 * <p><br/>
 * <strong>Required:</strong> agreementItem, agreementType, engagedParty, name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-651: Agreement Management API</li>
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
    defaultImpl = AgreementCreate.class
)
@Required(fields = {"agreementType", "name", "agreementItem", "engagedParty"})
public class AgreementCreate extends AgreementUpdate implements IAgreementCreate {

  private @Valid TimePeriod completionDate;
}