package Pensionaten.controller;

import Pensionaten.dto.RoomDTO;
import Pensionaten.models.RoomType;
import Pensionaten.service.RoomService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// Controller som hanterar rumssidorna
@Controller
@RequestMapping("/rooms")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    // Visar alla rum
    @GetMapping
    public String listRooms(Model model) {
        model.addAttribute("rooms", roomService.findAll());
        return "customers/room/list";
    }

    // Öppnar formuläret för att skapa ett nytt rum
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("room", new RoomDTO());
        model.addAttribute("roomTypes", RoomType.values());
        return "customers/room/form";
    }

    // Sparar ett nytt rum eller uppdaterar ett befintligt rum
    @PostMapping("/save")
    public String saveRoom(@Valid @ModelAttribute("room") RoomDTO roomDTO,
                           BindingResult result,
                           Model model) {

        if (result.hasErrors()) {
            model.addAttribute("roomTypes", RoomType.values());
            return "customers/room/form";
        }

        roomService.save(roomDTO);
        return "redirect:/rooms";
    }

    // Öppnar formuläret med ett befintligt rum för redigering
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("room", roomService.findById(id));
        model.addAttribute("roomTypes", RoomType.values());
        return "customers/room/form";
    }

    // Tar bort ett rum om det inte finns bokningar kopplade till rummet
    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        boolean deleted = roomService.delete(id);

        if (deleted) {
            redirectAttributes.addFlashAttribute("message", "Rummet togs bort.");
        } else {
            redirectAttributes.addFlashAttribute("error", "Rummet kunde inte tas bort eftersom det har bokningar.");
        }

        return "redirect:/rooms";
    }
}