package edu.eci.arsw.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.*;
import edu.eci.arsw.model.*;

@RestController
public class EntryController {

    private final AtomicLong counter = new AtomicLong();
    private List<Entry> entries = new ArrayList<>();
    {
        entries.add(new Entry("Title0","Content0"));
        entries.add(new Entry("Title1","Content1"));
    }

    @RequestMapping(method = RequestMethod.GET,value = "/blogs")
    public List<Entry> getEntries() {
	System.out.print("LLEGEEEEEEEEEEEE AL LISTADO"); 
        return entries;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/blog")
    public  ResponseEntity<?>  postEntry(@RequestBody Entry p) {
System.out.print("LLEGEEEEEEEEEEEE al agregar"); 
        entries.add(p);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
     
    @RequestMapping(method = RequestMethod.DELETE,value = "/blog")
    public  void delete(@RequestBody int p) {
	System.out.print("LLEGEEEEEEEEEEEE A ELIMINAR");        
	entries.remove(p);
        
    }

   @RequestMapping(method = RequestMethod.PUT,value = "/blog/{ind}")
    public  List<Entry> editar(@RequestBody int p, @RequestBody Entry e) {
	System.out.print("LLEGEEEEEEEEEEEE A Editar");        
	/*String auxT, auxC;
	Entry auxEntry;
	auxT = e.getTitle();
	auxC = e.getContent();*/
	entries.set(p, e);
	return entries;

	
        
    }
}
