package com.example.childrenpagination.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.childrenpagination.model.Children;

@Repository
public interface  ChildrenRepo extends JpaRepository <Children,Integer>{
    
}
