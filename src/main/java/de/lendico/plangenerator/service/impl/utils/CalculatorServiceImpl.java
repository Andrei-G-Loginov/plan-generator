package de.lendico.plangenerator.service.impl.utils;

import de.lendico.plangenerator.service.api.utils.CalculatorService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Implementation of {@link CalculatorService}.
 *
 * @author Andrei
 *
 */
@Service
public class CalculatorServiceImpl implements CalculatorService {
    private static final Integer DAYS_IN_MONTH = 30;
    private static final Integer DAYS_IN_YEAR = 360;
    private static final Double PERCENT = 100.0;
    private static final Double MONTHS = 12.0;
    private static final int SCALE = 2;

    @Override
    public BigDecimal getInterest(final Double nominalRate, final BigDecimal initialOutstandingPrincipal) {
        BigDecimal interest = new BigDecimal(nominalRate * DAYS_IN_MONTH * initialOutstandingPrincipal.doubleValue()
                / DAYS_IN_YEAR)
                .divide(new BigDecimal(PERCENT)).setScale(SCALE, BigDecimal.ROUND_HALF_EVEN);
        return interest.compareTo(initialOutstandingPrincipal) == 1 ? initialOutstandingPrincipal : interest;
    }

    @Override
    public BigDecimal getPrincipal(final BigDecimal annuity, final BigDecimal interest) {
        return annuity.subtract(interest).setScale(SCALE, BigDecimal.ROUND_HALF_EVEN);
    }

    @Override
    public BigDecimal getRemainingOutstandingPrincipal(final BigDecimal initialOutstandingPrincipal,
                                                       final BigDecimal principal) {
        BigDecimal remainingOutstandingPrincipal = initialOutstandingPrincipal.subtract(principal);
        if (remainingOutstandingPrincipal.compareTo(BigDecimal.ZERO) < 0) {
            remainingOutstandingPrincipal = BigDecimal.ZERO;
        }
        return remainingOutstandingPrincipal.setScale(SCALE, BigDecimal.ROUND_HALF_EVEN);
    }

    @Override
    public BigDecimal getAnnuityPayment(final BigDecimal loanAmount, final Double nominalRate, final Integer duration) {
        Double nominalRateByFraction = nominalRate / PERCENT;
        double annuity = (loanAmount.doubleValue() * (nominalRateByFraction / MONTHS)) /
                (1 - Math.pow(1 + (nominalRateByFraction / MONTHS), -duration));
        return new BigDecimal(annuity).setScale(SCALE, BigDecimal.ROUND_HALF_EVEN);
    }
}