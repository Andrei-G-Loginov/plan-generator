package de.lendico.plangenerator.service.impl.web;

import de.lendico.plangenerator.dto.PlanRequestDto;
import de.lendico.plangenerator.model.Repayment;
import de.lendico.plangenerator.service.api.utils.CalculatorService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link PlanGeneratorServiceImpl}.
 *
 * @author Andrei
 *
 */
@SpringBootTest
public class PlanGeneratorServiceImplTest {

    PlanGeneratorServiceImpl planGeneratorService;

    @Mock
    CalculatorService calculatorService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        planGeneratorService = new PlanGeneratorServiceImpl(calculatorService);
        when(calculatorService.getInterest(any(), any())).thenReturn(new BigDecimal(20.83));
        when(calculatorService.getAnnuityPayment(any(), any(), any())).thenReturn(new BigDecimal(5020.83));
        when(calculatorService.getPrincipal(any(), any())).thenReturn(new BigDecimal(5000));
        when(calculatorService.getRemainingOutstandingPrincipal(any(), any())).thenReturn(new BigDecimal(0));
    }

    @Test
    public void generatePlan() {
        PlanRequestDto planRequestDto = new PlanRequestDto(new BigDecimal(5000),
                5.0, 1, Date.from(Instant.now()));
        List<Repayment> repayments = planGeneratorService.generatePlan(planRequestDto);
        assertEquals(repayments.size(), 1);
    }
}