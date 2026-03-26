package org.opentmf.dnext.tmf632.model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.opentmf.commons.validation.constraints.Required;
import org.opentmf.commons.validation.constraints.SafeText;
import org.opentmf.dnext.common.model.Entity;
import org.opentmf.dnext.common.model.TimePeriod;
import org.opentmf.tmf632.model.ILanguageAbility;

/**
 * Ability of an individual to understand or converse in a language.
 *
 * <p><br/>
 * <strong>Required:</strong> languageCode, languageName<br/>
 * </p>
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
    defaultImpl = LanguageAbility.class
)
@Required(fields = {"languageCode", "languageName"})
public class LanguageAbility extends Entity implements ILanguageAbility {

  /**
   * A “true” value specifies whether the language is considered by the individual
   * as his favourite one.
   */
  private Boolean isFavouriteLanguage;

  /**
   * Language code (RFC 5646).
   */
  private @SafeText String languageCode;

  /**
   * Language name.
   */
  private @SafeText String languageName;

  /**
   * Listening proficiency evaluated for this language.
   */
  private @SafeText String listeningProficiency;

  /**
   * Reading proficiency evaluated for this language.
   */
  private @SafeText String readingProficiency;

  /**
   * Speaking proficiency evaluated for this language.
   */
  private @SafeText String speakingProficiency;

  private @Valid TimePeriod validFor;

  /**
   * Writing proficiency evaluated for this language.
   */
  private @SafeText String writingProficiency;
}