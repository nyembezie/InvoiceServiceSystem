/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.ioco.invoiceservice.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * <p>
 * <b>Purpose:</b><br>
 * <br>
 *
 * <p>
 * <b>Title:</b> IoCoInvoice<br>
 * <b>Description:</b>
 * </p>
 *
 * @author Eric Kabini<br>
 * @date 10 Dec 2019<br>
 * @version 1.0<br>
 *
 *          <b>Revision:</b>
 * 
 */
@Entity
public class IoCoInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String client;

    private Long vatRate;

    private Date invoiceDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "invoice_id")
    private List<IoCOLineItem> lineItems = new ArrayList<>();

    public IoCoInvoice() {
        // no-arg constructor
    }

    public void addLineItem(IoCOLineItem lineItem) {
        this.lineItems.add(lineItem);
        lineItem.setInvoice(this);
    }

    public void removeLineItem(IoCOLineItem lineItem) {
        this.lineItems.remove(lineItem);
        lineItem.setInvoice(null);
    }

    public Long getId() {
        return id;
    }

    public String getClient() {
        return client;
    }

    public Long getVatRate() {
        return vatRate;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public List<IoCOLineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<IoCOLineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setVatRate(Long vatRate) {

        this.vatRate = vatRate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public BigDecimal getSubTotal() {

        return lineItems.stream()
                .map(itm -> itm.getLineItemTotal())
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getVat() {
        return BigDecimal.valueOf(getVatRate() / 100d).multiply(getSubTotal()).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal getTotal() {
        return getSubTotal().add(getVat()).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof IoCoInvoice)) {
            return false;
        }

        IoCoInvoice invoice = (IoCoInvoice) o;

        if (!getId().equals(invoice.getId())) {
            return false;
        }
        if (!getClient().equals(invoice.getClient())) {
            return false;
        }
        if (!getVatRate().equals(invoice.getVatRate())) {
            return false;
        }
        return getInvoiceDate().equals(invoice.getInvoiceDate());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getClient().hashCode();
        result = 31 * result + getVatRate().hashCode();
        result = 31 * result + getInvoiceDate().hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Invoice{");
        sb.append("id=").append(id);
        sb.append(", client='").append(client).append('\'');
        sb.append(", vatRate=").append(vatRate);
        sb.append(", invoiceDate=").append(invoiceDate);
        sb.append('}');
        return sb.toString();
    }

}
