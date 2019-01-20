package de.lendico.plangenerator.controller;

import de.lendico.plangenerator.controller.model.request.PlanRequest;
import de.lendico.plangenerator.model.Repayment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests for {@link PlanGenegatorController}.
 *
 * @author Andrei
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanGenegatorControllerTest {

    @Autowired
    PlanGenegatorController planGenegatorController;

    PlanRequest request;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        request = new PlanRequest();
        request.setLoanAmount(new BigDecimal(5000));
        request.setNominalRate(5.0);
        request.setDuration(24);
        request.setStartDate(Date.from(Instant.now()));
    }

    @Test
    public void generatePlan() {
        List<Repayment> repayments = planGenegatorController.generatePlan(request);
        assertEquals(repayments.size(), 24);

    }

    @Test(expected = Exception.class)
    public void generatePlanWithException() {
        planGenegatorController.generatePlan(null);

    }
}