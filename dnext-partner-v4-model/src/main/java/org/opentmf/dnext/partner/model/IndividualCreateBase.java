package org.opentmf.dnext.partner.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import java.net.URI;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeId;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Characteristic;
import org.opentmf.dnext.common.model.ContactMedium;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.MarketSegmentRef;
import org.opentmf.dnext.common.model.PartyCreditProfile;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.TaxExemptionCertificate;

/**
 * Synthesized abstract parent for 4 model classes.
 *
 * <p><br/>
 * <strong>Direct descendants:</strong>
 * <ul>
 *   <li>IndividualCreate (632)</li>
 *   <li>IndividualUpdate (632)</li>
 *   <li>OrganizationCreate (632)</li>
 *   <li>OrganizationUpdate (632)</li>
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
    defaultImpl = IndividualCreateBase.class
)
public abstract class IndividualCreateBase extends Extensible {

  /**
   * List of: Indicates the contact medium that could be used to contact the
   * party.
   */
  @JsonProperty("contactMedium")
  private List<@Valid ContactMedium> contactMediums;

  /**
   * List of: An individual might be evaluated for its worthiness and this
   * evaluation might be based on a credit rating given by a credit agency.
   */
  @JsonProperty("creditRating")
  private List<@Valid PartyCreditProfile> creditRatings;

  /**
   * Hyperlink reference.
   */
  private URI href;

  /**
   * Unique identifier of the individual.
   */
  @SafeId
  @Size(max = 100)
  private String id;

  @JsonProperty("marketSegment")
  private List<@Valid MarketSegmentRef> marketSegments;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("partyCharacteristic")
  private List<@Valid Characteristic> partyCharacteristics;

  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  private @SafeText String status;

  /**
   * List of: A tax exemption certificate represents a tax exemption granted to a
   * party (individual or organization) by a tax jurisdiction which may be a city,
   * state, country,... An exemption has a certificate identifier (received from
   * the jurisdiction that levied the tax) and a validity period. An exemption is
   * per tax types and determines for each type of tax what portion of the tax is
   * exempted (partial by percentage or complete) via the tax definition.
   */
  @JsonProperty("taxExemptionCertificate")
  private List<@Valid TaxExemptionCertificate> taxExemptionCertificates;
}