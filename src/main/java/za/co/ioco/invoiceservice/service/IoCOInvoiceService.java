package za.co.ioco.invoiceservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import za.co.ioco.invoiceservice.dao.IoCOInvoiceRepository;
import za.co.ioco.invoiceservice.model.IoCoInvoice;

/**
 * <p>
 * <b>Purpose:</b><br>
 * <br>
 *
 * <p>
 * <b>Title:</b> IoCOInvoiceService<br>
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
@Service
public class IoCOInvoiceService {

    @Autowired
    private IoCOInvoiceRepository invoiceRepository;

    public IoCoInvoice addInvoice(IoCoInvoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public List<IoCoInvoice> findAllInvoices() {
        return (List<IoCoInvoice>) invoiceRepository.findAll();
    }

    public IoCoInvoice findInvoice(Long invoiceId) {

        return invoiceRepository.findById(invoiceId).orElse(null);

    }

}
