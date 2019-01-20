package de.lendico.plangenerator.controller.model.request;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Representation of JSON request for {@code PlanGenegatorController}.
 *
 * @author Andrei
 *
 */
public class PlanRequest {

    @NotNull
    private BigDecimal loanAmount;

    @NotNull
    private Double nominalRate;

    @NotNull
    private Integer duration;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private Date startDate;

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Double getNominalRate() {
        return nominalRate;
    }

    public void setNominalRate(Double nominalRate) {
        this.nominalRate = nominalRate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "PlanRequest{" +
                "loanAmount=" + loanAmount +
                ", nominalRate=" + nominalRate +
                ", duration=" + duration +
                ", startDate=" + startDate +
                '}';
    }
}
