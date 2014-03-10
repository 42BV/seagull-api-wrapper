package nl.mad.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactDate {
    @JsonProperty("DATE_ID")
    private int dateId;
    @JsonProperty("OCCASION_NAME")
    private String occasionName;
    @JsonProperty("OCCASION_DATE")
    private String occasionDate;
    @JsonProperty("REPEAT_YEARLY")
    private Boolean repeatYearly;
    @JsonProperty("CREATE_TASK_YEARLY")
    private Boolean createTaskYearly;

}
