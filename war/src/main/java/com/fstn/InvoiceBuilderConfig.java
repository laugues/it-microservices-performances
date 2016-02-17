package com.fstn;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Startup
@Singleton
public class InvoiceBuilderConfig {


    private static final Logger log = Logger.getLogger(InvoiceBuilderConfig.class
            .getName());
    private static final List<String> BATCHES = new ArrayList<String>();
    public static final String BATCH_NAME = "20160101_000";
    public static final int BATCH_NUMBER = 2;
    public static final int INVOICE_NUMBER_PER_BATCH = 2;

    private List<Invoice> invoices;

    @PostConstruct
    public void init() {

        buildInvoices();
    }

    @PreDestroy
    public void destroy() {

    }

    static {
        for (int i = 1; i <= BATCH_NUMBER; i++) {
            BATCHES.add(BATCH_NAME + i);
        }
    }

    public final List<Invoice> buildInvoices() {
        invoices = new ArrayList<Invoice>();
        Date date = new Date();
        BigDecimal totAmount = new BigDecimal(7850.00);
        BigDecimal hAmount = new BigDecimal(6935.44);

        for (String batch : BATCHES) {

            for (int i = 1; i <= INVOICE_NUMBER_PER_BATCH; i++) {

                String id = batch + "_000" + i;

                log.log(Level.SEVERE, String.format("Creating invoice with id %s....", id));


                Invoice invoice = new Invoice(
                        id,
                        "PAID",
                        date,
                        date,
                        id + new Double(Math.random()).intValue(),
                        totAmount,
                        hAmount,
                        "AIMARGUES",
                        "FI",
                        "EUR",
                        "CODE",
                        date,
                        batch,
                        date,
                        "custom1",
                        "custom2",
                        "custom3",
                        date,
                        date,
                        "1008",
                        "FABEMI",
                        "1005",
                        "CIFFREO BONA",
                        0,
                        "ITESOFT",
                        "FR",
                        false);

                invoices.add(invoice);
                log.log(Level.SEVERE, String.format("Creating invoice with id %s DONE.", id));
            }
        }

        log.log(Level.SEVERE, String.format("Number of invoices created is %d", invoices.size()));

        return invoices;
    }


    public List<Invoice> getInvoices() {
        return invoices;
    }
}
