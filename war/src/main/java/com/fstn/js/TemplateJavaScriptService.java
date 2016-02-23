package com.fstn.js;

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

@Path("/js")
public class TemplateJavaScriptService {

    private static final Logger log = Logger.getLogger(TemplateJavaScriptService.class
            .getName());
    public static final String ROOT_DIRECTORY_JAVASCRIPT = "js";

    @Inject
    private RegistrerConfig registrer;

    @PostConstruct
    private void init() {

    }


    @GET
    @Path("/get")
    @Produces("text/html")
    @Consumes("text/html")
    public InputStream getJavascript() {

        log.log(Level.INFO, "Getting javscript template ...");
        String url = ROOT_DIRECTORY_JAVASCRIPT + "/" + registrer.getApi().getName() + "/"+ registrer.getApi().getName() +"InvoiceController.js";
        log.log(Level.INFO, "registrer.getApi().getName() = " + registrer.getApi().getName());
        log.log(Level.INFO, "registrer.getApi().getAction() =" + registrer.getApi().getAction());
        log.log(Level.INFO, "Url found is " + url + " ...");

        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(url);


        log.log(Level.INFO, "Getting javscript template DONE.");
        return inputStream;
    }
}