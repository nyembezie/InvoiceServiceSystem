/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.ioco.invoiceservice.dao;

import org.springframework.data.repository.CrudRepository;
import za.co.ioco.invoiceservice.model.IoCoInvoice;


/**
 * <p>
 * <b>Purpose:</b><br>
 * <br>
 *
 * <p>
 * <b>Title:</b> IoCOInvoiceRepository<br>
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
public interface IoCOInvoiceRepository extends CrudRepository<IoCoInvoice, Long> {
    
}
