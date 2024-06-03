package com.example;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RibbonConfigurationTest {

    @Test
    public void testRibbonPingBean() {
   
        IClientConfig config = Mockito.mock(IClientConfig.class);

        RibbonConfiguration ribbonConfiguration = new RibbonConfiguration();

        IPing ping = ribbonConfiguration.ribbonPing(config);

        assertNotNull(ping);
       
    }

    @Test
    public void testRibbonRuleBean() {
       
        IClientConfig config = Mockito.mock(IClientConfig.class);

        RibbonConfiguration ribbonConfiguration = new RibbonConfiguration();

        IRule rule = ribbonConfiguration.ribbonRule(config);

        assertNotNull(rule);
        assertEquals(AvailabilityFilteringRule.class, rule.getClass());
    }
}

