package com.iralus.product.controller;

import com.iralus.product.entity.Model;
import com.iralus.product.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/models")
public class ModelController {
    private final ModelService modelService;
    @Autowired
    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }
    @PostMapping("/")
    public Model addModel(@RequestBody Model model){
        return modelService.addBrand(model);
    }
    @GetMapping("/")
    public List<Model> fetchModels(){
        return modelService.fetchModels();
    }
    @GetMapping("/{modelId}")
    public Model fetchModelById(@PathVariable Long modelId){
        return modelService.fetchModelById(modelId);
    }
    @DeleteMapping("/{modelId}")
    public Model deleteModel(@PathVariable Long modelId){
        return modelService.deleteModel(modelId);
    }
    @PutMapping("/{modelId}")
    public Model updateModel(@PathVariable Long modelId,
                             @RequestBody Model model){
        return modelService.updateModel(modelId, model);
    }
}
