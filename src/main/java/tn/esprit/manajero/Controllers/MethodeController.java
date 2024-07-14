package tn.esprit.manajero.Controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.manajero.Entities.Methode;
import tn.esprit.manajero.Services.IMethodeService;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin(origins = "*")
public class MethodeController {
    IMethodeService methodeService;



    @PostMapping("add")
    public Methode addingMethode(@RequestBody Methode methode){
        return methodeService.addMethode(methode);
    }

    // Order 2
    @GetMapping("getAll")
    public List<Methode> gettingAllMethods(){
        return methodeService.getAllMethods();
    }

    // Order 3
    @GetMapping("get")
    public Methode gettingMethode(@RequestParam("idMethode") String idMethode){
        return methodeService.getMethodeById(idMethode);
    }

    // Order 4
    @DeleteMapping("delete/{idMethode}")
    public void deletingMethode(@PathVariable("idMethode") String idMethode){
        methodeService.deleteMethode(idMethode);
    }

    // Order 5
    @PutMapping("/update/{id}")
    public ResponseEntity<Methode> updatingMethode(@PathVariable String id, @RequestBody Methode methode) {
        Methode updatedMethode = methodeService.updateMethode(id, methode);
        if (updatedMethode != null) {
            return ResponseEntity.ok(updatedMethode);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
