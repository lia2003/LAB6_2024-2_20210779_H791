package com.example.lab6_20242_20210779_h791.controller;
import org.springframework.stereotype.Controller;
import com.example.lab6_20242_20210779_h791.entity.*; //todas las entidades
import com.example.lab6_20242_20210779_h791.repository.*; //todos los repositorios
import org.springframework.web.bind.annotation.*; //postmapping, getmapping
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
import java.util.Optional;
//import javax.validation.Valid; no lo acepta ni con las dependencias en el pom ni con el proyecto creado con esto
import org.springframework.validation.BindingResult;


@Controller
@RequestMapping("/eventos") //es decir todas las rutas empiezan con employee, ES GENERAL
public class EventosController {

    final EventosRepository eventosRepository;
    public EventosController(EventosRepository eventosRepository) {
        this.eventosRepository = eventosRepository;
    }

    @GetMapping("/listar")
    public String listarEventos(Model model) {
        List<Eventos> lista_eventos = eventosRepository.findAll();
        model.addAttribute("lista_eventos", lista_eventos);
        return "eventos";
    }
    //@ModelAttribute("eventos") @Valid Eventos eventos,
    //                              BindingResult bindingResult,
    //                              Model model
    //no se pudo colocar de esta manera
    @GetMapping("/crear")
    public String crearEvento(@ModelAttribute("eventos") Eventos eventos,
                              BindingResult bindingResult,
                              Model model) {
        List<Eventos> lista_eventos = eventosRepository.findAll();
        model.addAttribute("lista_eventos", lista_eventos);
        return "editar_evento";
    }

    //@ModelAttribute("eventos") @Valid Eventos eventos,
    //                               BindingResult bindingResult,
    //                                 Model model,
    //                                 @RequestParam("eventoId") Integer eventoId
    //no se pudo colocar de esta manera
    @GetMapping("/editar")
    public String editarEvento(@ModelAttribute("eventos") Eventos eventos,
                               BindingResult bindingResult,
                                 Model model,
                                 @RequestParam("eventoId") Integer eventoId) {
        Optional<Eventos> optionalEventos = eventosRepository.findById(eventoId);

        if (optionalEventos.isPresent()) {
            eventos = optionalEventos.get();
            model.addAttribute("eventos", eventos);
            return "editar_evento";
        } else {
            return "eventos";
        }
    }
    //@ModelAttribute("eventos") @Valid Eventos eventos,
    //                                BindingResult bindingResult,
    //                                RedirectAttributes attr
    //no se pudo colocar de esta manera
    @PostMapping("/guardar")
    public String guardarEvento(@ModelAttribute("eventos") Eventos eventos,
                                BindingResult bindingResult,
                                RedirectAttributes attr) {
        if (eventos.getEventoId() == null) {
            attr.addFlashAttribute("msg", "Evento creado exitosamente");
        } else {
            attr.addFlashAttribute("msg", "Evento actualizado exitosamente");
        }
        eventosRepository.save(eventos);
        return "redirect:/eventos/listar";
    }


}
