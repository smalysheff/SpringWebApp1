package ru.smal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.smal.dao.PeopleDao;
import ru.smal.model.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PeopleDao peopleDao;

    @Autowired
    public PeopleController(PeopleDao peopleDao) {
        this.peopleDao = peopleDao;
    }


    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", peopleDao.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("person", peopleDao.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(Model model){

        model.addAttribute("person", new Person());
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") Person person){
        peopleDao.save(person);
        return "redirect:/people";
    }
}
