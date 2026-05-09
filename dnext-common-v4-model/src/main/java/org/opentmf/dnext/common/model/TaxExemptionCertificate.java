package org.opentmf.dnext.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.common.model.ITaxExemptionCertificate;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;

/**
 * A tax exemption certificate represents a tax exemption granted to a party
 * (individual or organization) by a tax jurisdiction which may be a city,
 * state, country,... An exemption has a certificate identifier (received from
 * the jurisdiction that levied the tax) and a validity period. An exemption is
 * per tax types and determines for each type of tax what portion of the tax is
 * exempted (partial by percentage or complete) via the tax definition.
 *
 * <p><br/>
 * <strong>Required:</strong> id<br/>
 * </p>
 *
 * <p><br/>
 * <strong>Referring TMF artifacts:</strong>
 * <ul>
 *   <li>TMF-632: Party Management API</li>
 *   <li>TMF-658: Loyalty</li>
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
    defaultImpl = TaxExemptionCertificate.class
)
@Required(fields = {"id"})
public class TaxExemptionCertificate extends Extensible implements ITaxExemptionCertificate {

  /**
   * The actual certificate contents, if such is supplied by the issuing
   * jurisdiction.
   */
  private @Valid AttachmentRefOrValue attachment;

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
   * Identifier of the tax exemption within list of the exemptions.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  /**
   * Name of the jurisdiction that issued the exemption.
   */
  private @SafeText String issuingJurisdiction;

  /**
   * Reason for the tax exemption.
   */
  private @SafeText String reason;

  /**
   * A list of taxes that are covered by the exemption, e.g. City Tax, State Tax.
   * The definition would include the exemption (e.g. for a rate exemption 0%
   * would be a full exemption, 5% could be a partial exemption if the actual rate
   * was 10%).
   */
  @JsonProperty("taxDefinition")
  private List<@Valid TaxDefinition> taxDefinitions;

  /**
   * The period of time for which the exemption is valid.
   */
  private @Valid TimePeriod validFor;
}