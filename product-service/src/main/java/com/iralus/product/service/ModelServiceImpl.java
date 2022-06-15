package com.iralus.product.service;

import com.iralus.product.entity.Model;
import com.iralus.product.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.iralus.product.util.EmptyChecker.empty;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    @Autowired
    public ModelServiceImpl(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }


    @Override
    public Model addBrand(Model model) {
        return modelRepository.save(model);
    }

    @Override
    public List<Model> fetchModels() {
        return modelRepository.findAll();
    }

    @Override
    public Model fetchModelById(Long modelId) {
        return modelRepository.findById(modelId).orElseThrow(() ->
                new IllegalArgumentException("Brand with id"+modelId+"could not be fount"));
    }

    @Override
    public Model updateModel(Long modelId, Model model) {
        Model modelDB = fetchModelById(modelId);
        if(!empty(model.getModelName())){
            modelDB.setModelName(model.getModelName());
        }
        if(!empty(model.getDescription())){
            modelDB.setDescription(model.getDescription());
        }
        if(!empty(model.getBrand())){
            modelDB.setBrand(model.getBrand());
        }
        if(!empty(model.getStatus())){
            modelDB.setStatus(model.getStatus());
        }
        return modelRepository.save(modelDB);
    }

    @Override
    public Model deleteModel(Long modelId) {
        Model model = fetchModelById(modelId);
        modelRepository.delete(model);
        return model;
    }
}
