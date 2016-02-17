package com.fstn.predicate;

import com.fstn.Invoice;
import org.apache.commons.collections.Predicate;

/**
 * Created by SOLO on 17/02/2016.
 */
public class InvoiceIdPredicate implements Predicate {

    private String id;

    public InvoiceIdPredicate(String id) {
        this.id = id;
    }

    @Override
    public boolean evaluate(Object o) {
        return ((Invoice) o).getId().equals(this.id);
    }
}
