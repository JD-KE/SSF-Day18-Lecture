package sg.edu.nus.iss.d18lecture.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Announcement {
    
    @NotNull(message = "Announcement Id required")
    @Digits(fraction = 0, integer = 9, message = "Numbers only")
    @Max(value = 888888)
    @Min(value = 111111)
    private Integer annId;

    @Pattern(regexp = "^[a-zA-Z]*$", message = "Only Alphabetical Characters accepted")
    private String code;

    @NotEmpty(message = "Title required")
    @Size(min = 10, max = 50, message = "Title must be between 10 to 50 characters")
    private String title;

    @NotEmpty(message = "Message required")
    private String message;

    @Future(message = "Announcement start date must be a future date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;

    public Integer getAnnId() {
        return annId;
    }

    public void setAnnId(Integer annId) {
        this.annId = annId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    
}
