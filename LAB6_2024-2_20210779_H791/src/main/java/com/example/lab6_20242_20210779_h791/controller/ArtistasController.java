package com.example.lab6_20242_20210779_h791.controller;
import java.util.Arrays;
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
@RequestMapping("/artistas")
public class ArtistasController {
    final ArtistasRepository artistasRepository;

    public ArtistasController(ArtistasRepository artistasRepository) {
        this.artistasRepository = artistasRepository;
    }

    @GetMapping("/listar")
    public String listarArtistas(Model model) {
        List<Artistas> lista_artistas = artistasRepository.findAll();
        model.addAttribute("lista_artistas", lista_artistas);
        return "artistas";
    }
    //@ModelAttribute("artistas") @Valid Artistas artistas,
    //                              BindingResult bindingResult,
    //                              Model model
    //no se pudo colocar de esta manera
    @GetMapping("/crear")
    public String crearArtistas(@ModelAttribute("artistas") Artistas artistas,
                              BindingResult bindingResult,
                              Model model) {
        List<Artistas> lista_artistas = artistasRepository.findAll();
        model.addAttribute("lista_artistas", lista_artistas);
        return "editar_artista";
    }

    //@ModelAttribute("artistas") @Valid Artistas artistas,
    //                               BindingResult bindingResult,
    //                                 Model model,
    //                                 @RequestParam("artistaId") Integer artistaId
    //no se pudo colocar de esta manera
    @GetMapping("/editar")
    public String editarArtista(@ModelAttribute("artistas") Artistas artistas,
                               BindingResult bindingResult,
                               Model model,
                               @RequestParam("artistaId") Integer artistaId) {
        Optional<Artistas> optionalArtistas = artistasRepository.findById(artistaId);

        if (optionalArtistas.isPresent()) {
            artistas = optionalArtistas.get();
            model.addAttribute("artistas", artistas);
            // Aquí añades la lista de géneros disponibles al modelo
            List<String> generos = Arrays.asList("Rock", "Pop", "Reggaeton", "R&B", "Jazz");
            model.addAttribute("generos", generos);

            return "editar_artista";
        } else {
            return "artistas";
        }
    }
    //@ModelAttribute("artistas") @Valid Artistas artistas,
    //                                BindingResult bindingResult,
    //                                RedirectAttributes attr
    //no se pudo colocar de esta manera
    @PostMapping("/guardar")
    public String guardarArtista(@ModelAttribute("artistas") Artistas artistas,
                                BindingResult bindingResult,
                                RedirectAttributes attr) {
        if (artistas.getArtistaId() == null) {
            attr.addFlashAttribute("msg", "Artista creado exitosamente");
        } else {
            attr.addFlashAttribute("msg", "Artista actualizado exitosamente");
        }
        artistasRepository.save(artistas);
        return "redirect:/artistas/listar";
    }

}
