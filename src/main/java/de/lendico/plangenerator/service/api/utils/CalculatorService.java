package de.lendico.plangenerator.service.api.utils;

import java.math.BigDecimal;

/**
 * Service for calculate interest, principal,
 * remaining outstanding principal and annuity payment values.
 *
 * @author Andrei
 *
 */
public interface CalculatorService {

    /**
     * Calculate the interest value.
     *
     * @param nominalRate Nominal interest rate
     *
     * @param initialOutstandingPrincipal Initial outstanding principal value
     *
     * @return Interest value
     */
    BigDecimal getInterest(Double nominalRate,
                                 BigDecimal initialOutstandingPrincipal);

    /**
     * Calculate the principal value.
     *
     * @param annuity Annuity value
     *
     * @param interest Interest value
     *
     * @return Principal value
     */
    BigDecimal getPrincipal(BigDecimal annuity, BigDecimal interest);

    /**
     * Calculate the remaining outstanding principal value.
     *
     * @param initialOutstandingPrincipal Initial outstanding principal value
     *
     * @param principal Principal value
     *
     * @return Remaining outstanding principal value
     */
    BigDecimal getRemainingOutstandingPrincipal(
            BigDecimal initialOutstandingPrincipal,
            BigDecimal principal);

    /**
     * Calculate the annuity value.
     *
     * @param loanAmount Amount of the loan
     *
     * @param nominalRate Nominal interest rate
     *
     * @param duration Duration in periods of the loan
     *
     * @return Annuity value
     */
    BigDecimal getAnnuityPayment(BigDecimal loanAmount, Double nominalRate,
                         Integer duration);
}
