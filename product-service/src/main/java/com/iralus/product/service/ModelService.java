package com.iralus.product.service;

import com.iralus.product.entity.Brand;
import com.iralus.product.entity.Model;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ModelService {
    Model addBrand(Model model);
    List<Model> fetchModels();
    Model fetchModelById(Long modelId);
    Model updateModel(Long modelId, Model model);
    Model deleteModel(Long modelId);
}
