package com.example.gfg.jbdl.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class EmployeeController {

    ArrayList<String> alList = new ArrayList<>();

    @RequestMapping(value = "/employee/test")
    public String employeeTest(){
        alList = new ArrayList<>();
        alList.add("Praneeth");
        alList.add("Satya");
        alList.add("Reddi");
        alList.add("Rsp");
        return "Employee API works, array has objects of size: "+alList.size();
    }

    @RequestMapping(value = "/employee/add/{name}")
    public String addToEmployee(@PathVariable("name")String name){
        if(name != null && !name.equals("")) alList.add(name);
        return "Array has objects of size: "+alList.size()+ " after adding "+name;
    }

    @RequestMapping(value = "/employee/getAll")
    public String allEmployees(){
        String al = "";
        for(String el: alList) al = al.concat(" "+el);
        return "Array consists of : "+al;
    }

    @RequestMapping(value = "/employee/getEmp/{name}")
    public String getEmp(@PathVariable("name")String name){
        for (int i = 0; i < alList.size(); i++){
            if (alList.get(i).equals(name)) return "Employee "+ name +" exists with id "+i;
        }
        return "Employee doesn't exist";
    }

    @RequestMapping(value = "/employee/delete/{id}")
    public String delEmp(@PathVariable("id")int id){
        if (alList.size() > id){
            String s = alList.remove(id);
            return "indexed element removed: "+s;
        }
        else return "index out of bounds, deletion not possible";
    }

    @RequestMapping(value = "/employee/greet/{name}")
    public String greetEmployee(@PathVariable("name") String name){
        return "Hello " + name;
    }
}
