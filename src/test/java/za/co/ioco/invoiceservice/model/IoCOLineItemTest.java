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
 * <b>Title:</b> IoCOLineItemTest<br>
 * <b>Description:</b>
 * </p>
 *
 * @author Eric Kabini<br>
 * @date 10 Dec 2019<br>
 * @version 1.0<br>
 *
 * <b>Revision:</b>
 *
 */
@RunWith(SpringRunner.class)
public class IoCOLineItemTest {

    private IoCOLineItem lineItem;

    @Before
    public void init() {

        lineItem = new IoCOLineItem();
        lineItem.setId(1l);
        lineItem.setQuantity(2l);
        lineItem.setUnitPrice(BigDecimal.valueOf(2l));

    }

    @Test
    public void givenLineItem_testLineItemTotal() {
        assertThat(lineItem.getLineItemTotal().toPlainString().equals("4.00")).isTrue();
    }

}
