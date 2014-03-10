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

    public int getDateId() {
        return dateId;
    }

    public void setDateId(int dateId) {
        this.dateId = dateId;
    }

    public String getOccasionName() {
        return occasionName;
    }

    public void setOccasionName(String occasionName) {
        this.occasionName = occasionName;
    }

    public String getOccasionDate() {
        return occasionDate;
    }

    public void setOccasionDate(String occasionDate) {
        this.occasionDate = occasionDate;
    }

    public Boolean getRepeatYearly() {
        return repeatYearly;
    }

    public void setRepeatYearly(Boolean repeatYearly) {
        this.repeatYearly = repeatYearly;
    }

    public Boolean getCreateTaskYearly() {
        return createTaskYearly;
    }

    public void setCreateTaskYearly(Boolean createTaskYearly) {
        this.createTaskYearly = createTaskYearly;
    }

    @Override
    public String toString() {
        return "ContactDate [dateId=" + dateId + ", occasionName=" + occasionName + ", occasionDate=" + occasionDate + ", repeatYearly=" + repeatYearly
                + ", createTaskYearly=" + createTaskYearly + "]";
    }

}
