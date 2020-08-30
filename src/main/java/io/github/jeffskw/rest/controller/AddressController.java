package io.github.jeffskw.rest.controller;

import io.github.jeffskw.domain.entity.Address;
import io.github.jeffskw.domain.repository.Adresses;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller

public class AddressController {

    public AddressController(Adresses adresses) {
        this.adresses = adresses;
    }

    private Adresses adresses;

    @GetMapping("/api/adresses/{id}")
    @ResponseBody
    public ResponseEntity getAddressById(@PathVariable Integer id) {
        Optional<Address> address = adresses.findById(id);
        if (address.isPresent()) {

            return ResponseEntity.ok(address.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/adresses")
    @ResponseBody
    public ResponseEntity save(@RequestBody Address address) {
        Address newAddress = adresses.save(address);
        return ResponseEntity.ok(newAddress);
    }

    @DeleteMapping("/api/adresses/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Address> address = adresses.findById(id);
        if (address.isPresent()) {

            adresses.delete(address.get());
            return ResponseEntity.ok("Success!");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/api/adresses/{id}")
    @ResponseBody
    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestBody Address address) {
        return adresses
                .findById(id).map(passedAddress ->
                {
                    address.setId(passedAddress.getId());
                    adresses.save(address);
                    return ResponseEntity.ok("success!");
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }


}
