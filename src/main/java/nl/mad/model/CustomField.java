package nl.mad.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomField {
    @JsonProperty("CUSTOM_FIELD_ID")
    private String customFieldId;
    @JsonProperty("FIELD_VALUE")
    private String fieldValue;

}
