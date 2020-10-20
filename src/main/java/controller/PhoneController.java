package controller;

import model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.PhoneService;

@Controller
@RequestMapping(value = "/phones")
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView showCreatePhonePage() {
        ModelAndView modelAndView = new ModelAndView("/new-phone");
        modelAndView.addObject("phone", new Phone());
        return modelAndView;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Phone createPhone(@RequestBody Phone phone) {
        return phoneService.save(phone);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Phone> listPhone() {
        return phoneService.findAll();
    }

    @GetMapping("")
    public ModelAndView ShowListPhone() {
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("listPhone", listPhone());
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Phone deletePhone(@PathVariable("id") Integer id) {
        return phoneService.remove(id);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView showEditPage(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("/edit");
        Phone phone = phoneService.findById(id);
        modelAndView.addObject("phone", phone);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Phone editPhone(@PathVariable("id") Integer id, @RequestBody Phone phone) {
        phone.setId(id);
        return phoneService.save(phone);
    }




}
