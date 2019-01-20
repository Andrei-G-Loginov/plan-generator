package de.lendico.plangenerator.service.impl.utils;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Tests for {@link CalculatorServiceImpl}.
 *
 * @author Andrei
 *
 */
@SpringBootTest
public class CalculatorServiceImplTest {
    private static final int SCALE = 2;

    CalculatorServiceImpl calculatorService;

    @Before
    public void setUp() {
        calculatorService = new CalculatorServiceImpl();
    }

    @Test
    public void getInterest() {
        Double nominalRate = 5.0;
        BigDecimal initialOutstandingPrincipal = new BigDecimal(5000);
        BigDecimal expectedResult = new BigDecimal(20.83).setScale(SCALE, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal interest = calculatorService.getInterest(nominalRate, initialOutstandingPrincipal);
        assertEquals(interest.compareTo(expectedResult), 0);
    }

    @Test
    public void checkInterestExceedInitialOutstandingPrincipal() {
        Double nominalRate = 10000.0;
        BigDecimal initialOutstandingPrincipal = new BigDecimal(5000);
        BigDecimal interest = calculatorService.getInterest(nominalRate, initialOutstandingPrincipal);
        assertEquals(interest.compareTo(initialOutstandingPrincipal), 0);
    }

    @Test
    public void getPrincipal() {
        BigDecimal interest = new BigDecimal(20.83);
        BigDecimal annuiny = new BigDecimal(219.36);
        BigDecimal expectedResult = new BigDecimal(198.53).setScale(SCALE, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal principal = calculatorService.getPrincipal(annuiny, interest);
        assertEquals(principal.compareTo(expectedResult), 0);

    }

    @Test
    public void getRemainingOutstandingPrincipal() {
        BigDecimal initialOutstandingPrincipal = new BigDecimal(5000);
        BigDecimal principal = new BigDecimal(198.53);
        BigDecimal expectedResult = new BigDecimal(4801.47).setScale(SCALE, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal remainingOutstandingPrincipal = calculatorService.getRemainingOutstandingPrincipal(
                initialOutstandingPrincipal, principal);
        assertEquals(remainingOutstandingPrincipal.compareTo(expectedResult), 0);
    }

    @Test
    public void getAnnuityPayment() {
        BigDecimal loanAmount = new BigDecimal(5000);
        Double nominalRate = 5.0;
        Integer duration = 24;
        BigDecimal expectedResult = new BigDecimal(219.36).setScale(SCALE, BigDecimal.ROUND_HALF_EVEN);
        BigDecimal annuiny = calculatorService.getAnnuityPayment(loanAmount, nominalRate, duration);
        assertEquals(annuiny.compareTo(expectedResult), 0);
    }

    @Test
    public void checkAnnuityWithPrincipalAndInterest() {
        BigDecimal loanAmount = new BigDecimal(5000);
        Double nominalRate = 5.0;
        Integer duration = 24;
        BigDecimal annuiny = calculatorService.getAnnuityPayment(loanAmount, nominalRate, duration);
        BigDecimal interest = calculatorService.getInterest(nominalRate, loanAmount);
        BigDecimal principal = calculatorService.getPrincipal(annuiny, interest);
        assertEquals(annuiny.compareTo(principal.add(interest)), 0);
    }
}