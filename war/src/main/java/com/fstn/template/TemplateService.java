package com.fstn.template;

import com.fstn.RegistrerConfig;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

@Path("/html")
public class TemplateService {

    private static final Logger log = Logger.getLogger(TemplateService.class
            .getName());

    @Inject
    private RegistrerConfig registrer;

    @PostConstruct
    private void init() {

    }


    @GET
    @Path("/get")
    @Produces("text/html")
    @Consumes("text/html")
    public InputStream getHtml() {

        log.log(Level.INFO, "Getting html template ...");
        String url = "html/"+registrer.getApi().getName()+"/invoiceTemplate.html";
        log.log(Level.INFO, "registrer.getApi().getName() = "+ registrer.getApi().getName());
        log.log(Level.INFO, "registrer.getApi().getAction() ="+ registrer.getApi().getAction());
        log.log(Level.INFO, "Url found is "+url+" ...");

        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(url);


        log.log(Level.INFO, "Getting html template DONE.");
        return inputStream;
    }


    @GET
    @Path("/get/common")
    @Produces("text/html")
    @Consumes("text/html")
    public InputStream getCommonTemplateHtml() {

        log.log(Level.INFO, "Getting html template ...");

        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("html/invoiceTemplate.html");


        log.log(Level.INFO, "Getting html template DONE.");
        return inputStream;
    }

}