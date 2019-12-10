/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.ioco.invoiceservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import za.co.ioco.invoiceservice.model.IoCoInvoice;
import za.co.ioco.invoiceservice.service.IoCOInvoiceService;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * <b>Purpose:</b><br>
 * <br>
 *
 * <p>
 * <b>Title:</b> IoCOInvoiceController<br>
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
@RestController
@RequestMapping("/invoices")
public class IoCOInvoiceController {
    
    @Autowired
    private IoCOInvoiceService invoiceService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody IoCoInvoice addInvoice(@RequestBody @NotNull IoCoInvoice invoice) {
        return invoiceService.addInvoice(invoice);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<IoCoInvoice> viewAllInvoices() {
        return invoiceService.findAllInvoices();
    }

    @GetMapping(value = "/{invoiceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody IoCoInvoice viewInvoice(@PathVariable Long invoiceId) {
        return invoiceService.findInvoice(invoiceId);
    }
    
}
