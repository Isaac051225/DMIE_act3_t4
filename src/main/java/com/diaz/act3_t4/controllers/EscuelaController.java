package com.diaz.act3_t4.controllers;

import com.diaz.act3_t4.models.Escuela;
import com.diaz.act3_t4.repository.EscuelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/escuelas")
public class EscuelaController {

    @Autowired
    private EscuelaRepository escuelaRepo;

    // LISTAR ESCUELAS
    @GetMapping
    public String listarEscuelas(Model model) {
        model.addAttribute("escuelas", escuelaRepo.findAll());
        return "escuelas/index"; // Renderizará la vista templates/escuelas/index.html
    }

    // FORMULARIO NUEVA ESCUELA
    @GetMapping("/nuevo")
    public String formularioNuevoEscuela(Model model) {
        model.addAttribute("escuela", new Escuela());
        return "escuelas/form"; // Renderizará la vista templates/escuelas/form.html
    }

    // GUARDAR ESCUELA
    @PostMapping("/guardar")
    public String guardarEscuela(@ModelAttribute("escuela") Escuela escuela) {
        escuelaRepo.save(escuela);
        return "redirect:/escuelas";
    }

    // EDITAR ESCUELA
    @GetMapping("/editar/{id}")
    public String editarEscuela(@PathVariable Integer id, Model model) {
        Escuela escuela = escuelaRepo.findById(id).orElse(null);
        model.addAttribute("escuela", escuela);
        return "escuelas/form";
    }

    // ELIMINAR ESCUELA
    @GetMapping("/eliminar/{id}")
    public String eliminarEscuela(@PathVariable Integer id) {
        escuelaRepo.deleteById(id);
        return "redirect:/escuelas";
    }
}