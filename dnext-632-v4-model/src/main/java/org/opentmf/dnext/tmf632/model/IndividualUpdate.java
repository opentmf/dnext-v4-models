package org.opentmf.dnext.tmf632.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.AclRelatedParty;
import org.opentmf.dnext.common.model.AttachmentRefOrValue;
import org.opentmf.dnext.common.model.Characteristic;
import org.opentmf.dnext.common.model.ContactMedium;
import org.opentmf.dnext.common.model.Extensible;
import org.opentmf.dnext.common.model.ExternalReference;
import org.opentmf.dnext.common.model.IndividualIdentification;
import org.opentmf.dnext.common.model.MarketSegmentRef;
import org.opentmf.dnext.common.model.PartyCreditProfile;
import org.opentmf.dnext.common.model.RelatedParty;
import org.opentmf.dnext.common.model.TaxExemptionCertificate;

/**
 * The Individual to be updated.
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
    defaultImpl = IndividualUpdate.class
)
public class IndividualUpdate extends Extensible {

  /**
   * List of: Related Entity reference. A related party defines party or party
   * role linked to a specific entity.
   */
  @JsonProperty("aclRelatedParty")
  private List<@Valid AclRelatedParty> aclRelatedParties;

  /**
   * e.g. Baron, Graf, Earl,….
   */
  private @SafeText String aristocraticTitle;

  /**
   * List of: An attachment by value or by reference. An attachment complements
   * the description of an element, for example through a document, a video, a
   * picture.
   */
  @JsonProperty("attachment")
  private List<@Valid AttachmentRefOrValue> attachments;

  /**
   * Birth date.
   */
  private OffsetDateTime birthDate;

  /**
   * List of: Indicates the contact medium that could be used to contact the
   * party.
   */
  @JsonProperty("contactMedium")
  private List<@Valid ContactMedium> contactMediums;

  /**
   * Country where the individual was born.
   */
  private @SafeText String countryOfBirth;

  /**
   * List of: An individual might be evaluated for its worthiness and this
   * evaluation might be based on a credit rating given by a credit agency.
   */
  @JsonProperty("creditRating")
  private List<@Valid PartyCreditProfile> creditRatings;

  /**
   * Date of death.
   */
  private OffsetDateTime deathDate;

  /**
   * List of: Lack or inadequate strength or ability.
   */
  @JsonProperty("disability")
  private List<@Valid Disability> disabilities;

  @JsonProperty("externalReference")
  private List<@Valid ExternalReference> externalReferences;

  /**
   * Contains the non-chosen or inherited name. Also known as last name in the
   * Western context.
   */
  private @SafeText String familyName;

  /**
   * Family name prefix.
   */
  private @SafeText String familyNamePrefix;

  /**
   * A fully formatted name in one string with all of its pieces in their proper
   * place and all of the necessary punctuation. Useful for specific contexts
   * (Chinese, Japanese, Korean,…).
   */
  private @SafeText String formattedName;

  /**
   * Full name flatten (first, middle, and last names).
   */
  private @SafeText String fullName;

  /**
   * Gender.
   */
  private @SafeText String gender;

  /**
   * e.g.. Sr, Jr, III (the third),….
   */
  private @SafeText String generation;

  /**
   * First name of the individual.
   */
  private @SafeText String givenName;

  /**
   * List of: Represents our registration of information used as proof of identity
   * by an individual (passport, national identity card, drivers license, social
   * security number, birth certificate).
   */
  @JsonProperty("individualIdentification")
  private List<@Valid IndividualIdentification> individualIdentifications;

  /**
   * List of: Ability of an individual to understand or converse in a language.
   */
  @JsonProperty("languageAbility")
  private List<@Valid LanguageAbility> languageAbilities;

  /**
   * Legal name or birth name (name one has for official purposes).
   */
  private @SafeText String legalName;

  /**
   * Temporary current location od the individual (may be used if the individual
   * has approved its sharing).
   */
  private @SafeText String location;

  /**
   * Marital status (married, divorced, widow ...).
   */
  private @SafeText String maritalStatus;

  @JsonProperty("marketSegment")
  private List<@Valid MarketSegmentRef> marketSegments;

  /**
   * Middles name or initial.
   */
  private @SafeText String middleName;

  /**
   * Nationality.
   */
  private @SafeText String nationality;

  /**
   * List of: Keeps track of other names, for example the old name of a woman
   * before marriage or an artist name.
   */
  @JsonProperty("otherName")
  private List<@Valid OtherNameIndividual> otherNames;

  /**
   * List of: Describes a given characteristic of an object or entity through a
   * name/value pair.
   */
  @JsonProperty("partyCharacteristic")
  private List<@Valid Characteristic> partyCharacteristics;

  /**
   * Reference to the place where the individual was born.
   */
  private @SafeText String placeOfBirth;

  /**
   * Contains the chosen name by which the individual prefers to be addressed.
   * Note: This name may be a name other than a given name, such as a nickname.
   */
  private @SafeText String preferredGivenName;

  @JsonProperty("relatedParty")
  private List<@Valid RelatedParty> relatedParties;

  /**
   * List of: Skills evaluated for an individual with a level and possibly with a
   * limited validity when an obsolescence is defined (Ex: the first-aid
   * certificate first level is limited to one year and an update training is
   * required each year to keep the level).
   */
  @JsonProperty("skill")
  private List<@Valid Skill> skills;

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

  /**
   * Useful for titles (aristocratic, social,...) Pr, Dr, Sir, ...
   */
  private @SafeText String title;
}