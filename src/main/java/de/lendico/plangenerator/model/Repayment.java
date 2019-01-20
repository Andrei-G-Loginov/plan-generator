package de.lendico.plangenerator.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Representation of Repayment.
 *
 * @author Andrei
 *
 */
public class Repayment {
    private BigDecimal borrowerPaymentAmount;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime date;

    private BigDecimal initialOutstandingPrincipal;
    private BigDecimal interest;
    private BigDecimal principal;
    private BigDecimal remainingOutstandingPrincipal;

    public BigDecimal getBorrowerPaymentAmount() {
        return borrowerPaymentAmount;
    }

    public void setBorrowerPaymentAmount(BigDecimal borrowerPaymentAmount) {
        this.borrowerPaymentAmount = borrowerPaymentAmount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public BigDecimal getInitialOutstandingPrincipal() {
        return initialOutstandingPrincipal;
    }

    public void setInitialOutstandingPrincipal(BigDecimal initialOutstandingPrincipal) {
        this.initialOutstandingPrincipal = initialOutstandingPrincipal;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getPrincipal() {
        return principal;
    }

    public void setPrincipal(BigDecimal principal) {
        this.principal = principal;
    }

    public BigDecimal getRemainingOutstandingPrincipal() {
        return remainingOutstandingPrincipal;
    }

    public void setRemainingOutstandingPrincipal(BigDecimal remainingOutstandingPrincipal) {
        this.remainingOutstandingPrincipal = remainingOutstandingPrincipal;
    }

    @Override
    public String toString() {
        return "Repayment{" +
                "borrowerPaymentAmount=" + borrowerPaymentAmount +
                ", date=" + date +
                ", initialOutstandingPrincipal=" + initialOutstandingPrincipal +
                ", interest=" + interest +
                ", principal=" + principal +
                ", remainingOutstandingPrincipal=" + remainingOutstandingPrincipal +
                '}';
    }
}
