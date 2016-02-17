package com.fstn.template;

import javax.annotation.PostConstruct;
import javax.ws.rs.Path;
import java.util.logging.Logger;

@Path("/html")
public class TemplateService {

    private static final Logger log = Logger.getLogger(TemplateService.class
            .getName());

    @PostConstruct
    private void init() {

    }

//    @GET
//    @Path("/get")
//    @Produces("text/html")
//    @Consumes("application/json")
//    public InputStream validate(Context context) {
//
//        log.log(Level.SEVERE, "Getting html template ...");
//
//        String path = Thread.currentThread().getContextClassLoader().getResource("html/commonTemplate").getPath();
//        log.log(Level.SEVERE, "Getting html template DONE.");
//        FileInputStream fileInputStream = null;
//        try {
//            fileInputStream = new FileInputStream(path);
//        } catch (FileNotFoundException e) {
//            log.log(Level.SEVERE, String.format("Can not find file with path %s ...", path));
//        }
//        return fileInputStream;
//    }

}