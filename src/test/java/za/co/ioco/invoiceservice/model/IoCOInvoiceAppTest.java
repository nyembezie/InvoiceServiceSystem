/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.ioco.invoiceservice.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <p>
 * <b>Purpose:</b><br>
 * <br>
 *
 * <p>
 * <b>Title:</b> IoCOInvoiceAppTest<br>
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
@RunWith(SpringRunner.class)
public class IoCOInvoiceAppTest {

    private IoCoInvoice invoice;

    @Before
    public void init() {

        invoice = new IoCoInvoice();

        invoice.setId(1l);
        invoice.setClient("Okuhle");
        invoice.setVatRate(15l);

        IoCOLineItem lineItem1 = new IoCOLineItem();
        lineItem1.setId(1l);
        lineItem1.setInvoice(invoice);
        lineItem1.setQuantity(2l);
        lineItem1.setUnitPrice(BigDecimal.valueOf(5l));

        IoCOLineItem lineItem2 = new IoCOLineItem();
        lineItem2.setId(2l);
        lineItem2.setInvoice(invoice);
        lineItem2.setQuantity(4l);
        lineItem2.setUnitPrice(BigDecimal.valueOf(10l));

        IoCOLineItem lineItem3 = new IoCOLineItem();
        lineItem3.setId(3l);
        lineItem3.setInvoice(invoice);
        lineItem3.setQuantity(6l);
        lineItem3.setUnitPrice(BigDecimal.valueOf(20l));

        invoice.getLineItems().add(lineItem1);
        invoice.getLineItems().add(lineItem2);
        invoice.getLineItems().add(lineItem3);

    }

    @Test
    public void testAddLineItem() {

        IoCOLineItem lineItem = new IoCOLineItem();
        lineItem.setId(4l);
        lineItem.setInvoice(invoice);
        lineItem.setQuantity(6l);
        lineItem.setUnitPrice(BigDecimal.valueOf(20l));
        invoice.getLineItems().add(lineItem);

        assertThat(invoice.getLineItems().size() == 4).isTrue();

    }

    @Test
    public void testRemoveLineItem() {

        IoCOLineItem lineItem = new IoCOLineItem();
        lineItem.setId(4l);
        lineItem.setInvoice(invoice);
        lineItem.setQuantity(6l);
        lineItem.setUnitPrice(BigDecimal.valueOf(20.00));
        invoice.getLineItems().add(lineItem);

        assertThat(invoice.getLineItems().size() == 4).isTrue();

        invoice.removeLineItem(lineItem);

        assertThat(invoice.getLineItems().size() == 3).isTrue();
    }

    @Test
    public void givenInvoice_TestSubTotalAndVatAndTotal() {

        assertThat(invoice.getSubTotal().toPlainString().equals("170.00")).isTrue();
        assertThat(invoice.getVat().toPlainString().equals("25.50")).isTrue();
        assertThat(invoice.getTotal().toPlainString().equals("195.50")).isTrue();

    }

}
