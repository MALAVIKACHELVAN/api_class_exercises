package com.example.childrenpagination.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.example.childrenpagination.model.Children;
import com.example.childrenpagination.repository.ChildrenRepo;

@Service
public class ChildrenService {
      
    ChildrenRepo childrenRepo;
    ChildrenService(ChildrenRepo childrenRepo)
    {
        this.childrenRepo=childrenRepo;
    }

     public Children postChildren(Children children)
     {
        return childrenRepo.save(children);
     }

     public List<Children> getChildrenOnSorting(String field)
     {
        return childrenRepo.findAll(Sort.by(field));
     }

     public Page<Children> getChildrenOnSorting2(int offset,int pagesize)
     {
        return childrenRepo.findAll(PageRequest.of(offset,pagesize));
     }
     public List<Children> getChildrenOnSortingOnPage(int offset,int pagesize)
     {
        Page<Children> data =  childrenRepo.findAll(PageRequest.of(offset,pagesize));
        List<Children>list=data.getContent();
        Collections.sort(list,Comparator.comparingInt(Children::getBabyId));
        return list;
     }

      public List<Children> getChildrenOnSorting3( int offset, int pagesize, String field)
      {
        PageRequest pageRequest=PageRequest.of(offset,pagesize,Sort.Direction.DESC,field);
        Page<Children>page=childrenRepo.findAll(pageRequest);

        return page.getContent();

      }
















}
