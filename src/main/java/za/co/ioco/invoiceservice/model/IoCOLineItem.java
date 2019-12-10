package za.co.ioco.invoiceservice.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * <p>
 * <b>Purpose:</b><br>
 * <br>
 *
 * <p>
 * <b>Title:</b> IoCOLineItem<br>
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
public class IoCOLineItem {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long quantity;

    private String description;

    private BigDecimal unitPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="invoice_id")
    private IoCoInvoice invoice;

    public IoCOLineItem() {
        // no-arg constructor
    }

    public Long getId() {
        return id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public IoCoInvoice getInvoice() {
        return invoice;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setInvoice(IoCoInvoice invoice) {
        this.invoice = invoice;
    }

    public BigDecimal getLineItemTotal() {
        return this.getUnitPrice().multiply(BigDecimal.valueOf(this.getQuantity())).setScale(2, RoundingMode.HALF_UP);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IoCOLineItem)) return false;

        IoCOLineItem lineItem = (IoCOLineItem) o;

        return (!getId().equals(lineItem.getId()));
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getQuantity().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getUnitPrice().hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LineItem{");
        sb.append("id=").append(id);
        sb.append(", quantity=").append(quantity);
        sb.append(", description='").append(description).append('\'');
        sb.append(", unitPrice=").append(unitPrice);
        sb.append('}');
        return sb.toString();
    }
}
