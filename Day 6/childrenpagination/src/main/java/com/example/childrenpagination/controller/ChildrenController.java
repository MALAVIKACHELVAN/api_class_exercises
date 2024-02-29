package com.example.childrenpagination.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.childrenpagination.service.ChildrenService;
import com.example.childrenpagination.model.Children;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ChildrenController {
    ChildrenService childrenService;
    ChildrenController(ChildrenService s)
    {
     childrenService =s;
    }
    @PostMapping("/api/children")
    public ResponseEntity<Children> post(@RequestBody Children children)
    {
        Children posted= childrenService.postChildren(children);
        if(posted==null)
        {
            return new ResponseEntity<>(posted,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else{
            return new ResponseEntity<>(posted,HttpStatus.CREATED);
        }
    }

    @GetMapping("/api/children/sortBy/{field}")
    public ResponseEntity<List<Children>> get(@PathVariable String field)
    {
        List<Children>list=childrenService.getChildrenOnSorting(field);
        if(list.isEmpty())
        {
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }

    @GetMapping("/api/children/{offset}/{pagesize}")
    public ResponseEntity<Page<Children>> get(@PathVariable int offset,@PathVariable int pagesize)
    {
        Page<Children>list=childrenService.getChildrenOnSorting2(offset,pagesize);
        if(list.isEmpty())
        {
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }
    @GetMapping("/api/children/{offset}/{pagesize}/{field}")
    public ResponseEntity<List<Children>> get(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        List<Children>list=childrenService.getChildrenOnSorting3(offset,pagesize,field);
        if(list.isEmpty())
        {
            return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
    }
    
    
    


    
}
