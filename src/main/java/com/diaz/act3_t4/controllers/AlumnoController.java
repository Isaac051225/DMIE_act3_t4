package com.diaz.act3_t4.controllers;

import com.diaz.act3_t4.models.Alumno;
import com.diaz.act3_t4.repository.AlumnoRepository;
import com.diaz.act3_t4.repository.EscuelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoRepository alumnoRepo;

    @Autowired
    private EscuelaRepository escuelaRepo;

    // LISTAR ALUMNOS
    @GetMapping
    public String listarAlumnos(Model model) {
        model.addAttribute("alumnos", alumnoRepo.findAll());
        return "alumnos/index";
    }

    // FORMULARIO NUEVO ALUMNO
    @GetMapping("/nuevo")
    public String formularioNuevoAlumno(Model model) {
        model.addAttribute("alumno", new Alumno());
        model.addAttribute("escuelas", escuelaRepo.findAll());
        return "alumnos/form";
    }

    // GUARDAR ALUMNO
    @PostMapping("/guardar")
    public String guardarAlumno(@ModelAttribute("alumno") Alumno alumno) {
        alumnoRepo.save(alumno);
        return "redirect:/alumnos";
    }

    // EDITAR ALUMNO
    @GetMapping("/editar/{id}")
    public String editarAlumno(@PathVariable("id") Integer id, Model model) {
        Alumno alumno = alumnoRepo.findById(id).orElse(null);
        model.addAttribute("alumno", alumno);
        model.addAttribute("escuelas", escuelaRepo.findAll());
        return "alumnos/form";
    }

    // ELIMINAR ALUMNO
    @GetMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable("id") Integer id) {
        alumnoRepo.deleteById(id);
        return "redirect:/alumnos";
    }
}