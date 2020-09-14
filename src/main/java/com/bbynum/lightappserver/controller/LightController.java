package com.bbynum.lightappserver.controller;

import com.bbynum.lightappserver.exception.ResourceNotFoundException;
import com.bbynum.lightappserver.model.Light;
import com.bbynum.lightappserver.repository.LightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LightController {

    @Autowired
    LightRepository lightRepository;

    // Get all Lights
    @GetMapping("/lights")
    public List<Light> getAllLights() {
        return lightRepository.findAll();
    }

    // Add a new Light
    @PostMapping("/lights")
    public Light createLight(@Validated @RequestBody Light light) {
        return lightRepository.save(light);
    }

    // Get a specific Light
    @GetMapping("lights/{id}")
    public Light getLightById(@PathVariable(value = "id") Long lightId) {
        return lightRepository.findById(lightId)
                .orElseThrow(() -> new ResourceNotFoundException("Light", "id", lightId));
    }

    // Update a Light
    @PostMapping("lights/{id}")
    public Light updateLight(@PathVariable(value = "id") Long lightId,
                             @Validated @RequestBody Light lightDetails) {
        Light light = lightRepository.findById(lightId)
                .orElseThrow(() -> new ResourceNotFoundException("Light", "id", lightId));

        light.setColor(lightDetails.getColor());

        Light updatedLight = lightRepository.save(light);
        return updatedLight;
    }

    // Delete a Light
    @DeleteMapping("lights/{id}")
    public ResponseEntity<?> deleteLight(@PathVariable(value = "id") Long lightId) {

        Light light = lightRepository.findById(lightId)
                .orElseThrow(() -> new ResourceNotFoundException("Light", "id", lightId));

        lightRepository.delete(light);

        return ResponseEntity.ok().build();
    }

}
