package com.fstn;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/")
public class ValidateInvoiceService {

    private static final Logger log = Logger.getLogger(ValidateInvoiceService.class
            .getName());


    @Inject
    private RegistrerConfig registrer;

    @Inject
    private InvoiceBuilderConfig invoiceBuilderConfig;

    @PostConstruct
    private void init() {


    }

    @POST
    @Path("/validateInvoice")
    @Produces("application/json")
    @Consumes("application/json")
    public Context validate(Context context) {
        context.addCall(new StackCall(registrer.getApi().getName() + registrer.getApi().getAction()));
        for (Api api : registrer.getChildApis()) {
            Client client = ClientBuilder.newBuilder().build();
            context = client
                    .target(api.getUrl() + api.getName() + "/rest/" + api.getAction())
                    .request()
                    .post(Entity.entity(context, MediaType.APPLICATION_JSON),
                            Context.class);
        }
        return context;
    }

    @GET
    @Path("/check")
    public Response check() {
        registrer.getApi();
        return Response.ok().build();
    }


    @GET
    @Path("/get")
    @Produces("application/json")
    public List<Invoice> get() {

        log.log(Level.SEVERE, String.format("Getting all invoices ..."));

        List<Invoice> invoices = invoiceBuilderConfig.getInvoices();
        log.log(Level.SEVERE, String.format("Getting all invoices [%d] DONE.", invoices.size()));

        return invoices;
    }

    @GET
    @Path("/get/{id}")
    @Produces("application/json")
    public Invoice get(@PathParam("id") String id) {
        log.log(Level.SEVERE, String.format("Getting invoice with id %s ...", id));

        Invoice invoice =
                invoiceBuilderConfig.getInvoices().stream()
                        .filter((p) -> p.getId().equals((id)))
                        .findFirst().get();
        log.log(Level.SEVERE, String.format("Getting invoice with id %s DONE.", id));
        return invoice;
    }


    @GET
    @Path("/html/get")
    @Produces("text/html")
    @Consumes("application/json")
    public InputStream getHtml(Context context) {

        log.log(Level.SEVERE, "Getting html template ...");

        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("html/commonTemplate.html");


        log.log(Level.SEVERE, "Getting html template DONE.");
        return inputStream;
    }

}