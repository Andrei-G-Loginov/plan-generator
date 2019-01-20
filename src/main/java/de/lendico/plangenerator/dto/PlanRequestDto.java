package de.lendico.plangenerator.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * Data transfer object for {@code PlanRequest}.
 *
 * @author Andrei
 *
 */
public class PlanRequestDto {
    private BigDecimal loanAmount;
    private Double nominalRate;
    private Integer duration;
    private LocalDateTime startDate;

    public PlanRequestDto(BigDecimal loanAmount,
                          Double nominalRate,
                          Integer duration,
                          Date startDate) {
        this.loanAmount = loanAmount;
        this.nominalRate = nominalRate;
        this.duration = duration;
        Instant instant = startDate.toInstant();
        this.startDate = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));
    }

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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "PlanRequestDto{" +
                "loanAmount=" + loanAmount +
                ", nominalRate=" + nominalRate +
                ", duration=" + duration +
                ", startDate=" + startDate +
                '}';
    }
}
