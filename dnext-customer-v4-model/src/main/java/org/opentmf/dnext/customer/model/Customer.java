package org.opentmf.dnext.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.customer.model.ICustomer;
import org.opentmf.dnext.common.model.AccountRef;
import org.opentmf.dnext.common.model.AclRelatedParty;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.CustomerBase;
import org.opentmf.dnext.common.model.ExternalReference;
import org.opentmf.dnext.common.model.PaymentMethodRef;
import org.opentmf.dnext.common.model.RelatedParty;

/**
 *
 * <p><br/>
 * <strong>Required:</strong> engagedParty, href, id, name<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-629: Customer Management API</li>
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
    defaultImpl = Customer.class
)
@Required(fields = {"name", "href", "id", "engagedParty"})
public class Customer extends CustomerBase implements ICustomer {

  /**
   * A list of account references.
   */
  @JsonProperty("account")
  private List<@Valid AccountRef> accounts;

  /**
   * List of: Related Entity reference. A related party defines party or party
   * role linked to a specific entity.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid AclRelatedParty> aclRelatedParties;

  /**
   * A list of attachment references.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * Name of created by user.
   */
  private @SafeText String createdBy;

  /**
   * Date of creation.
   */
  private OffsetDateTime createdDate;

  /**
   * A related party (RelatedParty). The party - an organization or an individual
   * - that is engaged as a customer.
   */
  private @Valid RelatedParty engagedParty;

  /**
   * A list of external references.
   */
  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * A list of payment method references.
   */
  @JsonProperty("paymentMethod")
  private List<@Valid PaymentMethodRef> paymentMethods;

  /**
   * Version number of the entity.
   */
  private Integer revision;

  /**
   * Name of updated by user.
   */
  private @SafeText String updatedBy;

  /**
   * Date of update.
   */
  private OffsetDateTime updatedDate;
}